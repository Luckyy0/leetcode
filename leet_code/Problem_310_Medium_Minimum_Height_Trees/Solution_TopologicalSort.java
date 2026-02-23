package leet_code.Problem_310_Medium_Minimum_Height_Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Collections;

public class Solution_TopologicalSort {

    /**
     * Finds roots of Minimum Height Trees.
     * Uses Topological Sort from Leaves (Peeling Onion).
     * Time: O(N), Space: O(N).
     * 
     * Tìm các gốc của Cây có Chiều cao Tối thiểu.
     * Sử dụng Sắp xếp Topo từ Lá (Bóc hành).
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }

        // Build Graph
        List<Set<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            adj.add(new HashSet<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        // Find initial leaves
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        // Peel layers
        int remainingNodes = n;
        while (remainingNodes > 2) {
            remainingNodes -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();

            for (int u : leaves) {
                // Remove leaf u from its neighbor v
                int v = adj.get(u).iterator().next();
                adj.get(v).remove(u);

                if (adj.get(v).size() == 1) {
                    newLeaves.add(v);
                }
            }

            leaves = newLeaves;
        }

        return leaves;
    }

    public static void main(String[] args) {
        Solution_TopologicalSort solution = new Solution_TopologicalSort();

        // Test Case 1: n = 4, edges = [[1,0],[1,2],[1,3]] -> [1]
        int[][] e1 = { { 1, 0 }, { 1, 2 }, { 1, 3 } };
        System.out.println("MHT Roots 1: " + solution.findMinHeightTrees(4, e1));

        // Test Case 2: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]] -> [3, 4]
        int[][] e2 = { { 3, 0 }, { 3, 1 }, { 3, 2 }, { 3, 4 }, { 5, 4 } };
        System.out.println("MHT Roots 2: " + solution.findMinHeightTrees(6, e2));
    }
}
