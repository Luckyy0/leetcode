package leet_code.Problem_967_Medium_Numbers_With_Same_Consecutive_Differences;

import java.util.*;

/**
 * Problem 967: Numbers With Same Consecutive Differences
 * https://leetcode.com/problems/numbers-with-same-consecutive-differences/
 */
public class Solution {

    /**
     * Finds numbers of length N with consecutive difference K.
     * Strategy: BFS/Level-order Construction.
     * 
     * @param n Length of the number.
     * @param k Difference between consecutive digits.
     * @return Array of valid numbers.
     * 
     *         Tóm tắt chiến lược:
     *         1. Xây dựng các số theo từng chữ số (BFS theo độ dài).
     *         2. Bắt đầu với các chữ số từ 1 đến 9 (vì N >= 2 nên không có số 0 ở
     *         đầu).
     *         Trường hợp đặc biệt N=1 (nếu có) sẽ bao gồm cả số 0, nhưng constraint
     *         nói N >= 2.
     *         3. Với mỗi số `num` hiện tại có chữ số cuối là `d`:
     *         - Ta có thể thêm `d + k` vào sau nếu `d + k <= 9`.
     *         - Ta có thể thêm `d - k` vào sau nếu `d - k >= 0`.
     *         - Lưu ý: Nếu `k = 0`, thì `d + k` và `d - k` là giống nhau. Ta chỉ
     *         thêm 1 lần để tránh trùng lặp.
     *         4. Lặp lại quá trình này `N-1` lần để đạt độ dài `N`.
     *         5. Thu thập kết quả vào mảng và trả về.
     */
    public int[] numsSameConsecDiff(int n, int k) {
        if (n == 1) {
            return new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        }

        List<Integer> currentLevel = new ArrayList<>();
        // Start with digits 1-9
        for (int i = 1; i <= 9; i++) {
            currentLevel.add(i);
        }

        // Build numbers digit by digit
        for (int level = 1; level < n; level++) {
            List<Integer> nextLevel = new ArrayList<>();
            for (int num : currentLevel) {
                int lastDigit = num % 10;

                // Option 1: lastDigit + k
                int nextDigit1 = lastDigit + k;
                if (nextDigit1 >= 0 && nextDigit1 <= 9) {
                    nextLevel.add(num * 10 + nextDigit1);
                }

                // Option 2: lastDigit - k
                // Only if k > 0 to avoid duplicates (e.g., if k=0, 5+0 and 5-0 are same)
                if (k > 0) {
                    int nextDigit2 = lastDigit - k;
                    if (nextDigit2 >= 0 && nextDigit2 <= 9) {
                        nextLevel.add(num * 10 + nextDigit2);
                    }
                }
            }
            currentLevel = nextLevel;
        }

        // Convert List to int[]
        int[] result = new int[currentLevel.size()];
        for (int i = 0; i < currentLevel.size(); i++) {
            result[i] = currentLevel.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] res1 = sol.numsSameConsecDiff(3, 7);
        System.out.println("Result: " + Arrays.toString(res1)); // [181, 292, 707, 818, 929]

        int[] res2 = sol.numsSameConsecDiff(2, 1);
        System.out.println("Result: " + Arrays.toString(res2)); // [10, 12, 21, 23, 32, 34, 43, 45, 54, 56, 65, 67, 76,
                                                                // 78, 87, 89, 98]
    }
}
