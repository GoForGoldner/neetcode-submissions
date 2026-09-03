class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int max = 0;

        while (right < n) {
            // Remove left character(s) if necessary
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add right character
            set.add(s.charAt(right));
            right++;

            // Potentailly update max value
            max = Math.max(max, right - left);
        }

        return max;
    }
}
