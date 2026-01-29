package leetcode.P989_AddToArrayFormOfInteger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>();
        int i = num.length - 1;
        int cur = k;

        while (i >= 0 || cur > 0) {
            if (i >= 0)
                cur += num[i--];
            res.add(cur % 10);
            cur /= 10;
        }

        Collections.reverse(res);
        return res;
    }
}
