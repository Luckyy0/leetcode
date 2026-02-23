package leet_code.Problem_1006_Medium_Clumsy_Factorial;

/**
 * Problem 1006: Clumsy Factorial
 * https://leetcode.com/problems/clumsy-factorial/
 */
public class Solution {

    /**
     * Calculates the clumsy factorial of n.
     * Strategy: Math trick modulo 4 (O(1) optimal).
     * 
     * @param n The input integer.
     * @return The clumsy factorial result.
     * 
     *         Tóm tắt chiến lược:
     *         1. "Giai thừa vụng về" yêu cầu lặp lại chu kỳ 4 phép toán:
     *         Nhân (*), Chia (/), Cộng (+), Trừ (-).
     *         2. Cách ngây thơ là dùng Stack, nhưng tốn O(N) bộ nhớ và thời gian.
     *         3. Tuy nhiên, nếu n > 4, ta xét cụm 4 số liên tiếp với 3 phép toán
     *         đầu tiên: x * (x-1) / (x-2).
     *         - Ví dụ: 5 * 4 / 3 = 6 = 5 + 1.
     *         - Ví dụ: 6 * 5 / 4 = 7 = 6 + 1.
     *         - Dễ dàng chứng minh: x * (x-1) / (x-2) xấp xỉ x + 1.
     *         4. Phần biểu thức dài có dạng:
     *         [x * (x-1) / (x-2)] + (x-3) - [(x-4) * (x-5) / (x-6)] + (x-7) - ...
     *         5. Vì dấu trước cụm trừ luôn là '-', ta rút gọn chuỗi thành một
     *         công thức cực kỳ đơn giản dựa vào phần dư của phép n chia 4 (n % 4).
     *         6. Nhờ công thức gom nhóm toán học này, ta có thể triệt tiêu hoàn
     *         toàn
     *         vòng lặp, biến nó thành độ phức tạp O(1) tuyệt đối.
     */
    public int clumsy(int n) {
        // Base cases for small values
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        if (n == 3)
            return 6;
        if (n == 4)
            return 7;

        // Math magic for N > 4
        if (n % 4 == 0) {
            return n + 1;
        } else if (n % 4 == 1) {
            return n + 2;
        } else if (n % 4 == 2) {
            return n + 2;
        } else {
            return n - 1;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result 1: " + sol.clumsy(4)); // expected 7
        System.out.println("Result 2: " + sol.clumsy(10)); // expected 12
        System.out.println("Result 3: " + sol.clumsy(5)); // expected 7
    }
}
