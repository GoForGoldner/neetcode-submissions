class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> output = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            // Skip duplicates
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Calculate two sum
            int left = i + 1, right = n - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else {
                    output.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Iterate pointers forward
                    left++;
                    right--;

                    // Skip duplicates
                    while (left < right && nums[left] == nums[left - 1]) left++;
                }
            }          
        }

        return output;
    }
}
