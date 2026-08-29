class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) continue;

            int left = map.getOrDefault(num - 1, 0);
            int right = map.getOrDefault(num + 1, 0);
            int updatedValue = left + right + 1;

            map.put(num, updatedValue);
            map.put(num - left, updatedValue);
            map.put(num + right, updatedValue);

            max = Math.max(max, updatedValue);
        }

        return max;
    }
}
