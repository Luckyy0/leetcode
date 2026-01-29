package leetcode.P1886_DetermineWhetherMatrixCanBeObtainedByRotation;

import java.util.Arrays;

public class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        for (int i = 0; i < 4; i++) {
            if (isEqual(mat, target))
                return true;
            rotate(mat);
        }
        return false;
    }

    private boolean isEqual(int[][] m1, int[][] m2) {
        int n = m1.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (m1[i][j] != m2[i][j])
                    return false;
            }
        }
        return true;
    }

    private void rotate(int[][] mat) {
        int n = mat.length;

        // Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // Reverse rows
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][n - 1 - j];
                mat[i][n - 1 - j] = temp;
            }
        }
    }
}
