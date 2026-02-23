package leet_code.Problem_851_Medium_Loud_and_Rich;

import java.util.*;

/**
 * Problem 851: Loud and Rich
 * https://leetcode.com/problems/loud-and-rich/
 */
public class Solution {

    /**
     * Finds the quietest person who is richer than or as rich as each person.
     * Strategy: Depth First Search (DFS) with memoization.
     * 
     * @param richer Array of [a, b] meaning a is richer than b.
     * @param quiet  Array of quietness levels for each person.
     * @return Array of individuals satisfying the criteria for each person.
     * 
     *         Tóm tắt chiến lược:
     *         Sử dụng DFS với ghi nhớ để tìm người yên lặng nhất trong số tất cả
     *         những người
     *         giàu hơn hoặc bằng người hiện tại. Chúng ta xây dựng một đồ thị có
     *         hướng
     *         trong đó cạnh x -> y nghĩa là y giàu hơn x.
     */
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        // Build adjacency list for richer relations (b -> a means a is richer than b)
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();
        for (int[] r : richer) {
            adj[r[1]].add(r[0]);
        }

        // Memoization array
        int[] answer = new int[n];
        Arrays.fill(answer, -1);

        // Execute DFS for each person
        for (int i = 0; i < n; i++) {
            dfs(i, adj, quiet, answer);
        }

        return answer;
    }

    /**
     * Helping DFS method to explore richer connections.
     */
    private int dfs(int node, List<Integer>[] adj, int[] quiet, int[] answer) {
        // Return if already computed
        if (answer[node] != -1)
            return answer[node];

        // Start by assuming the person themselves is the quietest
        int minQuietNode = node;

        // Explore all people who are richer
        for (int richerNode : adj[node]) {
            int candidate = dfs(richerNode, adj, quiet, answer);
            // Update if a quieter person is found among the richer group
            if (quiet[candidate] < quiet[minQuietNode]) {
                minQuietNode = candidate;
            }
        }

        // Memoize and return
        answer[node] = minQuietNode;
        return minQuietNode;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] richer = { { 1, 0 }, { 2, 1 }, { 3, 1 }, { 3, 7 }, { 4, 3 }, { 5, 3 }, { 6, 3 } };
        int[] quiet = { 3, 2, 5, 4, 1, 6, 1, 0 };
        // This is a dummy test case, checking output structure
        int[] result = sol.loudAndRich(richer, quiet);
        System.out.println(Arrays.toString(result));
    }
}
