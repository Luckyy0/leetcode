package leetcode.P1902_DepthOfBSTGivenInsertionOrder;

import java.util.TreeMap;

public class Solution {
    public int maxDepthBST(int[] order) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        // Root depth is 1
        // Actually map empty logic.
        // Wait, map stores depths of EXISTING nodes.
        // First node: depth 1.

        int maxD = 0;

        // Add sentinels? No, just handle null.
        // Or cleaner: lowerKey returns null.

        for (int x : order) {
            Integer lower = map.lowerKey(x);
            Integer higher = map.higherKey(x);

            int dLower = (lower == null) ? 0 : map.get(lower);
            int dHigher = (higher == null) ? 0 : map.get(higher);

            int currentDepth = 1 + Math.max(dLower, dHigher);
            map.put(x, currentDepth);
            maxD = Math.max(maxD, currentDepth);
        }

        return maxD;
    }
}
