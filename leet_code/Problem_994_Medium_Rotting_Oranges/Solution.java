package leet_code.Problem_994_Medium_Rotting_Oranges;

import java.util.*;

/**
 * Problem 994: Rotting Oranges
 * https://leetcode.com/problems/rotting-oranges/
 */
public class Solution {

    /**
     * Calculates the minimum minutes for all oranges to rot.
     * Strategy: Multi-source Breadth-First Search (BFS).
     * 
     * @param grid The grid of oranges.
     * @return Minimum minutes or -1 if impossible.
     * 
     *         Tóm tắt chiến lược:
     *         1. Đây là bài toán lây lan từ MỘT SỐ nguồn khác nhau cùng lúc. Giải
     *         pháp tốt nhất là BFS Đa Nguồn (Multi-source BFS).
     *         2. Quét toàn bộ lưới (grid) lần đầu tiên để:
     *         - Đếm tổng số lượng cam tươi (`freshCount`).
     *         - Đưa tất cả tọa độ của những quả cam đã hỏng sẵn (giá trị 2) vào một
     *         hàng đợi (`queue`). Đây là các "nguồn lây nhiễm" ban đầu (Phút thứ
     *         0).
     *         3. Xử lý BFS theo từng bước (từng lớp):
     *         - Mỗi vòng lặp của BFS đại diện cho 1 phút trôi qua.
     *         - Lấy tất cả các quả cam hỏng hiện có trong `queue` ra, kiểm tra 4
     *         hướng xung quanh nó (Tuyệt đối chỉ lấy số lượng phần tử ban đầu trong
     *         `queue` của lớp hiện tại bằng biến `size = queue.size()`).
     *         - Nếu hướng nào lân cận là quả cam tươi (giá trị 1):
     *         - Biến nó thành cam hỏng (cập nhật lưới thành giá trị 2).
     *         - Trừ bộ đếm `freshCount` đi 1.
     *         - Đẩy tọa độ quả cam mới hỏng này vào `queue` để lây nhiễm ở phút
     *         tiếp theo.
     *         - Kết thúc xử lý lớp hiện tại thì tăng biến `minutes` lên 1.
     *         4. Vòng lặp BFS kết thúc khi không còn cam hỏng nào trong `queue`
     *         hoăc khi `freshCount == 0` (để tránh cộng thừa phút xếp hàng cuối
     *         cùng trước khi dừng).
     *         5. Kết luận: Kiểm tra `freshCount`, nếu bằng 0 có nghĩa là tất cả đều
     *         hỏng, trả về số `minutes`. Nếu lớn hơn 0, có quả cam bị mắc kẹt không
     *         thể lây nhiễm, trả về -1.
     */
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        // Step 1: Count fresh oranges and find initial rotten oranges
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[] { r, c });
                } else if (grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }

        // Edge case: No fresh oranges to begin with
        if (freshCount == 0) {
            return 0;
        }

        int minutes = 0;
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // Up, Down, Left, Right

        // Step 2: Multi-source BFS
        // We also check freshCount > 0 to stop early and prevent counting the last
        // minute after everything has rotted
        while (!queue.isEmpty() && freshCount > 0) {
            int levelSize = queue.size();

            // Process ALL rotten oranges at the current minute
            for (int i = 0; i < levelSize; i++) {
                int[] current = queue.poll();
                int r = current[0];
                int c = current[1];

                // Rot adjacent fresh oranges
                for (int[] dir : directions) {
                    int nextR = r + dir[0];
                    int nextC = c + dir[1];

                    // Check bounds and if the adjacent orange is fresh
                    if (nextR >= 0 && nextR < rows && nextC >= 0 && nextC < cols && grid[nextR][nextC] == 1) {
                        grid[nextR][nextC] = 2; // Make it rotten
                        freshCount--;
                        queue.offer(new int[] { nextR, nextC }); // Enqueue for next minute
                    }
                }
            }
            // Finished a minute
            minutes++;
        }

        // Step 3: Check if all fresh oranges were successfully rotten
        return freshCount == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] grid1 = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        System.out.println("Result 1: " + sol.orangesRotting(grid1)); // 4

        int[][] grid2 = { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } };
        System.out.println("Result 2: " + sol.orangesRotting(grid2)); // -1

        int[][] grid3 = { { 0, 2 } };
        System.out.println("Result 3: " + sol.orangesRotting(grid3)); // 0
    }
}
