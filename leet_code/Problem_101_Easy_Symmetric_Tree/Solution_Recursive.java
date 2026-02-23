package leet_code.Problem_101_Easy_Symmetric_Tree;

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

public class Solution_Recursive {

    /**
     * Checks if a binary tree is symmetric (mirror of itself).
     * Uses a recursive approach to compare subtrees.
     * Kiểm tra xem một cây nhị phân có đối xứng không (là bản sao gương của chính
     * nó).
     * Sử dụng phương pháp đệ quy để so sánh các cây con.
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        // If both nodes are null, they are mirror symmetric
        // Nếu cả hai nút đều null, chúng đối xứng gương
        if (t1 == null && t2 == null) {
            return true;
        }

        // If only one is null or values are different, not symmetric
        // Nếu chỉ một nút null hoặc giá trị khác nhau, không đối xứng
        if (t1 == null || t2 == null || t1.val != t2.val) {
            return false;
        }

        // Compare the children in mirror fashion:
        // Left child of t1 matches Right child of t2
        // Right child of t1 matches Left child of t2
        // So sánh các nút con theo kiểu gương:
        // Con bên trái của t1 khớp với con bên phải của t2
        // Con bên phải của t1 khớp với con bên trái của t2
        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    public static void main(String[] args) {
        Solution_Recursive solution = new Solution_Recursive();

        // Test Case 1: [1,2,2,3,4,4,3]
        TreeNode t1 = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        System.out.println("Test Case 1: " + solution.isSymmetric(t1));
        // Expected: true

        // Test Case 2: [1,2,2,null,3,null,3]
        TreeNode t2 = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(2, null, new TreeNode(3)));
        System.out.println("Test Case 2: " + solution.isSymmetric(t2));
        // Expected: false
    }
}
