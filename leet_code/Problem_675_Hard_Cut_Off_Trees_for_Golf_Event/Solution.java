package leet_code.Problem_675_Hard_Cut_Off_Trees_for_Golf_Event;

import java.util.*;

public class Solution {

    /**
     * Cuts off all trees in order from shortest to tallest.
     * Strategy: Sort trees by height, then perform BFS between consecutive trees.
     * Time: O(M^2 * N^2), Space: O(M * N).
     */
    public int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.size() == 0)
            return 0;
        int m = forest.size();
        int n = forest.get(0).size();

        // 1. Collect all tree positions and their heights
        List<int[]> trees = new ArrayList<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int height = forest.get(r).get(c);
                if (height > 1) {
                    trees.add(new int[] { height, r, c });
                }
            }
        }

        // 2. Sort trees by height
        Collections.sort(trees, (a, b) -> a[0] - b[0]);

        // 3. Sequential navigation using BFS
        int totalSteps = 0;
        int currR = 0;
        int currC = 0;

        for (int[] tree : trees) {
            int targetR = tree[1];
            int targetC = tree[2];

            int steps = bfs(forest, currR, currC, targetR, targetC, m, n);
            if (steps == -1)
                return -1; // Unreachable tree

            totalSteps += steps;
            currR = targetR;
            currC = targetC;
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
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int[] d : dirs) {
                    int nr = curr[0] + d[0];
                    int nc = curr[1] + d[1];

                    if (nr == targetR && nc == targetC)
                        return steps;

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n &&
                            !visited[nr][nc] && forest.get(nr).get(nc) != 0) {
                        visited[nr][nc] = true;
                        queue.add(new int[] { nr, nc });
                    }
                }
            }
        }

        return -1; // Path blocked
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<Integer>> forest = new ArrayList<>();
        forest.add(Arrays.asList(1, 2, 3));
        forest.add(Arrays.asList(0, 0, 4));
        forest.add(Arrays.asList(7, 6, 5));

        System.out.println("Total steps: " + sol.cutOffTree(forest)); // 6
    }
}
