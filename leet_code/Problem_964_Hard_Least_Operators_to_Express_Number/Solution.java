package leet_code.Problem_964_Hard_Least_Operators_to_Express_Number;

import java.util.*;

/**
 * Problem 964: Least Operators to Express Number
 * https://leetcode.com/problems/least-operators-to-express-number/
 */
public class Solution {

    /**
     * Finds the least operators to express target using x.
     * Strategy: Dynamic Programming / Recursion on base-x digits.
     * 
     * @param x      The base number.
     * @param target The target number.
     * @return Minimum operators.
     * 
     *         Tóm tắt chiến lược:
     *         1. Biểu diễn `target` dưới dạng cơ số `x`.
     *         2. Tại mỗi vị trí `k` (tương ứng với `x^k`), ta có một chữ số `r` (số
     *         dư).
     *         3. Ta có hai trạng thái DP:
     *         - `pos`: Chi phí để biểu diễn chính xác phần dư `target % x^(k+1)`.
     *         (Tức là khớp đúng chữ số `r`).
     *         - `neg`: Chi phí để biểu diễn `x^(k+1) - (target % x^(k+1))`. (Tức là
     *         biểu diễn vượt quá, coi như ta mượn 1 đơn vị ở hàng `k+1` và cần trả
     *         lại `x - r` đơn vị ở hàng `k`).
     *         4. Chi phí cơ sở:
     *         - Để tạo ra một số hạng `x^k` (với `k > 0`), ta cần `k-1` phép nhân.
     *         Tuy nhiên, để CỘNG số hạng này vào tổng, ta tốn thêm 1 phép toán (+
     *         hoặc -).
     *         Nên tổng chi phí cho mỗi khối `x^k` là `k`.
     *         - Riêng với `k=0` (`x^0` hay là 1), ta cần 2 phép toán (`x/x`).
     *         5. Công thức chuyển trạng thái tại bước `k`:
     *         - `cnt`: Số lượng toán tử để tạo ra một khối `x^k`. (`k` nếu `k>0`, 2
     *         nếu `k=0`).
     *         - `r`: chữ số hiện tại (`target % x`).
     *         - `pos` mới = Min(
     *         `r * cnt + pos_cũ`, // Dùng `r` khối `x^k`, cộng dồn chi phí cũ
     *         `(x - r) * cnt + neg_cũ` // Dùng `x-r` khối `x^k` (theo hướng âm),
     *         cộng dồn chi phí neg cũ
     *         )
     *         - `neg` mới = Min(
     *         `(r + 1) * cnt + pos_cũ`, // Muốn đạt overshoot, tức là target+1 tại
     *         vị trí này.
     *         `(x - (r + 1)) * cnt + neg_cũ`
     *         )
     *         6. Sau khi duyệt hết các chữ số của `target`, kết quả cuối cùng là
     *         `min(pos, k + neg) - 1`.
     *         Trừ 1 vì số hạng đầu tiên không cần dấu toán tử phía trước.
     */
    public int leastOpsExpressTarget(int x, int target) {
        // Current digit r at position k=0 (x^0)
        int r = target % x;
        target /= x;

        // Initial costs for k=0
        // Cost to make '1' is 2 ops (x/x)
        // pos: cost to make 'r' exactly -> r * 2
        // neg: cost to make 'x - r' exactly -> (x - r) * 2
        int pos = r * 2;
        int neg = (x - r) * 2;

        int k = 1; // Current power x^k

        while (target > 0) {
            r = target % x;
            target /= x;

            // Cost for one block of x^k is k ops (k-1 muls + 1 add/sub).
            // Example: x*x + ...
            int cnt = k;

            // Calculate next states
            // new_pos: reach target exactly at this level
            // Option 1: Add r blocks of x^k. Inherit 'pos' cost from lower level.
            // Option 2: Subtract (x-r) blocks of x^k (borrow from next level). Inherit
            // 'neg' cost from lower level.
            int new_pos = Math.min(r * cnt + pos, (x - r) * cnt + neg);

            // new_neg: reach target + 1 at this level (prepare for borrow at next level)
            // Option 1: Add (r+1) blocks. Inherit 'pos'.
            // Option 2: Subtract (x - (r+1)) blocks. Inherit 'neg'.
            int new_neg = Math.min((r + 1) * cnt + pos, (x - (r + 1)) * cnt + neg);

            pos = new_pos;
            neg = new_neg;
            k++;
        }

        // Final result:
        // pos: we matched the target exactly.
        // neg: we matched target + x^limit. We need to subtract one x^limit block.
        // Cost to subtract x^limit is `k` ops (since loop incremented k at end).
        // Since we counted ops as "terms * cost", the very first term doesn't need an
        // operator.
        // e.g., "x + x" -> 2 terms, 1 op. Our cost model counts 2. So result - 1.
        return Math.min(pos, k + neg) - 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result: " + sol.leastOpsExpressTarget(3, 19)); // 5
        System.out.println("Result: " + sol.leastOpsExpressTarget(5, 501)); // 8
        System.out.println("Result: " + sol.leastOpsExpressTarget(100, 100000000)); // 3
    }
}
