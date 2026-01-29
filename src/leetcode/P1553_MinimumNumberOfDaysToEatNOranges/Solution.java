package leetcode.P1553_MinimumNumberOfDaysToEatNOranges;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<Integer, Integer> memo = new HashMap<>();

    public int minDays(int n) {
        if (n <= 1) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        // Option 1: Reach a multiple of 2 by subtracting 1s (n%2 operations), then
        // divide by 2.
        // Total days: (n % 2) + 1 + minDays(n / 2)

        // Option 2: Reach a multiple of 3 by subtracting 1s (n%3 operations), then
        // divide by 3.
        // Total days: (n % 3) + 1 + minDays(n / 3)

        int res = Math.min(
                n % 2 + 1 + minDays(n / 2),
                n % 3 + 1 + minDays(n / 3));

        memo.put(n, res);
        return res;
    }
}
