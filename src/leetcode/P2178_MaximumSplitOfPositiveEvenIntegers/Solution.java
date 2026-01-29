package leetcode.P2178_MaximumSplitOfPositiveEvenIntegers;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        if (finalSum % 2 != 0)
            return new ArrayList<>();

        List<Long> res = new ArrayList<>();
        long curr = 2;
        long remaining = finalSum;

        while (remaining >= curr) {
            res.add(curr);
            remaining -= curr;
            curr += 2;
        }

        // Add remainder to the last element (if any remainder left)
        // If remaining is 0, logic does nothing (correct).
        // If remaining > 0 (e.g., remaining < curr), we can't add 'curr'.
        // We add 'remaining' to the last added element (which was 'curr-2').
        // New last = (curr-2) + remaining.
        // Is it distinct from (curr-4)? Yes.

        if (remaining > 0) {
            int lastIdx = res.size() - 1;
            res.set(lastIdx, res.get(lastIdx) + remaining);
        }

        return res;
    }
}
