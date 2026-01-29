package leetcode.P323_NumberOfConnectedComponentsInAnUndirectedGraph;

public class Solution {

    /**
     * Problem 323: Number of Connected Components in an Undirected Graph
     * Approach: Union-Find
     * 
     * Time Complexity: O(E * alpha(N))
     * Space Complexity: O(N)
     */
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;

        int count = n;

        for (int[] edge : edges) {
            int p1 = find(parent, edge[0]);
            int p2 = find(parent, edge[1]);

            if (p1 != p2) {
                parent[p1] = p2;
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
        Solution solution = new Solution();

        // 5, [[0,1],[1,2],[3,4]] -> 2
        runTest(solution, 5, new int[][] { { 0, 1 }, { 1, 2 }, { 3, 4 } }, 2);

        // 5, [[0,1],[1,2],[2,3],[3,4]] -> 1
        runTest(solution, 5, new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 } }, 1);
    }

    private static void runTest(Solution s, int n, int[][] edges, int expected) {
        int result = s.countComponents(n, edges);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
