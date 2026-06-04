class Solution {
    public int getSum(int a, int b) {
        // 1001
        // 1011
        
        // a ^ b 0010
        // a & b << 1 = 10010
        // that is the equivilant to addition
        while (b != 0) {
            int temp = (a & b) << 1;
            a = a ^ b;
            b = temp;
        }

        return a;
    }
}
