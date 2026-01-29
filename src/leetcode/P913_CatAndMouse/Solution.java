package leetcode.P913_CatAndMouse;

import java.util.*;

class Solution {
    public int catMouseGame(int[][] graph) {
        int n = graph.length;
        // state: [m, c, turn]
        // 0: Draw, 1: Mouse, 2: Cat
        int[][][] color = new int[n][n][3];
        int[][][] degree = new int[n][n][3];

        for (int m = 0; m < n; m++) {
            for (int c = 0; c < n; c++) {
                degree[m][c][1] = graph[m].length;
                degree[m][c][2] = graph[c].length;
                for (int neighbor : graph[c]) {
                    if (neighbor == 0) {
                        degree[m][c][2]--;
                        break;
                    }
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        // Terminal states
        for (int i = 1; i < n; i++) {
            // Mouse in hole
            color[0][i][1] = color[0][i][2] = 1;
            queue.add(new int[] { 0, i, 1, 1 });
            queue.add(new int[] { 0, i, 2, 1 });
            // Cat catches Mouse
            color[i][i][1] = color[i][i][2] = 2;
            queue.add(new int[] { i, i, 1, 2 });
            queue.add(new int[] { i, i, 2, 2 });
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int m = curr[0], c = curr[1], t = curr[2], s = curr[3];

            for (int[] prev : getPrevStates(graph, m, c, t)) {
                int pm = prev[0], pc = prev[1], pt = prev[2];
                if (color[pm][pc][pt] == 0) {
                    if (pt == s) { // Can force win
                        color[pm][pc][pt] = s;
                        queue.add(new int[] { pm, pc, pt, s });
                    } else {
                        degree[pm][pc][pt]--;
                        if (degree[pm][pc][pt] == 0) { // All moves lead to loss
                            color[pm][pc][pt] = 3 - pt; // pt=1->2, pt=2->1
                            queue.add(new int[] { pm, pc, pt, 3 - pt });
                        }
                    }
                }
            }
        }

        return color[1][2][1];
    }

    private List<int[]> getPrevStates(int[][] graph, int m, int c, int t) {
        List<int[]> res = new ArrayList<>();
        if (t == 1) { // Current is Mouse turn, Prev was Cat turn
            for (int pc : graph[c]) {
                if (pc != 0)
                    res.add(new int[] { m, pc, 2 });
            }
        } else { // Current is Cat turn, Prev was Mouse turn
            for (int pm : graph[m]) {
                res.add(new int[] { pm, c, 1 });
            }
        }
        return res;
    }
}
