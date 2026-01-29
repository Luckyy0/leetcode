package leetcode.P1971_FindIfPathExistsInGraph;

public class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination)
            return true;

        int[] parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;

        for (int[] edge : edges) {
            union(parent, edge[0], edge[1]);
        }

        return find(parent, source) == find(parent, destination);
    }

    private int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }

    private void union(int[] parent, int i, int j) {
        int rootI = find(parent, i);
        int rootJ = find(parent, j);
        if (rootI != rootJ) {
            parent[rootI] = rootJ;
        }
    }
}
