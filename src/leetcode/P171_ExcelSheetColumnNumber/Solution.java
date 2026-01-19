package leetcode.P171_ExcelSheetColumnNumber;

public class Solution {

    /**
     * Problem 171: Excel Sheet Column Number
     * Approach: Polynomial accumulation in base 26
     * 
     * Theoretical Basis:
     * - result = result * 26 + (char - 'A' + 1)
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int titleToNumber(String columnTitle) {
        int result = 0;

        for (int i = 0; i < columnTitle.length(); i++) {
            char c = columnTitle.charAt(i);
            int val = c - 'A' + 1;
            result = result * 26 + val;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // A -> 1
        runTest(solution, "A", 1);

        // AB -> 28
        runTest(solution, "AB", 28);

        // ZY -> 701
        runTest(solution, "ZY", 701);
    }

    private static void runTest(Solution s, String title, int expected) {
        int result = s.titleToNumber(title);
        System.out.println(title + " -> " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
