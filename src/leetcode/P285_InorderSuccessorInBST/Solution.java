package leetcode.P285_InorderSuccessorInBST;

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
     * Problem 285: Inorder Successor in BST
     * Approach: BST Traversal
     * 
     * Theoretical Basis:
     * - If node.val > p.val, node is a candidate. Move left to find smaller
     * candidate.
     * - If node.val <= p.val, node is too small. Move right.
     * 
     * Time Complexity: O(H)
     * Space Complexity: O(1)
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        TreeNode current = root;

        while (current != null) {
            if (current.val > p.val) {
                // Current is larger than p, potentially the successor.
                // Try to find a smaller one in the left subtree.
                successor = current;
                current = current.left;
            } else {
                // Current is smaller or equal to p, cannot be successor.
                // Go right to find larger values.
                current = current.right;
            }
        }

        return successor;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [2,1,3], p=1 -> 2
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2, n1, n3);

        runTest(solution, n2, n1, 2);

        // [5,3,6,2,4,null,null,1], p=6 -> null
        // 5
        // / \
        // 3 6
        // / \
        // 2 4
        // /
        // 1
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2, t1, null);
        TreeNode t4 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3, t2, t4);
        TreeNode t6 = new TreeNode(6);
        TreeNode t5 = new TreeNode(5, t3, t6);

        runTest(solution, t5, t6, null); // 6 has no successor
    }

    private static void runTest(Solution s, TreeNode root, TreeNode p, Integer expectedVal) {
        TreeNode result = s.inorderSuccessor(root, p);
        Integer resVal = (result == null) ? null : result.val;

        System.out.println("P: " + p.val + " -> Result: " + resVal + " (Expected: " + expectedVal + ")");

        if (check(resVal, expectedVal)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }

    private static boolean check(Integer a, Integer b) {
        if (a == null && b == null)
            return true;
        if (a == null || b == null)
            return false;
        return a.equals(b);
    }
}
