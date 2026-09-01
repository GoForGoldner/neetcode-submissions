class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> output = new ArrayList<>();

        // Sort numbers in ascending order
        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            // Not possible once we are at a positive number
            if (nums[i] > 0) break;

            // Skip duplicate numbers
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Calculate all possible two sums
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

                    // Skip duplicate numbers
                    while (left < right && nums[left] == nums[left - 1]) left++;
                }
            }
        }

        return output;
    }
}
