package leet_code.Problem_980_Hard_Unique_Paths_III;

/**
 * Problem 980: Unique Paths III
 * https://leetcode.com/problems/unique-paths-iii/
 */
public class Solution {

    private int rows;
    private int cols;
    private int pathCount;
    private int targetWalkableCells;

    /**
     * Finds the number of paths visiting every non-obstacle square exactly once.
     * Strategy: Backtracking DFS.
     * 
     * @param grid The grid.
     * @return Number of unique paths.
     * 
     *         Tóm tắt chiến lược:
     *         1. Đây là bài toán tìm đường đi Hamilton trên lưới (đi qua mọi đỉnh
     *         đúng 1 lần).
     *         2. Do kích thước lưới nhỏ (`m*n <= 20`), ta có thể dùng thuật toán
     *         Quay lui (Backtracking).
     *         3. Đầu tiên, duyệt lưới để đếm tổng số ô không phải chướng ngại vật
     *         (`targetWalkableCells`).
     *         Bao gồm cả ô Bắt đầu (1) và ô Kết thúc (2).
     *         4. Tìm vị trí ô Bắt đầu.
     *         5. Khởi động DFS từ ô Bắt đầu.
     *         - Trong hàm DFS(r, c, count):
     *         - Kiểm tra biên và chướng ngại vật (`-1`). Nếu vi phạm -> Return.
     *         - Nếu gặp ô Kết thúc (`2`):
     *         Kiểm tra xem số lượng ô đã đi qua (`count`) có bằng tổng số ô cần đi
     *         (`targetWalkableCells`) không.
     *         Nếu bằng -> Tìm thấy 1 đường đi hợp lệ -> Tăng `pathCount`.
     *         Return.
     *         - Đánh dấu ô hiện tại là đã thăm (đổi thành `-1` tạm thời).
     *         - Gọi đệ quy 4 hướng: Lên, Xuống, Trái, Phải với `count + 1`.
     *         - Quay lui (Backtrack): Khôi phục ô hiện tại về trạng thái cũ để các
     *         nhánh đệ quy khác có thể sử dụng lại.
     */
    public int uniquePathsIII(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        pathCount = 0;
        targetWalkableCells = 0;

        int startR = 0, startC = 0;

        // Step 1: Count walkable cells and find start
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != -1) {
                    targetWalkableCells++;
                }
                if (grid[i][j] == 1) {
                    startR = i;
                    startC = j;
                }
            }
        }

        // Step 2: Start DFS
        // Current visited count is 1 (start node)
        dfs(grid, startR, startC, 1);

        return pathCount;
    }

    private void dfs(int[][] grid, int r, int c, int visitedCount) {
        // Base case: Check bounds and obstacles
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == -1) {
            return;
        }

        // Base case: Reached end square
        if (grid[r][c] == 2) {
            if (visitedCount == targetWalkableCells) {
                pathCount++;
            }
            return;
        }

        // Mark as visited by temporarily setting to obstacle (-1)
        // Store original value (should be 0 or 1, but we only backtrack 0 really since
        // 1 is start)
        int originalVal = grid[r][c];
        grid[r][c] = -1;

        // Explore neighbors
        dfs(grid, r + 1, c, visitedCount + 1);
        dfs(grid, r - 1, c, visitedCount + 1);
        dfs(grid, r, c + 1, visitedCount + 1);
        dfs(grid, r, c - 1, visitedCount + 1);

        // Backtrack: Restore cell state
        grid[r][c] = originalVal;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] g1 = { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 2, -1 } };
        System.out.println("Result: " + sol.uniquePathsIII(g1)); // 2

        int[][] g2 = { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 2 } };
        System.out.println("Result: " + sol.uniquePathsIII(g2)); // 4

        int[][] g3 = { { 0, 1 }, { 2, 0 } };
        System.out.println("Result: " + sol.uniquePathsIII(g3)); // 0
    }
}
