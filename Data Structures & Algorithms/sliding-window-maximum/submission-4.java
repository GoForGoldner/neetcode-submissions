class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] output = new int[n - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();

        for (int r = 0; r < n; r++) {
            // Remove numbers that are smaller from the stack
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[r]) {
                    queue.pollLast();
            }

            queue.offerLast(r);

            // Remove the front item if it's not in the stack
            if (queue.peek() < r - k + 1) queue.poll();

            // Add the item to the output if in sliding window
            if ((r + 1) >= k) {
                output[r - k + 1] = nums[queue.peek()];
            }
        }

        return output;
    }
}
