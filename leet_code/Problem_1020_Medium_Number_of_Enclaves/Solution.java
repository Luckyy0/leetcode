package leet_code.Problem_1020_Medium_Number_of_Enclaves;

/**
 * Problem 1020: Number of Enclaves
 * https://leetcode.com/problems/number-of-enclaves/
 */
public class Solution {

    /**
     * Determines the number of enclosed land cells (not connected to the boundary).
     * Strategy: Reverse Flood-Fill from Borders (DFS).
     * 
     * @param grid The binary grid representing land (1) and water (0).
     * @return The number of land cells in enclaves.
     * 
     *         Tóm tắt chiến lược:
     *         1. Muốn tìm Vùng Đất Kín (không dính mép bản đồ)? Cách thông thường
     *         là đi loang đếm từng hòn đảo rồi ngó chừng xem rễ nó có đâm ra Mép
     *         Bản Đồ không. Nếu đâm ra Mép thì bỏ, còn chui thụt trong lồng thì
     *         Lấy.
     *         - Gây Cồng kềnh biến cờ quản lý "Đã Đụng Viền". Chạy loang hết mọi
     *         đảo.
     *         2. Cách Tối Ưu Đẳng Cấp: Tấn Công Tư Duy Trái Chiều! (Flood-fill).
     *         - Tấc Đất nào rễ chạm mép viền, tấc đất đó sẽ Thoát Hiểm, không
     *         thể nào gọi là Khu Cù Lao Nội Cảnh được.
     *         - RỒI SAO? Tại sao mình không lượn 1 vòng mép Tường Bản Đồ Rìa,
     *         tùng xẻo ngay những tấc Đất ỷ thế dựa hơi vào Vách Tường đó!
     *         3. Gọi ĐẠI HỒNG THỦY DFS (Phép Dìm Đất):
     *         - Quét mép Hàng Trên Cùng, Dưới Cùng. Mép Cột Trái, Cột Phải.
     *         - Hễ gặp Ô Đất Số "1" nằm mấp mé Rìa Bản Đồ này. Phóng cơn rễ Hồng
     *         thủy bám lan truyền vào thân Đất liền của nó. Góp gió thành bão, dìm
     *         sạch sành sanh toàn bộ Vùng Đất dính líu dập thành Nước Số "0".
     *         4. Lục Địa Cởi Truồng: Cơn Hồng Thủy Rìa Bản Đồ chấm dứt. Bất dĩ
     *         những Vùng Đất nào KHÔNG có rễ vươn ra Rìa (Khu Đất Nội Cảnh KÍN) sẽ
     *         NẰM TRƠ TRỌI Y NGUYÊN Số "1" LẼ LOI CÔ ĐỘC !
     *         5. Vậy cuối cùng, lặp 2 vòng sương sương, nhặt lại tổng các số "1"
     *         còn sống sót chính là KẾT QUẢ VÙNG KÍN CHUẨN XÁC! (Và thuật toán thay
     *         đổi Trực Tiếp vào Bản đồ gốc - In place - Không xài mảng phụ!).
     */
    public int numEnclaves(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;

        // BROWSE BIÊN GIỚI DỌC (CỘT TRÁI - PHẢI)
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1)
                dfsSink(grid, i, 0); // Tường trái
            if (grid[i][n - 1] == 1)
                dfsSink(grid, i, n - 1); // Tường phải
        }

        // BROWSE BIÊN GIỚI NGANG (CỘT TRÊN - DƯỚI)
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1)
                dfsSink(grid, 0, j); // Sân thượng
            if (grid[m - 1][j] == 1)
                dfsSink(grid, m - 1, j); // Vực thẳm đáy
        }

        // Đếm Chiến Lợi Phẩm: Số lượng Ô Đất Kín
        int enclosedCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    enclosedCount++;
                }
            }
        }

        return enclosedCount;
    }

    // Phép Loang Đại Hồng Thủy Dìm Ô Đất Số "1" thành Vũng Nước Chết "0"
    private void dfsSink(int[][] grid, int i, int j) {
        // Tường Sắt: Ngoi ra khỏi Bản Đồ, Rơi Xuống Nước
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return; // Khựng Lại
        }

        // Dìm ngay tắp lự Kẻ Dính Trực Tiếp
        grid[i][j] = 0;

        // Xuyên Sóng lan dìm thê thảm anh em Đất 4 hướng liền kề vướng cùng 1 Cụm
        dfsSink(grid, i + 1, j); // Nước cuốn xuống Dưới
        dfsSink(grid, i - 1, j); // Sóng cào lên Trên
        dfsSink(grid, i, j + 1); // Trào Mạng Phải
        dfsSink(grid, i, j - 1); // Lấn Mạng Trái
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] grid1 = {
                { 0, 0, 0, 0 },
                { 1, 0, 1, 0 },
                { 0, 1, 1, 0 },
                { 0, 0, 0, 0 }
        };
        System.out.println("Result 1: " + sol.numEnclaves(grid1)); // expected 3

        int[][] grid2 = {
                { 0, 1, 1, 0 },
                { 0, 0, 1, 0 },
                { 0, 0, 1, 0 },
                { 0, 0, 0, 0 }
        };
        System.out.println("Result 2: " + sol.numEnclaves(grid2)); // expected 0
    }
}
