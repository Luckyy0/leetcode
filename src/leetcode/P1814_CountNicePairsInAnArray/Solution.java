package leetcode.P1814_CountNicePairsInAnArray;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int countNicePairs(int[] nums) {
        int MOD = 1_000_000_007;
        Map<Integer, Integer> freq = new HashMap<>();
        long count = 0;

        for (int x : nums) {
            int val = x - rev(x);
            int k = freq.getOrDefault(val, 0);
            count = (count + k) % MOD;
            freq.put(val, k + 1);
        }

        return (int) count;
    }

    private int rev(int num) {
        int r = 0;
        while (num > 0) {
            r = r * 10 + num % 10;
            num /= 10;
        }
        return r;
    }
}
