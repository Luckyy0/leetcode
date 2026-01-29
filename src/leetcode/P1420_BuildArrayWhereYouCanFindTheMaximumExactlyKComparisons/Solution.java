package leetcode.P1420_BuildArrayWhereYouCanFindTheMaximumExactlyKComparisons;

class Solution {
    public int numOfArrays(int n, int m, int k) {
        long[][][] dp = new long[n + 1][m + 1][k + 1];
        int MOD = 1_000_000_007;

        // Base case: length 1
        for (int v = 1; v <= m; v++) {
            dp[1][v][1] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int c = 1; c <= k; c++) {
                long sumPrevCost = 0;
                for (int maxVal = 1; maxVal <= m; maxVal++) {
                    // Part 1: New element <= maxVal. Current max remains maxVal. Cost unchanged.
                    // Choices for new element: 1 to maxVal.
                    // Wait, recursive relation:
                    // Ways to have maxVal at length i with cost c =
                    // (Ways with maxVal at length i-1 with cost c) * maxVal (append any 1..maxVal)
                    // + (Ways with prevMax < maxVal at length i-1 with cost c-1) (append maxVal)

                    long part1 = (dp[i - 1][maxVal][c] * maxVal) % MOD;

                    // sumPrevCost accumulates dp[i-1][prev][c-1] for prev < maxVal
                    // At start of loop maxVal=1, sumPrevCost includes nothing.
                    // Then add dp[i-1][1][c-1] for next iteration.

                    long part2 = sumPrevCost; // Just append maxVal (1 choice)

                    dp[i][maxVal][c] = (part1 + part2) % MOD;

                    // Update prefix sum for next maxVal
                    if (c > 0) {
                        sumPrevCost = (sumPrevCost + dp[i - 1][maxVal][c - 1]) % MOD;
                    }
                }
            }
        }

        long res = 0;
        for (int v = 1; v <= m; v++) {
            res = (res + dp[n][v][k]) % MOD;
        }

        return (int) res;
    }
}
