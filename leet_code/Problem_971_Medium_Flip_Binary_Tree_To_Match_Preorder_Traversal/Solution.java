package leet_code.Problem_971_Medium_Flip_Binary_Tree_To_Match_Preorder_Traversal;

import java.util.*;

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

/**
 * Problem 971: Flip Binary Tree To Match Preorder Traversal
 * https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/
 */
public class Solution {

    // Global variable to track index in the voyage array
    int index;
    List<Integer> flipped;

    /**
     * Determines which nodes to flip to match the preorder traversal 'voyage'.
     * Strategy: DFS Preorder Traversal.
     * 
     * @param root   Root of the tree.
     * @param voyage Target preorder sequence.
     * @return List of flipped nodes or [-1] if impossible.
     * 
     *         Tóm tắt chiến lược:
     *         1. Duyệt cây theo thứ tự Preorder (Root -> Left -> Right).
     *         2. Sử dụng biến toàn cục `index` để theo dõi vị trí hiện tại trong
     *         mảng `voyage`.
     *         3. Tại mỗi nút `node`:
     *         - Kiểm tra `node.val` có khớp với `voyage[index]` không. Nếu không ->
     *         Bất khả thi -> Return false.
     *         - Tăng `index`.
     *         - Logic lật:
     *         Nếu `node.left` tồn tại VÀ `node.left.val` KHÔNG GIỐNG với giá trị
     *         mong đợi tiếp theo `voyage[index]`:
     *         -> Điều này có nghĩa là thứ tự duyệt chuẩn (Left trước) sẽ sai. Ta
     *         BẮT BUỘC phải lật tại nút này để duyệt Right trước.
     *         -> Ghi nhận `node.val` vào danh sách `flipped`.
     *         -> Duyệt đệ quy con PHẢI trước, sau đó mới đến con TRÁI.
     *         -> Nếu cả hai trả về true -> OK.
     *         - Logic không lật (Normal):
     *         -> Duyệt đệ quy con TRÁI trước, sau đó đến con PHẢI.
     *         4. Nếu toàn bộ quá trình duyệt trả về true, trả về danh sách
     *         `flipped`. Ngược lại trả về `[-1]`.
     */
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        flipped = new ArrayList<>();
        index = 0;

        if (dfs(root, voyage)) {
            return flipped;
        } else {
            return Arrays.asList(-1);
        }
    }

    private boolean dfs(TreeNode node, int[] voyage) {
        if (node == null) {
            return true;
        }

        // Node value must match expected value in traversal
        if (node.val != voyage[index++]) {
            return false;
        }

        // Check if we need to flip
        // We only flip if left child exists and its value doesn't match next expected
        // value
        if (node.left != null && node.left.val != voyage[index]) {
            // Record the flip
            flipped.add(node.val);

            // Traverse Right then Left (Flipped order)
            return dfs(node.right, voyage) && dfs(node.left, voyage);
        } else {
            // Normal order: Traverse Left then Right
            return dfs(node.left, voyage) && dfs(node.right, voyage);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Ex 1: [1,2], [2,1] -> Impossible
        TreeNode r1 = new TreeNode(1);
        r1.left = new TreeNode(2);
        System.out.println("Result: " + sol.flipMatchVoyage(r1, new int[] { 2, 1 })); // [-1]

        // Ex 2: [1,2,3], [1,3,2] -> Flip 1
        TreeNode r2 = new TreeNode(1);
        r2.left = new TreeNode(2);
        r2.right = new TreeNode(3);
        System.out.println("Result: " + sol.flipMatchVoyage(r2, new int[] { 1, 3, 2 })); // [1]

        // Ex 3: [1,2,3], [1,2,3] -> No flip
        TreeNode r3 = new TreeNode(1);
        r3.left = new TreeNode(2);
        r3.right = new TreeNode(3);
        System.out.println("Result: " + sol.flipMatchVoyage(r3, new int[] { 1, 2, 3 })); // []
    }
}
