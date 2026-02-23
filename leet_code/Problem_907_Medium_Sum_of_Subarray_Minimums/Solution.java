package leet_code.Problem_907_Medium_Sum_of_Subarray_Minimums;

import java.util.*;

/**
 * Problem 907: Sum of Subarray Minimums
 * https://leetcode.com/problems/sum-of-subarray-minimums/
 */
public class Solution {

    /**
     * Calculates the sum of all subarray minimums.
     * Strategy: Monotonic Stack (Next Less Element / Previous Less Element).
     * 
     * @param arr Input array.
     * @return Sum modulo 10^9 + 7.
     * 
     *         Tóm tắt chiến lược:
     *         1. Thay vì duyệt tất cả các mảng con, ta tính xem mỗi phần tử arr[i]
     *         đóng vai trò là giá trị nhỏ nhất trong bao nhiêu mảng con.
     *         2. Giả sử arr[i] là giá trị nhỏ nhất của mảng con [L...R] (với L <= i
     *         <= R).
     *         - Ta cần tìm biên trái L xa nhất bên trái sao cho arr[L...i] >=
     *         arr[i].
     *         - Ta cần tìm biên phải R xa nhất bên phải sao cho arr[i...R] >
     *         arr[i].
     *         Lưu ý: Để tránh đếm trùng các giá trị bằng nhau, ta dùng quy ước:
     *         - Bên trái tìm phần tử đầu tiên NHỎ HƠN KHOẶC BẰNG (<=).
     *         - Bên phải tìm phần tử đầu tiên NHỎ HƠN (<).
     *         (Hoặc ngược lại, miễn là một bên <= và một bên <).
     *         3. Sử dụng Monotonic Stack để tìm Previous Less Element (PLE) và Next
     *         Less Element (NLE).
     *         4. Số lượng mảng con mà arr[i] là nhỏ nhất: (i - PLE) * (NLE - i).
     *         5. Tổng tất cả các đóng góp lại.
     */
    public int sumSubarrayMins(int[] arr) {
        long MOD = 1_000_000_007;
        int n = arr.length;

        // Arrays to store distances to Previous Less Element (PLE)
        // and Next Less Element (NLE)
        int[] leftDist = new int[n];
        int[] rightDist = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Calculate distances to Previous Less Element
        // Logic: Find distance to nearest element strictly less than arr[i] to the
        // left.
        // Actually, to handle duplicates:
        // Let left match represent finding nearest <= (so loop breaks on <=).
        // Let right match represent finding nearest < (so loop breaks on <).

        for (int i = 0; i < n; i++) {
            // Find Previous Less or Equal Element
            // We pop while top > arr[i]
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            // If stack empty, distance is i + 1 (extends to start)
            leftDist[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Calculate distances to Next Less Element
        for (int i = n - 1; i >= 0; i--) {
            // Find Next Strictly Less Element
            // We pop while top >= arr[i]
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            // If stack empty, distance is n - i (extends to end)
            rightDist[i] = stack.isEmpty() ? n - i : stack.peek() - i;
            stack.push(i);
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            long count = (long) leftDist[i] * rightDist[i] % MOD;
            long contribution = (count * arr[i]) % MOD;
            sum = (sum + contribution) % MOD;
        }

        return (int) sum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = { 3, 1, 2, 4 };
        System.out.println("Result: " + sol.sumSubarrayMins(arr1)); // 17

        int[] arr2 = { 11, 81, 94, 43, 3 };
        System.out.println("Result: " + sol.sumSubarrayMins(arr2)); // 444
    }
}
