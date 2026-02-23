package leet_code.Problem_899_Hard_Orderly_Queue;

import java.util.*;

/**
 * Problem 899: Orderly Queue
 * https://leetcode.com/problems/orderly-queue/
 */
public class Solution {

    /**
     * Finds the lexicographically smallest string possible.
     * Strategy: Case analysis on k.
     * 
     * @param s Input string.
     * @param k Max size of movable prefix.
     * @return Smallest string.
     * 
     *         Tóm tắt chiến lược:
     *         1. Trường hợp k > 1: Ta có thể di chuyển bất kỳ ký tự nào trong k ký
     *         tự đầu.
     *         Điều này tương đương với việc ta có thể hoán đổi các ký tự liền kề,
     *         giống
     *         như thuật toán Bubble Sort.
     *         -> Ta có thể tạo ra bất kỳ hoán vị nào của chuỗi.
     *         -> Kết quả là chuỗi đã được sắp xếp tăng dần.
     *         2. Trường hợp k = 1: Ta chỉ có thể di chuyển ký tự đầu tiên xuống
     *         cuối cùng.
     *         -> Đây là phép xoay vòng (rotation).
     *         -> Ta chỉ cần thử tất cả các phép xoay có thể và tìm chuỗi nhỏ nhất.
     */
    public String orderlyQueue(String s, int k) {
        if (k > 1) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        } else {
            String ans = s;
            for (int i = 1; i < s.length(); i++) {
                String rotated = s.substring(i) + s.substring(0, i);
                if (rotated.compareTo(ans) < 0) {
                    ans = rotated;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result: " + sol.orderlyQueue("cba", 1)); // "acb"
        System.out.println("Result: " + sol.orderlyQueue("baaca", 3)); // "aaabc"
        System.out.println("Result: " + sol.orderlyQueue("bacd", 2)); // "abcd"
    }
}
