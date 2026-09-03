class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int minValue = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < minValue) {
                minValue = price;
            } else {
                max = Math.max(max, price - minValue);
            }
        }
        

        return max;
    }
}
