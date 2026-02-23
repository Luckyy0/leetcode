package leet_code.Problem_962_Medium_Maximum_Width_Ramp;

import java.util.Stack;

/**
 * Problem 962: Maximum Width Ramp
 * https://leetcode.com/problems/maximum-width-ramp/
 */
public class Solution {

    /**
     * Finds the maximum width of a ramp (i, j) such that i < j and nums[i] <=
     * nums[j].
     * Strategy: Monotonic Decreasing Stack.
     * 
     * @param nums Array of integers.
     * @return Maximum width.
     * 
     *         Tóm tắt chiến lược:
     *         1. Mục tiêu là tìm cặp chỉ số `(i, j)` sao cho `i < j`, `nums[i] <=
     *         nums[j]`, và `j - i` lớn nhất.
     *         2. Nhận xét: Để tối đa hóa `j - i`, ta muốn `i` càng nhỏ càng tốt và
     *         `j` càng lớn càng tốt.
     *         3. Xây dựng một Stack đơn điệu giảm (lưu chỉ số):
     *         - Duyệt `i` từ 0 đến `n-1`.
     *         - Nếu Stack rỗng hoặc `nums[i] < nums[stack.peek()]`, thêm `i` vào
     *         Stack.
     *         - Tại sao chỉ thêm các phần tử nhỏ hơn?
     *         Giả sử `k < m` và `nums[k] <= nums[m]`. Nếu `m` có thể là điểm bắt
     *         đầu của một ramp với `j` nào đó (`nums[m] <= nums[j]`),
     *         thì `k` cũng thỏa mãn (`nums[k] <= nums[m] <= nums[j]`) và `j - k > j
     *         - m`.
     *         Do đó, `k` luôn là lựa chọn tốt hơn `m` để làm điểm bắt đầu. Ta chỉ
     *         quan tâm đến các điểm bắt đầu có giá trị giảm dần.
     *         4. Tìm điểm kết thúc `j` tốt nhất:
     *         - Duyệt `j` từ `n-1` về 0 (để ưu tiên `j` lớn nhất trước).
     *         - Trong khi Stack không rỗng và `nums[stack.peek()] <= nums[j]`:
     *         - Ta tìm thấy một ramp hợp lệ `(stack.peek(), j)`.
     *         - Cập nhật `maxWidth = max(maxWidth, j - stack.peek())`.
     *         - `stack.pop()`. Tại sao pop? Vì `stack.peek()` đã ghép với `j` lớn
     *         nhất có thể rồi.
     *         Bất kỳ `k < j` nào khác dù có thỏa mãn `nums[stack.peek()] <=
     *         nums[k]` thì độ rộng `k - stack.peek()` cũng sẽ nhỏ hơn `j -
     *         stack.peek()`.
     *         Nên ta không cần giữ lại `stack.peek()` để kiểm tra nữa.
     *         5. Trả về `maxWidth`.
     */
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();

        // Step 1: Build a decreasing stack of indices
        // Possible left boundaries of the ramp
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }

        int maxWidth = 0;

        // Step 2: Iterate from the end and try to match with the stack top
        for (int j = n - 1; j >= 0; j--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[j]) {
                maxWidth = Math.max(maxWidth, j - stack.peek());
                stack.pop();
            }
        }

        return maxWidth;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] n1 = { 6, 0, 8, 2, 1, 5 };
        System.out.println("Result: " + sol.maxWidthRamp(n1)); // 4 (idx 1 and 5 -> 0 <= 5)

        int[] n2 = { 9, 8, 1, 0, 1, 9, 4, 0, 4, 1 };
        System.out.println("Result: " + sol.maxWidthRamp(n2)); // 7 (idx 2 and 9 -> 1 <= 1)
    }
}
