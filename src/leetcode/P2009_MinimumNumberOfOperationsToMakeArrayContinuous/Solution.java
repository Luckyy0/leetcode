package leetcode.P2009_MinimumNumberOfOperationsToMakeArrayContinuous;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        // Dedup and sort
        int[] uniq = IntStream.of(nums).distinct().sorted().toArray();

        int maxPreserved = 0;
        int m = uniq.length;
        int r = 0;

        for (int l = 0; l < m; l++) {
            // Find max r such that uniq[r] - uniq[l] <= n - 1
            while (r < m && uniq[r] - uniq[l] <= n - 1) {
                r++;
            }
            // Window is [l, r-1]. Size r - l.
            maxPreserved = Math.max(maxPreserved, r - l);
        }

        return n - maxPreserved;
    }
}
