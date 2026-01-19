package leetcode.P094_BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
     * Problem 94: Binary Tree Inorder Traversal
     * Approach: Iterative (Stack)
     * Time Complexity: O(N)
     * Space Complexity: O(H)
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // Push all left nodes
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // Pop and visit
            curr = stack.pop();
            result.add(curr.val);

            // Move right
            curr = curr.right;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 1, null, 2, 3
        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(3);

        runTest(solution, root1, 3);
        runTest(solution, null, 0);
        runTest(solution, new TreeNode(1), 1);
    }

    private static void runTest(Solution s, TreeNode root, int expectedCount) {
        List<Integer> result = s.inorderTraversal(root);
        System.out.println("Output count: " + result.size() + " (Expected: " + expectedCount + ")");
        System.out.println("Result: " + result);

        if (result.size() == expectedCount) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
