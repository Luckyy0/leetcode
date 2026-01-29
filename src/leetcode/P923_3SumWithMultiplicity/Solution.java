package leetcode.P923_3SumWithMultiplicity;

class Solution {
    public int count3SumMulti(int[] arr, int target) {
        long mod = 1_000_000_007;
        long[] count = new long[101];
        for (int x : arr)
            count[x]++;

        long res = 0;
        for (int i = 0; i <= 100; i++) {
            for (int j = i; j <= 100; j++) {
                int k = target - i - j;
                if (k < j || k > 100)
                    continue;

                if (i == j && j == k) {
                    res = (res + count[i] * (count[i] - 1) * (count[i] - 2) / 6) % mod;
                } else if (i == j) {
                    res = (res + count[i] * (count[i] - 1) / 2 * count[k]) % mod;
                } else if (j == k) {
                    res = (res + count[i] * count[j] * (count[j] - 1) / 2) % mod;
                } else {
                    res = (res + count[i] * count[j] * count[k]) % mod;
                }
            }
        }
        return (int) res;
    }
}
