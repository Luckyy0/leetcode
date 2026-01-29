package leetcode.P499_TheMazeIII;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    private static class Node implements Comparable<Node> {
        int r, c, dist;
        String path;

        Node(int r, int c, int dist, String path) {
            this.r = r;
            this.c = c;
            this.dist = dist;
            this.path = path;
        }

        @Override
        public int compareTo(Node o) {
            if (this.dist != o.dist)
                return Integer.compare(this.dist, o.dist);
            return this.path.compareTo(o.path);
        }
    }

    /**
     * Problem 499: The Maze III
     * Approach: Dijkstra with Lexicographical tie-breaking
     */
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] dist = new int[m][n];
        String[][] paths = new String[m][n];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(ball[0], ball[1], 0, ""));
        dist[ball[0]][ball[1]] = 0;
        paths[ball[0]][ball[1]] = "";

        int[][] dirs = { { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, 0 } };
        char[] dirChars = { 'd', 'l', 'r', 'u' };

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            // If already found a better path to this stop point, skip
            if (curr.dist > dist[curr.r][curr.c])
                continue;
            if (paths[curr.r][curr.c] != null && curr.dist == dist[curr.r][curr.c]
                    && curr.path.compareTo(paths[curr.r][curr.c]) > 0)
                continue;

            if (curr.r == hole[0] && curr.c == hole[1])
                return curr.path;

            for (int i = 0; i < 4; i++) {
                int nr = curr.r;
                int nc = curr.c;
                int d = 0;

                while (nr + dirs[i][0] >= 0 && nr + dirs[i][0] < m &&
                        nc + dirs[i][1] >= 0 && nc + dirs[i][1] < n &&
                        maze[nr + dirs[i][0]][nc + dirs[i][1]] == 0) {
                    nr += dirs[i][0];
                    nc += dirs[i][1];
                    d++;
                    if (nr == hole[0] && nc == hole[1])
                        break;
                }

                if (d == 0)
                    continue; // Didn't move

                int totalDist = curr.dist + d;
                String totalPath = curr.path + dirChars[i];

                if (dist[nr][nc] > totalDist || (dist[nr][nc] == totalDist
                        && (paths[nr][nc] == null || totalPath.compareTo(paths[nr][nc]) < 0))) {
                    dist[nr][nc] = totalDist;
                    paths[nr][nc] = totalPath;
                    pq.offer(new Node(nr, nc, totalDist, totalPath));
                }
            }
        }

        return "impossible";
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Sample test case
        int[][] maze = {
                { 0, 0, 0, 0, 0 },
                { 1, 1, 0, 0, 1 },
                { 0, 0, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 0, 1, 1, 0, 0 }
        };
        int[] ball = { 4, 3 };
        int[] hole = { 0, 1 };
        // Expected: "lul"
        System.out.println("Result: " + sol.findShortestWay(maze, ball, hole));
    }
}
