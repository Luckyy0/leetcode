package leetcode.P114_FlattenBinaryTreeToLinkedList;

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
     * Problem 114: Flatten Binary Tree to Linked List
     * Approach: Morris-like In-Place O(1) Space
     * 
     * Theoretical Basis:
     * - Flatten to preorder: Root -> Left -> Right
     * - For each node with left child:
     * 1. Find rightmost node in left subtree
     * 2. Connect it to current node's right child
     * 3. Move left subtree to right, set left to null
     * - This is essentially rewiring without extra space
     * 
     * Time Complexity: O(N) - each node visited at most twice
     * Space Complexity: O(1) - no extra space used
     */
    public void flatten(TreeNode root) {
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left != null) {
                // Find the rightmost node in the left subtree
                TreeNode rightmost = curr.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }

                // Connect rightmost to current's right subtree
                rightmost.right = curr.right;

                // Move left subtree to right
                curr.right = curr.left;
                curr.left = null;
            }

            // Move to next node (which is always to the right now)
            curr = curr.right;
        }
    }

    // Alternative: Recursive postorder-like approach
    private TreeNode prev = null;

    public void flattenRecursive(TreeNode root) {
        if (root == null)
            return;

        // Process right first, then left (reverse preorder)
        flattenRecursive(root.right);
        flattenRecursive(root.left);

        // Connect current to previously processed node
        root.right = prev;
        root.left = null;
        prev = root;
    }

    // Helper: print flattened list
    public static void printFlattened(TreeNode root) {
        System.out.print("[");
        while (root != null) {
            System.out.print(root.val);
            if (root.right != null)
                System.out.print(",");
            root = root.right;
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test 1: [1,2,5,3,4,null,6]
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        root1.right = new TreeNode(5, null, new TreeNode(6));
        solution.flatten(root1);
        System.out.print("Test 1: ");
        printFlattened(root1);
        System.out.println("-----------------");

        // Test 2: Empty tree
        TreeNode root2 = null;
        solution.flatten(root2);
        System.out.print("Test 2 (empty): ");
        printFlattened(root2);
        System.out.println("-----------------");

        // Test 3: Single node
        TreeNode root3 = new TreeNode(1);
        solution.flatten(root3);
        System.out.print("Test 3 (single): ");
        printFlattened(root3);
        System.out.println("-----------------");
    }
}
