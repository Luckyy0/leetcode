package leetcode.P1058_MinimizeRoundingErrorToMeetTarget;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String minimizeError(String[] prices, int target) {
        double floorSum = 0;
        List<Double> diffs = new ArrayList<>();

        for (String p : prices) {
            double val = Double.parseDouble(p);
            double floor = Math.floor(val);
            double ceil = Math.ceil(val);

            floorSum += floor;
            if (floor != ceil) {
                // Cost to ceil vs Cost to floor
                // diff = (1 - frac) - frac = 1 - 2*frac?
                // Actually we just sort by frac desc.
                // We need to pick k items to ceil.
                // Error total = Sum(frac for floors) + Sum(1-frac for ceils)
                // Base error = Sum(frac).
                // If we flip one from floor to ceil: error changes by (1-frac) - frac = 1 -
                // 2*frac.
                // We want smallest change. So smallest 1-2*frac => largest frac.
                diffs.add(val - floor);
            }
        }

        int k = target - (int) floorSum;
        if (k < 0 || k > diffs.size())
            return "-1";

        double error = 0;
        // Base error (all floors for items with non-zero frac)
        for (double d : diffs)
            error += d;

        // We need to switch k items to ceil.
        // Switching reduces error by (d) and adds (1-d). Net change: 1 - 2d.
        // We pick largest d to minimize net addition (or maximize reduction).
        Collections.sort(diffs, Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            error += (1.0 - diffs.get(i)) - diffs.get(i);
        }

        return String.format("%.3f", error);
    }
}
