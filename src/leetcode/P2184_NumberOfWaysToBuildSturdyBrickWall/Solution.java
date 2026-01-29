package leetcode.P2184_NumberOfWaysToBuildSturdyBrickWall;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int buildWall(int height, int width, int[] bricks) {
        List<Integer> masks = new ArrayList<>();
        // Generate all valid row configurations (masks of cuts)
        // DFS
        dfs(0, 0, width, bricks, masks);

        int n = masks.size();
        if (n == 0)
            return 0; // Can't build even one row

        List<List<Integer>> compatible = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            compatible.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                if ((masks.get(i) & masks.get(j)) == 0) {
                    compatible.get(i).add(j);
                }
            }
        }

        long[] dp = new long[n];
        // Base case: row 0 can be any mask
        for (int i = 0; i < n; i++)
            dp[i] = 1;

        int MOD = 1_000_000_007;

        for (int h = 1; h < height; h++) {
            long[] nextDp = new long[n];
            for (int i = 0; i < n; i++) {
                if (dp[i] == 0)
                    continue;
                for (int neighbor : compatible.get(i)) {
                    nextDp[neighbor] = (nextDp[neighbor] + dp[i]) % MOD;
                }
            }
            dp = nextDp;
        }

        long total = 0;
        for (long val : dp)
            total = (total + val) % MOD;
        return (int) total;
    }

    private void dfs(int currentLen, int currentMask, int width, int[] bricks, List<Integer> masks) {
        if (currentLen == width) {
            masks.add(currentMask);
            return;
        }

        for (int b : bricks) {
            if (currentLen + b <= width) {
                int nextMask = currentMask;
                if (currentLen + b < width) {
                    nextMask |= (1 << (currentLen + b));
                }
                dfs(currentLen + b, nextMask, width, bricks, masks);
            }
        }
    }
}
