package leetcode.P793_PreimageSizeOfFactorialZeroesFunction;

class Solution {
    public int preimageSizeFZF(int k) {
        long low = 0, high = 5L * (k + 1);

        while (low < high) {
            long mid = low + (high - low) / 2;
            long val = zeroes(mid);
            if (val == k)
                return 5;
            if (val < k)
                low = mid + 1;
            else
                high = mid;
        }

        return 0;
    }

    private long zeroes(long n) {
        long res = 0;
        while (n >= 5) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }
}
