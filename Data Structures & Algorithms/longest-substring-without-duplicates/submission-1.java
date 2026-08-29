class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(); 

        int max = 0;
        Set<Character> letters = new HashSet<>();

        int left = 0, right = 0;

        while (right < n) {
            char rChar = s.charAt(right);
            
            if (letters.contains(rChar)) {
                max = Math.max(max, letters.size());

                // Remove the left letters until they're is no duplicates
                while (letters.contains(rChar)) {
                    letters.remove(s.charAt(left));
                    left++;
                }
            }

            letters.add(rChar);
            right++;
        }

        max = Math.max(max, letters.size());

        return max;
    }
}
