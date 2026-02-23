package leet_code.Problem_882_Hard_Reachable_Nodes_In_Subdivided_Graph;

import java.util.*;

/**
 * Problem 882: Reachable Nodes In Subdivided Graph
 * https://leetcode.com/problems/reachable-nodes-in-subdivided-graph/
 */
public class Solution {

    /**
     * Calculates the number of reachable nodes starting from node 0.
     * Strategy: Dijkstra's Algorithm + Counting nodes on edges.
     * 
     * @param edges    2D array representing edges and the number of split nodes.
     * @param maxMoves Maximum number of moves allowed.
     * @param n        Total number of original nodes.
     * @return Total reachable nodes (original + split).
     * 
     *         Tóm tắt chiến lược:
     *         1. Xây dựng đồ thị có trọng số từ mảng edges. Mỗi cạnh (u, v) với
     *         'cnt'
     *         nút chia nhỏ sẽ có trọng số là 'cnt + 1'.
     *         2. Dùng thuật toán Dijkstra để tìm khoảng cách ngắn nhất từ nút 0 đến
     *         tất cả các nút gốc khác. Gọi dist[i] là khoảng cách ngắn nhất đến nút
     *         i.
     *         3. Đếm số nút gốc có thể đến được (dist[i] <= maxMoves).
     *         4. Với mỗi cạnh (u, v) có 'cnt' nút:
     *         - Từ u, ta đi sâu vào cạnh này được max(0, maxMoves - dist[u]) bước.
     *         - Từ v, ta đi sâu vào cạnh này được max(0, maxMoves - dist[v]) bước.
     *         - Tổng số nút chia nhỏ được phủ trên cạnh này là min(cnt, (số bước từ
     *         u) + (số bước từ v)).
     *         5. Tổng kết quả là tổng số nút gốc + tổng số nút chia nhỏ trên các
     *         cạnh.
     */
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        // Build graph
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++)
            graph.put(i, new HashMap<>());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], cnt = edge[2];
            graph.get(u).put(v, cnt);
            graph.get(v).put(u, cnt);
        }

        // Dijkstra's Algorithm
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[] { 0, 0 }); // node, distance

        Map<Integer, Integer> dist = new HashMap<>();
        dist.put(0, 0);

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];

            if (d > dist.getOrDefault(u, Integer.MAX_VALUE))
                continue;

            if (graph.containsKey(u)) {
                for (int v : graph.get(u).keySet()) {
                    int weight = graph.get(u).get(v) + 1;
                    if (d + weight <= maxMoves) { // Optimization: only push if reachable
                        int newDist = d + weight;
                        if (newDist < dist.getOrDefault(v, Integer.MAX_VALUE)) {
                            dist.put(v, newDist);
                            pq.offer(new int[] { v, newDist });
                        }
                    }
                }
            }
        }

        // Count reachable nodes
        int ans = dist.size(); // All nodes in 'dist' map are reachable within maxMoves

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], cnt = edge[2];

            // How far can we reach from u into this edge?
            int a = 0;
            if (dist.containsKey(u)) {
                a = Math.min(cnt, maxMoves - dist.get(u));
            }

            // How far can we reach from v into this edge?
            int b = 0;
            if (dist.containsKey(v)) {
                b = Math.min(cnt, maxMoves - dist.get(v));
            }

            // The two traversals may overlap, but cannot exceed total 'cnt' nodes
            ans += Math.min(cnt, a + b);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] e1 = { { 0, 1, 10 }, { 0, 2, 1 }, { 1, 2, 2 } };
        System.out.println("Result: " + sol.reachableNodes(e1, 6, 3)); // 13

        int[][] e2 = { { 0, 1, 4 }, { 1, 2, 6 }, { 0, 2, 8 }, { 1, 3, 1 } };
        System.out.println("Result: " + sol.reachableNodes(e2, 10, 4)); // 23
    }
}
