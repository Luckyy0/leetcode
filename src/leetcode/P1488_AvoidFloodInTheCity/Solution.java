package leetcode.P1488_AvoidFloodInTheCity;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Map<Integer, Integer> fullLakes = new HashMap<>(); // lakeId -> day filled
        TreeSet<Integer> dryDays = new TreeSet<>(); // indices of zero rains

        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                dryDays.add(i);
                ans[i] = 1; // Default
            } else {
                int lake = rains[i];
                if (fullLakes.containsKey(lake)) {
                    // Need to dry this lake before today but after last fill
                    Integer dryDay = dryDays.higher(fullLakes.get(lake));
                    if (dryDay == null) {
                        return new int[0];
                    }
                    ans[dryDay] = lake;
                    dryDays.remove(dryDay);
                }
                fullLakes.put(lake, i);
                ans[i] = -1;
            }
        }

        return ans;
    }
}
