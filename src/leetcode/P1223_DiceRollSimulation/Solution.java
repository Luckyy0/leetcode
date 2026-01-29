package leetcode.P1223_DiceRollSimulation;

class Solution {
    public int dieSimulator(int n, int[] rollMax) {
        long MOD = 1_000_000_007;
        // dp[face][count] for length i
        // face: 0-5. count: 1 to 15.
        // Array size [6][16].
        long[][] dp = new long[6][16];

        // Init length 1
        for (int f = 0; f < 6; f++) {
            dp[f][1] = 1;
        }

        for (int i = 2; i <= n; i++) {
            long[][] nextDp = new long[6][16];

            // Calculate sums of prev length for each face
            long[] sumPrev = new long[6];
            long totalPrev = 0;
            for (int f = 0; f < 6; f++) {
                for (int c = 1; c <= rollMax[f]; c++) {
                    sumPrev[f] = (sumPrev[f] + dp[f][c]) % MOD;
                }
                totalPrev = (totalPrev + sumPrev[f]) % MOD;
            }

            // Transition
            for (int f = 0; f < 6; f++) {
                // 1. Same face: extend count
                for (int c = 1; c < rollMax[f]; c++) {
                    if (dp[f][c] > 0) {
                        nextDp[f][c + 1] = dp[f][c];
                    }
                }

                // 2. Different face: reset count to 1
                // Can come from any OTHER face
                // nextDp[f][1] = totalPrev - sumPrev[f]
                long diffSum = (totalPrev - sumPrev[f] + MOD) % MOD;
                nextDp[f][1] = diffSum;
            }
            dp = nextDp;
        }

        long res = 0;
        for (int f = 0; f < 6; f++) {
            for (int c = 1; c <= rollMax[f]; c++) {
                res = (res + dp[f][c]) % MOD;
            }
        }

        return (int) res;
    }
}
