class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] output = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        int left = 0, right = 0;
        while (right < n) {
            // Remove numbers from the queue that are smaller
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[right]) deque.pollLast();

            // Add current number to the queue
            deque.offerLast(right);
            
            // Remove stale entires from increasing the left pointer
            if (left > deque.peekFirst()) {
                deque.removeFirst();
            }

            // Add to output and shift window
            if (right + 2 > k) {
                output[left] = nums[deque.getFirst()];
                left++;
            }

            right++;
        }

        return output;
    }
}
