package leetcode.P113_PathSumII;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static class TreeNode {
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
     * Problem 113: Path Sum II
     * Approach: DFS Backtracking
     * 
     * Theoretical Basis:
     * - Extension of Problem 112: find ALL valid paths instead of checking
     * existence
     * - Classic backtracking pattern: Choose -> Explore -> Unchoose
     * - Add node to path, recurse, remove node (backtrack)
     * - When valid leaf found, add COPY of current path to result
     * 
     * Time Complexity: O(N²) - O(N) nodes, O(N) for path copy
     * Space Complexity: O(N) - path length + recursion stack
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        backtrack(root, targetSum, currentPath, result);
        return result;
    }

    private void backtrack(TreeNode node, int remainingSum, List<Integer> path, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        // Choose: add current node to path
        path.add(node.val);
        remainingSum -= node.val;

        // Check if valid leaf
        if (node.left == null && node.right == null && remainingSum == 0) {
            // Found valid path - add COPY to result
            result.add(new ArrayList<>(path));
        } else {
            // Explore: recurse into children
            backtrack(node.left, remainingSum, path, result);
            backtrack(node.right, remainingSum, path, result);
        }

        // Unchoose: backtrack by removing last element
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test 1: [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
        // Paths: [5,4,11,2] and [5,8,4,5]
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(8);
        root1.left.left = new TreeNode(11, new TreeNode(7), new TreeNode(2));
        root1.right.left = new TreeNode(13);
        root1.right.right = new TreeNode(4, new TreeNode(5), new TreeNode(1));
        runTest(solution, root1, 22, 2);

        // Test 2: [1,2,3], targetSum = 5 -> []
        TreeNode root2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        runTest(solution, root2, 5, 0);

        // Test 3: Empty tree -> []
        runTest(solution, null, 0, 0);
    }

    private static void runTest(Solution s, TreeNode root, int targetSum, int expectedPathCount) {
        List<List<Integer>> result = s.pathSum(root, targetSum);
        System.out.println("TargetSum: " + targetSum);
        System.out.println("Paths found: " + result.size() + " (Expected: " + expectedPathCount + ")");
        System.out.println("Paths: " + result);

        if (result.size() == expectedPathCount) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
