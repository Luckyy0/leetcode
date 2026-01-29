package leetcode.P2145_CountTheHiddenSequences;

public class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long current = 0;
        long minVal = 0;
        long maxVal = 0;

        for (int d : differences) {
            current += d;
            minVal = Math.min(minVal, current);
            maxVal = Math.max(maxVal, current);
        }

        // Range of values relative to start x is [minVal, maxVal].
        // Length of span: maxVal - minVal.
        // We fit this span into [lower, upper].
        // Available space: (upper - lower).
        // If span > space, impossible.
        // Else count = space - span + 1.

        long span = maxVal - minVal;
        long space = upper - lower;

        if (span > space)
            return 0;
        return (int) (space - span + 1);
    }
}
