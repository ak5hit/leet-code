class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;

        int divideBy = 2;
        if (n < 0) {
            divideBy = -2;
        }

        boolean ans = true;

        while (n != 1) {
            if (n % 2 != 0 || n == -1) {
                return false;
            }
            n = n / 2;
        }

        return true;
    }
}