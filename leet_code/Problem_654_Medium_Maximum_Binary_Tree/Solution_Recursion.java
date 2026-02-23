package leet_code.Problem_654_Medium_Maximum_Binary_Tree;

/**
 * Definition for a binary tree node.
 */
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

public class Solution_Recursion {

    /**
     * Constructs a maximum binary tree from an array.
     * Strategy: Recursively find maximum for root and split the array.
     * Time: O(N^2) worst, Space: O(N).
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int left, int right) {
        if (left > right)
            return null;

        // Find index of the maximum value in current range
        int maxIdx = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }

        // Create root and recursively build subtrees
        TreeNode root = new TreeNode(nums[maxIdx]);
        root.left = build(nums, left, maxIdx - 1);
        root.right = build(nums, maxIdx + 1, right);

        return root;
    }

    public static void main(String[] args) {
        Solution_Recursion sol = new Solution_Recursion();
        int[] nums = { 3, 2, 1, 6, 0, 5 };
        TreeNode root = sol.constructMaximumBinaryTree(nums);
        System.out.println("Root value: " + root.val); // Should be 6
    }
}
