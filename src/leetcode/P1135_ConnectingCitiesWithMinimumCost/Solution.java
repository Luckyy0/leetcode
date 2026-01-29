package leetcode.P1135_ConnectingCitiesWithMinimumCost;

import java.util.Arrays;

class Solution {
    int[] parent;
    int components;

    public int minimumCost(int n, int[][] connections) {
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++)
            parent[i] = i;
        components = n;

        int cost = 0;
        for (int[] c : connections) {
            if (union(c[0], c[1])) {
                cost += c[2];
            }
        }

        return components == 1 ? cost : -1;
    }

    private int find(int i) {
        if (parent[i] == i)
            return i;
        parent[i] = find(parent[i]);
        return parent[i];
    }

    private boolean union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI != rootJ) {
            parent[rootI] = rootJ;
            components--;
            return true;
        }
        return false;
    }
}
