package leetcode.P235_LowestCommonAncestorOfABST;

public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Problem 235: Lowest Common Ancestor of a Binary Search Tree
     * Approach: Iterative BST Traversal
     * 
     * Theoretical Basis:
     * - Use BST property: if both values are smaller, go left. If both larger, go
     * right.
     * - Else, current is the split point (LCA).
     * 
     * Time Complexity: O(H) where H is tree height
     * Space Complexity: O(1)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode output = root;

        while (output != null) {
            if (p.val < output.val && q.val < output.val) {
                // Both in left subtree
                output = output.left;
            } else if (p.val > output.val && q.val > output.val) {
                // Both in right subtree
                output = output.right;
            } else {
                // Split point found (or one equals current)
                return output;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [6,2,8,0,4,7,9,null,null,3,5], p=2, q=8 -> 6
        TreeNode n0 = new TreeNode(0);
        TreeNode n3 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);
        TreeNode n4 = new TreeNode(4, n3, n5);
        TreeNode n2 = new TreeNode(2, n0, n4); // p
        TreeNode n7 = new TreeNode(7);
        TreeNode n9 = new TreeNode(9);
        TreeNode n8 = new TreeNode(8, n7, n9); // q
        TreeNode root = new TreeNode(6, n2, n8);

        TreeNode lca1 = solution.lowestCommonAncestor(root, n2, n8);
        System.out.println("LCA(2, 8): " + (lca1 != null ? lca1.val : "null") + " (Expected: 6)");

        // p=2, q=4 -> 2
        TreeNode lca2 = solution.lowestCommonAncestor(root, n2, n4);
        System.out.println("LCA(2, 4): " + (lca2 != null ? lca2.val : "null") + " (Expected: 2)");
    }
}
