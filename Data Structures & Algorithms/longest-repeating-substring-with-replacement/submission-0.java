class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        int max = 0;
        int left = 0, maxCharacter = 0;

        for(int right = 0; right < s.length(); right++) {
            char rChar = s.charAt(right);

            // Update frequency and max character
            count.put(rChar, count.getOrDefault(rChar, 0) + 1);
            maxCharacter = Math.max(maxCharacter, count.get(rChar));

            // While there are more letter replacements then allowed
            while ((right - left + 1) - maxCharacter > k) {
                // Remove left character
                count.put(s.charAt(left), count.get(s.charAt(left)) - 1);
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
