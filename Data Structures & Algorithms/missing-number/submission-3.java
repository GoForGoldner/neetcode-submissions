class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        // The numbers always range from 0 to nums.length
        // Cyclic sort
        for (int i = 0; i < n; i++) {
            while (nums[i] < n && nums[i] != nums[nums[i]]) {
                // Swap the two numbers
                int target = nums[i];
                int temp = nums[i];
                nums[i] = nums[target];
                nums[target] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i) return i;
        }

        return n;
    }
}
