package leet_code.Problem_285_Medium_Inorder_Successor_In_BST;

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
     * Finds the inorder successor of a node in BST.
     * Uses Iterative BST Search.
     * Time: O(H), Space: O(1).
     * 
     * Tìm người kế vị inorder của một nút trong BST.
     * Sử dụng Tìm kiếm BST Lặp.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;

        while (root != null) {
            if (p.val >= root.val) {
                // p is in the right side (or is root), successor must be further right
                // p nằm bên phải (hoặc là root), người kế vị phải nằm xa hơn về bên phải
                root = root.right;
            } else {
                // root is larger than p, so root is a potential successor
                // Try to find a smaller valid successor in the left subtree
                // root lớn hơn p, nên root là người kế vị tiềm năng
                // Thử tìm người kế vị nhỏ hơn hợp lệ trong cây con bên trái
                successor = root;
                root = root.left;
            }
        }

        return successor;
    }

    public static void main(String[] args) {
        Solution_BST solution = new Solution_BST();

        // Test Case 1: [2,1,3], p=1 -> 2
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println("Successor 1: " + solution.inorderSuccessor(root, root.left).val);
    }
}
