package leetcode.P742_ClosestLeafInABinaryTree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        TreeNode kNode = null;

        // Build the undirected graph
        // Xây dựng đồ thị vô hướng
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.val == k)
                kNode = node;

            if (node.left != null) {
                addEdge(graph, node, node.left);
                q.add(node.left);
            }
            if (node.right != null) {
                addEdge(graph, node, node.right);
                q.add(node.right);
            }
        }

        // BFS to find the nearest leaf
        // BFS để tìm lá gần nhất
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(kNode);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(kNode);

        while (!bfsQueue.isEmpty()) {
            TreeNode curr = bfsQueue.poll();
            // Check if leaf
            if (curr.left == null && curr.right == null)
                return curr.val;

            for (TreeNode neighbor : graph.getOrDefault(curr, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    bfsQueue.add(neighbor);
                }
            }
        }
        return -1;
    }

    private void addEdge(Map<TreeNode, List<TreeNode>> graph, TreeNode u, TreeNode v) {
        graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }
}
