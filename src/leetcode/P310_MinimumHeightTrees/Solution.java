package leetcode.P310_MinimumHeightTrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    /**
     * Problem 310: Minimum Height Trees
     * Approach: Topological Sort (Peeling Onion)
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1)
            return Arrays.asList(0);

        // Build Graph
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new HashSet<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        // Initial leaves
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        int remainingNodes = n;
        while (remainingNodes > 2) {
            remainingNodes -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();

            for (int leaf : leaves) {
                // Determine neighbor
                // Since it's a leaf, it has only 1 neighbor in adj set
                int neighbor = adj.get(leaf).iterator().next();

                // Remove leaf from neighbor's adj
                adj.get(neighbor).remove(leaf);

                if (adj.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }

            leaves = newLeaves;
        }

        return leaves;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 4, [[1,0],[1,2],[1,3]] -> [1]
        int[][] e1 = { { 1, 0 }, { 1, 2 }, { 1, 3 } };
        runTest(solution, 4, e1, Arrays.asList(1));

        // 6, [[3,0],[3,1],[3,2],[3,4],[5,4]] -> [3,4]
        int[][] e2 = { { 3, 0 }, { 3, 1 }, { 3, 2 }, { 3, 4 }, { 5, 4 } };
        runTest(solution, 6, e2, Arrays.asList(3, 4));
    }

    private static void runTest(Solution s, int n, int[][] edges, List<Integer> expected) {
        List<Integer> result = s.findMinHeightTrees(n, edges);
        // Sort for comparison
        result.sort(null);
        List<Integer> expSorted = new ArrayList<>(expected);
        expSorted.sort(null);

        System.out.println("Result: " + result + " (Expected: " + expSorted + ")");
        if (result.equals(expSorted)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
