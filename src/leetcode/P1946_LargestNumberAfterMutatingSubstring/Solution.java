package leetcode.P1946_LargestNumberAfterMutatingSubstring;

public class Solution {
    public String maximumNumber(String num, int[] change) {
        char[] chars = num.toCharArray();
        int n = chars.length;
        boolean started = false;

        for (int i = 0; i < n; i++) {
            int d = chars[i] - '0';
            if (change[d] > d) {
                chars[i] = (char) (change[d] + '0');
                started = true;
            } else if (change[d] == d) {
                // Keep changing if started (no-op but maintains continuity)
                // If not started, don't start here?
                // Actually constraint: "mutate a substring".
                // If we iterate digits 3 -> 3 -> 4(>3) -> ...
                // If we haven't started mutating (haven't found >), then = doesn't technically
                // force start?
                // But maximizing means we want to find the first INCREASING sequence.
                // 3 -> 3 -> 4...
                // If we mutate index 0 (3->3), then index 1 (3->3), then index 2 (4->9).
                // It is better than waiting.
                // Wait. Substring. We want to apply mutation to give MAX number.
                // Mutation of 'd' to 'd' doesn't increase value.
                // So we should only start when we strictly increase.
                // BUT if we started, we should continue over equalities to reach potential
                // increases or just to extend?
                // Actually, stopping at equality doesn't hurt value, but stopping might prevent
                // reaching a later increase within "single substring".
                // However, if we stop, we can't restart.
                // So if started, continue on >=.
                // If not started, only start on >.
                if (started) {
                    chars[i] = (char) (change[d] + '0');
                }
            } else {
                // change[d] < d
                if (started)
                    break;
            }
        }

        return new String(chars);
    }
}
