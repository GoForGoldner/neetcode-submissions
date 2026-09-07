class Solution {
    public int longestConsecutive(int[] nums) {
        // Use a map to keep track of all elements that have currently been seen
        // Looking at the elements to the left and right of the current element will determine if you are building on the current sequence
        // Updating the ends of the sequence will make sure that it will continue to work for future operations

        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;

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
