package leetcode.P878_NthMagicalNumber;

class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        long lcm = (long) a * b / gcd(a, b);
        long low = 2, high = (long) Math.min(a, b) * n;
        long res = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long count = mid / a + mid / b - mid / lcm;
            if (count >= n) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return (int) (res % 1_000_000_007);
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
