package leetcode.P1349_MaximumStudentsTakingExam;

import java.util.Arrays;

class Solution {
    public int maxStudents(char[][] seats) {
        int m = seats.length;
        int n = seats[0].length;

        int[][] dp = new int[m + 1][1 << n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        dp[0][0] = 0; // Base case: row -1 (virtual) has limit 0 students with mask 0

        for (int i = 1; i <= m; i++) {
            int rowIdx = i - 1;
            // Iterate all masks for current row
            for (int mask = 0; mask < (1 << n); mask++) {
                // Check internal conflicts and broken seats
                if (!isValid(mask, seats[rowIdx], n))
                    continue;

                // Try to pair with prev mask
                for (int prev = 0; prev < (1 << n); prev++) {
                    if (dp[i - 1][prev] == -1)
                        continue;

                    if (isCompatible(mask, prev, n)) {
                        dp[i][mask] = Math.max(dp[i][mask], dp[i - 1][prev] + Integer.bitCount(mask));
                    }
                }
            }
        }

        int max = 0;
        for (int x : dp[m])
            max = Math.max(max, x);
        return max;
    }

    private boolean isValid(int mask, char[] row, int n) {
        // Check adjacent
        if ((mask & (mask >> 1)) != 0)
            return false;
        if ((mask & (mask << 1)) != 0)
            return false;

        // Check broken seats
        for (int j = 0; j < n; j++) {
            if (((mask >> j) & 1) == 1 && row[n - 1 - j] == '#')
                return false;
            // Wait, bitmask convention.
            // Let's say bit 0 is column n-1, bit n-1 is column 0.
            // row[0] corresponds to mask & (1<<(n-1)) ?
            // Let's use simpler: j-th bit is j-th column from right (0..n-1).
            // col 0 is index 0 in array. Corresponds to bit 0? Or bit n-1?
            // Let's assume bit j corresponds to col j.
            // Then adjacent check: (mask >> 1) & mask. Correct.
            // Broken seats check:
            // if ((mask >> j) & 1) == 1 => student at col j.
            // if seats[row][j] == '#' return false.
        }

        for (int j = 0; j < n; j++) {
            if (((mask >> j) & 1) == 1 && row[j] == '#')
                return false;
        }
        return true;
    }

    private boolean isCompatible(int curr, int prev, int n) {
        // Check upper-left: student at j in curr, student at j-1 in prev
        // bit j in curr vs bit j-1 in prev
        // (curr >> 1) & prev checks if curr has j and prev has j-1 (student at j has
        // upper-left neighbor?)
        // Wait: upper-left of (row, j) is (row-1, j-1).
        // If curr has bit j, prev CANNOT have bit j-1.
        if ((curr & (prev >> 1)) != 0)
            return false; // Checks curr(j) & prev(j+1)? No.
        // Let's trace carefully.
        // Upper-Left of col j is col j-1.
        // So if curr has j, prev cannot have j-1.
        // curr & (prev << 1)?
        // If prev has bit j-1 (value 1<<(j-1)). (prev << 1) has bit j.
        // So (curr & (prev << 1)) checks exactly this.

        // Upper-Right of col j is col j+1.
        // If curr has j, prev cannot have j+1.
        // curr & (prev >> 1).

        if ((curr & (prev << 1)) != 0)
            return false;
        if ((curr & (prev >> 1)) != 0)
            return false;

        return true;
    }
}
