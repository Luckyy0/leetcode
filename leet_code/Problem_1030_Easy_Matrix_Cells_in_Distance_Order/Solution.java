package leet_code.Problem_1030_Easy_Matrix_Cells_in_Distance_Order;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem 1030: Matrix Cells in Distance Order
 * https://leetcode.com/problems/matrix-cells-in-distance-order/
 */
public class Solution {

    /**
     * Returns coordinates of all cells sorted by distance from the center.
     * Strategy: Breadth-First Search (BFS) (O(R*C) time, avoids sorting).
     * 
     * @param rows    The number of rows in the matrix.
     * @param cols    The number of columns in the matrix.
     * @param rCenter The row coordinate of the center cell.
     * @param cCenter The column coordinate of the center cell.
     * @return 2D array of all coordinates sorted by Manhattan distance.
     * 
     *         Tóm tắt chiến lược:
     *         1. Nhiệm vụ: Tưởng tượng ném 1 viên đá xuống Ô Trung Tâm `(rCenter,
     *         cCenter)`
     *         của một mặt hồ phẳng lặng (Ma trận). Mặt nước rẽ sóng, GỢN SÓNG lan
     *         tỏa dần
     *         ra xa thành từng Vòng Đai.
     *         Đề bài bắt liệt kê tọa độ toàn bộ các ô bị sóng đánh trúng, Ô Nào Bị
     *         Sóng
     *         Tạt Trước Thì Xếp Vô Mảng Trước (Khoảng cách nứt nẻ Manhattan ngắn).
     *         2. Cách Gà Mờ: Moi Mọi Cái Ô ra ném vô một Mảng bự. Rồi dùng Thuật
     *         Toán
     *         Sắp Xếp Arrays.sort() gãi gập cực kỳ nặng nề nát bét để Đọ Khoảng
     *         Cách
     *         của R*C Ô. (Rất cồng kềnh, chạy rề rề O(R*C log(R*C))).
     *         3. Cách Điệu Nghệ Lan Tỏa Sóng Nước (Breadth-First Search - BFS
     *         Queue):
     *         - Bản chất "Loang" BFS là cái Rổ Hàng Đợi Queue Tuần Hoàn Nhịp Nhánh:
     *         Ưu
     *         tiên Moi ra Những Ô Sát Vách Lân Cận Đội lên Đầu Hàng. Không lén nhảy
     *         bước!
     *         => Điều Này CÓ NGHĨA LÀ GỢN SÓNG BFS ĐÃ TỰ ĐỘNG CHỨA ĐỰNG SỰ SẮP XẾP
     *         BẨM
     *         SINH (Sorted from the Core!)
     *         - Cho Điểm Ném Đá Ở Rốn (rCenter, cCenter) Vào Hàng Đợi (Queue).
     *         - Bôi đỏ Lưới Mất Tích `visited[r][c] = true` để Chặn luồng Trội Sóng
     *         Quét
     *         Lại trúng Cũ 2 lần (Tránh chìm sập Vòng lặp kẹt Thác Vô Tận).
     *         - Xoài lùi đập Đẩy queue, Rút Ô Báo Cáo kết Tủa Lên Đầu Mảng kết Quả.
     *         - Gọt vỏ 4 nhánh Tứ Hướng Thập Tự Giá (Lên, Xuống, Trái, Phải): Quăng
     *         Vô
     *         Hàng Đợi Lại Mạch Mật Bão. Tự động Nhấn Mọi Viền Nhọn Xung Quanh Trào
     *         Đều!
     */
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        // Nồi lẩu Thập Cẩm Chứa Tổng Danh sách Báo danh
        int[][] res = new int[rows * cols][2];

        // Màng Ngăn Ma Trận Xâm thực Sóng Cuộn Dịch Bệnh (Bị Lây thì True)
        boolean[][] visited = new boolean[rows][cols];

        // Vòng Rốn Hàng Đợi Queue - Bí Truyền Của Thuật Lan Sóng Đồ Thị (BFS)
        Queue<int[]> queue = new LinkedList<>();

        // Thí Viên Gạch Lót Đường Tại Lõi Mút Hệ Quy Chiếu
        queue.offer(new int[] { rCenter, cCenter });
        visited[rCenter][cCenter] = true;

        // La bàn 4 Cánh Cửa Gió Bão (Lên, Xuống, Rẽ Trái, Đạp Phải)
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int index = 0;

        while (!queue.isEmpty()) {
            int[] currentCell = queue.poll(); // Nhấc một Hạt Ngọc Lên Đục Lỗ

            // Ép Hạt Sơn Nhám Vô Trong Khung Tranh (Tự Động Mượt Chóp Dần Bằng Khoảng Cách)
            res[index++] = currentCell;

            int r = currentCell[0];
            int c = currentCell[1];

            // Xó Môn Thập Tự Bấm Lệnh Cho 4 Thằng Rác Bâu Nhào Ở Sát Cạnh Gánh Thay
            for (int[] dir : directions) {
                int neighborR = r + dir[0];
                int neighborC = c + dir[1];

                // Trượt Bước Vào Hẻm Xéo Gãy Rào Mảng? Nhảy Qua Bóng? Hoặc Lỡ Đạp Cứt Cũ?
                if (neighborR >= 0 && neighborR < rows
                        && neighborC >= 0 && neighborC < cols
                        && !visited[neighborR][neighborC]) {

                    // Phớt Lờ Tẩy Nảo Hàng Xóm Bị Móc Đít, Tịch thu Đẩy Nhét vào Boong Tàu Ngồi
                    visited[neighborR][neighborC] = true;
                    queue.offer(new int[] { neighborR, neighborC });
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // System.out.println("No complex outputs here natively, run array stringifier
        // to verify locally!");

        int[][] res1 = sol.allCellsDistOrder(1, 2, 0, 0);
        System.out.println("Result 1 rows = " + res1.length); // 2 elements

        int[][] res2 = sol.allCellsDistOrder(2, 2, 0, 1);
        System.out.println("Result 2 rows = " + res2.length); // 4 elements
    }
}
