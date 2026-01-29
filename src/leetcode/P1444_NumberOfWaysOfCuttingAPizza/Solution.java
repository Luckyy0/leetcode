package leetcode.P1444_NumberOfWaysOfCuttingAPizza;

class Solution {
    Integer[][][] memo;
    int[][] apples;
    int rows, cols;
    int MOD = 1_000_000_007;

    public int ways(String[] pizza, int k) {
        rows = pizza.length;
        cols = pizza[0].length();
        apples = new int[rows + 1][cols + 1];

        // Suffix Sums
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                int has = (pizza[i].charAt(j) == 'A') ? 1 : 0;
                apples[i][j] = has + apples[i + 1][j] + apples[i][j + 1] - apples[i + 1][j + 1];
            }
        }

        memo = new Integer[k + 1][rows][cols];
        return dfs(k, 0, 0);
    }

    private int dfs(int k, int r, int c) {
        if (apples[r][c] == 0)
            return 0; // No apples remaining
        if (k == 1)
            return 1; // Valid single piece

        if (memo[k][r][c] != null)
            return memo[k][r][c];

        long count = 0;

        // Horizontal Cuts
        for (int nr = r + 1; nr < rows; nr++) {
            // Cut between nr-1 and nr
            int upperApples = apples[r][c] - apples[nr][c];
            if (upperApples > 0) {
                count = (count + dfs(k - 1, nr, c)) % MOD;
            }
        }

        // Vertical Cuts
        for (int nc = c + 1; nc < cols; nc++) {
            int leftApples = apples[r][c] - apples[r][nc];
            if (leftApples > 0) {
                count = (count + dfs(k - 1, r, nc)) % MOD;
            }
        }

        return memo[k][r][c] = (int) count;
    }
}
