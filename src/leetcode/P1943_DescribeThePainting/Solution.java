package leetcode.P1943_DescribeThePainting;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        TreeMap<Integer, Long> changes = new TreeMap<>();

        for (int[] s : segments) {
            int start = s[0];
            int end = s[1];
            int color = s[2];

            changes.put(start, changes.getOrDefault(start, 0L) + color);
            changes.put(end, changes.getOrDefault(end, 0L) - color);
        }

        List<List<Long>> res = new ArrayList<>();
        long currentSum = 0;
        int prevPoint = -1;

        for (Map.Entry<Integer, Long> entry : changes.entrySet()) {
            int point = entry.getKey();
            long change = entry.getValue();

            if (prevPoint != -1 && currentSum > 0) {
                // Add segment
                List<Long> segment = new ArrayList<>();
                segment.add((long) prevPoint);
                segment.add((long) point);
                segment.add(currentSum);
                res.add(segment);
            }

            currentSum += change;
            prevPoint = point;
        }

        return res;
    }
}
