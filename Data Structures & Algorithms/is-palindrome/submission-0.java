class Solution {
    public boolean isPalindrome(String s) {
        String cleanStr = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int left = 0, right = cleanStr.length() - 1;

        while (left <= right) {
            if (cleanStr.charAt(left) != cleanStr.charAt(right)) return false;

            left++; 
            right--;
        }

        return true;
    }
}
