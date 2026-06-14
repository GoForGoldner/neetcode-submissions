class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tLetters = new HashMap<>();
        for (char c : t.toCharArray()) {
            tLetters.put(c, tLetters.getOrDefault(c, 0) + 1);
        }

        int have = 0, need = tLetters.size();
        int l = 0;
        int min = Integer.MAX_VALUE, leftPos = 0;
        Map<Character, Integer> current = new HashMap<>();

        for (int r = 0; r < s.length(); r++) {
            char rChar = s.charAt(r);

            // Add the right character to the current window
            current.put(rChar, current.getOrDefault(rChar, 0) + 1);
            if (tLetters.containsKey(rChar) && current.get(rChar).equals(tLetters.get(rChar))) {
                have++;
            }

            while (have == need) {
                char lChar = s.charAt(l);
                if (r - l + 1 < min) {
                    min = r - l + 1;
                    leftPos = l;
                }

                // Remove the left character
                current.put(lChar, current.get(lChar) - 1);

                // Potentially update have
                if (tLetters.containsKey(lChar) && current.get(lChar) < tLetters.get(lChar)) {
                    have--;
                }
                l++;
            }
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(leftPos, leftPos + min);
    }
}
