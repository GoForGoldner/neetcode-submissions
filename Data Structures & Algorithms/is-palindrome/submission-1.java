class Solution {
    public boolean isPalindrome(String s) {
        // Doesn't care about the case 
        // Ignore all non letter non number characters

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) sb.append(Character.toLowerCase(c));
        }

        String cleanStr = sb.toString();

        System.out.println(cleanStr);

        int left = 0, right = cleanStr.length() - 1;
        while (left <= right) {
            if (cleanStr.charAt(left) != cleanStr.charAt(right)) return false;

            left++;
            right--;
        }

        return true;
    }
}
