package leetcode.P250_CountUnivalueSubtrees;

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
     * Problem 250: Count Univalue Subtrees
     * Approach: Bottom-up DFS
     * 
     * Theoretical Basis:
     * - A subtree is univalue if both children are univalue AND root value matches
     * children values.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(H)
     */

    private int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        count = 0;
        isUnival(root);
        return count;
    }

    private boolean isUnival(TreeNode node) {
        // Base case: null nodes are essentially "valid" placeholders
        if (node == null) {
            return true;
        }

        boolean leftUnival = isUnival(node.left);
        boolean rightUnival = isUnival(node.right);

        // If either child is NOT unival, this node cannot be unival root
        if (!leftUnival || !rightUnival) {
            return false;
        }

        // Check value consistency with children
        if (node.left != null && node.left.val != node.val) {
            return false;
        }
        if (node.right != null && node.right.val != node.val) {
            return false;
        }

        // Passed all checks
        count++;
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [5,1,5,5,5,null,5] -> 4
        TreeNode n5_leaf1 = new TreeNode(5);
        TreeNode n5_leaf2 = new TreeNode(5);
        TreeNode n5_leaf3 = new TreeNode(5);

        TreeNode n1 = new TreeNode(1, n5_leaf1, n5_leaf2);
        TreeNode n5_right = new TreeNode(5, null, n5_leaf3);
        TreeNode root = new TreeNode(5, n1, n5_right);

        runTest(solution, root, 4);

        // [5,5,5,5,5,null,5] -> 6
        // Reconstruct same structure but 1 -> 5
        TreeNode m5_leaf1 = new TreeNode(5);
        TreeNode m5_leaf2 = new TreeNode(5);
        TreeNode m5_leaf3 = new TreeNode(5);

        TreeNode m5_left = new TreeNode(5, m5_leaf1, m5_leaf2);
        TreeNode m5_right_node = new TreeNode(5, null, m5_leaf3);
        TreeNode root2 = new TreeNode(5, m5_left, m5_right_node);

        runTest(solution, root2, 6);
    }

    private static void runTest(Solution s, TreeNode root, int expected) {
        int result = s.countUnivalSubtrees(root);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
