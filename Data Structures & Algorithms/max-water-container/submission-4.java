class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1;
        int max = 0;

        while(left < right) {
            int minWall = Math.min(heights[left], heights[right]);

            max = Math.max(max, getVolume(left, right, minWall));

            if (heights[left] == minWall) left++;
            else right--;
        }

        return max;
    }

    private int getVolume(int left, int right, int minWall) {
        return (right - left) * minWall;
    }
}
