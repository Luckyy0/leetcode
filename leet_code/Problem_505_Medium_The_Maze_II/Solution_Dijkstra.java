package leet_code.Problem_505_Medium_The_Maze_II;

import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;

public class Solution_Dijkstra {

    /**
     * Finds shortest distance to destination.
     * Strategy: Dijkstra's algorithm.
     * Time: O(MN log(MN)), Space: O(MN).
     */
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] distance = new int[m][n];

        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        distance[start[0]][start[1]] = 0;

        // PriorityQueue stores {row, col, dist}
        // Ordered by dist ascending
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[] { start[0], start[1], 0 });

        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int dist = curr[2];

            // Optimization: If we already found a shorter path to (r,c), skip
            // Note: In typical Dijkstra with 'visited', we skip.
            // But checking distance matrix is sufficient.
            if (dist > distance[r][c])
                continue;

            // If pop destination, return dist (Optimal property of Dijkstra)
            if (r == destination[0] && c == destination[1]) {
                return dist;
            }

            for (int[] d : dirs) {
                int nr = r;
                int nc = c;
                int step = 0;

                // Roll
                while (nr + d[0] >= 0 && nr + d[0] < m &&
                        nc + d[1] >= 0 && nc + d[1] < n &&
                        maze[nr + d[0]][nc + d[1]] == 0) {
                    nr += d[0];
                    nc += d[1];
                    step++;
                }

                if (distance[r][c] + step < distance[nr][nc]) {
                    distance[nr][nc] = distance[r][c] + step;
                    pq.offer(new int[] { nr, nc, distance[nr][nc] });
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution_Dijkstra solution = new Solution_Dijkstra();
        int[][] maze = {
                { 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 0 },
                { 1, 1, 0, 1, 1 },
                { 0, 0, 0, 0, 0 }
        };
        int[] start = { 0, 4 };
        int[] dest = { 4, 4 };
        System.out.println("Result: " + solution.shortestDistance(maze, start, dest)); // 12
    }
}
