class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        Map<Character, Integer> freqMap = new HashMap<>();
        int max = 0;
        int left = 0, maxCharacter = 0;

        for (int right = 0; right < n; right++) {
            char rChar = s.charAt(right);

            freqMap.put(rChar, freqMap.getOrDefault(rChar, 0) + 1);
            maxCharacter = Math.max(maxCharacter, freqMap.get(rChar));

            while ((right - left + 1) - maxCharacter > k) {
                freqMap.put(s.charAt(left), freqMap.get(s.charAt(left)) - 1);
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
