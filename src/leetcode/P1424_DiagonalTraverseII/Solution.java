package leetcode.P1424_DiagonalTraverseII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> groups = new HashMap<>();
        int maxKey = 0;
        int count = 0;

        // Iterate from bottom row to top row to maintain correct internal order (large
        // i first)
        for (int i = nums.size() - 1; i >= 0; i--) {
            List<Integer> row = nums.get(i);
            for (int j = 0; j < row.size(); j++) {
                int sum = i + j;
                groups.computeIfAbsent(sum, k -> new ArrayList<>()).add(row.get(j));
                maxKey = Math.max(maxKey, sum);
                count++;
            }
        }

        int[] res = new int[count];
        int idx = 0;
        for (int k = 0; k <= maxKey; k++) {
            List<Integer> diag = groups.get(k);
            if (diag != null) {
                for (int x : diag) {
                    res[idx++] = x;
                }
            }
        }

        return res;
    }
}
