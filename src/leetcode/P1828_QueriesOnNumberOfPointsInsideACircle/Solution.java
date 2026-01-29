package leetcode.P1828_QueriesOnNumberOfPointsInsideACircle;

public class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int cx = queries[i][0];
            int cy = queries[i][1];
            int r = queries[i][2];
            int rSq = r * r;

            int count = 0;
            for (int[] p : points) {
                int dx = p[0] - cx;
                int dy = p[1] - cy;
                if (dx * dx + dy * dy <= rSq) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }
}
