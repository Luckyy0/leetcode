package leet_code.Problem_970_Medium_Powerful_Integers;

import java.util.*;

/**
 * Problem 970: Powerful Integers
 * https://leetcode.com/problems/powerful-integers/
 */
public class Solution {

    /**
     * Finds powerful integers <= bound.
     * Strategy: Brute force loops over powers.
     * 
     * @param x     Base 1.
     * @param y     Base 2.
     * @param bound Upper bound.
     * @return List of powerful integers.
     * 
     *         Tóm tắt chiến lược:
     *         1. Duyệt qua tất cả các lũy thừa của `x`: `powX = x^i`.
     *         2. Với mỗi `powX`, duyệt qua tất cả các lũy thừa của `y`: `powY =
     *         y^j`.
     *         3. Tính tổng `val = powX + powY`.
     *         4. Nếu `val <= bound`, thêm vào HashSet để loại bỏ trùng lặp.
     *         5. Điều kiện dừng của vòng lặp: Khi `powX > bound` (hoặc `powX + 1` >
     *         bound để tối ưu hơn).
     *         6. Chú ý trường hợp đặc biệt: Nếu `x = 1` hoặc `y = 1`, lũy thừa của
     *         chúng luôn là 1.
     *         Cần `break` vòng lặp sau lần đầu tiên để tránh lặp vô hạn (vì 1 * 1 =
     *         1 mãi mãi).
     */
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> result = new HashSet<>();

        // Loop for powers of x: x^0, x^1, ...
        // i starts at 1 (x^0)
        // Condition i < bound is technically safe but optimizing inner loop is better.
        // If x=1, loop runs once.
        for (int i = 1; i < bound; i *= x) {

            // Loop for powers of y: y^0, y^1, ...
            // j starts at 1 (y^0)
            for (int j = 1; i + j <= bound; j *= y) {
                result.add(i + j);
                if (y == 1)
                    break; // Avoid infinite loop if y is 1
            }

            if (x == 1)
                break; // Avoid infinite loop if x is 1
        }

        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result: " + sol.powerfulIntegers(2, 3, 10)); // [2,3,4,5,7,9,10]
        System.out.println("Result: " + sol.powerfulIntegers(3, 5, 15)); // [2,4,6,8,10,14]
    }
}
