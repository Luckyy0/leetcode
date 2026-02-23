package leet_code.Problem_235_Medium_Lowest_Common_Ancestor_Of_A_Binary_Search_Tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution_BST {

    /**
     * Finds the Lowest Common Ancestor in a BST.
     * Uses the BST property to navigate down the tree.
     * Time: O(H), Space: O(1).
     * 
     * Tìm Tổ tiên chung thấp nhất trong BST.
     * Sử dụng tính chất BST để điều hướng xuống cây.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;

        while (curr != null) {
            // If both p and q are greater than curr, LCA is in the right subtree
            // Nếu cả p và q đều lớn hơn curr, LCA nằm ở cây con phải
            if (p.val > curr.val && q.val > curr.val) {
                curr = curr.right;
            }
            // If both p and q are smaller than curr, LCA is in the left subtree
            // Nếu cả p và q đều nhỏ hơn curr, LCA nằm ở cây con trái
            else if (p.val < curr.val && q.val < curr.val) {
                curr = curr.left;
            }
            // If we are at the split point (one is smaller/equal, one is larger/equal)
            // or if we match one of the nodes, then this is the LCA
            // Nếu ta ở điểm phân tách hoặc khớp với một trong hai nút, thì đây là LCA
            else {
                return curr;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Solution_BST solution = new Solution_BST();

        // Test Case 1: LCA of 2 and 8 in [6,2,8...]
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);

        TreeNode p = root.left; // 2
        TreeNode q = root.right; // 8

        TreeNode lca = solution.lowestCommonAncestor(root, p, q);
        System.out.println("LCA(2, 8): " + (lca != null ? lca.val : "null")); // 6

        // Test Case 2: LCA of 2 and 4
        q = root.left.right; // 4
        lca = solution.lowestCommonAncestor(root, p, q);
        System.out.println("LCA(2, 4): " + (lca != null ? lca.val : "null")); // 2
    }
}
