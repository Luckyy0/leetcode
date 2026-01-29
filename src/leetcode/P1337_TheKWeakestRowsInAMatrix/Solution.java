package leetcode.P1337_TheKWeakestRowsInAMatrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        List<int[]> list = new ArrayList<>();
        int rows = mat.length;
        int cols = mat[0].length;

        for (int i = 0; i < rows; i++) {
            int count = 0;
            // Binary search for first 0
            int l = 0, r = cols - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (mat[i][mid] == 1) {
                    count = mid + 1;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            list.add(new int[] { count, i });
        }

        Collections.sort(list, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i)[1];
        }

        return res;
    }
}
