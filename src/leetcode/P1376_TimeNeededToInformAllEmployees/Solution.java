package leetcode.P1376_TimeNeededToInformAllEmployees;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<Integer>> graph;
    private int[] informTime;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        this.informTime = informTime;
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                graph.get(manager[i]).add(i);
            }
        }

        return dfs(headID);
    }

    private int dfs(int u) {
        int maxChildTime = 0;
        for (int v : graph.get(u)) {
            maxChildTime = Math.max(maxChildTime, dfs(v));
        }
        return informTime[u] + maxChildTime;
    }
}
