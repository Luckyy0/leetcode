package leetcode.P939_MinimumAreaRectangle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] p : points) {
            map.computeIfAbsent(p[0], k -> new HashSet<>()).add(p[1]);
        }

        int minArea = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int[] p1 = points[i];
                int[] p2 = points[j];

                if (p1[0] == p2[0] || p1[1] == p2[1])
                    continue;

                // Potential diagonal p1 and p2. Check for p3(p1[0], p2[1]) and p4(p2[0], p1[1])
                if (map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])) {
                    minArea = Math.min(minArea, Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1]));
                }
            }
        }

        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }
}
