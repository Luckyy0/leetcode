package leetcode.P100_SameTree;

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
     * Problem 100: Same Tree
     * Approach: Recursion
     * 
     * Theoretical Basis:
     * - Tree equality is defined recursively:
     * - Two empty trees are equal
     * - Two non-empty trees are equal if roots match AND left subtrees are equal
     * AND right subtrees are equal
     * - This recursive definition translates directly to recursive code
     * 
     * Time Complexity: O(min(N, M)) - visit each node until mismatch or end
     * Space Complexity: O(min(H1, H2)) - recursion stack depth
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base case 1: Both null -> equal
        if (p == null && q == null) {
            return true;
        }

        // Base case 2: One is null, other is not -> not equal
        if (p == null || q == null) {
            return false;
        }

        // Base case 3: Values differ -> not equal
        if (p.val != q.val) {
            return false;
        }

        // Recursive case: Compare subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test 1: [1,2,3] vs [1,2,3] -> true
        TreeNode p1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        runTest(solution, p1, q1, true);

        // Test 2: [1,2] vs [1,null,2] -> false
        TreeNode p2 = new TreeNode(1, new TreeNode(2), null);
        TreeNode q2 = new TreeNode(1, null, new TreeNode(2));
        runTest(solution, p2, q2, false);

        // Test 3: [1,2,1] vs [1,1,2] -> false
        TreeNode p3 = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        TreeNode q3 = new TreeNode(1, new TreeNode(1), new TreeNode(2));
        runTest(solution, p3, q3, false);

        // Test 4: Both null -> true
        runTest(solution, null, null, true);
    }

    private static void runTest(Solution s, TreeNode p, TreeNode q, boolean expected) {
        boolean result = s.isSameTree(p, q);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
