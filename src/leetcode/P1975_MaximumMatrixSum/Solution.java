package leetcode.P1975_MaximumMatrixSum;

public class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        long minAbs = Long.MAX_VALUE;
        int negCount = 0;

        for (int[] row : matrix) {
            for (int val : row) {
                sum += Math.abs(val);
                minAbs = Math.min(minAbs, Math.abs(val));
                if (val < 0)
                    negCount++;
            }
        }

        if (negCount % 2 == 0) {
            return sum;
        } else {
            return sum - 2 * minAbs;
        }
    }
}
