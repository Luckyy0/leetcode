package leet_code.Problem_1034_Medium_Coloring_A_Border;

import java.util.Arrays;

/**
 * Problem 1034: Coloring A Border
 * https://leetcode.com/problems/coloring-a-border/
 */
public class Solution {

    /**
     * Colors the border of the connected component containing the given cell.
     * Strategy: Depth-First Search (DFS) with In-Place Grid Modification (Flood
     * Fill variant).
     * 
     * @param grid  The m x n integer matrix representing the grid.
     * @param row   The row index of the starting cell.
     * @param col   The col index of the starting cell.
     * @param color The new color to paint the border.
     * @return The modified grid.
     * 
     *         Tóm tắt chiến lược:
     *         1. "Tạt Sơn Biên Giới - Thuật Toán Thám Hiểm Lỗi DFS Biến Tính":
     *         - Cho 1 điểm rốn `(row, col)`. Tất cả các ô KHỚP MÀU với nó, dính
     *         chặt
     *         thành 1 Khối Nhất Thể (Connected Component).
     *         - Sứ Mệnh: Trát cái màu MỚI `color` CHỈ DUY NHẤT LÊN LỚP VỎ VIỀN
     *         NGOÀI.
     *         + Vỏ Viền = Rớt trúng Lề Tường Bản Đồ HOẶC Cọ Sát Kẻ Ngoại Đạo (Khác
     *         Màu Cũ).
     *         + Chỗ Lõi (4 phía bao bọc kín bưng bởi Đồng Môn) -> Nằm Nghỉ, Dữ Màu
     *         Cũ!
     * 
     *         2. Chơi chiêu Thuật O(N) Biến Dạng Tại Chỗ (In-Place Mutilation):
     *         - Dùng Đệ Quy Nở Hoa `dfs()`.
     *         - Mình Lội đi tới Đâu, mình Bóp Miệng Dìm Ô Đó Thành MÀU ÂM!
     *         (ví dụ gốc màu `1`, mình đạp méo nó thành `-1`).
     *         -> Đòn này Vừa Để ĐÁNH DẤU "ĐÃ ĐI QUA" (Visited) đỡ phải cài cắm mảng
     *         Phụ
     *         tốn RAM `boolean[][]`. Vừa BẢO TỒN ĐƯỢC MÀU GỐC BẦM XÁC (Trị tuyệt
     *         đối).
     * 
     *         3. Luật Suy Cứu: Điểm nào Phải Đổ Sơn?
     *         - Tại ô Hiện Tại, Quét Rada 4 Mạn Xung Quanh. Đếm Rọ:
     *         Đứa nào Mang Âm Khí (-1) HOẶC Mang Dương Khủng Ý Chí màu Gốc (1)
     *         CHÍNH LÀ
     *         Anh Em Huyết Nhục Máu Cũ Cả. Gom Rọ Lại 1 Cộng (`count`++).
     *         - VĂNG RA KHỎI VÒNG ĐỆ QUY (Lùi Backtrack):
     *         + Mở Rọ Xóa Kéo Lại: "Nếu Rọ Của Tớ KIẾM LOAN QUANH KHÔNG ĐỦ 4 ANH EM
     *         (count < 4), chứng tỏ Tớ Đứng Lọt Gió Lộ Thể Cọ Xát ĐỊCH Ngoại Đạo
     *         HOẶC
     *         Trớt Cực Bản Đồ!". Mày chính LÀ Cục Đá Biên Giới! -> ỘP SƠN MÀU MỚI!
     *         + "Dạ Bẩm, 4 Bề Bọn Em Kín Rục Mặc Màu Áo Cha Sinh (count == 4)". OK,
     *         Mày là Thằng Đẻ Kín Lỗ Cắm Giữa Trại. MỘC LẠI! TRẢ VỀ MÀU NGUYÊN BẢN
     *         CŨ!
     *         (Đắp lại màu Gốc Dương Tính `originalColor`).
     */
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int originalColor = grid[row][col];

        // Thằng Cha Mới Rạch Mã Đòi Sơn LẠI Vô Tình Giống Y Bon Áo Cũ Trắng Bóc!
        // Phá Vỡ Logic Trò Chơi -> Thôi Không Làm Gì Cả, Nhấn Nút Cút Liền Khoẻ Re.
        if (originalColor != color) {
            dfs(grid, row, col, originalColor, color);
        }

