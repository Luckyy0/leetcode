package leetcode.P2197_ReplaceNonCoprimeNumbersInArray;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int x : nums) {
            while (!res.isEmpty()) {
                int prev = res.get(res.size() - 1);
                int g = gcd(prev, x);
                if (g > 1) {
                    res.remove(res.size() - 1);
                    // LCM = (a * b) / gcd
                    // Use long to prevent overflow during multiply
                    long lcm = ((long) prev * x) / g;
                    x = (int) lcm; // Problem implies LCM fits in int? Or inputs are such.
                } else {
                    break;
                }
            }
            res.add(x);
        }
        return res;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
