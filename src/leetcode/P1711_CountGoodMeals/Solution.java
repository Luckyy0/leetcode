package leetcode.P1711_CountGoodMeals;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int countPairs(int[] deliciousness) {
        int MOD = 1_000_000_007;
        Map<Integer, Integer> map = new HashMap<>();
        long count = 0;

        for (int num : deliciousness) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Powers of 2 from 2^0 to 2^21 (since max num is 2^20)
        int[] powers = new int[22];
        for (int i = 0; i <= 21; i++)
            powers[i] = 1 << i;

        for (int val : map.keySet()) {
            long freq = map.get(val);
            for (int p : powers) {
                int target = p - val;
                if (map.containsKey(target)) {
                    if (target == val) {
                        count += freq * (freq - 1);
                    } else {
                        count += freq * map.get(target);
                    }
                }
            }
        }

        // Each pair counted twice (a,b) and (b,a). Divide by 2.
        return (int) ((count / 2) % MOD);
    }
}
