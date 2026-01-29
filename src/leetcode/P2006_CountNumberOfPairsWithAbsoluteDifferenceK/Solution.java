package leetcode.P2006_CountNumberOfPairsWithAbsoluteDifferenceK;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int x : nums) {
            count += map.getOrDefault(x - k, 0);
            count += map.getOrDefault(x + k, 0);
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        return count;
    }
}
