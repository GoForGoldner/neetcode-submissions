class Solution {
    public String longestPalindrome(String s) {
        // Base case(s)
        // dp[0] = 0
        // dp[1] = 1
        
        // dp[2] = 
            // If palindrome: 2
            // Or dp[1] (max prev value)
        
        // abbabba
        // dp[0] = 0
        // dp[1] = 1
        // dp[2] = 1
        // dp[3] = 2
        // dp[4] = 4
        // dp[5] = 4
        // dp[6] = 5
        // dp[7] = 7

        // dp[i] = Math.max(right - left + 1 + dp[left])
        // Where s.subtring(left, right) is a palindrome

        int n = s.length();
        int[] dp = new int[n + 1];

        int max = 0;
        int leftP = 0;
        int rightP = 0;

        dp[0] = 0;

        for (int right = 0; right < n; right++) {
            for (int left = 0; left < right; left++) {
                if (isPalindrome(left, right, s)) {
                    dp[right + 1] = right - left + 1;
                    
                    if (right - left + 1 > max) {
                        max = right - left + 1;
                        leftP = left;
                        rightP = right;
                    } 

                    break;
                }
            }
        }

        return s.substring(leftP, rightP + 1);
    }

    private boolean isPalindrome(int left, int right, String s) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) return false;

            left++;
            right--;
        }

        return true;
    }
}
