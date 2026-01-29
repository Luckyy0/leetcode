package leetcode.P505_TheMazeII;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    /**
     * Problem 505: The Maze II
     * Approach: Dijkstra's Algorithm
     * 
     * Time Complexity: O(MN log(MN))
     * Space Complexity: O(MN)
     */
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] dists = new int[m][n];
        for (int[] row : dists)
            Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.offer(new int[] { start[0], start[1], 0 });
        dists[start[0]][start[1]] = 0;

        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (curr[2] > dists[curr[0]][curr[1]])
                continue;

            for (int[] d : dirs) {
                int r = curr[0] + d[0];
                int c = curr[1] + d[1];
                int count = 0;

                while (r >= 0 && r < m && c >= 0 && c < n && maze[r][c] == 0) {
                    r += d[0];
                    c += d[1];
                    count++;
                }

                int nr = r - d[0];
                int nc = c - d[1];

                if (dists[curr[0]][curr[1]] + count < dists[nr][nc]) {
                    dists[nr][nc] = dists[curr[0]][curr[1]] + count;
                    pq.offer(new int[] { nr, nc, dists[nr][nc] });
                }
            }
        }

        return dists[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dists[destination[0]][destination[1]];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start =
        // [0,4], dest = [4,4]
        int[][] maze = {
                { 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 0 },
                { 1, 1, 0, 1, 1 },
                { 0, 0, 0, 0, 0 }
        };
        int[] start = { 0, 4 };
        int[] dest = { 4, 4 };
        System.out.println("Result: " + sol.shortestDistance(maze, start, dest) + " (Expected: 12)");
    }
}
