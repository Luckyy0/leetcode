package leetcode.P108_ConvertSortedArrayToBinarySearchTree;

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
     * Problem 108: Convert Sorted Array to Binary Search Tree
     * Approach: Divide and Conquer (Recursion)
     * 
     * Theoretical Basis:
     * - Sorted array's middle element becomes root for balanced tree
     * - Left half becomes left subtree, right half becomes right subtree
     * - This is binary search applied to tree construction
     * - Guarantees height-balanced: subtree heights differ by at most 1
     * 
     * Time Complexity: O(N) - each element processed once
     * Space Complexity: O(log N) - recursion stack for balanced tree
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int left, int right) {
        // Base case: no elements in range
        if (left > right) {
            return null;
        }

        // Choose middle element as root
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        // Recursively build left subtree from left half
        root.left = build(nums, left, mid - 1);

        // Recursively build right subtree from right half
        root.right = build(nums, mid + 1, right);

        return root;
    }

    // Helper: print inorder to verify BST property
    public static void printInorder(TreeNode root) {
        if (root == null)
            return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    // Helper: calculate height
    public static int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    // Helper: check if balanced
    public static boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.abs(leftHeight - rightHeight) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test 1: [-10,-3,0,5,9]
        int[] nums1 = { -10, -3, 0, 5, 9 };
        TreeNode root1 = solution.sortedArrayToBST(nums1);
        System.out.print("Inorder: ");
        printInorder(root1);
        System.out.println();
        System.out.println("Height: " + getHeight(root1) + ", Balanced: " + isBalanced(root1));
        System.out.println("-----------------");

        // Test 2: [1,3]
        int[] nums2 = { 1, 3 };
        TreeNode root2 = solution.sortedArrayToBST(nums2);
        System.out.print("Inorder: ");
        printInorder(root2);
        System.out.println();
        System.out.println("Height: " + getHeight(root2) + ", Balanced: " + isBalanced(root2));
        System.out.println("-----------------");

        // Test 3: Single element
        int[] nums3 = { 5 };
        TreeNode root3 = solution.sortedArrayToBST(nums3);
        System.out.print("Inorder: ");
        printInorder(root3);
        System.out.println();
        System.out.println("Height: " + getHeight(root3) + ", Balanced: " + isBalanced(root3));
        System.out.println("-----------------");
    }
}
