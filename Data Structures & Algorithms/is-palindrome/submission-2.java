class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }

        String cleanStr = sb.toString();

        int left = 0, right = cleanStr.length() - 1;
        while (left <= right) {
            if (cleanStr.charAt(left) != cleanStr.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }
}
