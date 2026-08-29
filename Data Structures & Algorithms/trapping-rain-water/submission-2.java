class Solution {
    public int trap(int[] height) {
        if (height.length < 2) return 0;

        int left = 0, right = height.length - 1;
        int leftWall = height[left], rightWall = height[right];
        int volume = 0;

        while(left < right) {
            // Iterate the pointer forward
            // Update the wall
            // Compute the volume to add
            if (height[left] <= height[right]) {
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
