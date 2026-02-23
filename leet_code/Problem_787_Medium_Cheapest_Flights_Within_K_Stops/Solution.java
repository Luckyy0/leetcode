package leet_code.Problem_787_Medium_Cheapest_Flights_Within_K_Stops;

import java.util.Arrays;

public class Solution {

    /**
     * Finds cheapest price with at most K stops.
     * Strategy: Bellman-Ford Algorithm (Relax edges K+1 times).
     * Time: O(K * E), Space: O(N).
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Distance array
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Loop K+1 times. K stops means K+1 edges/flights.
        for (int i = 0; i <= k; i++) {
            // Create a copy so updates in this iteration don't cascade immediately
            // (Standard Bellman-Ford behavior)
            int[] tempDist = dist.clone();

            for (int[] flight : flights) {
                int u = flight[0];
                int v = flight[1];
                int price = flight[2];

                // If u is reachable, try to relax v
                if (dist[u] != Integer.MAX_VALUE) {
                    tempDist[v] = Math.min(tempDist[v], dist[u] + price);
                }
            }

            // Commit updates for this iteration
            dist = tempDist;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] f1 = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
        System.out.println("Result 1: " + sol.findCheapestPrice(4, f1, 0, 3, 1)); // 700

        int[][] f2 = { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } };
        System.out.println("Result 2: " + sol.findCheapestPrice(3, f2, 0, 2, 1)); // 200

        int[][] f3 = { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } };
        System.out.println("Result 3: " + sol.findCheapestPrice(3, f3, 0, 2, 0)); // 500
    }
}
