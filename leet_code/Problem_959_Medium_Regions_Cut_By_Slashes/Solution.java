package leet_code.Problem_959_Medium_Regions_Cut_By_Slashes;

/**
 * Problem 959: Regions Cut By Slashes
 * https://leetcode.com/problems/regions-cut-by-slashes/
 */
public class Solution {

    /**
     * Finds the number of regions created by slashes in the grid.
     * Strategy: Matrix Upscaling (3x3) and DFS/BFS.
     * 
     * @param grid Array of strings representing the grid.
     * @return Number of regions.
     * 
     *         Tóm tắt chiến lược:
     *         1. Để dễ dàng xử lý các dấu gạch chéo '/' và '\' cắt các ô vuông, ta
     *         có thể mở rộng (upscale) mỗi ô `1x1` trong lưới ban đầu thành một
     *         lưới con `3x3`.
     *         Lý do chọn `3x3`:
     *         - Một dấu '/' sẽ đi qua các ô con `(0, 2), (1, 1), (2, 0)`.
     *         - Một dấu '\' sẽ đi qua các ô con `(0, 0), (1, 1), (2, 2)`.
     *         - Việc này tạo ra một ranh giới rõ ràng chia lưới con thành hai phần
     *         riêng biệt.
     *         2. Tạo một ma trận `matrix` kích thước `(3*N) x (3*N)`. Ban đầu tất
     *         cả là 0.
     *         3. Duyệt qua lưới `grid` ban đầu:
     *         - Nếu gặp '/', đánh dấu các ô tương ứng trong `matrix` là 1 (chướng
     *         ngại vật).
     *         - Nếu gặp '\', đánh dấu các ô tương ứng là 1.
     *         4. Bài toán trở thành tìm số lượng vùng liên thông (Connected
     *         Components) của các ô số 0 trong `matrix`.
     *         - Duyệt qua từng ô `(i, j)` của `matrix`.
     *         - Nếu gặp một ô 0 chưa được thăm, tăng biến đếm `regions` lên 1 và
     *         thực hiện DFS (hoặc BFS) để đánh dấu tất cả các ô 0 liên thông với nó
     *         thành 1 (đã thăm).
     *         5. Trả về `regions`.
     */
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int size = n * 3;
        int[][] matrix = new int[size][size];

        // Fill the upscaled matrix based on the slashes
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char ch = grid[i].charAt(j);
                if (ch == '/') {
                    matrix[i * 3][j * 3 + 2] = 1;
                    matrix[i * 3 + 1][j * 3 + 1] = 1;
                    matrix[i * 3 + 2][j * 3] = 1;
                } else if (ch == '\\') {
                    matrix[i * 3][j * 3] = 1;
                    matrix[i * 3 + 1][j * 3 + 1] = 1;
                    matrix[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }

        int regions = 0;
        // Count connected components of 0s
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == 0) {
                    regions++;
                    dfs(matrix, i, j, size);
                }
            }
        }

        return regions;
    }

    private void dfs(int[][] matrix, int r, int c, int size) {
        // Boundary checks and visited check (matrix[r][c] == 1 means obstacle or
        // visited)
        if (r < 0 || c < 0 || r >= size || c >= size || matrix[r][c] == 1) {
            return;
        }

        matrix[r][c] = 1; // Mark as visited

        // Visit neighbors
        dfs(matrix, r + 1, c, size);
        dfs(matrix, r - 1, c, size);
        dfs(matrix, r, c + 1, size);
        dfs(matrix, r, c - 1, size);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] g1 = { " /", "/ " };
        System.out.println("Result: " + sol.regionsBySlashes(g1)); // 2

        String[] g2 = { " /", "  " };
        System.out.println("Result: " + sol.regionsBySlashes(g2)); // 1

        String[] g3 = { "/\\", "\\/" }; // Represents /\ and \/
        System.out.println("Result: " + sol.regionsBySlashes(g3)); // 5
    }
}