        return grid;
    }

    private void dfs(int[][] grid, int r, int c, int originalColor, int newColor) {
        // Áp Bùa Chú Khóa Chân: Quật Móp Màu Dương Tính Sang Số Âm Rạch Dấu Chết Oan
        // (Vừa Chặn Lặp Vô Địch, Vừa Lưu Bản Gốc Âm Kì Kục Qua Abs)
        grid[r][c] = -originalColor;

        int rows = grid.length;
        int cols = grid[0].length;
        int countSafeNeighbors = 0; // Kênh Kéo Máu Lọc: Đếm Số Đứa Bạn Thân Rạch Dấu Cùng Cha Khác Ông Nội

        // Đảo Quét Xoắn Tứ Cực Định Tuyến: Bắc, Nam, Tây, Đông
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            // Xủi Nghẽo Rớt Mép Quỷ Vực Lề Ma Trận Lọt Nôi (Mất Rẽ)
            if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
                continue;
            }

            // 1. NGÓ NGẮM: À Mày Đứa Áo Tươi Cũ (Thịt Mới Tươi Gốc Chưa Chặt Phá)
            if (grid[nr][nc] == originalColor) {
                countSafeNeighbors++; // Xác Nhận Bạn Đội, Kí Dấu Cọc Nối Đất
                dfs(grid, nr, nc, originalColor, newColor); // Lan Cầu Treo Vắt Mủ Lần Lọt Đệ Quy
            }
            // 2. NGÓ MÓT: Ủa, Thằng Kìa Bị Ma Cầm Dìm Âm Quá Móp Lục Tính Gốc (-orig)
            // Vậy Mày Từng Đi Trước Tao! Vẫn LÀ GỐC ĐẢO CHA TA. Vẫn LÀ ĐỒNG ĐỘI CHE MẢNG
            // CHỞ CHU CHE CỬA
            else if (Math.abs(grid[nr][nc]) == originalColor) {
                countSafeNeighbors++;
            }
            // Ngoài Giao Thoa 2 Quỷ Đó, Phải Là Đứa Ô Áo Lạc Lõng Dị Bang Gốc Thủy Tổ. CÚT!
            // Không Đếm Nhé Lịch Cục.
        }

        // KẾT THÚC CƠ NHẦU DUYỆT ĐÁY VỚT CỘNG LÙI KẾT KẾT ĐÁNH DẤU
        // Lọt Gió Rách Áo Xuyên Không? Mất 1 Mảng Che (Trúc Lề, Hoặc Đụng Cát Khác Sắc)
        if (countSafeNeighbors != 4) {
            // Tượng Đài Biên Khảo Mốc! Ụp Nồi Ráo Sơn Liền Màu Chói Lỏi Gọi Thầu!
            grid[r][c] = newColor;
        } else {
            // Bảo Bọc Chống Đạn Bốn Bề Êm Thắm (Hạt Nút Trũng Tọa Đồi Câm Lõi Giữa Chắc
            // Trụ)
            // Nhổ Lão Lột Xóa Âm Linh, Phục Hoàn Thánh Địa Tổ Mẫu Lôi Nguyên Gốc Đỏ rực Cũ
            grid[r][c] = originalColor;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] grid1 = { { 1, 1 }, { 1, 2 } };
        int[][] res1 = sol.colorBorder(grid1, 0, 0, 3);
        System.out.println("Result 1: " + Arrays.deepToString(res1)); // expected [[3,3],[3,2]]

        int[][] grid2 = { { 1, 2, 2 }, { 2, 3, 2 } };
        int[][] res2 = sol.colorBorder(grid2, 0, 1, 3);
        System.out.println("Result 2: " + Arrays.deepToString(res2)); // expected [[1,3,3],[2,3,3]]

        int[][] grid3 = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
        int[][] res3 = sol.colorBorder(grid3, 1, 1, 2);
        System.out.println("Result 3: " + Arrays.deepToString(res3)); // expected [[2,2,2],[2,1,2],[2,2,2]]
    }
}
