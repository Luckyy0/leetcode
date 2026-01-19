package leetcode.P096_UniqueBinarySearchTrees;

public class Solution {

    /**
     * Problem 96: Unique Binary Search Trees
     * Approach: Dynamic Programming
     * Time Complexity: O(N^2)
     * Space Complexity: O(N)
     */
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // j is the root
                // Left side has j-1 nodes
                // Right side has i-j nodes
                G[i] += G[j - 1] * G[i - j];
            }
        }

        return G[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, 3, 5);
        runTest(solution, 1, 1);
        runTest(solution, 19, 1767263190);
    }

    private static void runTest(Solution s, int n, int expected) {
        System.out.println("Input: n=" + n);
        int result = s.numTrees(n);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
