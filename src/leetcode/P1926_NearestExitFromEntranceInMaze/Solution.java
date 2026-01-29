package leetcode.P1926_NearestExitFromEntranceInMaze;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        
        Queue(int[]) q = new LinkedList<>();
        q.offer(new int[]{entrance[0], entrance[1], 0});
        maze[entrance[0]][entrance[1]] = '+'; // Mark visited
        
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int dist = curr[2];
            
            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && maze[nr][nc] == '.') {
                    // Check if exit
                    if (nr == 0 || nr == m - 1 || nc == 0 || nc == n - 1) {
                        return dist + 1;
                    }
                    
                    maze[nr][nc] = '+'; // Mark visited
                    q.offer(new int[]{nr, nc, dist + 1});
                }
            }
        }
        
        return -1;
    }
}
