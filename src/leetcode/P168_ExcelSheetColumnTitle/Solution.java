package leetcode.P168_ExcelSheetColumnTitle;

public class Solution {

    /**
     * Problem 168: Excel Sheet Column Title
     * Approach: Base 26 conversion with 0-index shift
     * 
     * Theoretical Basis:
     * - Shift current number by -1 to handle 1-indexed to 0-indexed logic.
     * - Remainder % 26 gives the character 'A' + remainder.
     * 
     * Time Complexity: O(log26(N))
     * Space Complexity: O(log26(N))
     */
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {
            // Shift to 0-indexed for modulo operation
            columnNumber--;

            char c = (char) ('A' + (columnNumber % 26));
            result.append(c);

            columnNumber /= 26;
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 1 -> A
        runTest(solution, 1, "A");

        // 28 -> AB
        runTest(solution, 28, "AB");

        // 701 -> ZY
        runTest(solution, 701, "ZY");

        // 26 -> Z
        runTest(solution, 26, "Z");

        // 52 -> AZ
        runTest(solution, 52, "AZ");
    }

    private static void runTest(Solution s, int num, String expected) {
        String result = s.convertToTitle(num);
        System.out.println(num + " -> " + result + " (Expected: " + expected + ")");

        if (result.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
