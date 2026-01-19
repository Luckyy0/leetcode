package leetcode.P043_MultiplyStrings;

public class Solution {

    /**
     * Problem 43: Multiply Strings
     * Approach: Elementary Math
     * Time Complexity: O(m * n)
     * Space Complexity: O(m + n)
     */
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        int m = num1.length();
        int n = num2.length();
        int[] pos = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;

                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, "2", "3", "6");
        runTest(solution, "123", "456", "56088");
        runTest(solution, "0", "123", "0");
        runTest(solution, "999", "999", "998001");
    }

    private static void runTest(Solution s, String num1, String num2, String expected) {
        System.out.println("Input: " + num1 + " * " + num2);
        String result = s.multiply(num1, num2);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
