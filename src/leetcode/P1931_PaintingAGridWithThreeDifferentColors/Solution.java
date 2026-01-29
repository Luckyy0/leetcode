package leetcode.P1931_PaintingAGridWithThreeDifferentColors;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final int MOD = 1_000_000_007;

    public int colorTheGrid(int m, int n) {
        List<Integer> validMasks = new ArrayList<>();
        generateMasks(0, m, -1, 0, validMasks);

        int numPatterns = validMasks.size();
        // adj[i] contains list of indices in validMasks that are compatible with
        // validMasks[i]
        List<Integer>[] adj = new ArrayList[numPatterns];
        for (int i = 0; i < numPatterns; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < numPatterns; i++) {
            for (int j = 0; j < numPatterns; j++) {
                if (isCompatible(validMasks.get(i), validMasks.get(j), m)) {
                    adj[i].add(j);
                }
            }
        }

        long[] dp = new long[numPatterns];
        // Initialize for first column: all valid patterns are possible (1 way)
        for (int i = 0; i < numPatterns; i++)
            dp[i] = 1;

        for (int col = 1; col < n; col++) {
            long[] nextDp = new long[numPatterns];
            for (int i = 0; i < numPatterns; i++) {
                if (dp[i] == 0)
                    continue;
                for (int neighbor : adj[i]) {
                    nextDp[neighbor] = (nextDp[neighbor] + dp[i]) % MOD;
                }
            }
            dp = nextDp;
        }

        long ans = 0;
        for (long val : dp)
            ans = (ans + val) % MOD;
        return (int) ans;
    }

    // Generate valid columns. Encode as base 3 integer for simplicity/hashing or
    // just store values
    // Actually storing as integer: val = c0 + 3*c1 + ...
    private void generateMasks(int row, int m, int prevColor, int currentMask, List<Integer> result) {
        if (row == m) {
            result.add(currentMask);
            return;
        }

        for (int color = 0; color < 3; color++) {
            if (color != prevColor) {
                // Base 4 used here to avoid confusing digits? Or base 3.
                // Base 4 easier to decode bitwise if needed, but simple integer math fine.
                // Let's use Base 4 for bit shifting: (mask << 2) | color

                // Wait, recursion order matters for encoding.
                // If I just pass the integer, I need consistent decode.
                // Let's use array list of colors logic internally?
                // Or just: currentMask | (color << (2 * row))
                generateMasks(row + 1, m, color, currentMask | (color << (2 * row)), result);
            }
        }
    }

    private boolean isCompatible(int mask1, int mask2, int m) {
        for (int i = 0; i < m; i++) {
            int c1 = (mask1 >> (2 * i)) & 3;
            int c2 = (mask2 >> (2 * i)) & 3;
            if (c1 == c2)
                return false;
        }
        return true;
    }
}
