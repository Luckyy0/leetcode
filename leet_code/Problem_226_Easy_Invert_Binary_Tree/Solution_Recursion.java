package leet_code.Problem_226_Easy_Invert_Binary_Tree;

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
     * Inverts a binary tree.
     * Uses DFS recursion.
     * Time: O(N), Space: O(H).
     * 
     * Đảo ngược cây nhị phân.
     * Sử dụng đệ quy DFS.
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // Swap left and right children
        // Hoán đổi con trái và phải
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively invert subtrees
        // Đệ quy đảo ngược các cây con
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static void main(String[] args) {
        Solution_Recursion solution = new Solution_Recursion();

        // Test Case: [4,2,7,1,3,6,9]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode inverted = solution.invertTree(root);
        System.out.println("Root: " + inverted.val); // 4
        System.out.println("Left: " + inverted.left.val); // 7
        System.out.println("Right: " + inverted.right.val); // 2
    }
}
