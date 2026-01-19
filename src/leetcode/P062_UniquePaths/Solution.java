package leetcode.P062_UniquePaths;

public class Solution {

    /**
     * Problem 62: Unique Paths
     * Approach: Dynamic Programming (1D Array Optimization)
     * Time Complexity: O(m * n)
     * Space Complexity: O(n)
     */
    public int uniquePaths(int m, int n) {
        int[] row = new int[n];

        // Initialize first row with 1s
        for (int j = 0; j < n; j++) {
            row[j] = 1;
        }

        // For each subsequent row
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // row[j] currently holds value from the row above (i-1, j)
                // row[j-1] holds value from the left (i, j-1)
                row[j] += row[j - 1];
            }
        }

        return row[n - 1];
    }

    /**
     * Approach: Combinatorics (Math)
     * Limit: 2 * 10^9 fits in integer, but intermediate calculation might overflow
     * long if not careful.
     * C(total, k) = (total!) / (k! * (total-k)!)
     */
    public int uniquePathsMath(int m, int n) {
        long ans = 1;
        int total = m + n - 2;
        int k = Math.min(m - 1, n - 1);

        for (int i = 1; i <= k; i++) {
            ans = ans * (total - i + 1) / i;
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, 3, 7, 28);
        runTest(solution, 3, 2, 3);
        runTest(solution, 7, 3, 28);
        runTest(solution, 1, 1, 1);
    }

    private static void runTest(Solution s, int m, int n, int expected) {
        System.out.println("Input: m=" + m + ", n=" + n);
        int resultDP = s.uniquePaths(m, n);
        int resultMath = s.uniquePathsMath(m, n);
        System.out.println("Output DP:   " + resultDP);
        System.out.println("Output Math: " + resultMath + " (Expected: " + expected + ")");

        if (resultDP == expected && resultMath == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
