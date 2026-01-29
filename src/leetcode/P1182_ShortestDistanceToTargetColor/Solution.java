package leetcode.P1182_ShortestDistanceToTargetColor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        int n = colors.length;
        int[][] dist = new int[4][n];
        for (int i = 1; i <= 3; i++)
            Arrays.fill(dist[i], -1);

        // Left pass
        int[] lastPos = new int[4];
        Arrays.fill(lastPos, -1);
        for (int i = 0; i < n; i++) {
            lastPos[colors[i]] = i;
            for (int c = 1; c <= 3; c++) {
                if (lastPos[c] != -1) {
                    dist[c][i] = i - lastPos[c];
                }
            }
        }

        // Right pass
        Arrays.fill(lastPos, -1);
        for (int i = n - 1; i >= 0; i--) {
            lastPos[colors[i]] = i;
            for (int c = 1; c <= 3; c++) {
                if (lastPos[c] != -1) {
                    int d = lastPos[c] - i;
                    if (dist[c][i] == -1 || d < dist[c][i]) {
                        dist[c][i] = d;
                    }
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int[] q : queries) {
            res.add(dist[q[1]][q[0]]);
        }
        return res;
    }
}
