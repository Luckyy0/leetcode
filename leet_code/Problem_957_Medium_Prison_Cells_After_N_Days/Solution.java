package leet_code.Problem_957_Medium_Prison_Cells_After_N_Days;

import java.util.*;

/**
 * Problem 957: Prison Cells After N Days
 * https://leetcode.com/problems/prison-cells-after-n-days/
 */
public class Solution {

    /**
     * Simulates the state of prison cells after N days.
     * Strategy: Cycle Detection with HashMap.
     * 
     * @param cells Initial state of cells.
     * @param n     Number of days.
     * @return State of cells after N days.
     * 
     *         Tóm tắt chiến lược:
     *         1. Vì có 8 ô, nhưng ô đầu và ô cuối luôn trở thành 0 sau ngày đầu
     *         tiên (không có đủ 2 hàng xóm),
     *         nên chỉ có 6 ô giữa là thực sự thay đổi. Số lượng trạng thái tối đa
     *         là 2^6 = 64.
     *         2. Do số lượng trạng thái nhỏ và N có thể lên tới 10^9, chắc chắn sẽ
     *         xảy ra chu trình lặp lại.
     *         3. Sử dụng HashMap để lưu trữ trạng thái đã gặp và ngày tương ứng.
     *         4. Duyệt từng ngày:
     *         - Tính trạng thái của ngày hôm sau.
     *         - Kiểm tra xem trạng thái này đã gặp chưa.
     *         - Nếu đã gặp, ta tìm được chu trình. Tính độ dài chu trình
     *         `cycleLen`.
     *         - Tính số ngày còn lại `remainingDays = n - currentDay`.
     *         - Nhảy cóc thời gian bằng cách bỏ qua số vòng lặp nguyên vẹn:
     *         `remainingDays % cycleLen`.
     *         - Cập nhật số ngày cần chạy tiếp và tiếp tục mô phỏng cho đến khi hết
     *         N ngày.
     *         5. Trả về trạng thái cuối cùng.
     */
    public int[] prisonAfterNDays(int[] cells, int n) {
        Map<String, Integer> seen = new HashMap<>();
        boolean hasCycle = false;

        // We simulate day by day. However, if a cycle is found, we fast forward.
        for (int i = 0; i < n; i++) {
            int[] next = nextDay(cells);
            String stateKey = Arrays.toString(next);

            if (!hasCycle && seen.containsKey(stateKey)) {
                hasCycle = true;
                int prevDay = seen.get(stateKey);
                // Cycle length is current day 'i' (0-indexed logic in loop means this is
                // actually day i+1) minus previous occurrence
                // But let's be careful with indexing.
                // Loop i=0 corresponds to transition from Day 0 -> Day 1.
                // So 'next' is state at Day (i+1).
                // 'prevDay' was the index when this state was first seen (also representing Day
                // prevDay+1).

                int cycleLen = i - prevDay;
                int daysLeft = n - 1 - i;

                // Fast forward: Skip as many full cycles as possible
                i += (daysLeft / cycleLen) * cycleLen;
            } else {
                seen.put(stateKey, i);
            }

            cells = next;
        }

        return cells;
    }

    private int[] nextDay(int[] cells) {
        int[] next = new int[cells.length];
        // Rules: If neighbors are same (both 0 or both 1), cell becomes 1. Else 0.
        // First and last cells don't have enough neighbors, so they become 0 (default
        // int value).
        for (int i = 1; i < cells.length - 1; i++) {
            if (cells[i - 1] == cells[i + 1]) {
                next[i] = 1;
            } else {
                next[i] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] c1 = { 0, 1, 0, 1, 1, 0, 0, 1 };
        // Expected: [0,0,1,1,0,0,0,0]
        System.out.println("Result: " + Arrays.toString(sol.prisonAfterNDays(c1, 7)));

        int[] c2 = { 1, 0, 0, 1, 0, 0, 1, 0 };
        // Expected: [0,0,1,1,1,1,1,0]
        System.out.println("Result: " + Arrays.toString(sol.prisonAfterNDays(c2, 1000000000)));
    }
}
