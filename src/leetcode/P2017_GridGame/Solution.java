package leetcode.P2017_GridGame;

public class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[] top = new long[n];
        long[] bottom = new long[n];

        for (int x : grid[0])
            top[0] += x; // Wait, careful logic. Need suffix for top.
        // Actually simple:
        long topSum = 0;
        for (int x : grid[0])
            topSum += x;

        long bottomSum = 0; // Accumulated prefix for bottom

        long minR2 = Long.MAX_VALUE;
        long currentTopPrefix = 0; // Not needed, we need suffix

        for (int i = 0; i < n; i++) {
            topSum -= grid[0][i]; // Now topSum is suffix from i+1 to N-1
            long r2Option1 = topSum;
            long r2Option2 = bottomSum;

            long r2Score = Math.max(r2Option1, r2Option2);
            minR2 = Math.min(minR2, r2Score);

            bottomSum += grid[1][i];
        }

        return minR2;
    }
}
