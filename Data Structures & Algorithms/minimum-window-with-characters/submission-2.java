class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tLetters = new HashMap<>();
        for (char c : t.toCharArray()) {
            tLetters.put(c, tLetters.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> sLetters = new HashMap<>();

        int l = 0;
        int min = Integer.MAX_VALUE;
        int[] ends = {-1, -1};
        int have = 0, need = tLetters.size();

        for (int r = 0; r < s.length(); r++) {
            char rChar = s.charAt(r);
            // Add the right character
            sLetters.put(rChar, sLetters.getOrDefault(rChar, 0) + 1);
            if (tLetters.getOrDefault(rChar, 0) > 0 && sLetters.get(rChar).equals(tLetters.get(rChar))) {
                have++;
            }

            // Trim left characters while we have what we need
            while (have == need) {
                char lChar = s.charAt(l);

                // Update the max
                if (min > r - l + 1) {
                    min = r - l + 1;
                    ends = new int[]{l, r};
                }

                // Remove the left character
                if (tLetters.getOrDefault(lChar, 0) > 0 && sLetters.get(lChar).equals(tLetters.get(lChar))) {
                    have--;
                }
                sLetters.put(lChar, sLetters.get(lChar) - 1);
                l++;
            }
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(ends[0], ends[1] + 1);
    }
}
