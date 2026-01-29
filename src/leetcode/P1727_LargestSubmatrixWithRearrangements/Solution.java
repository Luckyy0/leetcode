package leetcode.P1727_LargestSubmatrixWithRearrangements;

import java.util.Arrays;

public class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxArea = 0;

        // Update matrix in-place to store heights
        // Or separate array
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1 && i > 0) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }

            // Get current row heights
            int[] heights = matrix[i].clone();
            Arrays.sort(heights);

            // Calculate max area for this row
            // Heights sorted asc, traverse backwards
            for (int k = 0; k < n; k++) {
                // width is n - k
                maxArea = Math.max(maxArea, heights[k] * (n - k));
            }
        }

        return maxArea;
    }
}
