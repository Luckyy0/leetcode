package leet_code.Problem_835_Medium_Image_Overlap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    /**
     * Finds the maximum possible overlap of 1s in two binary matrices.
     * Strategy: List all coordinates of 1s and count the frequency of shift
     * vectors.
     * Time: O(N^4) worst case, O(L1 * L2) on average.
     * Space: O(N^2).
     */
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;

        // List coordinates of 1s in both images
        List<int[]> list1 = new ArrayList<>();
        List<int[]> list2 = new ArrayList<>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (img1[r][c] == 1)
                    list1.add(new int[] { r, c });
                if (img2[r][c] == 1)
                    list2.add(new int[] { r, c });
            }
        }

        // Frequency map to store shift vector count
        // Key is a representation of the vector (dr, dc)
        Map<Integer, Integer> countMap = new HashMap<>();
        int maxOverlap = 0;

        for (int[] p1 : list1) {
            for (int[] p2 : list2) {
                // Vector required to shift p1 to p2
                int dr = p2[0] - p1[0];
                int dc = p2[1] - p1[1];

                // Encode vector into a single integer (assuming n <= 30)
                // Offset by 100 to handle negative values and ensure uniqueness
                int key = (dr + 100) * 1000 + (dc + 100);

                int currentCount = countMap.getOrDefault(key, 0) + 1;
                countMap.put(key, currentCount);
                maxOverlap = Math.max(maxOverlap, currentCount);
            }
        }

        return maxOverlap;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] i1 = { { 1, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 } };
        int[][] i2 = { { 0, 0, 0 }, { 0, 1, 1 }, { 0, 0, 1 } };
        System.out.println("Result 1: " + sol.largestOverlap(i1, i2)); // 3
    }
}
