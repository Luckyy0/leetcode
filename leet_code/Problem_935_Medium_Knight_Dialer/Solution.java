package leet_code.Problem_935_Medium_Knight_Dialer;

import java.util.Arrays;

/**
 * Problem 935: Knight Dialer
 * https://leetcode.com/problems/knight-dialer/
 */
public class Solution {

    /**
     * Counts the number of distinct phone numbers of length n.
     * Strategy: Dynamic Programming.
     * 
     * @param n Length of phone number.
     * @return Number of distinct phone numbers modulo 10^9 + 7.
     * 
     *         Tóm tắt chiến lược:
     *         1. Đây là bài toán Quy hoạch Động trên đồ thị.
     *         2. Trạng thái: `dp[k][d]` là số cách để kết thúc tại chữ số `d` sau
     *         `k` bước nhảy (độ dài k+1).
     *         3. Cơ sở: Với n=1, ta có thể đặt mã ở bất kỳ ô nào (0-9), nên có 10
     *         cách.
     *         4. Chuyển trạng thái: Số cách để đến được ô `next` ở bước `k` bằng
     *         tổng số cách đã đến các ô `prev` ở bước `k-1`,
     *         với điều kiện từ `prev` có thể nhảy tới `next`.
     *         5. Ta định nghĩa đồ thị các bước nhảy hợp lệ của mã:
     *         - 0 -> 4, 6
     *         - 1 -> 6, 8
     *         - 2 -> 7, 9
     *         - ... và ngược lại (đồ thị vô hướng).
     *         6. Thay vì mảng 2 chiều, ta chỉ cần mảng 1 chiều `counts` lưu số cách
     *         kết thúc tại mỗi chữ số ở bước hiện tại.
     *         7. Lưu ý: Phím 5 không có đường đi nào từ các phím khác (và cũng
     *         không đi đâu được), nên nếu n > 1,
     *         số cách bắt đầu hoặc kết thúc tại 5 sẽ là 0. Tuy nhiên với n=1, 5
     *         được tính là 1 cách.
     */
    public int knightDialer(int n) {
        if (n == 1)
            return 10;

        long MOD = 1_000_000_007;

        // Initial counts for n=1: each digit can be a starting point (1 way)
        long[] counts = new long[10];
        Arrays.fill(counts, 1);

        // Define jumps from each digit.
        // jumps[i] contains digits reachable FROM i via a knight move.
        int[][] jumps = {
                { 4, 6 }, // 0
                { 6, 8 }, // 1
                { 7, 9 }, // 2
                { 4, 8 }, // 3
                { 0, 3, 9 }, // 4
                {}, // 5 (Isolated)
                { 0, 1, 7 }, // 6
                { 2, 6 }, // 7
                { 1, 3 }, // 8
                { 2, 4 } // 9
        };

        // Perform n-1 jumps
        for (int i = 1; i < n; i++) {
            long[] nextCounts = new long[10];

            // For each digit d, distribute its count to its reachable neighbors
            for (int digit = 0; digit <= 9; digit++) {
                for (int nextDigit : jumps[digit]) {
                    nextCounts[nextDigit] = (nextCounts[nextDigit] + counts[digit]) % MOD;
                }
            }

            counts = nextCounts;
        }

        // Sum all possibilities
        long total = 0;
        for (long count : counts) {
            total = (total + count) % MOD;
        }

        return (int) total;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result: " + sol.knightDialer(1)); // 10
        System.out.println("Result: " + sol.knightDialer(2)); // 20
        System.out.println("Result: " + sol.knightDialer(3131)); // 136006598
    }
}
