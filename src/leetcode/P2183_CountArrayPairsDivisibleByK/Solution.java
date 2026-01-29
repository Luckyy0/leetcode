package leetcode.P2183_CountArrayPairsDivisibleByK;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public long countPairs(int[] nums, int k) {
        Map<Integer, Integer> gcdCounts = new HashMap<>();
        for (int x : nums) {
            int g = gcd(x, k);
            gcdCounts.put(g, gcdCounts.getOrDefault(g, 0) + 1);
        }

        long ans = 0;
        for (int g1 : gcdCounts.keySet()) {
            for (int g2 : gcdCounts.keySet()) {
                if (g1 > g2)
                    continue; // Avoid double counting, handled by == and < logic

                if (((long) g1 * g2) % k == 0) {
                    long c1 = gcdCounts.get(g1);
                    long c2 = gcdCounts.get(g2);

                    if (g1 == g2) {
                        ans += c1 * (c1 - 1) / 2;
                    } else {
                        ans += c1 * c2;
                    }
                }
            }
        }

        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
