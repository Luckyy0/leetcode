package Problem_1040_Medium_Moving_Stones_Until_Consecutive_II;

import java.util.Arrays;

/**
 * 1040. Moving Stones Until Consecutive II
 * 
 * There are some stones in different positions on the X-axis. You are given an
 * integer array stones.
 * Call a stone an endpoint stone if it has the smallest or largest position.
 * In one move, you can pick up an endpoint stone and move it to an unoccupied
 * position so that it is no longer an endpoint stone.
 * The game ends when you cannot make any more moves, i.e., the stones are in
 * consecutive positions.
 * Return an integer array answer of length 2 where answer[0] is the minimum
 * number of moves, and answer[1] is the maximum number of moves.
 */
public class Solution {

    /**
     * Thuật toán Cửa sổ trượt (Sliding Window) để tìm Min và Toán học Hố Rỗng để
     * tìm Max.
     * 
     * @param stones Mảng tọa độ các viên đá
     * @return Mảng 2 phần tử: [minMoves, maxMoves]
     */
    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int n = stones.length;

        // 1. Tìm Max Moves (Bòn số bước tối đa)
        // Chúng ta muốn di chuyển đá từ từ vào các khoảng trống.
        // Nước đi đầu tiên buộc phải bỏ qua khoảng trống giữa đá ngoài cùng và đá kề
        // nó.
        // Ta sẽ vứt bỏ khoảng trống nhỏ hơn (khoảng trống cấu thành từ đầu trái [0 tới
        // 1] hoặc đít phải [n-2 tới n-1])
        // để giữ lại nhiều khoảng trống dư thừa nhất có thể.
        int gapLeft = (stones[n - 2] - stones[0] + 1) - (n - 1);
        int gapRight = (stones[n - 1] - stones[1] + 1) - (n - 1);
        int maxMoves = Math.max(gapLeft, gapRight);

        // 2. Tìm Min Moves (Bòn số bước tối thiểu bằng Cửa Sổ Trượt)
        int minMoves = n;
        int i = 0;

        for (int j = 0; j < n; j++) {
            // Cửa sổ có kích thước vật lý không được vượt quá số lượng đá n
            while (stones[j] - stones[i] + 1 > n) {
                i++;
            }

            // Số lượng viên đá ĐÃ CÓ MẶT trong cửa sổ từ i đến j
            int countInWindow = j - i + 1;

            // Bẫy Edge Case (Trường hợp Cụm Gắn dính):
            // Nếu có n-1 viên đá đang dính chặt liên tiếp nhau, và viên còn lại văng tít mù
            // khơi.
            // Ví dụ: 1, 2, 3, 4 ... 10 (n=5).
            // Ta không thể ném 10 vào 5, vì 5 sẽ biến thành điểm mút. Bắt buộc phải mất 2
            // bước: 1 ném vào 6, rồi 10 ném vào 5.
            if (countInWindow == n - 1 && stones[j] - stones[i] + 1 == n - 1) {
                minMoves = Math.min(minMoves, 2);
            } else {
                // Trường hợp bình thường: Còn thiếu bao nhiêu viên đá để lấp đầy n chỗ,
                // thì nhặt đúng bấy nhiêu viên ở ngoài ném vào khung lưới (mất n -
                // countInWindow bước).
                minMoves = Math.min(minMoves, n - countInWindow);
            }
        }

        return new int[] { minMoves, maxMoves };
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] stones1 = { 7, 4, 9 };
        System.out.println("Test 1: " + Arrays.toString(sol.numMovesStonesII(stones1))); // Expected: [1, 2]

        int[] stones2 = { 6, 5, 4, 3, 10 };
        System.out.println("Test 2: " + Arrays.toString(sol.numMovesStonesII(stones2))); // Expected: [2, 3]

        int[] stones3 = { 100, 101, 104, 102, 103 };
        System.out.println("Test 3: " + Arrays.toString(sol.numMovesStonesII(stones3))); // Expected: [0, 0]
    }
}
