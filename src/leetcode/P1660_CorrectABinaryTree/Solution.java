package leetcode.P1660_CorrectABinaryTree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public TreeNode correctBinaryTree(TreeNode root) {
        Queue<TreeNode[]> queue = new LinkedList<>(); // {node, parent}
        Set<TreeNode> visited = new HashSet<>();

        // Parent of root is null
        queue.offer(new TreeNode[] { root, null });
        visited.add(root);

        while (!queue.isEmpty()) {
            TreeNode[] curr = queue.poll();
            TreeNode node = curr[0];
            TreeNode parent = curr[1];

            // Check condition: node.right points to previously visited node
            // Note: We traverse Right-to-Left, so nodes to the right are in 'visited'.
            if (node.right != null && visited.contains(node.right)) {
                // 'node' is the invalid node to be deleted
                if (parent.left == node) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
                return root;
            }

            // Push Right first
            if (node.right != null) {
                visited.add(node.right);
                queue.offer(new TreeNode[] { node.right, node });
            }

            // Push Left second
            if (node.left != null) {
                visited.add(node.left);
                queue.offer(new TreeNode[] { node.left, node });
            }
        }

        return root;
    }
}
