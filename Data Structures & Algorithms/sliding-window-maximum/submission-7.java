class Solution {
    // Invariants
    // 1. The deque holds indices for the current window in descending order,
    // so deque.peek() is always the largest value / index for the window
    // 2. Anything removed from the window can't be the max again. Every window that has a smaller value behind a larger value will always just use the larger value
    // 3. Make sure the front is always in the window
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
