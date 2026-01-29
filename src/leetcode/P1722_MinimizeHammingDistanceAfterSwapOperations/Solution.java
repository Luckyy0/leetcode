package leetcode.P1722_MinimizeHammingDistanceAfterSwapOperations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        UnionFind uf = new UnionFind(n);
        for (int[] pair : allowedSwaps) {
            uf.union(pair[0], pair[1]);
        }

        // Group indices by root
        Map<Integer, List<Integer>> components = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            components.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }

        int distance = 0;

        for (List<Integer> indices : components.values()) {
            Map<Integer, Integer> srcCounts = new HashMap<>();

            for (int idx : indices) {
                int val = source[idx];
                srcCounts.put(val, srcCounts.getOrDefault(val, 0) + 1);
            }

            int matches = 0;
            for (int idx : indices) {
                int val = target[idx];
                if (srcCounts.getOrDefault(val, 0) > 0) {
                    matches++;
                    srcCounts.put(val, srcCounts.get(val) - 1);
                }
            }

            distance += (indices.size() - matches);
        }

        return distance;
    }

    class UnionFind {
        int[] parent;

        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY)
                parent[rootX] = rootY;
        }
    }
}
