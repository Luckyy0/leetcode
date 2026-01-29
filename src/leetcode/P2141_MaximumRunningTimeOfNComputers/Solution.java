package leetcode.P2141_MaximumRunningTimeOfNComputers;

import java.util.Arrays;

public class Solution {
    public long maxRunTime(int n, int[] batteries) {
        Arrays.sort(batteries);
        long sum = 0;
        for (int b : batteries)
            sum += b;

        int m = batteries.length;
        // Iterate from largest battery
        for (int i = m - 1; i >= 0; i--) {
            // Check if this battery is larger than average
            // If so, it can power one computer indefinitely (relative to the bottleneck of
            // the rest)
            // So we dedicate it to one computer, and solve for n-1 computers with remaining
            // sum
            if (batteries[i] > sum / n) {
                sum -= batteries[i];
                n--;
            } else {
                // If the largest remaining battery is <= average,
                // then all remaining batteries can fully contribute their charge (min(b, T) ==
                // b).
                // Thus the max time is simply sum / n.
                return sum / n;
            }
        }
        return 0;
    }
}
