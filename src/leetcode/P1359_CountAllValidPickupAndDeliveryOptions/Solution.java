package leetcode.P1359_CountAllValidPickupAndDeliveryOptions;

class Solution {
    public int countOrders(int n) {
        long res = 1;
        long MOD = 1_000_000_007;

        for (int i = 1; i <= n; i++) {
            res = (res * i) % MOD;
            res = (res * (2 * i - 1)) % MOD;
        }

        return (int) res;
    }
}
