package leet_code.Problem_861_Medium_Score_After_Flipping_Matrix;

/**
 * Problem 861: Score After Flipping Matrix
 * https://leetcode.com/problems/score-after-flipping-matrix/
 */
public class Solution {

    /**
     * Calculates the highest possible binary score after row/column flips.
     * Strategy:
     * 1. Flip rows so that every row starts with 1 (MSB optimization).
     * 2. Flip columns if flipping increases the number of 1s in that column.
     * 
     * @param grid Binary matrix.
     * @return Max score.
     * 
     *         Tóm tắt chiến lược:
     *         Bước 1: Lật tất cả các hàng bắt đầu bằng số 0 để đảm bảo bit cao nhất
     *         (MSB) luôn là 1.
     *         Bước 2: Với các cột tiếp theo, đếm số lượng số 1 hiện có. Nếu số 1 ít
     *         hơn
     *         số 0, chúng ta lật cột đó.
     */
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Initial score from MSBs: every row will have 1 at the start.
        // Value of MSB is 2^(n-1).
        int totalScore = m * (1 << (n - 1));

        // Process each remaining column
        for (int j = 1; j < n; j++) {
            int countOnes = 0;
            for (int i = 0; i < m; i++) {
                // If the first cell of the row (grid[i][0]) is 1, the row stayed as is.
                // If it's 0, the row was flipped.
                // So grid[i][j] is 1 in the "final" state if it matches grid[i][0].
                if (grid[i][j] == grid[i][0]) {
                    countOnes++;
                }
            }

            // We want either countOnes or (m - countOnes) whichever is larger.
            int optimizedOnes = Math.max(countOnes, m - countOnes);
            totalScore += optimizedOnes * (1 << (n - 1 - j));
        }

        return totalScore;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] grid1 = { { 0, 0, 1, 1 }, { 1, 0, 1, 0 }, { 1, 1, 0, 0 } };
        System.out.println("Max Score: " + sol.matrixScore(grid1)); // 39

        int[][] grid2 = { { 0 } };
        System.out.println("Max Score: " + sol.matrixScore(grid2)); // 1
    }
}
