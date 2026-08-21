class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int left = 0, right = n - 1;

        int max = 0;

        while (left < right) {
            int minWall = Math.min(heights[left], heights[right]);
            int distance = right - left;

            // Compute current volume
            max = Math.max(max, minWall * distance);

            // Update walls
            if (heights[left] <= heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}
