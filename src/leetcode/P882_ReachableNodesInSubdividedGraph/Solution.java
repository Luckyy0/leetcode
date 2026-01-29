package leetcode.P882_ReachableNodesInSubdividedGraph;

import java.util.*;

class Solution {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        Map<Integer, Map<Integer, Integer>> adj = new HashMap<>();
        for (int[] e : edges) {
            adj.computeIfAbsent(e[0], k -> new HashMap<>()).put(e[1], e[2]);
            adj.computeIfAbsent(e[1], k -> new HashMap<>()).put(e[0], e[2]);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]); // [node, remainingMoves]
        pq.add(new int[] { 0, maxMoves });

        Map<Integer, Integer> visited = new HashMap<>(); // node -> maxRemainingMoves

        int count = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0], moves = curr[1];

            if (visited.containsKey(u))
                continue;
            visited.put(u, moves);
            count++;

            if (adj.containsKey(u)) {
                for (int v : adj.get(u).keySet()) {
                    int weight = adj.get(u).get(v);
                    int remaining = moves - weight - 1;
                    if (!visited.containsKey(v) && remaining >= 0) {
                        pq.add(new int[] { v, remaining });
                    }
                }
            }
        }

        // Count nodes on edges
        for (int[] e : edges) {
            int u = e[0], v = e[1], cnt = e[2];
            int a = visited.getOrDefault(u, 0);
            int b = visited.getOrDefault(v, 0);
            count += Math.min(cnt, a + b);
        }

        return count;
    }
}
