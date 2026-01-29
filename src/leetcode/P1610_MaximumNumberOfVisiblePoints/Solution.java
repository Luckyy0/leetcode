package leetcode.P1610_MaximumNumberOfVisiblePoints;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> angles = new ArrayList<>();
        int baseCount = 0;
        int posX = location.get(0);
        int posY = location.get(1);

        for (List<Integer> p : points) {
            int x = p.get(0);
            int y = p.get(1);

            if (x == posX && y == posY) {
                baseCount++;
                continue;
            }

            double ang = Math.toDegrees(Math.atan2(y - posY, x - posX));
            // Standardize to positive
            // atan2 returns -180 to 180.
            // Actually sliding window works fine with negative as long as sorted.
            // But let's map to [0, 360)? Or just sort naturally.
            // Let's keep natural sorting.
            angles.add(ang);
        }

        Collections.sort(angles);

        // Handle circularity: duplicated angles + 360
        // Original list size
        int n = angles.size();
        for (int i = 0; i < n; i++) {
            angles.add(angles.get(i) + 360);
        }

        int maxVisible = 0;
        int left = 0;

        for (int right = 0; right < angles.size(); right++) {
            while (angles.get(right) - angles.get(left) > angle) {
                left++;
            }
            maxVisible = Math.max(maxVisible, right - left + 1);
        }

        return maxVisible + baseCount;
    }
}
