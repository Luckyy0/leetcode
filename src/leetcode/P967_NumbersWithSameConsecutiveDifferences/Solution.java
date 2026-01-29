package leetcode.P967_NumbersWithSameConsecutiveDifferences;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> res = new ArrayList<>();
        if (n == 1)
            res.add(0);

        for (int i = 1; i <= 9; i++) {
            dfs(n - 1, k, i, res);
        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
            ans[i] = res.get(i);
        return ans;
    }

    private void dfs(int n, int k, int current, List<Integer> res) {
        if (n == 0) {
            res.add(current);
            return;
        }

        int lastDigit = current % 10;
        if (lastDigit + k <= 9) {
            dfs(n - 1, k, current * 10 + lastDigit + k, res);
        }
        if (k != 0 && lastDigit - k >= 0) {
            dfs(n - 1, k, current * 10 + lastDigit - k, res);
        }
    }
}
