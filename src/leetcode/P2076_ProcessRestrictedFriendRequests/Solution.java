package leetcode.P2076_ProcessRestrictedFriendRequests;

public class Solution {
    class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        public int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
            }
        }
    }

    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        UnionFind uf = new UnionFind(n);
        boolean[] result = new boolean[requests.length];

        for (int i = 0; i < requests.length; i++) {
            int u = requests[i][0];
            int v = requests[i][1];

            int rootU = uf.find(u);
            int rootV = uf.find(v);

            if (rootU == rootV) {
                result[i] = true;
                continue;
            }

            boolean possible = true;
            for (int[] r : restrictions) {
                int rx = uf.find(r[0]);
                int ry = uf.find(r[1]);

                // If restriction is between the two components we want to merge
                if ((rx == rootU && ry == rootV) || (rx == rootV && ry == rootU)) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                uf.union(u, v);
                result[i] = true;
            } else {
                result[i] = false;
            }
        }

        return result;
    }
}
