package leet_code.Problem_536_Medium_Construct_Binary_Tree_from_String;

// Definition for a binary tree node.
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

public class Solution_Recursion {

    // Global index to simulate stream processing
    private int index = 0;

    /**
     * Constructs tree from string.
     * Strategy: Recursive parsing with global index.
     * Time: O(N), Space: O(H).
     */
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        index = 0;
        return parse(s);
    }

    private TreeNode parse(String s) {
        if (index >= s.length()) {
            return null;
        }

        // 1. Parse number (can be negative)
        int start = index;
        while (index < s.length() && (Character.isDigit(s.charAt(index)) || s.charAt(index) == '-')) {
            index++;
        }

        int val = Integer.parseInt(s.substring(start, index));
        TreeNode node = new TreeNode(val);

        // 2. Check for left child
        if (index < s.length() && s.charAt(index) == '(') {
            index++; // Consumption of '('
            node.left = parse(s);
            index++; // Consumption of matching ')'
        }

        // 3. Check for right child
        if (node.left != null && index < s.length() && s.charAt(index) == '(') {
            index++; // Consumption of '('
            node.right = parse(s);
            index++; // Consumption of matching ')'
        }

        return node;
    }

    public static void main(String[] args) {
        Solution_Recursion solution = new Solution_Recursion();
        String s = "4(2(3)(1))(6(5))";
        TreeNode root = solution.str2tree(s);
        System.out.println("Root val: " + root.val); // 4
        System.out.println("Left val: " + root.left.val); // 2
        System.out.println("Right val: " + root.right.val); // 6
    }
}
