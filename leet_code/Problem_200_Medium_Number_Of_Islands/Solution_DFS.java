package leet_code.Problem_200_Medium_Number_Of_Islands;

public class Solution_DFS {

    /**
     * Counts the number of islands in a binary grid.
     * Uses DFS to traverse and "sink" connected lands.
     * Time: O(MxN), Space: O(MxN) (worst case recursion).
     * 
     * Đếm số lượng hòn đảo trong lưới nhị phân.
     * Sử dụng DFS để duyệt và "đánh chìm" các vùng đất liên kết.
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If we encounter a piece of land, it starts a new island
                // Nếu gặp một mảnh đất, nó bắt đầu một hòn đảo mới
                if (grid[i][j] == '1') {
                    count++;
                    // Sink the entire island
                    // Đánh chìm toàn bộ hòn đảo
                    sinkIsland(grid, i, j, rows, cols);
                }
            }
        }

        return count;
    }

    // Helper DFS function to mark visited land as water ('0')
    private void sinkIsland(char[][] grid, int r, int c, int rows, int cols) {
        // Boundary checks and water check
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == '0') {
            return;
        }

        // Mark as visited (turn land to water)
        grid[r][c] = '0';

        // Visit all 4 adjacent neighbors
        sinkIsland(grid, r + 1, c, rows, cols); // Down
        sinkIsland(grid, r - 1, c, rows, cols); // Up
        sinkIsland(grid, r, c + 1, rows, cols); // Right
        sinkIsland(grid, r, c - 1, rows, cols); // Left
    }

    public static void main(String[] args) {
        Solution_DFS solution = new Solution_DFS();

        // Test Case 1
        char[][] grid1 = {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' }
        };
        System.out.println("Islands 1: " + solution.numIslands(grid1));

        // Test Case 2
        char[][] grid2 = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };
        System.out.println("Islands 2: " + solution.numIslands(grid2)); // Note: grid is modified
    }
}
