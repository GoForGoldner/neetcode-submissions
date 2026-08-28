class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> numToIndex = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int compliment = target - nums[i];

            if (numToIndex.containsKey(compliment)) {
                return new int[]{ numToIndex.get(compliment), i };
            } else {
                numToIndex.put(nums[i], i);
            }
        }

        // Shouldn't be possible
        return new int[]{};
    }
}
