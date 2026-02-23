package leet_code.Problem_863_Medium_All_Nodes_Distance_K_in_Binary_Tree;

import java.util.*;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * Problem 863: All Nodes Distance K in Binary Tree
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 */
public class Solution {

    /**
     * Finds all nodes at distance K from target node.
     * Strategy: Build parent pointers to treat tree as an undirected graph,
     * then perform BFS starting from the target.
     * 
     * @param root   The binary tree root.
     * @param target The starting node.
     * @param k      Distance.
     * @return List of node values at distance k.
     * 
     *         Tóm tắt chiến lược:
     *         Vì trong cây chỉ đi xuống được, chúng ta cần dùng DFS để tạo một bản
     *         đồ
     *         lưu nút cha của mỗi nút. Sau đó, ta dùng BFS bắt đầu từ nút target để
     *         đi theo 3 hướng: trái, phải, và lên trên (cha). Sau k bước BFS, các
     *         nút
     *         trong hàng đợi chính là kết quả.
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // Map to store parent of each node
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        findParents(root, null, parents);

        // BFS queue and visited set
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.offer(target);
        visited.add(target);

        int currentDistance = 0;
        while (!queue.isEmpty()) {
            if (currentDistance == k) {
                List<Integer> result = new ArrayList<>();
                for (TreeNode node : queue) {
                    result.add(node.val);
                }
                return result;
            }

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                // Explore neighbors: Left, Right, Parent
                if (curr.left != null && !visited.contains(curr.left)) {
                    visited.add(curr.left);
                    queue.offer(curr.left);
                }
                if (curr.right != null && !visited.contains(curr.right)) {
                    visited.add(curr.right);
                    queue.offer(curr.right);
                }
                TreeNode p = parents.get(curr);
                if (p != null && !visited.contains(p)) {
                    visited.add(p);
                    queue.offer(p);
                }
            }
            currentDistance++;
        }

        return new ArrayList<>();
    }

    private void findParents(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parents) {
        if (node == null)
            return;
        parents.put(node, parent);
        findParents(node.left, node, parents);
        findParents(node.right, node, parents);
    }
}
