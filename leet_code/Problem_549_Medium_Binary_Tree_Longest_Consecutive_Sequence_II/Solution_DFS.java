package leet_code.Problem_549_Medium_Binary_Tree_Longest_Consecutive_Sequence_II;

// Definition for a binary tree node.
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

public class Solution_DFS {

    private int maxLen = 0;

    /**
     * Finds the length of the longest consecutive path.
     * Strategy: DFS returning [increasing_path_len, decreasing_path_len].
     * Time: O(N), Space: O(H).
     */
    public int longestConsecutive(TreeNode root) {
        maxLen = 0;
        dfs(root);
        return maxLen;
    }

    private int[] dfs(TreeNode node) {
        if (node == null)
            return new int[] { 0, 0 };

        int inc = 1;
        int dec = 1;

        if (node.left != null) {
            int[] left = dfs(node.left);
            if (node.val == node.left.val + 1) {
                dec = Math.max(dec, left[1] + 1);
            } else if (node.val == node.left.val - 1) {
                inc = Math.max(inc, left[0] + 1);
            }
        }

        if (node.right != null) {
            int[] right = dfs(node.right);
            if (node.val == node.right.val + 1) {
                dec = Math.max(dec, right[1] + 1);
            } else if (node.val == node.right.val - 1) {
                inc = Math.max(inc, right[0] + 1);
            }
        }

        maxLen = Math.max(maxLen, inc + dec - 1);
        return new int[] { inc, dec };
    }

    public static void main(String[] args) {
        Solution_DFS sol = new Solution_DFS();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println("Longest consecutive: " + sol.longestConsecutive(root)); // Output: 3
    }
}
