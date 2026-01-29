package leetcode.P952_LargestComponentSizeByCommonFactor;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int largestComponentSize(int[] nums) {
        int max = 0;
        for (int x : nums)
            max = Math.max(max, x);
        DSU dsu = new DSU(max + 1);

        for (int x : nums) {
            for (int i = 2; i * i <= x; i++) {
                if (x % i == 0) {
                    dsu.union(x, i);
                    dsu.union(x, x / i);
                }
            }
        }

        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            int root = dsu.find(x);
            map.put(root, map.getOrDefault(root, 0) + 1);
            res = Math.max(res, map.get(root));
        }
        return res;
    }

    class DSU {
        int[] parent;

        DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        int find(int x) {
            if (parent[x] == x)
                return x;
            return parent[x] = find(parent[x]);
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY)
                parent[rootX] = rootY;
        }
    }
}
