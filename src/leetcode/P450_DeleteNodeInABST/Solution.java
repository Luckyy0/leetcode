package leetcode.P450_DeleteNodeInABST;

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
     * Problem 450: Delete Node in a BST
     * Approach: Recursive removal with Successor replacement
     * 
     * Time Complexity: O(H) where H is tree height
     * Space Complexity: O(H)
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Found node to delete
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;

            // 2 children: find successor and swap
            TreeNode successor = findMin(root.right);
            root.val = successor.val;
            root.right = deleteNode(root.right, successor.val);
        }

        return root;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // [5,3,6,2,4,null,7], key = 3
        TreeNode root = new TreeNode(5,
                new TreeNode(3, new TreeNode(2), new TreeNode(4)),
                new TreeNode(6, null, new TreeNode(7)));

        TreeNode result = sol.deleteNode(root, 3);
        System.out.println("Root val: " + result.val);
        System.out.println("Left child of root: " + result.left.val); // Should be 2 or 4
    }
}
