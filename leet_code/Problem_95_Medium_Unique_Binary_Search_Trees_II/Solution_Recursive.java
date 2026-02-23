package leet_code.Problem_95_Medium_Unique_Binary_Search_Trees_II;

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

public class Solution_Recursive {

    /**
     * Generates all structurally unique BSTs with n nodes.
     * Uses divide and conquer to build subtrees.
     * Tạo tất cả các BST có cấu trúc duy nhất với n nút.
     * Sử dụng phương pháp chia để trị để xây dựng các cây con.
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<>();
        return generate(1, n);
    }

    private List<TreeNode> generate(int start, int end) {
        List<TreeNode> res = new ArrayList<>();

        // Base case: no numbers to form a tree
        // Trường hợp cơ sở: không có số nào để tạo thành cây
        if (start > end) {
            res.add(null);
            return res;
        }

        // Try using each number as the root
        // Thử sử dụng mỗi số làm nút gốc
        for (int i = start; i <= end; i++) {
            // Generate all possible left and right subtrees
            // Tạo tất cả các cây con bên trái và bên phải có thể
            List<TreeNode> leftSubtrees = generate(start, i - 1);
            List<TreeNode> rightSubtrees = generate(i + 1, end);

            // Connect root i with all combinations of left and right subtrees
            // Kết nối gốc i với tất cả các tổ hợp của cây con bên trái và bên phải
            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution_Recursive solution = new Solution_Recursive();

        // Test Case 1: n = 3
        List<TreeNode> res1 = solution.generateTrees(3);
        System.out.println("Test Case 1 (n=3): " + res1.size() + " trees found.");
        // Expected: 5 trees

        // Test Case 2: n = 1
        List<TreeNode> res2 = solution.generateTrees(1);
        System.out.println("Test Case 2 (n=1): " + res2.size() + " tree found.");
        // Expected: 1 tree
    }
}
