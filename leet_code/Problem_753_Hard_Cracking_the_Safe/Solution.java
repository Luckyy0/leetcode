package leet_code.Problem_753_Hard_Cracking_the_Safe;

import java.util.*;

public class Solution {

    /**
     * Finds the shortest string covering all k^n possibilities.
     * Strategy: Hierholzer's Algorithm to find Eulerian Path (De Bruijn Sequence).
     * Time: O(k^n), Space: O(k^n).
     */
    public String crackSafe(int n, int k) {
        // StringBuilder to store the resulting sequence in reverse (initially)
        StringBuilder result = new StringBuilder();

        // Visited set to track edges: string representation of "node + edge"
        // Or simply the n-length sequence that the edge represents.
        Set<String> visited = new HashSet<>();

        // Start node: string of (n-1) '0's
        StringBuilder startNode = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            startNode.append('0');
        }

        dfs(startNode.toString(), k, visited, result);

        // Append the starting node context to complete the sequence
        result.append(startNode);

        // Convert to string (result was built post-order)
        return result.toString();
    }

    private void dfs(String node, int k, Set<String> visited, StringBuilder result) {
        for (int i = 0; i < k; i++) {
            // Edge represents adding digit 'i' to the current node context
            // The combined string "node + i" is the n-length sequence achieved
            String edge = node + i;

            if (!visited.contains(edge)) {
                visited.add(edge);
                // Next node is the suffix of length n-1 of the edge
                String nextNode = edge.substring(1);
                dfs(nextNode, k, visited, result);

                // Add the edge digit to result (post-order)
                result.append(i);
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result 1: " + sol.crackSafe(1, 2)); // 10 or 01
        System.out.println("Result 2: " + sol.crackSafe(2, 2)); // 01100 or similar
    }
}
