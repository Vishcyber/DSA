class Solution {
    public int reverse(int x) {
        int rev = 0;
        int num = x;

        while (num != 0) {
            int dig = num % 10;
            num = num / 10;

            if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10) {
                return 0;
            }
            rev = rev * 10 + dig;

        }
        return rev;
    }
}