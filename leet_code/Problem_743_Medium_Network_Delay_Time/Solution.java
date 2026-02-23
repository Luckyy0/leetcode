package leet_code.Problem_743_Medium_Network_Delay_Time;

import java.util.*;

public class Solution {

    /**
     * Calculates the time for all nodes to receive the signal.
     * Strategy: Dijkstra's Algorithm using Priority Queue.
     * Time: O(E log V), Space: O(V + E).
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        // Build adjacency list
        // Map<Source, List<int[]{Target, Time}>>
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(new int[] { edge[1], edge[2] });
        }

        // Dijkstra's Algorithm
        // PriorityQueue stores int[]{totalTime, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] { 0, k });

        // Distances array
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentTime = current[0];
            int u = current[1];

            // If we found a shorter path to u before processing this one, skip
            if (currentTime > dist[u]) {
                continue;
            }

            if (graph.containsKey(u)) {
                for (int[] neighbor : graph.get(u)) {
                    int v = neighbor[0];
                    int time = neighbor[1];
                    if (dist[u] + time < dist[v]) {
                        dist[v] = dist[u] + time;
                        pq.offer(new int[] { dist[v], v });
                    }
                }
            }
        }

        // Find the maximum distance
        int maxDist = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1; // Unreachable node
            }
            maxDist = Math.max(maxDist, dist[i]);
        }

        return maxDist;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] times1 = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
        System.out.println("Result 1: " + sol.networkDelayTime(times1, 4, 2)); // 2

        int[][] times2 = { { 1, 2, 1 } };
        System.out.println("Result 2: " + sol.networkDelayTime(times2, 2, 1)); // 1

        int[][] times3 = { { 1, 2, 1 } };
        System.out.println("Result 3: " + sol.networkDelayTime(times3, 2, 2)); // -1
    }
}
