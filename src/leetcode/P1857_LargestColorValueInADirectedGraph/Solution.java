package leetcode.P1857_LargestColorValueInADirectedGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        int[] indegree = new int[n];
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            indegree[e[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int[][] dp = new int[n][26];

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                dp[i][colors.charAt(i) - 'a'] = 1;
            }
        }

        int processed = 0;
        int maxVal = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            processed++;

            // Update global max
            for (int k = 0; k < 26; k++) {
                maxVal = Math.max(maxVal, dp[u][k]);
            }

            for (int v : adj[u]) {
                for (int k = 0; k < 26; k++) {
                    // Propagate u to v. Note: v's color is added later when v is processed?
                    // No. v accumulates from multiple parents.
                    // We simply update the accumulator.
                    // The color of v itself is added once when?
                    // Best way: dp[v][k] stores value including v itself?
                    // Or excluding?
                    // If including: we need to handle "add 1 if match" logic correctly.
                    // If we just do `dp[v][k] = max(dp[v][k], dp[u][k])`, we are missing v's
                    // contribution.
                    // Better: `base_v` inherits from `u`.
                    // `dp[v][k] = max(dp[v][k], dp[u][k])`.
                    // But we can only add v's color ONCE.
                    // So wait until v is popped? No, we need values ready if v is pushed.
                    // Actually, if we update `dp[v]` incrementally.
                    // When indegree becomes 0, we add v's color contribution?
                    // Yes. Only then it's final.
                    dp[v][k] = Math.max(dp[v][k], dp[u][k]);
                }

                indegree[v]--;
                if (indegree[v] == 0) {
                    dp[v][colors.charAt(v) - 'a']++;
                    q.offer(v);
                }
            }
        }

        if (processed < n)
            return -1; // Cycle
        return maxVal;
    }
}
