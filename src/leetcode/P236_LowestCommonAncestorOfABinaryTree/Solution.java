package leetcode.P236_LowestCommonAncestorOfABinaryTree;

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
     * Problem 236: Lowest Common Ancestor of a Binary Tree
     * Approach: Recursive DFS
     * 
     * Theoretical Basis:
     * - If root is p or q, root is a candidate ancestor.
     * - Look in left and right subtrees.
     * - If found in both, root is LCA. If found in one, bubble it up.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(H) recursion stack
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: null or found one of the nodes
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recurse left and right
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both return non-null, this node is the split point (LCA)
        if (left != null && right != null) {
            return root;
        }

        // Otherwise, return the non-null child (or null if both are null)
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [3,5,1,6,2,0,8,null,null,7,4], p=5, q=1 -> 3
        TreeNode n7 = new TreeNode(7);
        TreeNode n4 = new TreeNode(4);
        TreeNode n6 = new TreeNode(6);
        TreeNode n2 = new TreeNode(2, n7, n4);
        TreeNode n0 = new TreeNode(0);
        TreeNode n8 = new TreeNode(8);
        TreeNode n5 = new TreeNode(5, n6, n2);
        TreeNode n1 = new TreeNode(1, n0, n8);
        TreeNode root = new TreeNode(3, n5, n1);

        TreeNode lca1 = solution.lowestCommonAncestor(root, n5, n1);
        System.out.println("LCA(5, 1): " + (lca1 != null ? lca1.val : "null") + " (Expected: 3)");

        // p=5, q=4 -> 5
        TreeNode lca2 = solution.lowestCommonAncestor(root, n5, n4);
        System.out.println("LCA(5, 4): " + (lca2 != null ? lca2.val : "null") + " (Expected: 5)");
    }
}
