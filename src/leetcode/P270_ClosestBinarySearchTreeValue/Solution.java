package leetcode.P270_ClosestBinarySearchTreeValue;

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
     * Problem 270: Closest Binary Search Tree Value
     * Approach: Iterative BST Search
     * 
     * Theoretical Basis:
     * - Utilize BST property to discard half the tree at each step.
     * 
     * Time Complexity: O(H)
     * Space Complexity: O(1)
     */
    public int closestValue(TreeNode root, double target) {
        int closest = root.val;
        TreeNode current = root;

        while (current != null) {
            // Update closest if current node is closer
            if (Math.abs(current.val - target) < Math.abs(closest - target)) {
                closest = current.val;
            } else if (Math.abs(current.val - target) == Math.abs(closest - target)) {
                // If distances are equal, pick smaller value?
                // Problem doesn't specify sort order preference, usually any is fine.
                // But typically assume consistent choice.
            }

            // Navigate
            if (target < current.val) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return closest;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [4,2,5,1,3], target=3.714286 -> 4
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2, n1, n3);
        TreeNode n5 = new TreeNode(5);
        TreeNode root = new TreeNode(4, n2, n5);

        runTest(solution, root, 3.714286, 4);

        // [1], target=4.4 -> 1
        runTest(solution, new TreeNode(1), 4.428571, 1);
    }

    private static void runTest(Solution s, TreeNode root, double target, int expected) {
        int result = s.closestValue(root, target);
        System.out.println("Target: " + target + " -> Result: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
