package leetcode.P314_BinaryTreeVerticalOrderTraversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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
     * Problem 314: Binary Tree Vertical Order Traversal
     * Approach: BFS with Column Index
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        int minCol = 0;
        int maxCol = 0;

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            TreeNode node = curr.node;
            int col = curr.col;

            map.computeIfAbsent(col, k -> new ArrayList<>()).add(node.val);

            minCol = Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);

            if (node.left != null) {
                queue.offer(new Pair(node.left, col - 1));
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, col + 1));
            }
        }

        for (int i = minCol; i <= maxCol; i++) {
            result.add(map.get(i));
        }

        return result;
    }

    private static class Pair {
        TreeNode node;
        int col;

        Pair(TreeNode n, int c) {
            node = n;
            col = c;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 3 <- 9 -> 8 <- 4 -> 0 <- 1 -> 7
        // [3,9,8,4,0,1,7] - Example 2
        /*
         * 3
         * / \
         * 9 8
         * / \ / \
         * 4 0 1 7
         */
        // Col:
        // 0: 3, 0, 1 -> Wait, 0 is child of 9(-1 -> 0), 1 is child of 8(+1 -> 0).
        // -2: 4
        // -1: 9
        // 1: 8
        // 2: 7
        // Correct.

        TreeNode n4 = new TreeNode(4);
        TreeNode n0 = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n7 = new TreeNode(7);
        TreeNode n9 = new TreeNode(9, n4, n0);
        TreeNode n8 = new TreeNode(8, n1, n7);
        TreeNode root = new TreeNode(3, n9, n8);

        runTest(solution, root);
    }

    private static void runTest(Solution s, TreeNode root) {
        List<List<Integer>> result = s.verticalOrder(root);
        System.out.println("Result: " + result);
        // Expected: [[4], [9], [3, 0, 1], [8], [7]]
        // Note: 0 and 1 order depends on BFS order. Left (9) processed first -> child 0
        // offered. Right (8) processed -> child 1 offered.
        // So 0 comes before 1.
        System.out.println("-----------------");
    }
}
