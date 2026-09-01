class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        int n = nums.length;

        // Sort the array (ascending order)
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            // Not possible once it's a positive number
            if (nums[i] > 0) break;

            // Skip duplicates
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Two sum for each possible target
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                if (nums[left] + nums[right] + nums[i] < 0) {
                    left++;
                } else if (nums[left] + nums[right] + nums[i] > 0) {
                    right--;
                } else {
                    // Found possible entry
                    output.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Iterate pointers forward
                    left++;
                    right--;

                    // Skip duplicate entries
                    while (left < right && nums[left] == nums[left - 1]) left++;
                }
            }
        }

        return output;   
    }
}
