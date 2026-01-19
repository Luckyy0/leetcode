package leetcode.P298_BinaryTreeLongestConsecutiveSequence;

public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int x, TreeNode left, TreeNode right) {
            val = x;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Problem 298: Binary Tree Longest Consecutive Sequence
     * Approach: DFS Top-Down
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(H)
     */

    private int maxLength = 0;

    public int longestConsecutive(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root, 0, 0); // initial parentVal doesn't matter as length is 1 initially
        return maxLength;
    }

    private void dfs(TreeNode node, int parentVal, int length) {
        if (node == null)
            return;

        // Check if consecutive
        if (node.val == parentVal + 1) {
            length++;
        } else {
            length = 1;
        }

        maxLength = Math.max(maxLength, length);

        dfs(node.left, node.val, length);
        dfs(node.right, node.val, length);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [1, null, 3, 2, 4, null, null, null, 5]
        /*
         * 1
         * \
         * 3
         * / \
         * 2 4
         * \
         * 5
         */
        // 3-4-5 is length 3.
        TreeNode n5 = new TreeNode(5);
        TreeNode n4 = new TreeNode(4, null, n5);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3, n2, n4);
        TreeNode root = new TreeNode(1, null, n3);

        runTest(solution, root, 3);

        // [2, null, 3, 2, null, 1]
        // 2-3 is len 2.
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2, t1, null);
        TreeNode t3 = new TreeNode(3, t2, null);
        TreeNode root2 = new TreeNode(2, null, t3);
        // Wait, structure:
        // 2
        // \
        // 3
        // /
        // 2
        // /
        // 1
        // Path 2-3 (len 2). Path 3-2-1 (len 1,1,1).

        runTest(solution, root2, 2);
    }

    private static void runTest(Solution s, TreeNode root, int expected) {
        // Reset state
        s = new Solution();
        int result = s.longestConsecutive(root);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
