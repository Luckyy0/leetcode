package leetcode.P006_ZigzagConversion;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * Approach 1: Sort by Row (Simulation)
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public String convertSimulation(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            // Change direction at top or bottom row
            // Đổi hướng tại hàng đầu hoặc hàng cuối
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row);
        }
        return ret.toString();
    }

    /**
     * Approach 2: Visit by Row (Mathematical Construction)
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public String convertMath(String s, int numRows) {
        if (numRows == 1)
            return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                // Add character for current cycle's primary column
                // Thêm ký tự cho cột chính của chu kỳ hiện tại
                ret.append(s.charAt(j + i));

                // For internal rows, add the diagonal character
                // Đối với các hàng bên trong, thêm ký tự chéo
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n) {
                    ret.append(s.charAt(j + cycleLen - i));
                }
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        String s1 = "PAYPALISHIRING";
        int r1 = 3;
        // Exp: "PAHNAPLSIIGYIR"
        runTest(solution, s1, r1, "PAHNAPLSIIGYIR");

        // Test Case 2
        String s2 = "PAYPALISHIRING";
        int r2 = 4;
        // Exp: "PINALSIGYAHRPI"
        runTest(solution, s2, r2, "PINALSIGYAHRPI");

        // Test Case 3
        String s3 = "A";
        int r3 = 1;
        // Exp: "A"
        runTest(solution, s3, r3, "A");

        // Test Case 4: Short string
        String s4 = "AB";
        int r4 = 1;
        runTest(solution, s4, r4, "AB");
    }

    private static void runTest(Solution s, String input, int rows, String expected) {
        System.out.println("Input: \"" + input + "\", numRows = " + rows);
        String resSim = s.convertSimulation(input, rows);
        String resMath = s.convertMath(input, rows);

        System.out.println("Simulation: " + resSim);
        System.out.println("Math:       " + resMath);

        if (resSim.equals(expected) && resMath.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL (Expected: " + expected + ")");
        }
        System.out.println("-------------------------");
    }
}
