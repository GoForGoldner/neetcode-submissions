class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftPrefix = new int[n + 1];
        int[] rightPrefix = new int[n + 1];

        leftPrefix[0] = 1;
        rightPrefix[n] = 1;

        for (int i = 1; i <= n; i++) {
            leftPrefix[i] = leftPrefix[i - 1] * nums[i - 1]; 
        }

        for (int i = n - 1; i >= 0; i--) {
            rightPrefix[i] = rightPrefix[i + 1] * nums[i];
        }

        int[] output = new int[n];
        for (int i = 0; i < n; i++) {
            output[i] = leftPrefix[i] * rightPrefix[i + 1];
        }

        return output;
    }
}  
