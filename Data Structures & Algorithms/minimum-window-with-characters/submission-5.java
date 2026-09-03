class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        // Create a frequency map for t
        int uniqueLetters = 0;
        Map<Character, Integer> tLetters = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (!tLetters.containsKey(c)) uniqueLetters++;
            tLetters.put(c, tLetters.getOrDefault(c, 0) + 1);
        }

        int length = Integer.MAX_VALUE;
        int leftPointer = -1;

        Map<Character, Integer> freq = new HashMap<>();
        int left = 0, right = 0;
        int matches = 0;

        while (right < s.length()) {
            char rChar = s.charAt(right);

            // Update frequency and move right pointer
            freq.put(rChar, freq.getOrDefault(rChar, 0) + 1);
            // Potentially update matches
            if (freq.get(rChar).equals(tLetters.getOrDefault(rChar, 0))) matches++;
            right++;

            while (matches == uniqueLetters) {
                // Update max length
                int currentLength = right - left;
                if (currentLength < length) {
                    length = currentLength;
                    leftPointer = left;
                }

                // Move left pointer forward
                char lChar = s.charAt(left);
                freq.put(lChar, freq.get(lChar) - 1);
                left++;

                // Potentially remove match
                if (freq.get(lChar) < tLetters.getOrDefault(lChar, 0)) {
                    matches--;
                }
            }
        }

        return leftPointer == -1 ? "" : s.substring(leftPointer, leftPointer + length);
    }
}
