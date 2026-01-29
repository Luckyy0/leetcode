package leetcode.P963_MinimumAreaRectangleII;

import java.util.*;

class Solution {
    public double minAreaFreeRect(int[][] points) {
        int n = points.length;
        Map<String, List<int[]>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long dx = points[i][0] - points[j][0];
                long dy = points[i][1] - points[j][1];
                long distSq = dx * dx + dy * dy;
                double centerX = (points[i][0] + points[j][0]) / 2.0;
                double centerY = (points[i][1] + points[j][1]) / 2.0;
                String key = distSq + ":" + centerX + ":" + centerY;
                map.computeIfAbsent(key, k -> new ArrayList<>()).add(new int[] { i, j });
            }
        }

        double minArea = Double.MAX_VALUE;
        for (List<int[]> diagList : map.values()) {
            if (diagList.size() < 2)
                continue;
            for (int i = 0; i < diagList.size(); i++) {
                for (int j = i + 1; j < diagList.size(); j++) {
                    int p1Idx = diagList.get(i)[0];
                    int p2Idx = diagList.get(i)[1]; // p1-p2 is one diagonal
                    int p3Idx = diagList.get(j)[0]; // p3 is a corner

                    double d13Sq = Math.pow(points[p1Idx][0] - points[p3Idx][0], 2) +
                            Math.pow(points[p1Idx][1] - points[p3Idx][1], 2);
                    double d23Sq = Math.pow(points[p2Idx][0] - points[p3Idx][0], 2) +
                            Math.pow(points[p2Idx][1] - points[p3Idx][1], 2);
                    minArea = Math.min(minArea, Math.sqrt(d13Sq) * Math.sqrt(d23Sq));
                }
            }
        }

        return minArea == Double.MAX_VALUE ? 0 : minArea;
    }
}
