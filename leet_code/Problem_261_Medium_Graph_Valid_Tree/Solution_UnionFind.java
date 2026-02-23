package leet_code.Problem_261_Medium_Graph_Valid_Tree;

public class Solution_UnionFind {

    /**
     * Checks if the graph is a valid tree.
     * Uses Union-Find to detect cycles and verify connectivity.
     * Time: O(N * alpha(N)), Space: O(N).
     * 
     * Kiểm tra xem đồ thị có phải là cây hợp lệ không.
     * Sử dụng Union-Find để phát hiện chu trình và xác minh tính liên thông.
     */
    public boolean validTree(int n, int[][] edges) {
        // A tree with n nodes must have exactly n - 1 edges
        // Một cây với n nút phải có chính xác n - 1 cạnh
        if (edges.length != n - 1) {
            return false;
        }

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            int rootU = find(parent, u);
            int rootV = find(parent, v);

            // If roots are same, a cycle exists
            // Nếu root giống nhau, tồn tại chu trình
            if (rootU == rootV) {
                return false;
            }

            // Union
            parent[rootU] = rootV;
        }

        // If we processed n-1 edges without cycles, the graph is fully connected and is
        // a tree
        // Nếu đã xử lý n-1 cạnh mà không có chu trình, đồ thị liên thông hoàn toàn và
        // là cây
        return true;
    }

    private int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]); // Path compression
        }
        return parent[i];
    }

    public static void main(String[] args) {
        Solution_UnionFind solution = new Solution_UnionFind();

        // Test Case 1: n = 5, edges = [[0,1], [0,2], [0,3], [1,4]] -> true
        int[][] edges1 = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } };
        System.out.println("Valid Tree 1: " + solution.validTree(5, edges1));

        // Test Case 2: n = 5, edges = [[0,1], [1,2], [2,3], [1,3], [1,4]] -> false
        int[][] edges2 = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 3 }, { 1, 4 } };
        System.out.println("Valid Tree 2: " + solution.validTree(5, edges2));
    }
}
