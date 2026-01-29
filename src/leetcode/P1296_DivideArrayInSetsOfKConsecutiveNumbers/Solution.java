package leetcode.P1296_DivideArrayInSetsOfKConsecutiveNumbers;

import java.util.Map;
import java.util.TreeMap;

class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0)
            return false;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int x : nums)
            map.put(x, map.getOrDefault(x, 0) + 1);

        for (int start : map.keySet()) {
            int count = map.get(start);
            if (count > 0) {
                // Try to form 'count' sequences starting at 'start'
                for (int i = 0; i < k; i++) {
                    int curr = start + i;
                    if (map.getOrDefault(curr, 0) < count)
                        return false;
                    map.put(curr, map.get(curr) - count);
                }
            }
        }

        return true;
    }
}
