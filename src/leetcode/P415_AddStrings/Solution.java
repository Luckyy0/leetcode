package leetcode.P415_AddStrings;

public class Solution {

    /**
     * Problem 415: Add Strings
     * Approach: Manual Addition Simulation
     * 
     * Time Complexity: O(max(N, M))
     * Space Complexity: O(max(N, M))
     */
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {
            int d1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int d2 = (j >= 0) ? num2.charAt(j) - '0' : 0;

            int sum = d1 + d2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;

            i--;
            j--;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // "11", "123" -> "134"
        runTest(solution, "11", "123", "134");

        // "456", "77" -> "533"
        runTest(solution, "456", "77", "533");

        // "99", "1" -> "100"
        runTest(solution, "99", "1", "100");
    }

    private static void runTest(Solution sol, String s1, String s2, String expected) {
        String result = sol.addStrings(s1, s2);
        System.out.println("num1: " + s1 + ", num2: " + s2 + " -> Result: " + result + " (Expected: " + expected + ")");
        if (result.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
