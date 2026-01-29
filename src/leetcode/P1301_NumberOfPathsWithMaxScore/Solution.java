package leetcode.P1301_NumberOfPathsWithMaxScore;

import java.util.List;

class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int MOD = 1_000_000_007;

        // dp[i][j][0] = max score, dp[i][j][1] = count
        int[][][] dp = new int[n][n][2];

        // Directions: Right, Down, Down-Right (relative to top-left if going backwards)
        // Wait, start is 'E' (bottom-right) or 'S' (top-left)?
        // Problem says: "You are starting at cell (n-1, n-1)... move only to (r-1, c),
        // (r, c-1), (r-1, c-1)"
        // Start is bottom-right. End is top-left (0,0).
        // Let's build DP from top-left (0,0) towards bottom-right?
        // Or bottom-right to top-left.
        // It's easier to think we start at (n-1, n-1) and go to (0,0).
        // Let's use DP table where dp[i][j] is result for getting FROM (i, j) TO (0,
        // 0).
        // Base case: dp[0][0] is {0, 1} (reached start).
        // We iterate i from 0 to n-1, j from 0 to n-1.
        // Wait, moves are Up/Left. So to reach (i, j), we come from (i+1, j), (i, j+1)
        // etc? No.
        // If we want paths FROM Start TO End, moving Up/Left...
        // Then dp[i][j] depends on dp[i-1][j], dp[i][j-1], dp[i-1][j-1].
        // Let's fill from (n-1, n-1) backwards to (0,0).
        // But moves are directions.
        // Rephrase: Start at S(0,0)? No, start at 'S' (0,0) is WRONG.
        // Problem: "start at 'E' (bottom-right)". Target 'S' (top-left).
        // Moves: (r-1, c), (r, c-1), (r-1, c-1).

        // Let's do DP[i][j] = max score from (i, j) to Top-Left.
        // Base case: DP[0][0] = {0, 1}.
        // For cell (i, j), we look at previous cells (i-1, j), (i, j-1), (i-1, j-1)
        // Transitions: if we are at (i, j) we came from (i-1, j)...
        // Actually, let's reverse the problem. Start at (0,0) go to (n-1, n-1). Moves:
        // Down, Right, Diag.
        // Values are same. Max score path is symmetric.

        // DP[i][j] = result reaching (i, j) from (0,0).
        // Initialize everything -1/0.
        // dp[0][0] = {0, 1}.

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0] = -1; // -1 indicates unreachable
            }
        }

        dp[0][0][0] = 0;
        dp[0][0][1] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board.get(i).charAt(j) == 'X')
                    continue;

                // Check neighbors: top, left, top-left
                int[][] neighbors = { { i - 1, j }, { i, j - 1 }, { i - 1, j - 1 } };
                int maxS = -1;

                for (int[] prev : neighbors) {
                    int r = prev[0], c = prev[1];
                    if (r >= 0 && c >= 0 && dp[r][c][0] != -1) {
                        maxS = Math.max(maxS, dp[r][c][0]);
                    }
                }

                if (maxS == -1 && !(i == 0 && j == 0))
                    continue; // Can't reach this cell
                if (i == 0 && j == 0)
                    maxS = 0; // handled init

                int currentVal = 0;
                char ch = board.get(i).charAt(j);
                if (Character.isDigit(ch)) {
                    currentVal = ch - '0';
                }

                dp[i][j][0] = maxS + currentVal;

                // Sum counts
                for (int[] prev : neighbors) {
                    int r = prev[0], c = prev[1];
                    if (r >= 0 && c >= 0 && dp[r][c][0] != -1) {
                        if (dp[r][c][0] == maxS) {
                            dp[i][j][1] = (dp[i][j][1] + dp[r][c][1]) % MOD;
                        }
                    }
                }
            }
        }

        if (dp[n - 1][n - 1][0] == -1)
            return new int[] { 0, 0 };
        return dp[n - 1][n - 1];
    }
}
