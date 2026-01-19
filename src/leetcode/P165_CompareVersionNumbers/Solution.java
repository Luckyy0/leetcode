package leetcode.P165_CompareVersionNumbers;

public class Solution {

    /**
     * Problem 165: Compare Version Numbers
     * Approach: String Splitting and Integer Comparison
     * 
     * Theoretical Basis:
     * - Split versions by dots.
     * - Compare revisions numerically.
     * - Treat missing revisions as 0.
     * 
     * Time Complexity: O(N + M)
     * Space Complexity: O(N + M)
     */
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int n1 = v1.length;
        int n2 = v2.length;
        int maxLen = Math.max(n1, n2);

        for (int i = 0; i < maxLen; i++) {
            int val1 = (i < n1) ? Integer.parseInt(v1[i]) : 0;
            int val2 = (i < n2) ? Integer.parseInt(v2[i]) : 0;

            if (val1 < val2)
                return -1;
            if (val1 > val2)
                return 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // "1.01" vs "1.001" -> 0
        runTest(solution, "1.01", "1.001", 0);

        // "1.0" vs "1.1" -> -1
        runTest(solution, "1.0", "1.1", -1);

        // "0.1" vs "1.1" -> -1
        runTest(solution, "0.1", "1.1", -1);

        // "1.0.1" vs "1" -> 1
        runTest(solution, "1.0.1", "1", 1);
    }

    private static void runTest(Solution s, String v1, String v2, int expected) {
        int result = s.compareVersion(v1, v2);
        System.out.println("V1: \"" + v1 + "\", V2: \"" + v2 + "\"");
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
