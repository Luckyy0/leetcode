package leet_code.Problem_104_Easy_Maximum_Depth_Of_Binary_Tree;

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
     * Calculates the maximum depth of a binary tree.
     * Uses a simple recursive bottom-up approach.
     * Tính chiều sâu tối đa của một cây nhị phân.
     * Sử dụng phương pháp đệ quy từ dưới lên đơn giản.
     */
    public int maxDepth(TreeNode root) {
        // Base case: null node has depth 0
        // Trường hợp cơ sở: nút null có chiều sâu 0
        if (root == null) {
            return 0;
        }

        // Recursively find depth of left and right subtrees
        // Tìm đệ quy chiều sâu của các cây con bên trái và bên phải
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // Max depth is 1 (for current node) plus the max of the two subtrees
        // Chiều sâu tối đa là 1 (cho nút hiện tại) cộng với giá trị lớn nhất của hai
        // cây con
        return 1 + Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        Solution_Recursive solution = new Solution_Recursive();

        // Test Case 1: [3,9,20,null,null,15,7]
        TreeNode t1 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println("Test Case 1: " + solution.maxDepth(t1));
        // Expected: 3

        // Test Case 2: [1,null,2]
        TreeNode t2 = new TreeNode(1, null, new TreeNode(2));
        System.out.println("Test Case 2: " + solution.maxDepth(t2));
        // Expected: 2
    }
}
