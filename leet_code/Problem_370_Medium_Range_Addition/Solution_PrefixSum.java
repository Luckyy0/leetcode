package leet_code.Problem_370_Medium_Range_Addition;

import java.util.Arrays;

public class Solution_PrefixSum {

    /**
     * Range Addition.
     * Uses Difference Array (Prefix Sum trick).
     * Time: O(K + N), Space: O(N).
     * 
     * Cộng dồn Khoảng.
     * Sử dụng Mảng Hiệu (Mẹo Tổng tiền tố).
     */
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];

        // 1. Mark boundaries
        // 1. Đánh dấu các biên
        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int inc = update[2];

            res[start] += inc;
            if (end + 1 < length) {
                res[end + 1] -= inc;
            }
        }

        // 2. Compute prefix sum to get final values
        // 2. Tính tổng tiền tố để có giá trị cuối cùng
        for (int i = 1; i < length; i++) {
            res[i] += res[i - 1];
        }

        return res;
    }

    public static void main(String[] args) {
        Solution_PrefixSum solution = new Solution_PrefixSum();

        // Test Case 1: length=5, [[1,3,2],[2,4,3],[0,2,-2]] -> [-2,0,3,5,3]
        int[][] u1 = { { 1, 3, 2 }, { 2, 4, 3 }, { 0, 2, -2 } };
        int[] r1 = solution.getModifiedArray(5, u1);
        System.out.println("Result 1: " + Arrays.toString(r1));

        // Test Case 2: length=10, [[2,4,6],[5,6,8],[1,9,-4]]
        int[][] u2 = { { 2, 4, 6 }, { 5, 6, 8 }, { 1, 9, -4 } };
        int[] r2 = solution.getModifiedArray(10, u2);
        System.out.println("Result 2: " + Arrays.toString(r2));
    }
}
