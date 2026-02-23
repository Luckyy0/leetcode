package leet_code.Problem_546_Hard_Remove_Boxes;

public class Solution_DP {

    /**
     * Finds max points to remove boxes.
     * Strategy: 3D DP dp[i][j][k] - max points for boxes[i...j] with k boxes same
     * as boxes[i] to its left.
     * Time: O(N^4), Space: O(N^3).
     */
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] memo = new int[n][n][n];
        return dp(boxes, 0, n - 1, 0, memo);
    }

    private int dp(int[] boxes, int i, int j, int k, int[][][] memo) {
        if (i > j)
            return 0;
        if (memo[i][j][k] > 0)
            return memo[i][j][k];

        // Optimization: skip identical boxes at the beginning
        int i0 = i;
        int k0 = k;
        while (i + 1 <= j && boxes[i + 1] == boxes[i]) {
            i++;
            k++;
        }

        // Option 1: Remove the group boxes[i...i0] along with k prefix
        int res = (k + 1) * (k + 1) + dp(boxes, i + 1, j, 0, memo);

        // Option 2: Try to merge with boxes[m] if boxes[m] == boxes[i]
        for (int m = i + 1; m <= j; m++) {
            if (boxes[m] == boxes[i]) {
                res = Math.max(res, dp(boxes, i + 1, m - 1, 0, memo) + dp(boxes, m, j, k + 1, memo));
            }
        }

        memo[i0][j][k0] = res;
        return res;
    }

    public static void main(String[] args) {
        Solution_DP sol = new Solution_DP();
        int[] boxes = { 1, 3, 2, 2, 2, 3, 4, 3, 1 };
        System.out.println("Max points: " + sol.removeBoxes(boxes)); // Output: 23
    }
}
