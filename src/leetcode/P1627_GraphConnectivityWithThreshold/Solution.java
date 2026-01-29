package leetcode.P1627_GraphConnectivityWithThreshold;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    class DSU {
        int[] parent;

        public DSU(int n) {
            parent = new int[n + 1];
            for (int i = 0; i <= n; i++)
                parent[i] = i;
        }

        public int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        public void union(int x, int y) {
            int rx = find(x);
            int ry = find(y);
            if (rx != ry)
                parent[rx] = ry;
        }
    }

    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        DSU dsu = new DSU(n);

        for (int z = threshold + 1; z <= n; z++) {
            for (int multiple = 2 * z; multiple <= n; multiple += z) {
                dsu.union(z, multiple);
            }
        }

        List<Boolean> result = new ArrayList<>();
        for (int[] q : queries) {
            result.add(dsu.find(q[0]) == dsu.find(q[1]));
        }

        return result;
    }
}
