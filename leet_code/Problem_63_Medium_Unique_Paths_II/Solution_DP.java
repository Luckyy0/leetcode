package leet_code.Problem_63_Medium_Unique_Paths_II;

public class Solution_DP {

    /**
     * Finds the number of unique paths in a grid with obstacles.
     * Uses optimized DP with O(n) space.
     * Tìm số lượng đường đi duy nhất trong lưới có vật cản.
     * Sử dụng Quy hoạch động tối ưu với không gian O(n).
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0][0] == 1) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];

        // Start cell
        dp[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    // Obstacle: no paths through this cell
                    // Vật cản: không có đường đi qua ô này
                    dp[j] = 0;
                } else if (j > 0) {
                    // Contribution from left neighbor (contribution from above is already in dp[j])
                    // Đóng góp từ ô lân cận bên trái (đóng góp từ phía trên đã có sẵn trong dp[j])
                    dp[j] += dp[j - 1];
                }
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();

        // Test Case 1
        int[][] g1 = {
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 0 }
        };
        System.out.println("Test Case 1: " + solution.uniquePathsWithObstacles(g1));
        // Expected: 2

        // Test Case 2
        int[][] g2 = {
                { 0, 1 },
                { 0, 0 }
        };
        System.out.println("Test Case 2: " + solution.uniquePathsWithObstacles(g2));
        // Expected: 1
    }
}
