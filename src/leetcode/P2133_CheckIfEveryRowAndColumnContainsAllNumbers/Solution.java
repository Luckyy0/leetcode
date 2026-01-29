package leetcode.P2133_CheckIfEveryRowAndColumnContainsAllNumbers;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;

        // Check rows
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < 1 || matrix[i][j] > n || !set.add(matrix[i][j])) {
                    return false;
                }
            }
        }

        // Check cols
        for (int j = 0; j < n; j++) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (!set.add(matrix[i][j])) {
                    return false;
                }
            }
        }

        return true;
    }
}
