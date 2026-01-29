package leetcode.P818_RaceCar;

class Solution {
    public int racecar(int target) {
        int[] dp = new int[target + 1];

        for (int i = 1; i <= target; i++) {
            dp[i] = Integer.MAX_VALUE;

            int n = 0;
            while ((1 << n) - 1 < i)
                n++;

            // Case 1: Pass target and reverse
            // Truong hop 1: Di qua dich roi quay lai
            if ((1 << n) - 1 == i) {
                dp[i] = n;
                continue;
            }

            // Instructions to pass target: n times 'A' + 1 time 'R'
            dp[i] = n + 1 + dp[(1 << n) - 1 - i];

            // Case 2: Stop before target, reverse back m times, then reverse again and go
            // forward
            // Truong hop 2: Dung truoc dich, lui lai m lan, sau do quay lai di tiep
            for (int m = 0; m < n - 1; m++) {
                dp[i] = Math.min(dp[i], n - 1 + 1 + m + 1 + dp[i - ((1 << (n - 1)) - (1 << m))]);
            }
        }

        return dp[target];
    }
}
