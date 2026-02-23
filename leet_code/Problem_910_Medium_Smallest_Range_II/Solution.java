package leet_code.Problem_910_Medium_Smallest_Range_II;

import java.util.*;

/**
 * Problem 910: Smallest Range II
 * https://leetcode.com/problems/smallest-range-ii/
 */
public class Solution {

    /**
     * Minimizes the difference between max and min after modifying elements.
     * Strategy: Sort and find optimal split point.
     * 
     * @param A Input array.
     * @param K Adjustment value.
     * @return Minimal score.
     * 
     *         Tóm tắt chiến lược:
     *         1. Sắp xếp mảng A tăng dần.
     *         2. Ta muốn giảm các số lớn (trừ K) và tăng các số nhỏ (cộng K) để
     *         chúng gần nhau hơn.
     *         3. Sẽ có một điểm cắt (pivot) tại chỉ số i, sao cho:
     *         - Tất cả các số bên trái i (A[0]...A[i]) được cộng K.
     *         - Tất cả các số bên phải i (A[i+1]...A[n-1]) được trừ K.
     *         4. Khi đó, giá trị lớn nhất mới sẽ là max(A[n-1]-K, A[i]+K).
     *         Giá trị nhỏ nhất mới sẽ là min(A[0]+K, A[i+1]-K).
     *         5. Duyệt qua tất cả các điểm cắt i có thể và tìm hiệu số nhỏ nhất.
     */
    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int n = A.length;
        int ans = A[n - 1] - A[0]; // Initial range (add K to all or subtract K from all)

        // Iterate through all possible pivot points i
        // We split between A[i] and A[i+1]
        for (int i = 0; i < n - 1; i++) {
            int maxVal = Math.max(A[n - 1] - K, A[i] + K);
            int minVal = Math.min(A[0] + K, A[i + 1] - K);

            ans = Math.min(ans, maxVal - minVal);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result: " + sol.smallestRangeII(new int[] { 1 }, 0)); // 0
        System.out.println("Result: " + sol.smallestRangeII(new int[] { 0, 10 }, 2)); // 6
        System.out.println("Result: " + sol.smallestRangeII(new int[] { 1, 3, 6 }, 3)); // 3
    }
}
