package leet_code.Problem_891_Hard_Sum_of_Subsequence_Widths;

import java.util.*;

/**
 * Problem 891: Sum of Subsequence Widths
 * https://leetcode.com/problems/sum-of-subsequence-widths/
 */
public class Solution {

    /**
     * Calculates the sum of widths of all subsequences.
     * Strategy: Sort the array and use mathematical properties.
     * 
     * @param nums Array of integers.
     * @return Sum of widths modulo 10^9 + 7.
     * 
     *         Tóm tắt chiến lược:
     *         1. Sắp xếp mảng `nums`. Giá trị nhỏ nhất/lớn nhất không phụ thuộc
     *         vào thứ tự, nên việc sắp xếp là hợp lệ.
     *         2. Với một phần tử `nums[i]` (sau khi sắp xếp):
     *         - Nó sẽ đóng vai trò là "lớn nhất" trong 2^i dãy con.
     *         (Các dãy con gồm nums[i] và các tập hợp con của các số đứng trước
     *         nó).
     *         - Nó sẽ đóng vai trò là "nhỏ nhất" trong 2^(n-1-i) dãy con.
     *         (Các dãy con gồm nums[i] và các tập hợp con của các số đứng sau nó).
     *         3. Tổng đóng góp của nums[i] vào kết quả cuối cùng là:
     *         nums[i] * (2^i - 2^(n-1-i)).
     *         4. Tính toán với modulo để tránh tràn số.
     */
    public int sumSubseqWidths(int[] nums) {
        int MOD = 1_000_000_007;
        int n = nums.length;
        Arrays.sort(nums);

        long[] pow = new long[n];
        pow[0] = 1;
        for (int i = 1; i < n; i++) {
            pow[i] = (pow[i - 1] * 2) % MOD;
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            // How many times nums[i] works as max? -> pow[i]
            // How many times nums[i] works as min? -> pow[n - 1 - i]
            long count = (pow[i] - pow[n - 1 - i]);

            // Adjust count if negative due to modulo subtraction
            // Note: In Java, % can return negative for negative dividends.
            // But we should handle the term-by-term modulo carefully.

            long term = (count * nums[i]) % MOD;
            ans = (ans + term + MOD) % MOD;
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = { 2, 1, 3 };
        System.out.println("Result: " + sol.sumSubseqWidths(nums1)); // 6

        int[] nums2 = { 2 };
        System.out.println("Result: " + sol.sumSubseqWidths(nums2)); // 0
    }
}
