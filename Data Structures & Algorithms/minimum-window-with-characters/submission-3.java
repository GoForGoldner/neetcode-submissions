class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tLetters = new HashMap<>();
        for (char c : t.toCharArray()) {
            tLetters.put(c, tLetters.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> current = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int lPos = 0;
        int l = 0;

        int have = 0, need = tLetters.size();

        for (int r = 0; r < s.length(); r++) {
            char rChar = s.charAt(r);

            // Add the character to the current
            current.put(rChar, current.getOrDefault(rChar, 0) + 1);
            if (tLetters.containsKey(rChar) && tLetters.get(rChar) == current.get(rChar)) {
                have++;
            }

            // While have = need
            while (have == need) {
                char lChar = s.charAt(l);

                // Compute the new min
                if (min > r - l + 1) {
                    min = r - l + 1;
                    lPos = l;
                }

                // Remove letters until have < need
                current.put(lChar, current.get(lChar) - 1);
                if (tLetters.containsKey(lChar) && tLetters.get(lChar) > current.get(lChar)) {
                    have--;
                }
                l++;
            }
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(lPos, lPos + min);
    }
}
