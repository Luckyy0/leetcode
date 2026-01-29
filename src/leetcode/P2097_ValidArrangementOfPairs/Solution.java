package leetcode.P2097_ValidArrangementOfPairs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, Deque<Integer>> adj = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Integer> outDegree = new HashMap<>();

        for (int[] p : pairs) {
            int u = p[0];
            int v = p[1];
            adj.computeIfAbsent(u, k -> new ArrayDeque<>()).push(v);
            outDegree.put(u, outDegree.getOrDefault(u, 0) + 1);
            inDegree.put(v, inDegree.getOrDefault(v, 0) + 1);
        }

        // Find start node
        int startNode = -1;

        // If exists node with out > in (must be exactly one such node for path)
        for (int u : outDegree.keySet()) {
            if (outDegree.get(u) == inDegree.getOrDefault(u, 0) + 1) {
                startNode = u;
                break;
            }
        }

        // If Eulerian Circuit (all in == out), start anywhere
        if (startNode == -1) {
            startNode = pairs[0][0];
        }

        List<Integer> path = new ArrayList<>();
        dfs(startNode, adj, path);

        Collections.reverse(path);

        int[][] res = new int[pairs.length][2];
        for (int i = 0; i < path.size() - 1; i++) {
            res[i][0] = path.get(i);
            res[i][1] = path.get(i + 1);
        }

        return res;
    }

    private void dfs(int u, Map<Integer, Deque<Integer>> adj, List<Integer> path) {
        Deque<Integer> stack = adj.get(u);
        while (stack != null && !stack.isEmpty()) {
            int v = stack.pop();
            dfs(v, adj, path);
        }
        path.add(u);
    }
}
