package leetcode.P753_CrackingTheSafe;

import java.util.HashSet;
import java.util.Set;

class Solution {
    StringBuilder res;
    Set<String> visited;
    int k;

    public String crackSafe(int n, int k) {
        this.k = k;
        res = new StringBuilder();
        visited = new HashSet<>();

        // Start with n-1 zeros
        // Bắt đầu với n-1 số không
        StringBuilder start = new StringBuilder();
        for (int i = 0; i < n - 1; i++)
            start.append('0');

        dfs(start.toString());
        res.append(start);

        return res.toString();
    }

    private void dfs(String u) {
        for (int i = 0; i < k; i++) {
            String v = u + i;
            if (!visited.contains(v)) {
                visited.add(v);
                dfs(v.substring(1));
                res.append(i);
            }
        }
    }
}
