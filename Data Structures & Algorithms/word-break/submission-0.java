class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        // Dynamic programming problem

        // For each new character

        // Look at all new possible words that can be added for it
        // If it's possible state that in the dp
        // return if dp is possible at the end

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int r = 1; r <= n; r++) {
            for (int l = r; l >= 0; l--) {
                String possibleWord = s.substring(l, r);

                if (dp[l] && wordDict.contains(possibleWord)) {
                    dp[r] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
