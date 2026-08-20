class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int leftMax = height[l], rightMax = height[r];
        int volume = 0;

        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);

                volume += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);

                volume += rightMax - height[r];
            }
        }

        return volume;
    }
}
