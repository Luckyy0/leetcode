package leet_code.Problem_991_Medium_Broken_Calculator;

/**
 * Problem 991: Broken Calculator
 * https://leetcode.com/problems/broken-calculator/
 */
public class Solution {

    /**
     * Calculates minimum operations to reach target from startValue.
     * Strategy: Backwards Greedy approach from target to startValue.
     * 
     * @param startValue Initial value.
     * @param target     Target value.
     * @return Minimum operations.
     * 
     *         Tóm tắt chiến lược:
     *         1. Thay vì đi từ `startValue` đến `target` (có hai nhánh lựa chọn +
     *         và * làm phức tạp), ta sẽ đi ngược lại từ `target` về `startValue`.
     *         2. Phép tính "Ngược lại":
     *         - "Nhân 2" biến thành "Chia 2" (chỉ làm được khi số hiện tại là
     *         chẵn).
     *         - "Trừ 1" biến thành "Cộng 1".
     *         3. Chiến lược thăm lam (Greedy):
     *         - Nếu `target` lớn hơn `startValue`:
     *         - Ta luôn muốn giảm `target` xuống nhanh nhất thông qua phép "Chia
     *         2".
     *         - Nếu `target` lẻ, ta BẮT BUỘC phải "Cộng 1" để biến nó thành chẵn,
     *         từ đó mới có thể "Chia 2".
     *         - Nếu `target` chẵn, chia 2 luôn đem lại lợi ích lớn nhất và giảm số
     *         bước đi.
     *         - Nếu `target` nhỏ hơn hoặc bằng `startValue`:
     *         - Lúc này phép "Chia 2" vô nghĩa vì ta chỉ cần "Cộng 1" liên tục cho
     *         đến khi `target` bằng `startValue`.
     *         - Số phép toán cần thiết chính là khoảng cách: `startValue - target`.
     */
    public int brokenCalc(int startValue, int target) {
        int operations = 0;

        // Work backwards from target
        while (target > startValue) {
            operations++;
            // If target is odd, we must add 1 to make it divisible by 2
            if (target % 2 != 0) {
                target++;
            } else {
                // If it is even, dividing by 2 brings it closer to startValue much faster
                target /= 2;
            }
        }

        // Once target is <= startValue, the only way to reach startValue
        // is to add 1 repeatedly (which corresponds to subtracting 1 going forward).
        return operations + (startValue - target);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result 1: " + sol.brokenCalc(2, 3)); // 2
        System.out.println("Result 2: " + sol.brokenCalc(5, 8)); // 2
        System.out.println("Result 3: " + sol.brokenCalc(3, 10)); // 3
    }
}
