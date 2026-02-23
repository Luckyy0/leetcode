package leet_code.Problem_113_Medium_Path_Sum_II;

import java.util.*;

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

public class Solution_Backtracking {

    /**
     * Finds all root-to-leaf paths that sum up to targetSum.
     * Uses backtracking to explore all branches.
     * 
     * Tìm tất cả các con đường từ gốc đến lá có tổng bằng targetSum.
     * Sử dụng quay lui để khám phá tất cả các nhánh.
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPaths(root, targetSum, currentPath, result);
        return result;
    }

    private void findPaths(TreeNode node, int remainingSum, List<Integer> currentPath, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        // Add current node to the path
        // Thêm nút hiện tại vào con đường
        currentPath.add(node.val);

        // Check if it's a leaf node and if path sum matches target
        // Kiểm tra xem có phải là nút lá và tổng đường đi có khớp với mục tiêu không
        if (node.left == null && node.right == null && node.val == remainingSum) {
            // Found a valid path! Add a copy of currentPath to result
            // Đã tìm thấy một con đường hợp lệ! Thêm một bản sao của currentPath vào kết
            // quả
            result.add(new ArrayList<>(currentPath));
        } else {
            // Otherwise explore children
            // Nếu không, hãy khám phá các nút con
            findPaths(node.left, remainingSum - node.val, currentPath, result);
            findPaths(node.right, remainingSum - node.val, currentPath, result);
        }

        // Backtrack: remove current node's value to clean up for other recursive calls
        // Quay lui: xóa giá trị nút hiện tại để dọn dẹp cho các lời gọi đệ quy khác
        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        Solution_Backtracking solution = new Solution_Backtracking();

        // Test Case 1: Multiple paths summing to 22
        TreeNode root1 = new TreeNode(5,
                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1))));
        System.out.println("Test Case 1 (Target 22): " + solution.pathSum(root1, 22));
        // Expected: [[5, 4, 11, 2], [5, 8, 4, 5]]

        // Test Case 2: No paths found
        TreeNode root2 = new TreeNode(1, new TreeNode(2), null);
        System.out.println("Test Case 2 (Target 0): " + solution.pathSum(root2, 0));
        // Expected: []
    }
}
