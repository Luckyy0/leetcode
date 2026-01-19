package leetcode.P226_InvertBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static class TreeNode {
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

    /**
     * Problem 226: Invert Binary Tree
     * Approach: Recursive DFS
     * 
     * Theoretical Basis:
     * - Swap left and right children.
     * - Repeat recursively.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(H) recursion stack
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // Swap
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recurse
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [4,2,7,1,3,6,9] -> [4,7,2,9,6,3,1]
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        TreeNode n6 = new TreeNode(6);
        TreeNode n9 = new TreeNode(9);
        TreeNode n2 = new TreeNode(2, n1, n3);
        TreeNode n7 = new TreeNode(7, n6, n9);
        TreeNode root = new TreeNode(4, n2, n7);

        System.out.print("Original Level Order: ");
        printLevelOrder(root);

        TreeNode inverted = solution.invertTree(root);

        System.out.print("Inverted Level Order: ");
        printLevelOrder(inverted);
    }

    private static void printLevelOrder(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        System.out.print("[");
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            System.out.print(curr.val + " ");
            if (curr.left != null)
                q.offer(curr.left);
            if (curr.right != null)
                q.offer(curr.right);
        }
        System.out.println("]");
    }
}
