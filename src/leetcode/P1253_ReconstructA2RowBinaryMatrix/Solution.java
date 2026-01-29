package leetcode.P1253_ReconstructA2RowBinaryMatrix;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int n = colsum.length;
        int[][] res = new int[2][n];

        for (int i = 0; i < n; i++) {
            if (colsum[i] == 2) {
                res[0][i] = 1;
                res[1][i] = 1;
                upper--;
                lower--;
            } else if (colsum[i] == 1) {
                if (upper >= lower) {
                    res[0][i] = 1;
                    upper--;
                } else {
                    res[1][i] = 1;
                    lower--;
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        if (upper == 0 && lower == 0) {
            List<Integer> r1 = new ArrayList<>();
            List<Integer> r2 = new ArrayList<>();
            for (int x : res[0])
                r1.add(x);
            for (int x : res[1])
                r2.add(x);
            result.add(r1);
            result.add(r2);
        }

        return result;
    }
}
