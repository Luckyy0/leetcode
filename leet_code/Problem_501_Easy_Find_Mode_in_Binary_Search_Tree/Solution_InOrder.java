package leet_code.Problem_501_Easy_Find_Mode_in_Binary_Search_Tree;

import java.util.ArrayList;
import java.util.List;

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

public class Solution_InOrder {

    // State variables for traversal
    private Integer prev = null;
    private int currentCount = 0;
    private int maxCount = 0;
    private List<Integer> modes = new ArrayList<>();

    /**
     * Finds mode(s) in BST.
     * Strategy: In-order traversal to process duplicates consecutively. O(1) extra
     * space.
     * Time: O(N), Space: O(1) excluding recursion stack and result list.
     */
    public int[] findMode(TreeNode root) {
        modes.clear();
        maxCount = 0;
        currentCount = 0;
        prev = null;

        inOrder(root);

        // Convert List to array
        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }
        return result;
    }

    private void inOrder(TreeNode node) {
        if (node == null)
            return;

        inOrder(node.left);

        // Process current node
        handleValue(node.val);

        inOrder(node.right);
    }

    private void handleValue(int val) {
        if (prev == null || val != prev) {
            currentCount = 1;
        } else {
            currentCount++;
        }

        if (currentCount > maxCount) {
            maxCount = currentCount;
            modes.clear();
            modes.add(val);
        } else if (currentCount == maxCount) {
            modes.add(val);
        }

        prev = val;
    }

    public static void main(String[] args) {
        Solution_InOrder solution = new Solution_InOrder();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);

        int[] res = solution.findMode(root);
        System.out.print("Result: ");
        for (int val : res) {
            System.out.print(val + " "); // 2
        }
    }
}
