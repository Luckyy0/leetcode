package leetcode.P337_HouseRobberIII;

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
     * Problem 337: House Robber III
     * Approach: Tree DP
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(H)
     */
    public int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

    // returns [rob, skip]
    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[] { 0, 0 };
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        // If we rob this node, we CANNOT rob children
        int rob = node.val + left[1] + right[1];

        // If we skip this node, we can rob or skip children (take max)
        int skip = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[] { rob, skip };
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [3,2,3,null,3,null,1] -> 7
        TreeNode root1 = new TreeNode(3,
                new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(3, null, new TreeNode(1)));
        runTest(solution, root1, 7);

        // [3,4,5,1,3,null,1] -> 9
        // 3
        // / \
        // 4 5
        // / \ \
        // 1 3 1
        // Rob 4+5 = 9. Max.
        // Rob 3+1+3+1 = 8.
        TreeNode root2 = new TreeNode(3,
                new TreeNode(4, new TreeNode(1), new TreeNode(3)),
                new TreeNode(5, null, new TreeNode(1)));
        runTest(solution, root2, 9);
    }

    private static void runTest(Solution s, TreeNode root, int expected) {
        int result = s.rob(root);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
