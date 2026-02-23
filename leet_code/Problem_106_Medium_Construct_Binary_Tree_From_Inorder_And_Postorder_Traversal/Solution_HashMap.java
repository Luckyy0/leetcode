package leet_code.Problem_106_Medium_Construct_Binary_Tree_From_Inorder_And_Postorder_Traversal;

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
    private int postorderIndex;

    /**
     * Constructs a binary tree from its inorder and postorder traversals.
     * Uses a HashMap for fast lookup of root index in inorder array.
     * Xây dựng cây nhị phân từ phép duyệt theo thứ tự giữa và thứ tự sau.
     * Sử dụng HashMap để tra cứu nhanh chỉ số gốc trong mảng thứ tự giữa.
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        // Start from the last element of postorder
        // Bắt đầu từ phần tử cuối cùng của mảng postorder
        postorderIndex = postorder.length - 1;
        return arrayToTree(postorder, 0, inorder.length - 1);
    }

    private TreeNode arrayToTree(int[] postorder, int left, int right) {
        if (left > right)
            return null;

        // Select the current root from postorder and move counter backwards
        // Chọn gốc hiện tại từ postorder và di chuyển bộ đếm ngược lại
        int rootValue = postorder[postorderIndex--];
        TreeNode root = new TreeNode(rootValue);

        int index = inorderMap.get(rootValue);

        // IMPORTANT: Build the RIGHT subtree first because we are going backwards in
        // postorder
        // (Postorder sequence: Left -> Right -> Root)
        // QUAN TRỌNG: Xây dựng cây con bên PHẢI trước vì chúng ta đang đi ngược lại
        // trong postorder
        // (Thứ tự sau: Trái -> Phải -> Gốc)
        root.right = arrayToTree(postorder, index + 1, right);
        root.left = arrayToTree(postorder, left, index - 1);

        return root;
    }

    public static void main(String[] args) {
        Solution_HashMap solution = new Solution_HashMap();

        // Test Case 1: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
        int[] in1 = { 9, 3, 15, 20, 7 };
        int[] post1 = { 9, 15, 7, 20, 3 };
        TreeNode res1 = solution.buildTree(in1, post1);
        System.out.println("Test Case 1: Root should be 3, its left 9, its right 20.");
        System.out.println("Result root: " + res1.val + ", left: " + res1.left.val + ", right: " + res1.right.val);

        // Test Case 2: inorder = [-1], postorder = [-1]
        int[] in2 = { -1 };
        int[] post2 = { -1 };
        TreeNode res2 = solution.buildTree(in2, post2);
        System.out.println("Test Case 2: " + res2.val);
    }
}
