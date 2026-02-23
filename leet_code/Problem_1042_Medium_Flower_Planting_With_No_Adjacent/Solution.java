package Problem_1042_Medium_Flower_Planting_With_No_Adjacent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1042. Flower Planting With No Adjacent
 * 
 * You have n gardens, labeled from 1 to n, and an array paths where paths[i] =
 * [x_i, y_i] describes a bidirectional path.
 * You want to plant one of 4 types of flowers in each garden.
 * All gardens have at most 3 paths coming into or leaving it.
 * Return any choice as an array answer, where answer[i] is the type of flower
 * planted in the (i+1)th garden.
 */
public class Solution {

    /**
     * Dùng chiến lược Tham Lâm (Greedy) kết hợp Tô Màu Đồ Thị (Graph Coloring).
     * Dựa trên Định lý Brooks: Có Tối Đa 3 Hàng Xóm thì dùng 4 Màu chắc chắn không
     * bao giờ bị trùng.
     * 
     * @param n     Số lượng khu vườn
     * @param paths Ma trận các con đường kết nối giữa hai khu vườn
     * @return Mảng kết quả liệt kê loại hoa được trồng cho từng khu vườn
     */
    public int[] gardenNoAdj(int n, int[][] paths) {
        // Thiết lập Danh sách kề (Adjacency List) đại diện cho Đồ thị Mạng lưới Vườn
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // Cập nhật Cầu nối Hai Chiều
        for (int[] path : paths) {
            graph.get(path[0]).add(path[1]);
            graph.get(path[1]).add(path[0]);
        }

        int[] result = new int[n];

        // Chạy qua từng mảnh vườn từ 1 tới N để tô màu (Gieo Giống Hoa)
        for (int i = 1; i <= n; i++) {
            // Danh sách Theo Dõi Đánh Dấu Cấm Kỵ 5 Lỗ (Dùng từ 1 đến 4, bỏ Ô 0)
            boolean[] usedColors = new boolean[5];

            // Xoi Vườn Hàng Xóm xem Nó Ráp Giống Hoa Thứ Mấy Rồi?
            for (int neighbor : graph.get(i)) {
                // Đánh Dấu Tuyệt Đối Không Xài Lại Giống Này Nữa! Cờ Chó Đã Cắm!
                usedColors[result[neighbor - 1]] = true;
            }

            // Phân Lựa Chọn Mầu Chưa Bị Hàng Xóm "Chiếm Đoạt"
            for (int color = 1; color <= 4; color++) {
                if (!usedColors[color]) {
                    result[i - 1] = color;
                    break; // Ngon! Bốc được cái Nhụy không Đụng Hàng Nhanh Tay Vọt Chui Khỏi Vườn Mình
                           // Ngay!
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int n1 = 3;
        int[][] paths1 = { { 1, 2 }, { 2, 3 }, { 3, 1 } };
        System.out.println("Test 1: " + Arrays.toString(sol.gardenNoAdj(n1, paths1)));
        // Expected valid output example: [1, 2, 3]

        int n2 = 4;
        int[][] paths2 = { { 1, 2 }, { 3, 4 } };
        System.out.println("Test 2: " + Arrays.toString(sol.gardenNoAdj(n2, paths2)));
        // Expected valid output example: [1, 2, 1, 2]

        int n3 = 4;
        int[][] paths3 = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 1 }, { 1, 3 }, { 2, 4 } };
        System.out.println("Test 3: " + Arrays.toString(sol.gardenNoAdj(n3, paths3)));
        // Expected valid output example: [1, 2, 3, 4]
    }
}
