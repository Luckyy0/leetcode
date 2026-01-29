package leetcode.P1998_GCDSortOfAnArray;

import java.util.Arrays;

public class Solution {
    public boolean gcdSort(int[] nums) {
        int max = 0;
        for (int x : nums)
            max = Math.max(max, x);

        UnionFind uf = new UnionFind(max + 1);

        // Union each number with its factors
        for (int x : nums) {
            int val = x;
            for (int i = 2; i * i <= val; i++) {
                if (val % i == 0) {
                    uf.union(x, i);
                    while (val % i == 0)
                        val /= i;
                }
            }
            if (val > 1) {
                uf.union(x, val);
            }
        }

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        for (int i = 0; i < nums.length; i++) {
            if (uf.find(nums[i]) != uf.find(sorted[i])) {
                return false;
            }
        }

        return true;
    }

    class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        public int find(int i) {
            if (parent[i] != i)
                parent[i] = find(parent[i]);
            return parent[i];
        }

        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ)
                parent[rootI] = rootJ;
        }
    }
}
