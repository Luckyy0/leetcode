package leetcode.P1133_LargestUniqueNumber;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int largestUniqueNumber(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int x : nums) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        int max = -1;
        for (int x : count.keySet()) {
            if (count.get(x) == 1) {
                max = Math.max(max, x);
            }
        }
        return max;
    }
}
