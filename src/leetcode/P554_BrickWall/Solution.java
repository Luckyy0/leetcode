package leetcode.P554_BrickWall;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> gapCounts = new HashMap<>();
        int maxGaps = 0;

        for (List<Integer> row : wall) {
            int currentWidth = 0;
            // Iterate all bricks except the last one (total width edge doesn't count)
            // Lặp qua tất cả các viên gạch ngoại trừ viên cuối cùng
            for (int i = 0; i < row.size() - 1; i++) {
                currentWidth += row.get(i);
                int count = gapCounts.getOrDefault(currentWidth, 0) + 1;
                gapCounts.put(currentWidth, count);
                maxGaps = Math.max(maxGaps, count);
            }
        }

        return wall.size() - maxGaps;
    }
}
