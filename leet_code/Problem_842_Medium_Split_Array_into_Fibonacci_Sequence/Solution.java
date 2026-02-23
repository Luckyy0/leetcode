package leet_code.Problem_842_Medium_Split_Array_into_Fibonacci_Sequence;

import java.util.*;

/**
 * Problem 842: Split Array into Fibonacci Sequence
 * https://leetcode.com/problems/split-array-into-fibonacci-sequence/
 */
public class Solution {

    /**
     * Splits string num into a Fibonacci-like sequence.
     * Strategy: Backtracking with pruning.
     * 
     * @param num String of digits.
     * @return List of integers if possible, else empty list.
     * 
     *         Tóm tắt chiến lược:
     *         1. Sử dụng thuật toán Quay lui (Backtracking) để tìm cách chia chuỗi.
     *         2. Ta thử lấy các chuỗi con làm số tiếp theo trong dãy.
     *         3. Ràng buộc:
     *         - Không có số 0 ở đầu (trừ chính số 0).
     *         - Giá trị phải nhỏ hơn hoặc bằng Integer.MAX_VALUE.
     *         - Khi đã có >= 2 số, số tiếp theo phải bằng tổng của 2 số trước đó.
     *         4. Cắt tỉa: Nếu số hiện tại đã lớn hơn tổng của 2 số trước, các chuỗi
     *         con
     *         dài hơn chắc chắn sẽ không hợp lệ -> dừng vòng lặp tìm kiếm sớm.
     */
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> result = new ArrayList<>();
        backtrack(num, 0, result);
        return result;
    }

    private boolean backtrack(String num, int start, List<Integer> result) {
        // Base case: Reached the end with at least 3 numbers
        if (start == num.length() && result.size() >= 3) {
            return true;
        }

        for (int i = start; i < num.length(); i++) {
            // Case 1: Leading zero - only allowed if it's the digit '0' alone
            if (num.charAt(start) == '0' && i > start) {
                break;
            }

            // Convert current substring to long to check for 32-bit overflow
            long val = Long.parseLong(num.substring(start, i + 1));
            if (val > Integer.MAX_VALUE) {
                break;
            }

            int size = result.size();
            // Pruning: if current val > sum of last two, no need to check longer strings
            if (size >= 2 && val > (long) result.get(size - 1) + result.get(size - 2)) {
                break;
            }

            // If we have fewer than 2 numbers, we can pick any valid number
            // If we have >= 2, the number must equal the sum
            if (size < 2 || val == (long) result.get(size - 1) + result.get(size - 2)) {
                result.add((int) val);
                if (backtrack(num, i + 1, result)) {
                    return true;
                }
                // Backtrack: remove last added element
                result.remove(result.size() - 1);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result: " + sol.splitIntoFibonacci("1101111")); // [11, 0, 11, 11]
        System.out.println("Result: " + sol.splitIntoFibonacci("123456579")); // [123, 456, 579]
        System.out.println("Result: " + sol.splitIntoFibonacci("0123")); // []
    }
}
