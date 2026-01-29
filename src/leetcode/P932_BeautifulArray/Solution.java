package leetcode.P932_BeautifulArray;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] beautifulArray(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        while (res.size() < n) {
            List<Integer> next = new ArrayList<>();
            for (int x : res)
                if (2 * x - 1 <= n)
                    next.add(2 * x - 1);
            for (int x : res)
                if (2 * x <= n)
                    next.add(2 * x);
            res = next;
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++)
            ans[i] = res.get(i);
        return ans;
    }
}
