package leetcode.P067_AddBinary;

public class Solution {

    /**
     * Problem 67: Add Binary
     * Approach: Simulation (Bit-by-bit addition)
     * Time Complexity: O(max(N, M))
     * Space Complexity: O(max(N, M))
     */
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            sb.append(sum % 2);
            carry = sum / 2;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, "11", "1", "100");
        runTest(solution, "1010", "1011", "10101");
        runTest(solution, "0", "0", "0");
    }

    private static void runTest(Solution s, String a, String b, String expected) {
        System.out.println("Input: a=\"" + a + "\", b=\"" + b + "\"");
        String result = s.addBinary(a, b);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
