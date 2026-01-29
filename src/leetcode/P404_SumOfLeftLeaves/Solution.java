package leetcode.P404_SumOfLeftLeaves;

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
     * Problem 404: Sum of Left Leaves
     * Approach: Recursive DFS
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(H)
     */
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }

    private int dfs(TreeNode node, boolean isLeft) {
        if (node == null)
            return 0;

        // Check if current node is a leaf
        if (node.left == null && node.right == null) {
            return isLeft ? node.val : 0;
        }

        // Explore left and right children
        return dfs(node.left, true) + dfs(node.right, false);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // root = [3,9,20,null,null,15,7] -> 24
        TreeNode root1 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        runTest(solution, root1, 24);

        // root = [1] -> 0
        TreeNode root2 = new TreeNode(1);
        runTest(solution, root2, 0);

        // root = [1, 2, 3, 4, 5] -> 4 (left leaf is 4)
        TreeNode root3 = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3));
        runTest(solution, root3, 4);
    }

    private static void runTest(TreeNode root, int expected) {
        // Overloaded runTest helper
    }

    private static void runTest(Solution sol, TreeNode root, int expected) {
        int result = sol.sumOfLeftLeaves(root);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
