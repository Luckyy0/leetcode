package leet_code.Problem_221_Medium_Maximal_Square;

public class Solution_DP {

    /**
     * Finds the area of the largest square containing only 1s.
     * Uses Dynamic Programming with O(MN) time and O(MN) space.
     * 
     * Tìm diện tích của hình vuông lớn nhất chỉ chứa số 1.
     * Sử dụng Quy hoạch động với thời gian O(MN) và không gian O(MN).
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxSide = 0;

        // dp[i][j] represents the side length of the max square whose bottom-right
        // corner is (i, j)
        // dp[i][j] đại diện cho độ dài cạnh của hình vuông lớn nhất có góc dưới bên
        // phải là (i, j)
        int[][] dp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        // Base case: First row or first column can only form square of size 1
                        // Trường hợp cơ sở: Hàng đầu hoặc cột đầu chỉ có thể tạo hình vuông kích thước
                        // 1
                        dp[i][j] = 1;
                    } else {
                        // Recurrence relation
                        // Hệ thức truy hồi
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }

        return maxSide * maxSide;
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();

        // Test Case 1
        char[][] matrix1 = {
                { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' }
        };
        System.out.println("Maximal Square 1: " + solution.maximalSquare(matrix1));

        // Test Case 2
        char[][] matrix2 = {
                { '0', '1' },
                { '1', '0' }
        };
        System.out.println("Maximal Square 2: " + solution.maximalSquare(matrix2));
    }
}
