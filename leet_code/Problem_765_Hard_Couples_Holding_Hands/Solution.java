package leet_code.Problem_765_Hard_Couples_Holding_Hands;

public class Solution {

    private int[] parent;
    private int count; // Number of connected components

    /**
     * Finds min swaps to seat couples together.
     * Strategy: Union-Find (DSU) to count cyclic dependencies.
     * Time: O(N), Space: O(N).
     */
    public int minSwapsCouples(int[] row) {
        int n = row.length / 2; // Number of couples
        parent = new int[n];
        count = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // Iterate over couches. A couch has seats 2*i and 2*i + 1.
        for (int i = 0; i < n; i++) {
            int p1 = row[2 * i];
            int p2 = row[2 * i + 1];

            // Identify which couple these people belong to
            int c1 = p1 / 2;
            int c2 = p2 / 2;

            // Union the two couples because they are connected by this couch
            union(c1, c2);
        }

        // Min swaps = Total Couples - Number of Connected Components
        return n - count;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            parent[rootX] = rootY;
            count--; // Merged two components
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] row1 = { 0, 2, 1, 3 };
        System.out.println("Result 1: " + sol.minSwapsCouples(row1)); // 1

        int[] row2 = { 3, 2, 0, 1 };
        System.out.println("Result 2: " + sol.minSwapsCouples(row2)); // 0
    }
}
