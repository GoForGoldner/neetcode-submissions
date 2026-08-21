class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        // Sort nums in ascending order
        Arrays.sort(nums);

        int n = nums.length;
        int max = 1;
        int count = 0;
        int prev = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] == prev) {
                continue;
            } else if (nums[i] == prev + 1) {
                count++;
            }
            else {
                max = Math.max(max, count + 1);
                count = 0;
            }

            prev = nums[i];
        }

        max = Math.max(max, count + 1);

        return max;
    }
}
