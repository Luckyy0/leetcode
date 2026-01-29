package leetcode.P1766_TreeOfCoprimes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private List<Integer>[] adj;
    private List<Integer>[] coprimes;
    private int[] result;
    // path[val] stores {depth, nodeId}
    // Since we only care about the DEEPEST ancestor, and we traverse DFS,
    // the value "closest" is effectively the one we saw most recently?
    // Wait, on the path, the deepest one is the current stack top.
    // However, for each value v, there might be multiple nodes. We only need the
    // deepest one.
    // Since we push to stack as we go deeper, the top of stack IS the deepest.
    // So pos[v] can just be a list acting as stack.

    // Using simple stack logic
    private List<int[]>[] pathStacks;

    public int[] getCoprimes(int[] nums, int[][] edges) {
        int n = nums.length;
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        // Precompute coprimes
        coprimes = new ArrayList[51];
        for (int i = 1; i <= 50; i++) {
            coprimes[i] = new ArrayList<>();
            for (int j = 1; j <= 50; j++) {
                if (gcd(i, j) == 1)
                    coprimes[i].add(j);
            }
        }

        pathStacks = new ArrayList[51];
        for (int i = 1; i <= 50; i++)
            pathStacks[i] = new ArrayList<>();

        result = new int[n];
        Arrays.fill(result, -1);

        dfs(0, -1, 0, nums);

        return result;
    }

    private void dfs(int u, int p, int depth, int[] nums) {
        int val = nums[u];

        // Find closest ancestor
        int maxDepth = -1;
        int bestId = -1;

        for (int coprimeVal : coprimes[val]) {
            List<int[]> stack = pathStacks[coprimeVal];
            if (!stack.isEmpty()) {
                int[] top = stack.get(stack.size() - 1);
                if (top[0] > maxDepth) {
                    maxDepth = top[0];
                    bestId = top[1];
                }
            }
        }
        result[u] = bestId;

        // Push current
        pathStacks[val].add(new int[] { depth, u });

        for (int v : adj[u]) {
            if (v != p) {
                dfs(v, u, depth + 1, nums);
            }
        }

        // Pop (Backtrack)
        pathStacks[val].remove(pathStacks[val].size() - 1);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
