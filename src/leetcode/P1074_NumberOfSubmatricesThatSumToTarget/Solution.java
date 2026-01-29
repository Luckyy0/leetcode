package leetcode.P1074_NumberOfSubmatricesThatSumToTarget;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Precompute row prefix sums
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }

        int count = 0;

        // Iterate over all pairs of columns
        for (int c1 = 0; c1 < n; c1++) {
            for (int c2 = c1; c2 < n; c2++) {
                Map<Integer, Integer> map = new HashMap<>(); // Stores prefix sum frequencies
                map.put(0, 1);
                int currSum = 0;

                for (int r = 0; r < m; r++) {
                    int rowVal = matrix[r][c2] - (c1 > 0 ? matrix[r][c1 - 1] : 0);
                    currSum += rowVal;

                    if (map.containsKey(currSum - target)) {
                        count += map.get(currSum - target);
                    }
                    map.put(currSum, map.getOrDefault(currSum, 0) + 1);
                }
            }
        }

        return count;
    }
}
