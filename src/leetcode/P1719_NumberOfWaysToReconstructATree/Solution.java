package leetcode.P1719_NumberOfWaysToReconstructATree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public int checkWays(int[][] pairs) {
        Set<Integer>[] adj = new Set[505];
        for (int[] p : pairs) {
            if (adj[p[0]] == null)
                adj[p[0]] = new HashSet<>();
            if (adj[p[1]] == null)
                adj[p[1]] = new HashSet<>();
            adj[p[0]].add(p[1]);
            adj[p[1]].add(p[0]);
        }

        List<Integer> nodes = new ArrayList<>();
        for (int i = 1; i <= 500; i++) {
            if (adj[i] != null) {
                nodes.add(i);
                adj[i].add(i); // Add self for easier subset check (optional, but consistent)
            }
        }

        nodes.sort((a, b) -> adj[b].size() - adj[a].size());

        int n = nodes.size();
        boolean multiple = false;

        // Root must connect to everything
        if (adj[nodes.get(0)].size() != n)
            return 0;

        for (int i = 0; i < n; i++) {
            int u = nodes.get(i);
            // Search for parent
            int p = -1;
            int minDeg = Integer.MAX_VALUE;

            // Look for neighbor with smallest degree greater/equal to u
            // Because nodes are sorted descending, ancestors are to the left (0 to i-1)
            for (int k = i - 1; k >= 0; k--) {
                int v = nodes.get(k);
                if (adj[u].contains(v)) {
                    if (adj[v].size() < minDeg) {
                        minDeg = adj[v].size();
                        p = v;
                    }
                }
            }

            if (p == -1) {
                if (i != 0)
                    return 0; // Only root has no parent
                continue;
            }

            // Check subset
            for (int neighbor : adj[u]) {
                if (!adj[p].contains(neighbor))
                    return 0;
            }

            if (adj[u].size() == adj[p].size())
                multiple = true;
        }

        return multiple ? 2 : 1;
    }
}
