package leet_code.Problem_701_Medium_Insert_into_a_Binary_Search_Tree;

/**
 * Definition for a binary tree node.
 */
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

    /**
     * Inserts a value into a BST and returns the root.
     * Strategy: Recursive descent until a null leaf position is found.
     * Time: O(H), Space: O(H).
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val > root.val) {
            // New value is larger, go right
            root.right = insertIntoBST(root.right, val);
        } else {
            // New value is smaller, go left
            root.left = insertIntoBST(root.left, val);
        }

        return root;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7));
        TreeNode result = sol.insertIntoBST(root, 5);
        // Result should have 5 as the left child of 7
        System.out.println("Root: " + result.val);
        System.out.println("7's left child: " + result.right.left.val); // 5
    }
}
