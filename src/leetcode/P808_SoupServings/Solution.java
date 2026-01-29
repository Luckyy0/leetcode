package leetcode.P808_SoupServings;

import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<String, Double> memo = new HashMap<>();

    public double soupServings(int n) {
        if (n > 4800)
            return 1.0;
        int m = (n + 24) / 25;
        return solve(m, m);
    }

    private double solve(int a, int b) {
        if (a <= 0 && b <= 0)
            return 0.5;
        if (a <= 0)
            return 1.0;
        if (b <= 0)
            return 0.0;

        String key = a + "," + b;
        if (memo.containsKey(key))
            return memo.get(key);

        double prob = 0.25 * (solve(a - 4, b) + solve(a - 3, b - 1) +
                solve(a - 2, b - 2) + solve(a - 1, b - 3));

        memo.put(key, prob);
        return prob;
    }
}
