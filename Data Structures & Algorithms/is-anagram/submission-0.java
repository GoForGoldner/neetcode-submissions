class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] sLetterCount = new int[26];
        for (char c : s.toCharArray()) {
            sLetterCount[c - 'a']++;
        }

        int[] tLetterCount = new int[26];
        for (char c : t.toCharArray()) {
            tLetterCount[c - 'a']++;
        }

        return Arrays.equals(sLetterCount, tLetterCount);
    }
}
