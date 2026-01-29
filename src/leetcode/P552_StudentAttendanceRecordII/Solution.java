package leetcode.P552_StudentAttendanceRecordII;

class Solution {
    public int checkRecord(int n) {
        final int MOD = 1000000007;

        // dp[i][j][k] = number of records of length i with j absents and k trailing
        // lates
        // optimized to use only previous state
        // dp[j][k]
        long[][] dp = new long[2][3]; // absents: 0,1; lates: 0,1,2

        // Base case: length 0 -> 1 way (empty string) with 0A, 0L
        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            long[][] nextDp = new long[2][3];

            // Iterate through all current states
            // Lặp qua tất cả các trạng thái hiện tại
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    long val = dp[j][k];
                    if (val == 0)
                        continue;

                    // Add 'P' (Present) -> resets lates to 0
                    // Thêm 'P' -> đặt lại số lần đi muộn thành 0
                    nextDp[j][0] = (nextDp[j][0] + val) % MOD;

                    // Add 'A' (Absent) -> increments absents, resets lates to 0
                    // Thêm 'A' -> tăng số lần vắng mặt, đặt lại số lần đi muộn thành 0
                    if (j == 0) {
                        nextDp[j + 1][0] = (nextDp[j + 1][0] + val) % MOD;
                    }

                    // Add 'L' (Late) -> increments lates
                    // Thêm 'L' -> tăng số lần đi muộn
                    if (k < 2) {
                        nextDp[j][k + 1] = (nextDp[j][k + 1] + val) % MOD;
                    }
                }
            }
            dp = nextDp;
        }

        long sum = 0;
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 3; k++) {
                sum = (sum + dp[j][k]) % MOD;
            }
        }

        return (int) sum;
    }
}
