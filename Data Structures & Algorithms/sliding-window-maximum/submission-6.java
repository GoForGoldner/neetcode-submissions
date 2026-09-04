class Solution {
    // Invariants
    // 1. Using a monotonic deque, the largest number will always be deque.peek()
    // 2. Removing numbers that are smaller then the current number keep the stack correct
    // 3. Removing indices that aren't in the sliding window from the top will make sure that the maximum is in the sliding window
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] output = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int r = 0; r < n; r++) {
            // Remove numbers smaller then the current number to add
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[r]) {
                deque.pollLast();
            }

            // Add the current number to the stack
            deque.offerLast(r);
            
            // Remove top number if out of sliding window
            if (deque.peek() < r - k + 1) deque.poll();

            // Add max in monotonic stack to the output
            if (r + 1 >= k) {
                output[r - k + 1] = nums[deque.peek()];
            }
        }

        return output;
    }
}
