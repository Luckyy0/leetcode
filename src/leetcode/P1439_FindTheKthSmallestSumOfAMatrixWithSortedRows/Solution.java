package leetcode.P1439_FindTheKthSmallestSumOfAMatrixWithSortedRows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int m = mat.length;
        List<Integer> row = new ArrayList<>();
        for (int x : mat[0])
            row.add(x);
        if (row.size() > k)
            row = row.subList(0, k);

        for (int i = 1; i < m; i++) {
            List<Integer> nextRow = new ArrayList<>();
            // Optimization: We only need K smallest sums.
            // Brute force all pairs and sort might be okay given K=200?
            // K * N = 200 * 40 = 8000. Sorting 8000 is fast.
            for (int x : row) {
                for (int y : mat[i]) {
                    nextRow.add(x + y);
                }
            }
            Collections.sort(nextRow);
            if (nextRow.size() > k) {
                row = nextRow.subList(0, k);
            } else {
                row = nextRow;
            }
        }

        return row.get(k - 1);
    }
}
