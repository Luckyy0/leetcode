package leetcode.P1072_FlipColumnsForMaximumNumberOfEqualRows;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> count = new HashMap<>();
        int maxRows = 0;

        for (int[] row : matrix) {
            StringBuilder sb = new StringBuilder();
            // Choose canonical form: always start with 0
            // If row starts with 1, we treat it as its inverse (effectively flipping all
            // bits if we compared to 0-start)
            // Actually, construct pattern relative to first element.
            int first = row[0];
            for (int val : row) {
                if (val == first) {
                    sb.append('0');
                } else {
                    sb.append('1');
                }
            }
            String key = sb.toString();
            int freq = count.getOrDefault(key, 0) + 1;
            count.put(key, freq);
            maxRows = Math.max(maxRows, freq);
        }

        return maxRows;
    }
}
