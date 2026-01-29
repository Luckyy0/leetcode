package leetcode.P947_MostStonesRemovedWithSameRowOrColumn;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int removeStones(int[][] stones) {
        DSU dsu = new DSU();
        for (int[] s : stones) {
            dsu.union(s[0], s[1] + 10001); // Use offset for columns
        }
        return stones.length - dsu.count;
    }

    class DSU {
        Map<Integer, Integer> parent = new HashMap<>();
        int count = 0;

        int find(int x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                count++;
            }
            if (x != parent.get(x)) {
                parent.put(x, find(parent.get(x)));
            }
            return parent.get(x);
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent.put(rootX, rootY);
                count--;
            }
        }
    }
}
