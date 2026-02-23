package Problem_1046_Easy_Last_Stone_Weight;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 1046. Last Stone Weight
 * 
 * You are given an array of integers stones where stones[i] is the weight of
 * the ith stone.
 * We are playing a game with the stones. On each turn, we choose the heaviest
 * two stones and smash them together.
 * Suppose the heaviest two stones have weights x and y with x <= y. The result
 * of this smash is:
 * - If x == y, both stones are destroyed.
 * - If x != y, the stone of weight x is destroyed, and the stone of weight y
 * has new weight y - x.
 * 
 * At the end of the game, there is at most one stone left.
 * Return the weight of the last remaining stone. If there are no stones left,
 * return 0.
 */
public class Solution {

    /**
     * Dùng Hàng đợi ưu tiên (Priority Queue - Max Heap) để giải quyết.
     * Cấu trúc Max-Heap sẽ giúp ta luôn lấy ra được 2 viên đá nặng nhất (thời gian
     * rút O(log N))
     * một cách nhanh chóng ngay cả khi ta liên tục chèn thêm viên đá sứt mẻ mới
     * vào.
     * 
     * @param stones Mảng chứa cân nặng các viên đá ban đầu
     * @return Cân nặng của viên đá còn sót lại cuối cùng (hoặc 0 nếu toàn bộ vỡ
     *         vụn)
     */
    public int lastStoneWeight(int[] stones) {
        // 1. Dựng lồng Max-Heap (Viên bự nhất nổi đầu rễ lên trên)
        // Dùng Collections.reverseOrder() để ép PriorityQueue nôn số lớn ra trước thay
        // vì số nhỏ mặc định
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // 2. Chở hết gạch đá đổ vào Lò Max-Heap
        for (int stoneWeight : stones) {
            maxHeap.add(stoneWeight);
        }

        // 3. Cuộc chiến Đập Đá Sinh Tử: Lặp liên tục chừng nào trong Lò Hố còn chứa >=
        // 2 Đấu Thủ
        while (maxHeap.size() > 1) {
            // Lôi gáy thằng Mập vô địch Số 1 ra
            int heaviestStone1 = maxHeap.poll();

            // Xách cổ thằng Béo Số 2 ra
            int heaviestStone2 = maxHeap.poll();

            // Hai cục đập đầu nhau. Nếu thằng Béo Cố Nội 1 nặng hơn thằng 2:
            // Sẽ có mảnh vỡ rớt ra kích thước bằng hiệu của 2 đứa (heaviestStone1 -
            // heaviestStone2).
            // Lập tức quăng Cục Mảnh Vỡ đó ngược vào Lò Đấu Max-Heap để phân tài cao thấp
            // tiếp!
            if (heaviestStone1 != heaviestStone2) {
                maxHeap.add(heaviestStone1 - heaviestStone2);
            }
            // (Lưu ý: Nếu heaviestStone1 == heaviestStone2, chúng triệt tiêu nhau hoàn
            // toàn, không ném gì lại cả)
        }

        // 4. Khép lại Tuồng. Nếu Lò Max-Heap trống trơn (hủy diệt sạch) -> Trả 0.
        // Ngược lại, Tự hào lấy Tượng Đài Cuối Cùng rút ra khỏi Hố Lò nộp mạng.
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] stones1 = { 2, 7, 4, 1, 8, 1 };
        System.out.println("Test 1: " + sol.lastStoneWeight(stones1)); // Expected: 1

        int[] stones2 = { 1 };
        System.out.println("Test 2: " + sol.lastStoneWeight(stones2)); // Expected: 1
    }
}
