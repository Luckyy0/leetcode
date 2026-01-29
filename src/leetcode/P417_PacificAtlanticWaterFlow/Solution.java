package leetcode.P417_PacificAtlanticWaterFlow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    /**
     * Problem 417: Pacific Atlantic Water Flow
     * Approach: BFS starting from ocean boundaries (Reverse Flow)
     * 
     * Time Complexity: O(M * N)
     * Space Complexity: O(M * N)
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();

        // Horizontal boundaries
        for (int j = 0; j < n; j++) {
            pQueue.offer(new int[] { 0, j });
            pacific[0][j] = true;

            aQueue.offer(new int[] { m - 1, j });
            atlantic[m - 1][j] = true;
        }

        // Vertical boundaries
        for (int i = 0; i < m; i++) {
            pQueue.offer(new int[] { i, 0 });
            pacific[i][0] = true;

            aQueue.offer(new int[] { i, n - 1 });
            atlantic[i][n - 1] = true;
        }

        bfs(heights, pQueue, pacific);
        bfs(heights, aQueue, atlantic);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void bfs(int[][] heights, Queue<int[]> queue, boolean[][] reachable) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : dirs) {
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !reachable[nr][nc]
                        && heights[nr][nc] >= heights[curr[0]][curr[1]]) {
                    reachable[nr][nc] = true;
                    queue.offer(new int[] { nr, nc });
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[][] heights1 = {
                { 1, 2, 2, 3, 5 },
                { 3, 2, 3, 4, 4 },
                { 2, 4, 5, 3, 1 },
                { 6, 7, 1, 4, 5 },
                { 5, 1, 1, 2, 4 }
        };
        System.out.println("Result 1: " + solution.pacificAtlantic(heights1));

        // Example 2
        int[][] heights2 = { { 1 } };
        System.out.println("Result 2: " + solution.pacificAtlantic(heights2));
    }
}
