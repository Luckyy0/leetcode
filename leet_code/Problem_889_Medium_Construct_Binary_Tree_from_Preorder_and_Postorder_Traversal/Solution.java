package leet_code.Problem_889_Medium_Construct_Binary_Tree_from_Preorder_and_Postorder_Traversal;

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
 * Problem 889: Construct Binary Tree from Preorder and Postorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
 */
public class Solution {

    /**
     * Constructs a binary tree.
     * Strategy: Recursive divide and conquer.
     * 
     * @param preorder  Preorder traversal array.
     * @param postorder Postorder traversal array.
     * @return Root of the constructed tree.
     * 
     *         Tóm tắt chiến lược:
     *         1. Phần tử đầu tiên của preorder luôn là gốc (root).
     *         2. Nếu có nhiều hơn 1 phần tử, phần tử thứ hai của preorder sẽ là gốc
     *         của cây con bên trái (left_root).
     *         3. Tìm vị trí của left_root trong mảng postorder. Tất cả các phần tử
     *         từ đầu mảng postorder đến vị trí này thuộc về cây con trái.
     *         4. Dựa vào số lượng phần tử của cây con trái, ta xác định được phạm
     *         vi
     *         của cây con phải trong cả hai mảng.
     *         5. Đệ quy xây dựng cây con trái và phải.
     */
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        Map<Integer, Integer> postMap = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            postMap.put(postorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1,
                postorder, 0, postorder.length - 1, postMap);
    }

    private TreeNode build(int[] pre, int preStart, int preEnd,
            int[] post, int postStart, int postEnd,
            Map<Integer, Integer> postMap) {

        // Base cases
        if (preStart > preEnd)
            return null;
        if (preStart == preEnd)
            return new TreeNode(pre[preStart]);

        // The root is the first element of preorder
        int rootVal = pre[preStart];
        TreeNode root = new TreeNode(rootVal);

        // The second element of preorder is the root of the left subtree
        int leftRootVal = pre[preStart + 1];

        // Find the index of the left root in postorder to determine size
        int leftRootIndex = postMap.get(leftRootVal);
        int leftSize = leftRootIndex - postStart + 1;

        // Recursively build left and right subtrees
        root.left = build(pre, preStart + 1, preStart + leftSize,
                post, postStart, leftRootIndex, postMap);

        root.right = build(pre, preStart + leftSize + 1, preEnd,
                post, leftRootIndex + 1, postEnd - 1, postMap);

        return root;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] pre = { 1, 2, 4, 5, 3, 6, 7 };
        int[] post = { 4, 5, 2, 6, 7, 3, 1 };

        TreeNode root = sol.constructFromPrePost(pre, post);
        System.out.println("Root val: " + root.val); // 1
        System.out.println("Left val: " + root.left.val); // 2
        System.out.println("Right val: " + root.right.val); // 3
    }
}
