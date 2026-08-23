class Solution {
    // Base case is the number with no neighbors
        // Add to the map

    // left is present
    // make left be +1 and this be left +1

    // right is present
    // make right be +1 and this be right +1
    
    // both are present
    // make left and right be left + right + 1

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int output = 0;

        for (int num : nums) {
            if (!map.containsKey(num)) {
                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);
                
                map.put(num, left + right + 1);
                map.put(num - left, map.get(num));
                map.put(num + right, map.get(num));

                output = Math.max(output, map.get(num));
            }
        }

        return output;
    }
}
