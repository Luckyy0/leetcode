package leetcode.P1387_SortIntegersByThePowerValue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<Integer, Integer> memo = new HashMap<>();

    public int getKth(int lo, int hi, int k) {
        Integer[] arr = new Integer[hi - lo + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = lo + i;
        }

        Arrays.sort(arr, (a, b) -> {
            int pa = getPower(a);
            int pb = getPower(b);
            if (pa != pb)
                return pa - pb;
            return a - b;
        });

        return arr[k - 1];
    }

    private int getPower(int x) {
        if (x == 1)
            return 0;
        if (memo.containsKey(x))
            return memo.get(x);

        int res;
        if (x % 2 == 0) {
            res = 1 + getPower(x / 2);
        } else {
            res = 1 + getPower(3 * x + 1);
        }

        memo.put(x, res);
        return res;
    }
}
