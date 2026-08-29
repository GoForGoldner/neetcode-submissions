class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);   
        List<List<Integer>> output = new ArrayList<>();

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) break;
            // Skip duplicate values
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    // Add to solution
                    output.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }

        return output;
    }


}
