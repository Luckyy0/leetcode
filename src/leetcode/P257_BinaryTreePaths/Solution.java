package leetcode.P257_BinaryTreePaths;

import java.util.ArrayList;
import java.util.List;

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
     * Problem 257: Binary Tree Paths
     * Approach: Recursive DFS
     * 
     * Theoretical Basis:
     * - Accumulate path string.
     * - Add to result at leaves.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(H) recursion
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null) {
            dfs(root, "", result);
        }
        return result;
    }

    private void dfs(TreeNode node, String currentPath, List<String> result) {
        // Append current val
        currentPath += node.val;

        // Check leaf
        if (node.left == null && node.right == null) {
            result.add(currentPath);
            return;
        }

        // Recurse
        if (node.left != null) {
            dfs(node.left, currentPath + "->", result);
        }
        if (node.right != null) {
            dfs(node.right, currentPath + "->", result);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [1,2,3,null,5] -> ["1->2->5", "1->3"]
        TreeNode n5 = new TreeNode(5);
        TreeNode n2 = new TreeNode(2, null, n5);
        TreeNode n3 = new TreeNode(3);
        TreeNode root = new TreeNode(1, n2, n3);

        List<String> paths = solution.binaryTreePaths(root);
        System.out.println("Paths: " + paths);
        // Expected: [1->2->5, 1->3] (Order usually left then right)

        // [1] -> ["1"]
        System.out.println("Single Node: " + solution.binaryTreePaths(new TreeNode(1)));
    }
}
