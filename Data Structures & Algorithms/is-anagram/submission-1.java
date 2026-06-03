class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int n = s.length();
        int[] sLetters = new int[26];
        int[] tLetters = new int[26];

        for (int i = 0; i < n; i++) {
            sLetters[s.charAt(i) - 'a']++;
            tLetters[t.charAt(i) - 'a']++;
        }

        return Arrays.equals(sLetters, tLetters);
    }
}
