package leetcode.P2039_TheTimeWhenTheNetworkBecomesIdle;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        dist[0] = 0;

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj[u]) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.offer(v);
                }
            }
        }

        int maxIdle = 0;
        for (int i = 1; i < n; i++) {
            int rtt = 2 * dist[i];
            int p = patience[i];

            int lastSendTime;
            if (rtt <= p) {
                lastSendTime = 0;
            } else {
                // Last send is strictly before rtt.
                int k = (rtt - 1) / p;
                lastSendTime = k * p;
            }

            int lastArrival = lastSendTime + rtt;
            maxIdle = Math.max(maxIdle, lastArrival + 1);
        }

        return maxIdle;
    }
}
