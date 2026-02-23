package leet_code.Problem_354_Hard_Russian_Doll_Envelopes;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_LIS {

    /**
     * Finds max number of Russian doll envelopes.
     * Uses Sorting (W asc, H desc) + LIS on Height (Binary Search).
     * Time: O(N log N), Space: O(N).
     * 
     * Tìm số lượng phong bao tối đa lồng vào nhau.
     * Sử dụng Sắp xếp (W tăng, H giảm) + LIS trên Chiều cao (Tìm kiếm Nhị phân).
     */
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0)
            return 0;

        // Step 1: Sort by width ascending, then height descending
        // Bước 1: Sắp xếp theo chiều rộng tăng dần, sau đó chiều cao giảm dần
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];
            return a[0] - b[0];
        });

        // Step 2: Find LIS on heights
        // Bước 2: Tìm LIS trên mảng chiều cao
        int[] heights = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            heights[i] = envelopes[i][1];
        }

        return lengthOfLIS(heights);
    }

    private int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;

        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size)
                size++;
        }

        return size;
    }

    public static void main(String[] args) {
        Solution_LIS solution = new Solution_LIS();

        // Test Case 1: [[5,4],[6,4],[6,7],[2,3]] -> 3
        int[][] e1 = { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } };
        System.out.println("Max Envelopes 1: " + solution.maxEnvelopes(e1));

        // Test Case 2: [[1,1],[1,1],[1,1]] -> 1
        int[][] e2 = { { 1, 1 }, { 1, 1 }, { 1, 1 } };
        System.out.println("Max Envelopes 2: " + solution.maxEnvelopes(e2));
    }
}
