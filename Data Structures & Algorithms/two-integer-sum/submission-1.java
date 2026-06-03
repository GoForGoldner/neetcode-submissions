class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> letterToIndex = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int compliment = target - nums[i];

            if (letterToIndex.containsKey(compliment)) {
                return new int[] {letterToIndex.get(compliment), i};
            } else {
                letterToIndex.put(nums[i], i);
            }
        }

        return new int[]{};
    }
}
