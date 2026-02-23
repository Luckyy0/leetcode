package leet_code.Problem_490_Medium_The_Maze;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_BFS {

    /**
     * Determines if ball can stop at destination.
     * Strategy: BFS on stopping points.
     * Time: O(M * N), Space: O(M * N).
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;

        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            if (r == destination[0] && c == destination[1]) {
                return true;
            }

            for (int[] d : dirs) {
                int nr = r;
                int nc = c;

                // Roll untill hitting a wall
                while (nr + d[0] >= 0 && nr + d[0] < m &&
                        nc + d[1] >= 0 && nc + d[1] < n &&
                        maze[nr + d[0]][nc + d[1]] == 0) {
                    nr += d[0];
                    nc += d[1];
                }

                // nr, nc is the stopping point
                if (!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    // Note: Check destination here optimization?
                    // Can check here or at poll time. Checking at poll is cleaner for start==dest
                    // edge case.
                    // But typically efficient to check before pushing.
                    // However, we stick to generic BFS structure: check at poll or check before
                    // push.
                    // Let's check at poll to handle start==dest naturally if not handled.
                    // But wait, if dest is never a stopping point, we return false correctly.

                    queue.offer(new int[] { nr, nc });
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution_BFS solution = new Solution_BFS();
        int[][] maze = {
                { 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 0 },
                { 1, 1, 0, 1, 1 },
                { 0, 0, 0, 0, 0 }
        };
        int[] start = { 0, 4 };
        int[] dest = { 4, 4 };
        System.out.println("Result 1: " + solution.hasPath(maze, start, dest)); // true

        int[] dest2 = { 3, 2 };
        System.out.println("Result 2: " + solution.hasPath(maze, start, dest2)); // false
    }
}
