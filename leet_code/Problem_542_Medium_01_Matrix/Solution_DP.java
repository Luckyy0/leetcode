package leet_code.Problem_542_Medium_01_Matrix;

public class Solution_DP {

    /**
     * Finds distance to nearest 0.
     * Strategy: Two-pass DP.
     * Time: O(M*N), Space: O(1) (Output matrix).
     */
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int INF = m + n; // Maximum possible distance

        // Pass 1: Top-Left to Bottom-Right
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0)
                    continue;

                int top = (i - 1 >= 0) ? mat[i - 1][j] : INF;
                int left = (j - 1 >= 0) ? mat[i][j - 1] : INF;

                mat[i][j] = Math.min(top, left) + 1;
            }
        }

        // Pass 2: Bottom-Right to Top-Left
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (mat[i][j] == 0)
                    continue;

                int bottom = (i + 1 < m) ? mat[i + 1][j] : INF;
                int right = (j + 1 < n) ? mat[i][j + 1] : INF;

                mat[i][j] = Math.min(mat[i][j], Math.min(bottom, right) + 1);
            }
        }

        return mat;
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();
        int[][] mat = {
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 1, 1, 1 }
        };
        // Expected: [[0,0,0],[0,1,0],[1,2,1]]
        int[][] res = solution.updateMatrix(mat);

        System.out.println("Result:");
        for (int[] row : res) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
