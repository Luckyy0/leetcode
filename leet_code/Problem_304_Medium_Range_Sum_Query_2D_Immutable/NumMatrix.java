package leet_code.Problem_304_Medium_Range_Sum_Query_2D_Immutable;

public class NumMatrix {

    private int[][] dp;

    /**
     * Initializes with the input matrix.
     * Computes 2D prefix sums.
     * Time: O(M*N) init, O(1) query.
     * 
     * Khởi tạo với ma trận đầu vào.
     * Tính toán tổng tiền tố 2D.
     */
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // dp[i+1][j+1] = matrix[i][j] + top + left - diag
                dp[i + 1][j + 1] = matrix[i][j]
                        + dp[i][j + 1]
                        + dp[i + 1][j]
                        - dp[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        // Sum = BottomRight - TopRight - BottomLeft + TopLeft
        // Note indices are +1 because dp is padded
        return dp[row2 + 1][col2 + 1]
                - dp[row1][col2 + 1]
                - dp[row2 + 1][col1]
                + dp[row1][col1];
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 3, 0, 1, 4, 2 },
                { 5, 6, 3, 2, 1 },
                { 1, 2, 0, 1, 5 },
                { 4, 1, 0, 1, 7 },
                { 1, 0, 3, 0, 5 }
        };
        NumMatrix obj = new NumMatrix(matrix);

        System.out.println("Region 1: " + obj.sumRegion(2, 1, 4, 3)); // 8
        System.out.println("Region 2: " + obj.sumRegion(1, 1, 2, 2)); // 11
        System.out.println("Region 3: " + obj.sumRegion(1, 2, 2, 4)); // 12
    }
}
