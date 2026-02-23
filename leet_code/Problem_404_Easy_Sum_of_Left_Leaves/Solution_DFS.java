package leet_code.Problem_404_Easy_Sum_of_Left_Leaves;

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

public class Solution_DFS {

    /**
     * Calculates the sum of all left leaves.
     * Use DFS with a flag to identify left children.
     * Time: O(N), Space: O(H).
     * 
     * Tính tổng của tất cả các lá bên trái.
     * Sử dụng DFS với một cờ hiệu để nhận biết con bên trái.
     */
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }

    private int dfs(TreeNode node, boolean isLeft) {
        if (node == null)
            return 0;

        // Check if it's a leaf
        // Kiểm tra xem có phải là lá không
        if (node.left == null && node.right == null) {
            return isLeft ? node.val : 0;
        }

        // Recurse left and right
        // Đệ quy sang trái và phải
        return dfs(node.left, true) + dfs(node.right, false);
    }

    public static void main(String[] args) {
        Solution_DFS solution = new Solution_DFS();

        // Test Case 1: [3,9,20,null,null,15,7] -> 24
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        System.out.println("Result 1: " + solution.sumOfLeftLeaves(root));

        // Test Case 2: [1] -> 0
        System.out.println("Result 2: " + solution.sumOfLeftLeaves(new TreeNode(1)));
    }
}
