package leetcode.P964_LeastOperatorsToExpressNumber;

import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<String, Integer> memo = new HashMap<>();
    int x;

    public int leastOpsExpressTarget(int x, int target) {
        this.x = x;
        return dfs(0, target) - 1;
    }

    private int dfs(int p, int target) {
        String key = p + ":" + target;
        if (memo.containsKey(key))
            return memo.get(key);

        int res;
        if (target == 0) {
            res = 0;
        } else if (target == 1) {
            res = (p == 0) ? 2 : p;
        } else if (p >= 30) { // Safety break
            res = target * 2;
        } else {
            int r = target % x;
            int q = target / x;

            // Two ways to handle remainder:
            // 1. Add r * x^p
            int res1 = r * (p == 0 ? 2 : p) + dfs(p + 1, q);
            // 2. Add (x - r) * x^p and increment the quotient
            int res2 = (x - r) * (p == 0 ? 2 : p) + dfs(p + 1, q + 1);

            res = Math.min(res1, res2);
        }

        memo.put(key, res);
        return res;
    }
}
