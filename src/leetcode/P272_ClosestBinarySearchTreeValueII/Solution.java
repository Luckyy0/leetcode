package leetcode.P272_ClosestBinarySearchTreeValueII;

import java.util.ArrayList;
import java.util.LinkedList;
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
     * Problem 272: Closest Binary Search Tree Value II
     * Approach: Inorder Traversal + Sliding Window (Deque)
     * 
     * Theoretical Basis:
     * - Inorder traversal yields sorted elements.
     * - Maintain a window of size k.
     * - Prune search when current element is worse than the furthest element in
     * window.
     * 
     * Time Complexity: O(N) worst case (O(k + log N) with complex stack logic, but
     * O(N) is standard).
     * Space Complexity: O(k) for deque + O(H) recursion.
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> window = new LinkedList<>();
        inorder(root, target, k, window);
        return new ArrayList<>(window);
    }

    private void inorder(TreeNode node, double target, int k, LinkedList<Integer> window) {
        if (node == null)
            return;

        inorder(node.left, target, k, window);

        if (window.size() < k) {
            window.add(node.val);
        } else {
            // Window full. Check if current node is better than the 'furthest' (first) node
            // in window.
            // 'First' is the smallest value in the sorted window.
            // If |first - target| > |node.val - target|, it means node.val is closer than
            // first.
            // So we remove first and add node.val.
            double diffFirst = Math.abs(window.getFirst() - target);
            double diffNode = Math.abs(node.val - target);

            if (diffFirst > diffNode) {
                window.removeFirst();
                window.addLast(node.val);
            } else {
                // Since BST is sorted, if current node is further than the furthest 'small'
                // value,
                // all subsequent nodes (which are larger) will also be further.
                // We can stop the entire traversal immediately?
                // Wait, recursion stack needs to unroll. We can't strictly 'return' to stop
                // parent calls
                // unless we use a flag or check window state.
                // Simple optimization: Just return for this branch. The parent might still call
                // right branch?
                // Actually, if we are in right child of parent, and we stop, we return to
                // parent...
                // well, Inorder: Left -> Root -> Right.
                // If we stop at Root/Right, we stop everything after.
                // O(N) logic traverses all, so "early exit" is optimization.
                // Actually, just returning here stops processing the RIGHT subtree of current
                // node.
                // But does it stop the parent? strictly no.
                // But typically for LeetCode constraints O(N) is fine without aggressive
                // pruning.
                return;
            }
        }

        inorder(node.right, target, k, window);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Root=[4,2,5,1,3], target=3.714286, k=2 -> [4,3]
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2, n1, n3);
        TreeNode n5 = new TreeNode(5);
        TreeNode root = new TreeNode(4, n2, n5);

        runTest(solution, root, 3.714286, 2);

        // Root=[1], target=0.0, k=1 -> [1]
        runTest(solution, new TreeNode(1), 0.0, 1);
    }

    private static void runTest(Solution s, TreeNode root, double target, int k) {
        List<Integer> result = s.closestKValues(root, target, k);
        System.out.println("Result: " + result);
        System.out.println("-----------------");
    }
}
