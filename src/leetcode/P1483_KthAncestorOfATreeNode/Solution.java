package leetcode.P1483_KthAncestorOfATreeNode;

import java.util.Arrays;

class TreeAncestor {
    int[][] up;
    int LOG;

    public TreeAncestor(int n, int[] parent) {
        LOG = 0;
        while ((1 << LOG) <= n)
            LOG++;

        up = new int[n][LOG];
        for (int[] row : up)
            Arrays.fill(row, -1);

        for (int i = 0; i < n; i++)
            up[i][0] = parent[i];

        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {
                if (up[i][j - 1] != -1) {
                    up[i][j] = up[up[i][j - 1]][j - 1];
                }
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        for (int j = 0; j < LOG; j++) {
            if (((k >> j) & 1) != 0) {
                node = up[node][j];
                if (node == -1)
                    return -1;
            }
        }
        return node;
    }
}
