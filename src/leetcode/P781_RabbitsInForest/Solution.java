package leetcode.P781_RabbitsInForest;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : answers)
            map.put(x, map.getOrDefault(x, 0) + 1);

        int res = 0;
        for (int x : map.keySet()) {
            int count = map.get(x);
            int groupSize = x + 1;
            // Number of groups = (count + groupSize - 1) / groupSize
            int numGroups = (count + x) / groupSize;
            res += numGroups * groupSize;
        }
        return res;
    }
}
