package leetcode.P2015_AverageHeightOfBuildingsInEachSegment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public int[][] averageHeightOfBuildings(int[][] buildings) {
        TreeMap<Integer, long[]> events = new TreeMap<>();
        // Key: coordinate, Value: {heightSumDelta, countDelta} using long for sum

        for (int[] b : buildings) {
            int start = b[0];
            int end = b[1];
            int h = b[2];

            long[] evStart = events.computeIfAbsent(start, k -> new long[2]);
            evStart[0] += h;
            evStart[1] += 1;

            long[] evEnd = events.computeIfAbsent(end, k -> new long[2]);
            evEnd[0] -= h;
            evEnd[1] -= 1;
        }

        List<int[]> res = new ArrayList<>();
        long currentSum = 0;
        long currentCount = 0;
        Integer prevPos = null;

        for (Map.Entry<Integer, long[]> entry : events.entrySet()) {
            int currPos = entry.getKey();
            long[] delta = entry.getValue();

            if (prevPos != null && currentCount > 0) {
                int avg = (int) (currentSum / currentCount);
                if (!res.isEmpty() && res.get(res.size() - 1)[1] == prevPos && res.get(res.size() - 1)[2] == avg) {
                    // Merge
                    res.get(res.size() - 1)[1] = currPos;
                } else {
                    res.add(new int[] { prevPos, currPos, avg });
                }
            }

            currentSum += delta[0];
            currentCount += delta[1];
            prevPos = currPos;
        }

        return res.toArray(new int[res.size()][]);
    }
}
