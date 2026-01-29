package leetcode.P851_LoudAndRich;

import java.util.*;

class Solution {
    int[] quiet;
    int[] ans;
    List<List<Integer>> richerThan;

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        this.quiet = quiet;
        this.ans = new int[n];
        Arrays.fill(ans, -1);

        richerThan = new ArrayList<>();
        for (int i = 0; i < n; i++)
            richerThan.add(new ArrayList<>());
        for (int[] r : richer) {
            richerThan.get(r[1]).add(r[0]); // b -> a means a is richer than b
        }

        for (int i = 0; i < n; i++) {
            dfs(i);
        }

        return ans;
    }

    private int dfs(int u) {
        if (ans[u] != -1)
            return ans[u];

        ans[u] = u;
        for (int v : richerThan.get(u)) {
            int candidate = dfs(v);
            if (quiet[candidate] < quiet[ans[u]]) {
                ans[u] = candidate;
            }
        }
        return ans[u];
    }
}
