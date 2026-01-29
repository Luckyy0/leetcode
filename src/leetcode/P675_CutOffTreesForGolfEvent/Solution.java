package leetcode.P675_CutOffTreesForGolfEvent;

import java.util.*;

class Solution {
    int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int cutOffTree(List<List<Integer>> forest) {
        List<int[]> trees = new ArrayList<>();
        int m = forest.size();
        int n = forest.get(0).size();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int h = forest.get(i).get(j);
                if (h > 1)
                    trees.add(new int[] { h, i, j });
            }
        }

        // Sort trees by height
        // Sắp xếp cây theo chiều cao
        Collections.sort(trees, (a, b) -> Integer.compare(a[0], b[0]));

        int totalSteps = 0;
        int curR = 0, curC = 0;

        for (int[] tree : trees) {
            int steps = bfs(forest, curR, curC, tree[1], tree[2], m, n);
            if (steps == -1)
                return -1;
            totalSteps += steps;
            curR = tree[1];
            curC = tree[2];
        }

        return totalSteps;
    }

    private int bfs(List<List<Integer>> forest, int startR, int startC, int targetR, int targetC, int m, int n) {
        if (startR == targetR && startC == targetC)
            return 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { startR, startC });
        boolean[][] visited = new boolean[m][n];
        visited[startR][startC] = true;
        int steps = 0;

        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int[] d : dir) {
                    int nr = curr[0] + d[0];
                    int nc = curr[1] + d[1];

                    if (nr == targetR && nc == targetC)
                        return steps;

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n &&
                            !visited[nr][nc] && forest.get(nr).get(nc) > 0) {
                        visited[nr][nc] = true;
                        queue.add(new int[] { nr, nc });
                    }
                }
            }
        }
        return -1;
    }
}
