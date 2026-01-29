package leetcode.P1738_FindKthLargestXORCoordinateValue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        List<Integer> values = new ArrayList<>(m * n);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int top = (i > 0) ? dp[i - 1][j] : 0;
                int left = (j > 0) ? dp[i][j - 1] : 0;
                int diag = (i > 0 && j > 0) ? dp[i - 1][j - 1] : 0;

                dp[i][j] = matrix[i][j] ^ top ^ left ^ diag;
                values.add(dp[i][j]);
            }
        }

        Collections.sort(values);
        return values.get(values.size() - k);
    }
}
