package leetcode.P098_ValidateBinarySearchTree;

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
     * Problem 98: Validate Binary Search Tree
     * Approach: Recursive Range Validation
     * 
     * Theoretical Basis:
     * - BST property requires ALL nodes in left subtree < root < ALL nodes in right
     * subtree
     * - We propagate valid range (min, max) down the tree
     * - Going left: upper bound becomes current node's value
     * - Going right: lower bound becomes current node's value
     * 
     * Time Complexity: O(N) - visit each node once
     * Space Complexity: O(H) - recursion stack depth equals tree height
     */
    public boolean isValidBST(TreeNode root) {
        // Use Long to handle Integer.MIN_VALUE and Integer.MAX_VALUE edge cases
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {
        // Base case: null node is valid
        if (node == null) {
            return true;
        }

        // Check current node against valid range
        // Must be strictly greater than min and strictly less than max
        if (node.val <= min || node.val >= max) {
            return false;
        }

        // Recursively validate left subtree (upper bound becomes node.val)
        // and right subtree (lower bound becomes node.val)
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test 1: [2,1,3] -> true
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        runTest(solution, root1, true);

        // Test 2: [5,1,4,null,null,3,6] -> false
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);
        runTest(solution, root2, false);

        // Test 3: Single node -> true
        runTest(solution, new TreeNode(1), true);

        // Test 4: [5,4,6,null,null,3,7] -> false (3 is in right subtree but < 5)
        TreeNode root4 = new TreeNode(5);
        root4.left = new TreeNode(4);
        root4.right = new TreeNode(6);
        root4.right.left = new TreeNode(3);
        root4.right.right = new TreeNode(7);
        runTest(solution, root4, false);

        // Test 5: Integer boundary [Integer.MIN_VALUE] -> true
        runTest(solution, new TreeNode(Integer.MIN_VALUE), true);
    }

    private static void runTest(Solution s, TreeNode root, boolean expected) {
        boolean result = s.isValidBST(root);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
