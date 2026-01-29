package leetcode.P1394_FindLuckyIntegerInAnArray;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int x : arr)
            count.put(x, count.getOrDefault(x, 0) + 1);

        int result = -1;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getKey().equals(entry.getValue())) {
                result = Math.max(result, entry.getKey());
            }
        }

        return result;
    }
}
