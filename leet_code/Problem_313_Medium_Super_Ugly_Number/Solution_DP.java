package leet_code.Problem_313_Medium_Super_Ugly_Number;

import java.util.Arrays;

public class Solution_DP {

    /**
     * Finds the nth super ugly number.
     * Uses DP with multiple pointers (equivalent to merging K sorted lists).
     * Time: O(N * K), Space: O(N + K).
     * 
     * Tìm số siêu xấu thứ n.
     * Sử dụng DP với đa con trỏ (tương đương hợp nhất K danh sách đã sắp xếp).
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] idx = new int[primes.length];
        long[] val = new long[primes.length]; // Handle potential overflow during intermediate
        // Though problem says result fits in int, intermediate primes[j] * ugly[idx[j]]
        // might overflow if we reached end?
        // Actually since result < Integer.MAX, and primes[j] >= 2, the next candidate
        // might slightly exceed MAX_INT briefly before being picked?
        // But we only pick min. If min exceeds MAX_INT, then result exceeds. So long is
        // safer.

        Arrays.fill(val, 1);
        ugly[0] = 1;

        // Init vals
        for (int j = 0; j < primes.length; j++) {
            val[j] = (long) primes[j];
        }

        for (int i = 1; i < n; i++) {
            long min = Long.MAX_VALUE;

            // Find minimum candidate
            // Tìm ứng viên nhỏ nhất
            for (long v : val) {
                min = Math.min(min, v);
            }

            ugly[i] = (int) min;

            // Advance pointers for all primes that produced this min
            // Tăng con trỏ cho tất cả các số nguyên tố đã tạo ra số min này
            for (int j = 0; j < primes.length; j++) {
                if (val[j] == min) {
                    idx[j]++;
                    val[j] = (long) primes[j] * ugly[idx[j]];
                }
            }
        }

        return ugly[n - 1];
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();

        // Test Case 1
        int[] primes1 = { 2, 7, 13, 19 };
        System.out.println("Nth Super Ugly 1: " + solution.nthSuperUglyNumber(12, primes1)); // 32

        // Test Case 2
        int[] primes2 = { 2, 3, 5 };
        System.out.println("Nth Super Ugly 2: " + solution.nthSuperUglyNumber(1, primes2)); // 1
    }
}
