package leet_code.Problem_617_Easy_Merge_Two_Binary_Trees;

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
     * Merges two binary trees into one.
     * Strategy: Recursive preorder traversal.
     * Time: O(min(N, M)), Space: O(min(H1, H2)).
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // Base cases: if one tree is null, return the other
        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;

        // Sum the overlapping values
        TreeNode merged = new TreeNode(root1.val + root2.val);

        // Recursively merge subtrees
        merged.left = mergeTrees(root1.left, root2.left);
        merged.right = mergeTrees(root1.right, root2.right);

        return merged;
    }

    public static void main(String[] args) {
        Solution_Recursion solution = new Solution_Recursion();
        TreeNode t1 = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2));
        TreeNode t2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(7)));

        TreeNode result = solution.mergeTrees(t1, t2);
        System.out.println("Merged Root Val: " + result.val); // 3
    }
}
