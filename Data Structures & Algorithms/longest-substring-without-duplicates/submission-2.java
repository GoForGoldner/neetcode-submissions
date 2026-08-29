class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, max = 0;

        for (int right = 0; right < s.length(); right++) {
            char rChar = s.charAt(right);

            // Update the left pointer
            if (map.containsKey(rChar)) {
                left = Math.max(map.get(rChar) + 1, left);
            }

            // Add the right char to the map
            map.put(rChar, right);

            // Update the max value
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
