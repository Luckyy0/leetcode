package leetcode.P1489_FindCriticalAndPseudoCriticalEdgesInMinimumSpanningTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    class UnionFind {
        int[] parent;
        int count;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
            count = n;
        }

        public int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
                count--;
                return true;
            }
            return false;
        }
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int m = edges.length;
        int[][] sortedEdges = new int[m][4];
        for (int i = 0; i < m; i++) {
            sortedEdges[i][0] = edges[i][0];
            sortedEdges[i][1] = edges[i][1];
            sortedEdges[i][2] = edges[i][2];
            sortedEdges[i][3] = i; // Original index
        }

        Arrays.sort(sortedEdges, (a, b) -> Integer.compare(a[2], b[2]));

        int mstWeight = getMSTWeight(n, sortedEdges, -1, -1);

        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudo = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int originalIdx = sortedEdges[i][3];

            // Check Critical (Exclude)
            int weightExclude = getMSTWeight(n, sortedEdges, i, -1);
            if (weightExclude > mstWeight || weightExclude == -1) {
                critical.add(originalIdx);
                continue;
            }

            // Check Pseudo (Force Include)
            int weightInclude = getMSTWeight(n, sortedEdges, -1, i);
            if (weightInclude == mstWeight) {
                pseudo.add(originalIdx);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(critical);
        result.add(pseudo);
        return result;
    }

    private int getMSTWeight(int n, int[][] edges, int excludeIdx, int includeIdx) {
        UnionFind uf = new UnionFind(n);
        int weight = 0;

        if (includeIdx != -1) {
            // Find edge structure in sorted array or use original?
            // includeIdx refers to position in SORTED array for simplicity if passed that
            // way?
            // Wait, loop uses index in sortedEdges. So i is index in sortedEdges.
            // includeIdx passed is index in SORTED array.

            int[] edge = edges[includeIdx];
            uf.union(edge[0], edge[1]);
            weight += edge[2];
        }

        for (int i = 0; i < edges.length; i++) {
            if (i == excludeIdx || i == includeIdx)
                continue;

            int[] edge = edges[i];
            if (uf.union(edge[0], edge[1])) {
                weight += edge[2];
            }
        }

        if (uf.count > 1)
            return -1; // Not connected
        return weight;
    }
}
