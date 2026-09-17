class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int prev1 = 1, prev2 = 2;

        for (int i = 0; i < n - 2; i++) {
            int output = prev2 + prev1;
            prev1 = prev2;
            prev2 = output;
        }

        return prev2;
    }
}
