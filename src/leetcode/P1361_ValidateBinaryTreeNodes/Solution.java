package leetcode.P1361_ValidateBinaryTreeNodes;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] inDegree = new int[n];

        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                inDegree[leftChild[i]]++;
                if (inDegree[leftChild[i]] > 1)
                    return false;
            }
            if (rightChild[i] != -1) {
                inDegree[rightChild[i]]++;
                if (inDegree[rightChild[i]] > 1)
                    return false;
            }
        }

        int root = -1;
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                if (root != -1)
                    return false; // Multiple roots
                root = i;
            }
        }

        if (root == -1)
            return false; // No root (cycle)

        // Connectivity Check
        int visitedCount = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(root);
        visitedCount++;
        boolean[] visited = new boolean[n];
        visited[root] = true;

        while (!q.isEmpty()) {
            int u = q.poll();

            int[] children = { leftChild[u], rightChild[u] };
            for (int v : children) {
                if (v != -1) {
                    if (visited[v])
                        return false; // Cycle detected during traversal
                    visited[v] = true;
                    visitedCount++;
                    q.offer(v);
                }
            }
        }

        return visitedCount == n;
    }
}
