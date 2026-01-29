package leetcode.P333_LargestBSTSubtree;

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
     * Problem 333: Largest BST Subtree
     * Approach: Post-order Traversal
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(H)
     */

    private int maxBstSize = 0;

    // State class
    private static class State {
        boolean isBST;
        int min;
        int max;
        int size;

        State(boolean is, int mn, int mx, int sz) {
            isBST = is;
            min = mn;
            max = mx;
            size = sz;
        }
    }

    public int largestBSTSubtree(TreeNode root) {
        maxBstSize = 0;
        dfs(root);
        return maxBstSize;
    }

    private State dfs(TreeNode node) {
        if (node == null) {
            return new State(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        State left = dfs(node.left);
        State right = dfs(node.right);

        if (left.isBST && right.isBST && node.val > left.max && node.val < right.min) {
            int size = left.size + right.size + 1;
            maxBstSize = Math.max(maxBstSize, size);

            int minVal = Math.min(node.val, left.min);
            int maxVal = Math.max(node.val, right.max);

            return new State(true, minVal, maxVal, size);
        } else {
            return new State(false, 0, 0, 0);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [10,5,15,1,8,null,7] -> 3
        TreeNode n1 = new TreeNode(1);
        TreeNode n8 = new TreeNode(8);
        TreeNode n5 = new TreeNode(5, n1, n8);
        TreeNode n7 = new TreeNode(7);
        TreeNode n15 = new TreeNode(15, null, n7);
        TreeNode root = new TreeNode(10, n5, n15);

        // 5 is BST (1 < 5 < 8). Size 3.
        // 15 is NOT BST (7 < 15, on right).
        // 10 is NOT BST.
        // Result 3.
        runTest(solution, root, 3);

        // [4,2,7,2,3,5,null,2,null,null,null,null,null,1] -> 2 ??
        // LeetCode Examples can be tricky.
    }

    private static void runTest(Solution s, TreeNode root, int expected) {
        // New instance
        s = new Solution();
        int result = s.largestBSTSubtree(root);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
