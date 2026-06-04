class Solution {
    public int getSum(int a, int b) {
        // a ^ b + (a & b) << 1 is equivilant to addition
        while (b != 0) {
            int temp = (a & b) << 1;
            a = a ^ b;
            b = temp;
        }

        return a;
    }
}
