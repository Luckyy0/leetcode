package leetcode.P2127_MaximumEmployeesToBeInvitedToAMeeting;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] inDegree = new int[n];
        for (int f : favorite) {
            inDegree[f]++;
        }

        // Topological sort to process trees (chains)
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0)
                q.offer(i);
        }

        int[] depth = new int[n]; // Max chain length ending at i (excluding i itself initially? Let's say
                                  // depth[i] is length)
        // Actually simpler: depth[i] is max arm length entering i.
        // Initially 0. If u -> v, depth[v] = max(depth[v], depth[u] + 1).

        // Wait, if chain is just u->v. u is leaf.
        // depth[u] = 0. depth[v] = 1.
        // Then cycle u-v (len 2) uses depth[u] and depth[v].

        // But u is NOT in cycle if it was in queue.
        // The nodes in cycle are never added to queue.
        // Once queue empty, we have depth values for nodes *incident* to cycles.

        boolean[] processed = new boolean[n];

        while (!q.isEmpty()) {
            int u = q.poll();
            processed[u] = true;
            int v = favorite[u];
            depth[v] = Math.max(depth[v], depth[u] + 1);
            inDegree[v]--;
            if (inDegree[v] == 0) {
                q.offer(v);
            }
        }

        int maxCycle = 0;
        int sum2Cycles = 0;

        // Process cycles
        for (int i = 0; i < n; i++) {
            if (!processed[i]) {
                // Found a cycle component
                int curr = i;
                int cycleLen = 0;
                while (!processed[curr]) {
                    processed[curr] = true;
                    curr = favorite[curr];
                    cycleLen++;
                }

                if (cycleLen == 2) {
                    // Mutual pair.
                    // i and favorite[i] form the cycle.
                    // We need depth[i] and depth[favorite[i]].
                    // The 'curr' loop moved processed true, so we need to access the nodes.
                    // Re-accessing nodes is tricky if we don't know who they are.
                    // But we iterate i. 'i' is inside cycle.
                    // Cycle is i -> neighbor -> i.
                    int neighbor = favorite[i];
                    sum2Cycles += 2 + depth[i] + depth[neighbor];
                } else {
                    maxCycle = Math.max(maxCycle, cycleLen);
                }
            }
        }

        return Math.max(maxCycle, sum2Cycles);
    }
}
