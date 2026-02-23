package leet_code.Problem_112_Easy_Path_Sum;

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
     * Given a binary tree and a targetSum, checks if there is a root-to-leaf path
     * that sums up to the targetSum.
     * 
     * Cho một cây nhị phân và một targetSum, kiểm tra xem có đường đi từ gốc đến lá
     * nào có tổng bằng targetSum hay không.
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Base case: If the node is null, there is no path
        // Trường hợp cơ sở: Nếu nút null, không có đường đi
        if (root == null) {
            return false;
        }

        // If we reach a leaf node, check if the value matches the remaining sum
        // Nếu chúng ta đến một nút lá, kiểm tra xem giá trị có khớp với tổng còn lại
        // không
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        // Recursively check children with the updated sum
        // Updated sum is targetSum minus current node's value
        // Kiểm tra đệ quy các nút con với tổng đã cập nhật
        // Tổng cập nhật là targetSum trừ đi giá trị của nút hiện tại
        int remainingSum = targetSum - root.val;
        return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
    }

    public static void main(String[] args) {
        Solution_Recursive solution = new Solution_Recursive();

        // Test Case 1: Standard tree with a path sum of 22
        // Example structure: 5 -> 4 -> 11 -> 2
        TreeNode root1 = new TreeNode(5,
                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1))));
        System.out.println("Test Case 1 (Target 22): " + solution.hasPathSum(root1, 22));
        // Expected: true

        // Test Case 2: Tree with no such path
        TreeNode root2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println("Test Case 2 (Target 5): " + solution.hasPathSum(root2, 5));
        // Expected: false
    }
}
