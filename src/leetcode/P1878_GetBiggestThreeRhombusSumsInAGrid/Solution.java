package leetcode.P1878_GetBiggestThreeRhombusSumsInAGrid;

import java.util.TreeSet;

public class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        TreeSet<Integer> sums = new TreeSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Radius k
                for (int k = 0; k <= 50; k++) { // Valid k?
                    // Check bounds
                    if (i - k < 0 || i + k >= m || j - k < 0 || j + k >= n) {
                        break;
                    }

                    int currentSum = 0;
                    if (k == 0) {
                        currentSum = grid[i][j];
                    } else {
                        // Top (i-k, j) -> Right (i, j+k)
                        for (int d = 0; d < k; d++)
                            currentSum += grid[i - k + d][j + d];
                        // Right (i, j+k) -> Bottom (i+k, j)
                        for (int d = 0; d < k; d++)
                            currentSum += grid[i + d][j + k - d];
                        // Bottom (i+k, j) -> Left (i, j-k)
                        for (int d = 0; d < k; d++)
                            currentSum += grid[i + k - d][j - d];
                        // Left (i, j-k) -> Top (i-k, j)
                        for (int d = 0; d < k; d++)
                            currentSum += grid[i - d][j - k + d];
                    }

                    sums.add(currentSum);
                    if (sums.size() > 3) {
                        sums.pollFirst(); // Remove smallest
                    }
                }
            }
        }

        // Convert to descending array
        int[] result = new int[sums.size()];
        int idx = 0;
        for (int val : sums.descendingSet()) {
            result[idx++] = val;
        }
        return result;
    }
}
