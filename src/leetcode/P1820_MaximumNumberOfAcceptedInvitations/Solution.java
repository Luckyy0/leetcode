package leetcode.P1820_MaximumNumberOfAcceptedInvitations;

import java.util.Arrays;

public class Solution {
    private int[] match;
    private boolean[] visited;

    public int maximumInvitations(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        match = new int[n];
        Arrays.fill(match, -1);

        int count = 0;
        for (int i = 0; i < m; i++) {
            visited = new boolean[n];
            if (dfs(i, grid)) {
                count++;
            }
        }
        return count;
    }

    private boolean dfs(int u, int[][] grid) {
        int n = grid[0].length;
        for (int v = 0; v < n; v++) {
            if (grid[u][v] == 1 && !visited[v]) {
                visited[v] = true;
                if (match[v] == -1 || dfs(match[v], grid)) {
                    match[v] = u;
                    return true;
                }
            }
        }
        return false;
    }
}
