package leetcode.P1124_LongestWellPerformingInterval;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestWPI(int[] hours) {
        int res = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>(); // First occurrence of sum

        for (int i = 0; i < hours.length; i++) {
            sum += (hours[i] > 8) ? 1 : -1;

            if (sum > 0) {
                res = i + 1;
            } else {
                map.putIfAbsent(sum, i);
                if (map.containsKey(sum - 1)) {
                    res = Math.max(res, i - map.get(sum - 1));
                }
            }
        }

        return res;
    }
}
