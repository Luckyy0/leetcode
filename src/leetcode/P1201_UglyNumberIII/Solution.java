package leetcode.P1201_UglyNumberIII;

class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long low = 1, high = 2_000_000_000;
        long la = a, lb = b, lc = c;
        long lab = lcm(la, lb);
        long lac = lcm(la, lc);
        long lbc = lcm(lb, lc);
        long labc = lcm(lab, lc);

        while (low < high) {
            long mid = low + (high - low) / 2;
            long count = mid / la + mid / lb + mid / lc
                    - mid / lab - mid / lac - mid / lbc
                    + mid / labc;
            if (count < n) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return (int) low;
    }

    private long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    private long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }
}
