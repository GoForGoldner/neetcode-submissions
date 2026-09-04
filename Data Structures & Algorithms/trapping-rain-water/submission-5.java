class Solution {
    // Invariants:
    // 1. Volume is the distance between times the minWall
    // int dist = (right - left - 1) * minWall
    // 2. When the minWall is being shifted, the lowerBound will still always be that wall for that operation
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftWall = height[left], rightWall = height[right];
        int volume = 0;

        while (left < right) {
            if (leftWall < rightWall) {
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
