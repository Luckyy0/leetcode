package leetcode.P1524_NumberOfSubArraysWithOddSum;

class Solution {
    public int numOfSubarrays(int[] arr) {
        long odd = 0, even = 1; // even initialized to 1 for prefix sum 0
        long res = 0;
        int sum = 0;
        int MOD = 1_000_000_007;

        for (int x : arr) {
            sum += x;
            if (sum % 2 != 0) {
                res = (res + even) % MOD;
                odd++;
            } else {
                res = (res + odd) % MOD;
                even++;
            }
        }

        return (int) res;
    }
}
