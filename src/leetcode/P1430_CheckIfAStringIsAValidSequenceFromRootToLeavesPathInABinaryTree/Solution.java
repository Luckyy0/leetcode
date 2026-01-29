package leetcode.P1430_CheckIfAStringIsAValidSequenceFromRootToLeavesPathInABinaryTree;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return dfs(root, arr, 0);
    }

    private boolean dfs(TreeNode node, int[] arr, int index) {
        if (node == null || index >= arr.length || node.val != arr[index]) {
            return false;
        }

        if (index == arr.length - 1) {
            return node.left == null && node.right == null;
        }

        return dfs(node.left, arr, index + 1) || dfs(node.right, arr, index + 1);
    }
}
