package leet_code.Problem_785_Medium_Is_Graph_Bipartite;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    /**
     * Checks if the graph is bipartite.
     * Strategy: BFS 2-coloring.
     * Time: O(V + E), Space: O(V).
     */
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        // 0: uncolored, 1: Color A, -1: Color B
        int[] colors = new int[n];

        // Iterate through all nodes to handle disconnected components
        for (int i = 0; i < n; i++) {
            // Start BFS if node is not colored yet
            if (colors[i] == 0) {
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                colors[i] = 1; // Assign first color

                while (!q.isEmpty()) {
                    int node = q.poll();

                    for (int neighbor : graph[node]) {
                        if (colors[neighbor] == 0) {
                            // If uncolored, assign opposite color and enqueue
                            colors[neighbor] = -colors[node];
                            q.offer(neighbor);
                        } else if (colors[neighbor] == colors[node]) {
                            // If already colored with same color, implies odd cycle -> not bipartite
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] g1 = {
                { 1, 2, 3 },
                { 0, 2 },
                { 0, 1, 3 },
                { 0, 2 }
        };
        System.out.println("Result 1: " + sol.isBipartite(g1)); // false

        int[][] g2 = {
                { 1, 3 },
                { 0, 2 },
                { 1, 3 },
                { 0, 2 }
        };
        System.out.println("Result 2: " + sol.isBipartite(g2)); // true
    }
}
