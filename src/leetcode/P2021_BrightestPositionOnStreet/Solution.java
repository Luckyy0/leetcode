package leetcode.P2021_BrightestPositionOnStreet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int brightestPosition(int[][] lights) {
        List<int[]> events = new ArrayList<>();
        for (int[] light : lights) {
            int pos = light[0];
            int range = light[1];
            events.add(new int[] { pos - range, 1 });
            events.add(new int[] { pos + range + 1, -1 });
        }

        Collections.sort(events, (a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]); // Order doesn't matter for correctness if we process all same pos
                                                // together
        });

        int maxBrightness = 0;
        int maxPos = 0; // Initialize?
        if (!events.isEmpty())
            maxPos = events.get(0)[0];

        int currentBrightness = 0;

        for (int i = 0; i < events.size(); i++) {
            currentBrightness += events.get(i)[1];

            // Check if next event is at different position or we are at end
            if (i == events.size() - 1 || events.get(i + 1)[0] != events.get(i)[0]) {
                if (currentBrightness > maxBrightness) {
                    maxBrightness = currentBrightness;
                    maxPos = events.get(i)[0];
                }
            }
        }

        return maxPos;
    }
}
