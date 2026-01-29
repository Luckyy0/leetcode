package leetcode.P490_TheMaze;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    /**
     * Problem 490: The Maze
     * Approach: BFS with Rolling Logic
     * 
     * Time Complexity: O(M * N)
     * Space Complexity: O(M * N)
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;

        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (curr[0] == destination[0] && curr[1] == destination[1])
                return true;

            for (int[] d : dirs) {
                int r = curr[0] + d[0];
                int c = curr[1] + d[1];

                // Roll until hitting wall or boundary
                while (r >= 0 && r < m && c >= 0 && c < n && maze[r][c] == 0) {
                    r += d[0];
                    c += d[1];
                }

                // Stop at last valid cell
                int nr = r - d[0];
                int nc = c - d[1];

                if (!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new int[] { nr, nc });
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], [0,4],
        // [4,4] -> true
        int[][] maze = {
                { 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 0 },
                { 1, 1, 0, 1, 1 },
                { 0, 0, 0, 0, 0 }
        };
        int[] start = { 0, 4 };
        int[] dest = { 4, 4 };
        System.out.println("Result: " + sol.hasPath(maze, start, dest) + " (Expected: true)");
    }
}
