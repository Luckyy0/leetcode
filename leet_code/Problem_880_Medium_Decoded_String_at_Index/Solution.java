package leet_code.Problem_880_Medium_Decoded_String_at_Index;

/**
 * Problem 880: Decoded String at Index
 * https://leetcode.com/problems/decoded-string-at-index/
 */
public class Solution {

    /**
     * Finds the K-th character in the decoded string.
     * Strategy: Instead of building the string, calculate total length
     * and traverse backwards using modulo logic.
     * 
     * @param s The encoded string.
     * @param k The target index (1-indexed).
     * @return The K-th character.
     * 
     *         Tóm tắt chiến lược:
     *         1. Tính tổng độ dài (size) của chuỗi sau khi giải mã.
     *         2. Duyệt ngược chuỗi gốc từ cuối lên đầu.
     *         3. Dùng K = K % size để ánh xạ vị trí cần tìm vào chuỗi ngắn hơn hiện
     *         tại.
     *         4. Nếu K == 0 và gặp chữ cái, đó chính là kết quả.
     *         5. Nếu gặp số d: size = size / d. Nếu gặp chữ: size = size - 1.
     */
    public String decodeAtIndex(String s, int k) {
        long size = 0;
        int n = s.length();

        // Phase 1: Calculate total size of the decoded string
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                size *= (c - '0');
            } else {
                size++;
            }
        }

        // Use long for K because calculations with size require it
        long K = k;

        // Phase 2: Traverse backwards to find the character
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            K %= size;

            // If K % size == 0 and we are at a letter, it means this letter
            // is at the target position.
            if (K == 0 && Character.isLetter(c)) {
                return Character.toString(c);
            }

            if (Character.isDigit(c)) {
                size /= (c - '0');
            } else {
                size--;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result: " + sol.decodeAtIndex("leet2code3", 10)); // "o"
        System.out.println("Result: " + sol.decodeAtIndex("ha22", 5)); // "h"
        System.out.println("Result: " + sol.decodeAtIndex("a2345678999999999999999", 1)); // "a"
    }
}
