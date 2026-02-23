package leet_code.Problem_873_Medium_Length_of_Longest_Fibonacci_Subsequence;

import java.util.*;

/**
 * Problem 873: Length of Longest Fibonacci Subsequence
 * https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/
 */
public class Solution {

    /**
     * Finds the length of the longest Fibonacci-like subsequence.
     * Strategy: Use a HashSet for O(1) lookup of elements. Try every pair
     * of numbers as the start of a Fibonacci sequence.
     * 
     * @param arr Strictly increasing array.
     * @return Max length (>= 3) or 0.
     * 
     *         Tóm tắt chiến lược:
     *         1. Lưu tất cả các số vào một HashSet để tra cứu nhanh.
     *         2. Dùng hai vòng lặp lồng nhau để chọn hai số đầu tiên (a, b) cho dãy
     *         Fibonacci.
     *         3. Tìm số tiếp theo c = a + b trong Hashset. Tiếp tục cho đến khi
     *         không tìm thấy.
     *         4. Vì số Fibonacci tăng rất nhanh (hàm mũ), vòng lặp tìm kiếm c sẽ
     *         kết thúc
     *         rất sớm (tối đa khoảng 45 lần cho số đến 10^9).
     */
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Set<Integer> set = new HashSet<>();
        for (int x : arr) {
            set.add(x);
        }

        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = arr[i];
                int b = arr[j];
                int currentLen = 2;

                // Keep looking for the next number in the Fibonacci sequence
                while (set.contains(a + b)) {
                    int c = a + b;
                    a = b;
                    b = c;
                    currentLen++;
                }

                // Only consider sequences of length 3 or more
                if (currentLen >= 3) {
                    maxLen = Math.max(maxLen, currentLen);
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Max Len: " + sol.lenLongestFibSubseq(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 })); // 5
        System.out.println("Max Len: " + sol.lenLongestFibSubseq(new int[] { 1, 3, 7, 11, 12, 14, 18 })); // 3
    }
}
