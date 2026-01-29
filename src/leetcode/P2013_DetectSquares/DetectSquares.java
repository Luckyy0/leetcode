package leetcode.P2013_DetectSquares;

import java.util.ArrayList;
import java.util.List;

public class DetectSquares {
    int[][] counts;
    List<int[]> distinctPoints;

    public DetectSquares() {
        counts = new int[1001][1001];
        distinctPoints = new ArrayList<>();
    }

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        if (counts[x][y] == 0) {
            distinctPoints.add(point);
        }
        counts[x][y]++;
    }

    public int count(int[] point) {
        int px = point[0];
        int py = point[1];
        int res = 0;

        for (int[] p : distinctPoints) {
            int x = p[0];
            int y = p[1];

            // Should be diagonal
            if (Math.abs(px - x) == Math.abs(py - y) && px != x) {
                // p is (x, y). We need (x, py) and (px, y).
                res += counts[x][y] * counts[x][py] * counts[px][y];
            }
        }

        return res;
    }
}
