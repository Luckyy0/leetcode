package leetcode.P536_ConstructBinaryTreeFromString;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
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

class Solution {
    int index = 0;

    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        index = 0;
        return parse(s);
    }

    private TreeNode parse(String s) {
        if (index >= s.length())
            return null;

        // Parse number (handling negative sign)
        // Phân tích số (xử lý dấu gạch ngang)
        int start = index;
        while (index < s.length() && (Character.isDigit(s.charAt(index)) || s.charAt(index) == '-')) {
            index++;
        }
        int val = Integer.parseInt(s.substring(start, index));
        TreeNode node = new TreeNode(val);

        // Check for left child
        // Kiểm tra con trái
        if (index < s.length() && s.charAt(index) == '(') {
            index++; // consume '('
            node.left = parse(s);
            index++; // consume ')'
        }

        // Check for right child
        // Kiểm tra con phải
        if (index < s.length() && s.charAt(index) == '(') {
            index++; // consume '('
            node.right = parse(s);
            index++; // consume ')'
        }

        return node;
    }
}
