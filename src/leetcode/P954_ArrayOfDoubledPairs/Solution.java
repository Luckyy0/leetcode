package leetcode.P954_ArrayOfDoubledPairs;

import java.util.*;

class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> count = new TreeMap<>();
        for (int x : arr)
            count.put(x, count.getOrDefault(x, 0) + 1);

        List<Integer> keys = new ArrayList<>(count.keySet());
        Collections.sort(keys, Comparator.comparingInt(Math::abs));

        for (int x : keys) {
            if (count.get(x) > count.getOrDefault(2 * x, 0))
                return false;
            count.put(2 * x, count.get(2 * x) - count.get(x));
        }

        return true;
    }
}
// Note: Use absolute value sorting to handle negative numbers correctly.
// (e.g. -2 should pair with -4, but -2 > -4).
