package leetcode.P1659_MaximizeGridHappiness;

public class Solution {
    private int m, n;
    private int[][][][] memo;
    private int[] pow3;

    // Happiness constants
    private static final int H_INTRO = 120;
    private static final int H_EXTRO = 40;

    // Interaction costs [curr][neighbor]
    // 0: Empty, 1: Intro, 2: Extro
    // Adjustment to TOTAL score when 'curr' is placed next to 'neighbor'
    // This value accounts for changes to both agents.
    private int[][] diffs = {
            { 0, 0, 0 },
            { 0, -60, -10 }, // Intro next to Intro (-30*2), Intro next to Extro (-30+20 = -10)
            { 0, -10, 40 } // Extro next to Intro (+20-30 = -10), Extro next to Extro (+20*2 = 40)
    };

    public int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {
        this.m = m;
        this.n = n;
        this.memo = new int[m * n][introvertsCount + 1][extrovertsCount + 1][(int) Math.pow(3, n)];

        pow3 = new int[n + 1];
        pow3[0] = 1;
        for (int i = 1; i <= n; i++)
            pow3[i] = pow3[i - 1] * 3;

        // Initialize memo with -1 (not 0, as 0 is valid score)
        // Wait, standard Java array is 0. But score > 0.
        // We can just check for existence? Or fill -1.
        for (int[][][] d1 : memo)
            for (int[][] d2 : d1)
                for (int[] d3 : d2)
                    java.util.Arrays.fill(d3, -1);

        return dfs(0, introvertsCount, extrovertsCount, 0);
    }

    private int dfs(int idx, int intro, int extro, int mask) {
        if (idx == m * n)
            return 0;

        if (memo[idx][intro][extro][mask] != -1) {
            return memo[idx][intro][extro][mask];
        }

        int r = idx / n;
        int c = idx % n;

        // Decode neighbors from mask
        // Mask stores last n cells. LSB is left neighbor? MSB is Up neighbor?
        // Mask: [Up, ..., Left]
        // Left is at mask % 3
        // Up is at mask / 3^(n-1)

        int up = mask / pow3[n - 1];
        int left = mask % 3;

        // However, standard profile DP often pushes new val to LSB and shifts up?
        // Let's assume Mask = (val_{idx-n} ... val_{idx-1}) in base 3 representation?
        // Actually simplest is: newMask = (mask % pow3[n-1]) * 3 + newVal.
        // This means the oldest value (Up) is discarded from MSB.
        // And 'left neighbor' (which is the most recently added value) is now shifted?
        // Wait, if we 'push' to LSB, LSB has the neighbor at `idx-1`. Correct.
        // Then `up` neighbor (at `idx-n`) would be at `mask / pow3[n-1]`. Correct.

        int nextMaskBase = (mask % pow3[n - 1]) * 3;

        int res = -1;

        // Option 1: Empty
        res = Math.max(res, dfs(idx + 1, intro, extro, nextMaskBase + 0));

        // Option 2: Intro
        if (intro > 0) {
            int score = H_INTRO;
            if (c > 0)
                score += diffs[1][left]; // Interaction with Left
            if (r > 0)
                score += diffs[1][up]; // Interaction with Up
            res = Math.max(res, score + dfs(idx + 1, intro - 1, extro, nextMaskBase + 1));
        }

        // Option 3: Extro
        if (extro > 0) {
            int score = H_EXTRO;
            if (c > 0)
                score += diffs[2][left];
            if (r > 0)
                score += diffs[2][up];
            res = Math.max(res, score + dfs(idx + 1, intro, extro - 1, nextMaskBase + 2));
        }

        return memo[idx][intro][extro][mask] = res;
    }
}
