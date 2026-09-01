class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftWall = height[left], rightWall = height[right];
        int volume = 0;

        while (left < right) {
            if (leftWall <= rightWall) {
                left++;
                leftWall = Math.max(leftWall, height[left]);
                volume += Math.max(leftWall - height[left], 0);
            } else {
                right--;
                rightWall = Math.max(rightWall, height[right]);
                volume += Math.max(rightWall - height[right], 0);
            }
        }

        return volume;
    }
}
