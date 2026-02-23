package leet_code.Problem_236_Medium_Lowest_Common_Ancestor_Of_A_Binary_Tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution_Recursion {

    /**
     * Finds the Lowest Common Ancestor in a Binary Tree.
     * Uses DFS recursion.
     * Time: O(N), Space: O(H).
     * 
     * Tìm Tổ tiên chung thấp nhất trong Cây nhị phân.
     * Sử dụng đệ quy DFS.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if root is null or we found one of the nodes
        // Trường hợp cơ sở: nếu root là null hoặc tìm thấy một trong các nút
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recurse left and right
        // Đệ quy trái và phải
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both left and right return a node, it means p and q are on different sides
        // So root is the LCA
        // Nếu cả trái và phải đều trả về một nút, nghĩa là p và q ở hai phía khác nhau
        // Vậy root là LCA
        if (left != null && right != null) {
            return root;
        }

        // Otherwise return the non-null child (propagate the found node up)
        // Ngược lại trả về con không null (lan truyền nút tìm thấy lên trên)
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        Solution_Recursion solution = new Solution_Recursion();

        // Test Case 1: LCA of 5 and 1 via 3
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root.left; // 5
        TreeNode q = root.right; // 1

        TreeNode lca = solution.lowestCommonAncestor(root, p, q);
        System.out.println("LCA(5, 1): " + (lca != null ? lca.val : "null")); // 3

        // Test Case 2: LCA of 5 and 4 via 5
        q = root.left.right.right; // 4
        lca = solution.lowestCommonAncestor(root, p, q);
        System.out.println("LCA(5, 4): " + (lca != null ? lca.val : "null")); // 5
    }
}
