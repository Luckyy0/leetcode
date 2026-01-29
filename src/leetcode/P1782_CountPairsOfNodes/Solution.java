package leetcode.P1782_CountPairsOfNodes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        int[] degree = new int[n + 1];
        Map<Integer, Integer> shared = new HashMap<>(); // key: u*20000 + v, value: shared count

        for (int[] e : edges) {
            int u = Math.min(e[0], e[1]);
            int v = Math.max(e[0], e[1]);
            degree[u]++;
            degree[v]++;
            int key = u * 20001 + v; // Assuming n <= 20000
            shared.put(key, shared.getOrDefault(key, 0) + 1);
        }

        int[] sortedDeg = degree.clone();
        Arrays.sort(sortedDeg); // indices 0 is 0 (unused node 0), 1..n used. Sort includes 0.
        // Actually sortedDeg has size n+1. sortedDeg[1..n] are relevant.

        int[] result = new int[queries.length];

        for (int k = 0; k < queries.length; k++) {
            int q = queries[k];
            int count = 0;

            // Two pointers on sorted degrees
            // Relevant range: 1 to n
            int l = 1;
            int r = n;
            while (l < r) {
                if (sortedDeg[l] + sortedDeg[r] > q) {
                    count += (r - l);
                    r--;
                } else {
                    l++;
                }
            }

            // Adjust for shared edges
            for (Map.Entry<Integer, Integer> entry : shared.entrySet()) {
                int key = entry.getKey();
                int sh = entry.getValue();
                int u = key / 20001;
                int v = key % 20001;

                int sum = degree[u] + degree[v];
                if (sum > q && sum - sh <= q) {
                    count--;
                }
            }
            result[k] = count;
        }

        return result;
    }
}
