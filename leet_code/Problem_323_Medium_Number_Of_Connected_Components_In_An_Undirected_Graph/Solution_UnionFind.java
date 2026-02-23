package leet_code.Problem_323_Medium_Number_Of_Connected_Components_In_An_Undirected_Graph;

public class Solution_UnionFind {

    /**
     * Counts connected components.
     * Uses Union-Find algorithm.
     * Time: O(E * alpha(N)), Space: O(N).
     * 
     * Đếm số lượng thành phần liên thông.
     * Sử dụng thuật toán Union-Find.
     */
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int count = n;

        for (int[] edge : edges) {
            int rootU = find(parent, edge[0]);
            int rootV = find(parent, edge[1]);

            if (rootU != rootV) {
                parent[rootU] = rootV;
                count--;
            }
        }

        return count;
    }

    private int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]); // Path compression
        }
        return parent[i];
    }

    public static void main(String[] args) {
        Solution_UnionFind solution = new Solution_UnionFind();

        // Test Case 1: n = 5, edges = [[0,1],[1,2],[3,4]] -> 2
        int[][] e1 = { { 0, 1 }, { 1, 2 }, { 3, 4 } };
        System.out.println("Components 1: " + solution.countComponents(5, e1));

        // Test Case 2: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]] -> 1
        int[][] e2 = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 } };
        System.out.println("Components 2: " + solution.countComponents(5, e2));
    }
}
