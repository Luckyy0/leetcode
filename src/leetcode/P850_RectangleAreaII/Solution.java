package leetcode.P850_RectangleAreaII;

import java.util.*;

class Solution {
    public int rectangleArea(int[][] rectangles) {
        long mod = 1_000_000_007;
        Set<Integer> xCoords = new TreeSet<>();
        for (int[] r : rectangles) {
            xCoords.add(r[0]);
            xCoords.add(r[2]);
        }

        List<Integer> xList = new ArrayList<>(xCoords);
        long totalArea = 0;

        for (int i = 0; i < xList.size() - 1; i++) {
            int x1 = xList.get(i), x2 = xList.get(i + 1);
            if (x1 == x2)
                continue;

            List<int[]> yRanges = new ArrayList<>();
            for (int[] r : rectangles) {
                if (r[0] <= x1 && r[2] >= x2) {
                    yRanges.add(new int[] { r[1], r[3] });
                }
            }

            Collections.sort(yRanges, (a, b) -> a[0] - b[0]);
            long coveredY = 0;
            int lastY = -1;
            for (int[] y : yRanges) {
                int start = Math.max(y[0], lastY);
                int end = y[1];
                if (end > start) {
                    coveredY += (end - start);
                    lastY = end;
                }
            }

            totalArea = (totalArea + coveredY * (x2 - x1)) % mod;
        }

        return (int) totalArea;
    }
}
