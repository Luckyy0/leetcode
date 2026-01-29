package leetcode.P1751_MaximumNumberOfEventsThatCanBeAttendedII;

import java.util.Arrays;

public class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n = events.length;
        int[][] memo = new int[n][k + 1];
        for (int[] row : memo)
            Arrays.fill(row, -1);

        return solve(events, 0, k, memo);
    }

    private int solve(int[][] events, int idx, int k, int[][] memo) {
        if (idx >= events.length || k == 0)
            return 0;
        if (memo[idx][k] != -1)
            return memo[idx][k];

        // Option 1: Skip
        int res = solve(events, idx + 1, k, memo);

        // Option 2: Take
        int nextIdx = findNext(events, idx + 1, events[idx][1]);
        res = Math.max(res, events[idx][2] + solve(events, nextIdx, k - 1, memo));

        return memo[idx][k] = res;
    }

    private int findNext(int[][] events, int low, int targetEnd) {
        int high = events.length - 1;
        int ans = events.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (events[mid][0] > targetEnd) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
