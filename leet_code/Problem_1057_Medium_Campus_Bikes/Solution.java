package Problem_1057_Medium_Campus_Bikes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1057. Campus Bikes
 * 
 * On a campus represented on the X-Y plane, there are n workers and m bikes,
 * with n <= m.
 * You are given an array workers of length n where workers[i] = [xi, yi] is the
 * coordinate of the ith worker.
 * You are also given an array bikes of length m where bikes[j] = [xj, yj] is
 * the coordinate of the jth bike.
 * 
 * We assign a bike to each worker. To do this, we sort the pairs (worker, bike)
 * by the Manhattan distance
 * between each worker and their assigned bike in ascending order.
 * If multiple (worker, bike) pairs have the same shortest Manhattan distance,
 * we choose the pair with
 * the smallest worker index. If there are multiple ways to do that, we choose
 * the pair with the smallest bike index.
 * Repeat this process until there are no available workers.
 */
public class Solution {

    /**
     * Thuật toán: Sắp xếp theo Xô (Bucket Sort).
     * Do giới hạn bài toán: Khoảng cách Manhattan tối đa giữa 2 điểm trong khoảng
     * [0, 999]
     * là 999 + 999 = 1998. Vậy khoảng cách luôn là số nguyên thuộc [0, 2000].
     * Thay vì dùng Hàng Đợi Ưu Tiên (Priority Queue / Min Heap) tốn thời gian O(N*M
     * log(N*M)),
     * ta có thể tạo mảng 2000 "cái xô" (buckets), với chỉ số mảng chính là 'khoảng
     * cách'.
     * Ta ném tất cả các cặp (worker, bike) vào từng xô tương ứng với khoảng cách
     * của chúng.
     * 
     * @param workers Mảng tọa độ của các nhân viên
     * @param bikes   Mảng tọa độ của các xe đạp
     * @return Mảng kết quả, trong đó answer[i] là chỉ số của chiếc xe đạp gán cho
     *         nhân viên i
     */
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int wSize = workers.length;
        int bSize = bikes.length;

        // Mảng Hệ Thống 2001 Cái Xô. Chỉ số mảng = Khoảng cách.
        // Bên trong mỗi xô là 1 List chứa dữ liệu: [workerIndex, bikeIndex]
        @SuppressWarnings("unchecked")
        List<int[]>[] buckets = new List[2001];

        // Bước 1: Tính khoảng cách cho TẤT CẢ các cặp và cho vào Xô tương ứng.
        // LƯU Ý QUAN TRỌNG: Vòng lặp 'w' ở ngoài, 'b' ở trong.
        // Đảm bảo rằng các cặp có cùng khoảng cách sẽ được thêm vào List THEO ĐÚNG THỨ
        // TỰ ưu tiên:
        // worker index nhỏ trước, nếu worker giống thì bike index nhỏ trước.
        for (int w = 0; w < wSize; w++) {
            for (int b = 0; b < bSize; b++) {

                int manhattanDist = Math.abs(workers[w][0] - bikes[b][0]) + Math.abs(workers[w][1] - bikes[b][1]);

                if (buckets[manhattanDist] == null) {
                    buckets[manhattanDist] = new ArrayList<>();
                }

                buckets[manhattanDist].add(new int[] { w, b });
            }
        }

        // Mảng lưu kết quả gán xe cho công nhân
        int[] result = new int[wSize];
        Arrays.fill(result, -1); // Khởi tạo -1 nghĩa là chưa có xe

        // Mảng đánh dấu xem chiếc xe thứ 'b' đã bị ai đó nẫng mất chưa
        boolean[] bikeAssigned = new boolean[bSize];

        int assignedCount = 0; // Đếm số công nhân đã nhận được xe (để thoát sớm)

        // Bước 2: Duyệt các xô từ khoảng cách nhỏ nhất (0) đến lớn nhất (2000)
        for (int dist = 0; dist < 2001; dist++) {
            if (buckets[dist] == null)
                continue; // Xô này rỗng, bỏ qua

            // Lôi tất cả các cặp trong xô hiện tại ra xử lý
            for (int[] pair : buckets[dist]) {
                int wIndex = pair[0];
                int bIndex = pair[1];

                // Nếu CẢ công nhân này CHƯA có xe, VÀ chiếc xe này CHƯA bị ai lấy -> Ghi nhận
                // ghép đôi!
                if (result[wIndex] == -1 && !bikeAssigned[bIndex]) {
                    result[wIndex] = bIndex;
                    bikeAssigned[bIndex] = true;
                    assignedCount++;

                    // Nếu TẤT CẢ công nhân đều đã có xe rồi thì kết thúc sớm thuật toán, không cần
                    // duyệt tiếp xô nữa!
                    if (assignedCount == wSize) {
                        return result;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] workers1 = { { 0, 0 }, { 2, 1 } };
        int[][] bikes1 = { { 1, 2 }, { 3, 3 } };
        System.out.println("Test 1: " + Arrays.toString(sol.assignBikes(workers1, bikes1))); // Expected: [1, 0]

        int[][] workers2 = { { 0, 0 }, { 1, 1 }, { 2, 0 } };
        int[][] bikes2 = { { 1, 0 }, { 2, 2 }, { 2, 1 } };
        System.out.println("Test 2: " + Arrays.toString(sol.assignBikes(workers2, bikes2))); // Expected: [0, 2, 1]
    }
}
