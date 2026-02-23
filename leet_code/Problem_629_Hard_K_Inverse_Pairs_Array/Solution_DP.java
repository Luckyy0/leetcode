package leet_code.Problem_629_Hard_K_Inverse_Pairs_Array;

public class Solution_DP {

    /**
     * Finds the number of arrays of n elements with exactly k inverse pairs.
     * Strategy: DP with O(1) sliding window optimization.
     * Time: O(N*K), Space: O(K).
     */
    public int kInversePairs(int n, int k) {
        int MOD = 1000000007;

        // dp[j] represents number of permutations of current 'i' elements with 'j'
        // inverse pairs
        int[] dp = new int[k + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            int[] nextDp = new int[k + 1];
            long currentSum = 0;

            for (int j = 0; j <= k; j++) {
                // Add the new contribution
                currentSum = (currentSum + dp[j]) % MOD;

                // Subtract the element that falls out of the sliding window of size 'i'
                if (j >= i) {
                    currentSum = (currentSum - dp[j - i] + MOD) % MOD;
                }

                nextDp[j] = (int) currentSum;
            }
            dp = nextDp;
        }

        return dp[k];
    }

    public static void main(String[] args) {
        Solution_DP sol = new Solution_DP();
        System.out.println("Result (n=3, k=0): " + sol.kInversePairs(3, 0)); // 1
        System.out.println("Result (n=3, k=1): " + sol.kInversePairs(3, 1)); // 2
    }
}
