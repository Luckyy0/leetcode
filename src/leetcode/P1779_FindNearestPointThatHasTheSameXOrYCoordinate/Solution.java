package leetcode.P1779_FindNearestPointThatHasTheSameXOrYCoordinate;

public class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int minInd = -1;
        int minDst = Integer.MAX_VALUE;

        for (int i = 0; i < points.length; i++) {
            int px = points[i][0];
            int py = points[i][1];

            if (px == x || py == y) {
                int dist = Math.abs(x - px) + Math.abs(y - py);
                if (dist < minDst) {
                    minDst = dist;
                    minInd = i;
                }
            }
        }

        return minInd;
    }
}
