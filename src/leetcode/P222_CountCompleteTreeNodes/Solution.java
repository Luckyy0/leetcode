package leetcode.P222_CountCompleteTreeNodes;

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
     * Problem 222: Count Complete Tree Nodes
     * Approach: Recursive Height Comparison
     * 
     * Theoretical Basis:
     * - Compare height of left and right subtrees.
     * - If heights match, left subtree is perfect.
     * - If heights differ, right subtree is perfect (one level less).
     * 
     * Time Complexity: O(log N * log N)
     * Space Complexity: O(log N)
     */
    public int countNodes(TreeNode root) {
        int h = height(root);
        if (h == 0)
            return 0; // Empty tree or null, usually 0

        // height of right subtree
        int hRight = height(root.right);

        // If right subtree height is h-1, it means left subtree is a full tree of
        // height h-1.
        // Total nodes = (root + left_subtree) + recursive_right
        // (1 << h) is actually 2^h, which accounts for root + (2^(h-1)-1 left nodes) ?
        // Actually:
        // Full tree of height H has 2^H - 1 nodes.
        // If height(right) == h - 1: Left is perfect height h-1. Nodes: (2^(h-1) - 1) +
        // 1 (root) + count(right)
        // = 2^(h-1) + count(right).
        // Note: My height function returns 1 for leaf. So if tree is just root, height
        // is 1.

        // Careful with height definition.
        // Let's say: height(null) = 0. height(leaf) = 1.
        // If root height is h.
        // If right height is h-1: Left is perfect with height h-1.
        // Nodes in Left + Root = (2^(h-1) - 1) + 1 = 2^(h-1).
        // Total = 2^(h-1) + countNodes(right).
        // If right height is < h-1 (must be h-2): Right is perfect with height h-2.
        // Nodes in Right + Root = (2^(h-2) - 1) + 1 = 2^(h-2).
        // Total = 2^(h-2) + countNodes(left).

        if (height(root.right) == h - 1) {
            return (1 << (h - 1)) + countNodes(root.right);
        } else {
            return (1 << (h - 2)) + countNodes(root.left);
        }
    }

    // Returns height of tree going purely left.
    private int height(TreeNode node) {
        if (node == null)
            return 0;
        return 1 + height(node.left);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [1,2,3,4,5,6] -> 6
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode n3 = new TreeNode(3, n6, null);
        TreeNode n1 = new TreeNode(1, n2, n3);

        System.out.println("Test 1: " + solution.countNodes(n1)); // 6

        // [] -> 0
        System.out.println("Test 2: " + solution.countNodes(null)); // 0

        // [1] -> 1
        System.out.println("Test 3: " + solution.countNodes(new TreeNode(1))); // 1
    }
}
