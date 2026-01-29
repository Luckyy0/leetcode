package leetcode.P1872_StoneGameVIII;

public class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int[] prefix = new int[n];
        prefix[0] = stones[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + stones[i];
        }

        // dp[i] represents the max score difference the current player can get
        // given the previous move ended at index i-1 (so can pick i...n-1).
        // Actually, the choices are indices in prefix array.
        // Choices range from 1 to n-1.
        // Let 'ans' be the max relative score for the player whose turn it is.

        // Base case: Only choice is picking everything (index n-1).
        // Score is prefix[n-1].
        int ans = prefix[n - 1]; // Equivalent to picking index n-1

        // Iterate backwards. At each step i, we can pick index i.
        // Score: prefix[i] - (best opponent score from i+1 forwards)
        // Best opponent score from i+1 forward is simply 'ans' from previous iteration.
        // So current option value: prefix[i] - ans.
        // We update ans = max(ans, prefix[i] - ans).

        for (int i = n - 2; i >= 1; i--) {
            ans = Math.max(ans, prefix[i] - ans);
        }

        return ans;
    }
}
