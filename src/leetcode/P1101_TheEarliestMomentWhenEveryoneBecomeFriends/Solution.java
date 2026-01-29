package leetcode.P1101_TheEarliestMomentWhenEveryoneBecomeFriends;

import java.util.Arrays;

class Solution {
    int[] parent;
    int components;

    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
        components = n;

        for (int[] log : logs) {
            int t = log[0];
            int x = log[1];
            int y = log[2];

            if (union(x, y)) {
                if (components == 1)
                    return t;
            }
        }

        return -1;
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
