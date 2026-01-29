package leetcode.P1983_WidestPairOfIndicesWithEqualRangeSum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int widestPairOfIndices(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Map<Integer, Integer> first = new HashMap<>();
        first.put(0, -1); // diff 0 at index -1 (before start)

        int diff = 0;
        int maxDist = 0;

        for (int i = 0; i < n; i++) {
            diff += nums1[i] - nums2[i];
            if (first.containsKey(diff)) {
                maxDist = Math.max(maxDist, i - first.get(diff));
            } else {
                first.put(diff, i);
            }
        }

        return maxDist;
    }
}
