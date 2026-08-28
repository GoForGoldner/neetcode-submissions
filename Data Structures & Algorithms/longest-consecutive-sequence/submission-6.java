class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for (int num : nums) {
            if (!map.containsKey(num)) {
                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);
                int updatedCount = left + right + 1;

                map.put(num, updatedCount);
                map.put(num - left, updatedCount);
                map.put(num + right, updatedCount);

                max = Math.max(max, updatedCount);
            }
        }

        return max;
    }
}
