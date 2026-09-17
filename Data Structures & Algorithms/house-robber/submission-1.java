class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        else if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int prev1 = 0, prev2 = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int current = Math.max(prev1 + nums[i], prev2);

            // Shift values forward
            prev1 = prev2;
            prev2 = current;
        }

        return prev2;
    }
}
