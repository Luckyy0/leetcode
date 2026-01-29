package leetcode.P366_FindLeavesOfBinaryTree;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int x, TreeNode left, TreeNode right) {
            val = x;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Problem 366: Find Leaves of Binary Tree
     * Approach: Height Grouping (DFS)
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        getHeight(root, result);
        return result;
    }

    private int getHeight(TreeNode node, List<List<Integer>> result) {
        if (node == null) {
            return -1;
        }

        int leftH = getHeight(node.left, result);
        int rightH = getHeight(node.right, result);

        int currentH = 1 + Math.max(leftH, rightH);

        if (result.size() <= currentH) {
            result.add(new ArrayList<>());
        }

        result.get(currentH).add(node.val);

        return currentH;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [1,2,3,4,5] -> [[4,5,3],[2],[1]]
        // Order in sublist doesn't strictly matter unless specified left-to-right.
        // Post-order visits L, R, Root. So 4 (H0), 5 (H0), 2 (H1), 3 (H0), 1 (H2).
        // H0 list: [4, 5, 3]. H1: [2]. H2: [1].
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3));

        runTest(solution, root);
    }

    private static void runTest(Solution s, TreeNode root) {
        List<List<Integer>> result = s.findLeaves(root);
        System.out.println("Result: " + result);
        System.out.println("-----------------");
    }
}
