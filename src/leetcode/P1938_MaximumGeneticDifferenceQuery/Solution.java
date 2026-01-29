package leetcode.P1938_MaximumGeneticDifferenceQuery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[2];
        int count = 0; // Number of values passing through this node
    }

    TrieNode rootTrie;
    List<Integer>[] adj;
    List<int[]>[] queriesByNode;
    int[] ans;

    public int[] maxGeneticDifference(int[] parents, int[][] queries) {
        int n = parents.length;
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (parents[i] == -1)
                root = i;
            else
                adj[parents[i]].add(i);
        }

        queriesByNode = new ArrayList[n];
        for (int i = 0; i < n; i++)
            queriesByNode[i] = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            queriesByNode[queries[i][0]].add(new int[] { queries[i][1], i });
        }

        ans = new int[queries.length];
        rootTrie = new TrieNode();

        dfs(root);

        return ans;
    }

    private void dfs(int u) {
        insert(u);

        for (int[] q : queriesByNode[u]) {
            ans[q[1]] = getMaxXor(q[0]);
        }

        for (int v : adj[u]) {
            dfs(v);
        }

        remove(u);
    }

    private void insert(int val) {
        TrieNode curr = rootTrie;
        for (int i = 17; i >= 0; i--) {
            int bit = (val >> i) & 1;
            if (curr.children[bit] == null)
                curr.children[bit] = new TrieNode();
            curr = curr.children[bit];
            curr.count++;
        }
    }

    private void remove(int val) {
        TrieNode curr = rootTrie;
        for (int i = 17; i >= 0; i--) {
            int bit = (val >> i) & 1;
            curr = curr.children[bit];
            curr.count--;
        }
        // Could prune empty nodes, but count logic sufficient
    }

    private int getMaxXor(int val) {
        TrieNode curr = rootTrie;
        int maxXor = 0;
        for (int i = 17; i >= 0; i--) {
            int bit = (val >> i) & 1;
            int desired = 1 - bit;

            if (curr.children[desired] != null && curr.children[desired].count > 0) {
                maxXor |= (1 << i);
                curr = curr.children[desired];
            } else {
                curr = curr.children[bit];
            }
        }
        return maxXor;
    }
}
