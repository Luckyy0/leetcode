package leet_code.Problem_105_Medium_Construct_Binary_Tree_From_Preorder_And_Inorder_Traversal;

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

public class Solution_HashMap {
    private Map<Integer, Integer> inorderMap;
    private int preorderIndex;

    /**
     * Constructs a binary tree from its preorder and inorder traversals.
     * Uses a HashMap for fast lookup of root index in inorder array.
     * Xây dựng cây nhị phân từ phép duyệt theo thứ tự trước và thứ tự giữa.
     * Sử dụng HashMap để tra cứu nhanh chỉ số gốc trong mảng thứ tự giữa.
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        preorderIndex = 0;
        return arrayToTree(preorder, 0, inorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        // If there are no elements to construct the tree
        // Nếu không còn phần tử nào để xây dựng cây
        if (left > right)
            return null;

        // Select the preorderIndex element as the root and increment it
        // Chọn phần tử tại preorderIndex làm gốc và tăng chỉ số
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // Build left and right subtrees
        // Excluding rootValue from the inorder traversal
        // Xây dựng cây con bên trái và bên phải
        // Loại trừ rootValue khỏi phép duyệt theo thứ tự giữa
        int index = inorderMap.get(rootValue);
        root.left = arrayToTree(preorder, left, index - 1);
        root.right = arrayToTree(preorder, index + 1, right);

        return root;
    }

    public static void main(String[] args) {
        Solution_HashMap solution = new Solution_HashMap();

        // Test Case 1: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        int[] pre1 = { 3, 9, 20, 15, 7 };
        int[] in1 = { 9, 3, 15, 20, 7 };
        TreeNode res1 = solution.buildTree(pre1, in1);
        System.out.println("Test Case 1: Root should be 3, its left 9, its right 20.");
        System.out.println("Result root: " + res1.val + ", left: " + res1.left.val + ", right: " + res1.right.val);
        // Expected: 3, 9, 20

        // Test Case 2: preorder = [-1], inorder = [-1]
        int[] pre2 = { -1 };
        int[] in2 = { -1 };
        TreeNode res2 = solution.buildTree(pre2, in2);
        System.out.println("Test Case 2: " + res2.val);
        // Expected: -1
    }
}
