package leetcode.P1697_CheckingExistenceOfEdgeLengthLimitedPaths;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        // Prepare queries with indices
        int qLen = queries.length;
        int[][] sortedQueries = new int[qLen][4]; // [p, q, limit, originalIndex]
        for (int i = 0; i < qLen; i++) {
            sortedQueries[i][0] = queries[i][0];
            sortedQueries[i][1] = queries[i][1];
            sortedQueries[i][2] = queries[i][2];
            sortedQueries[i][3] = i;
        }

        // Sort edges by weight
        Arrays.sort(edgeList, Comparator.comparingInt(a -> a[2]));
        // Sort queries by limit
        Arrays.sort(sortedQueries, Comparator.comparingInt(a -> a[2]));

        UnionFind uf = new UnionFind(n);
        boolean[] result = new boolean[qLen];
        int edgeIdx = 0;
        int eLen = edgeList.length;

        for (int[] query : sortedQueries) {
            int p = query[0];
            int q = query[1];
            int limit = query[2];
            int idx = query[3];

            // Add edges < limit
            while (edgeIdx < eLen && edgeList[edgeIdx][2] < limit) {
                uf.union(edgeList[edgeIdx][0], edgeList[edgeIdx][1]);
                edgeIdx++;
            }

            result[idx] = uf.connected(p, q);
        }

        return result;
    }

    static class UnionFind {
        int[] parent;

        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
            }
        }

        boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
