class Solution {
    public int missingNumber(int[] nums) {
        // Cyclic sort 
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // Swap the numbers with their proper indexes until something can't be swapped
            while (nums[i] != i && nums[i] >= 0 && nums[i] < n) {
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
