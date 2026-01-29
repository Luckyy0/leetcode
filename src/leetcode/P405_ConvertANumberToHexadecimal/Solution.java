package leetcode.P405_ConvertANumberToHexadecimal;

public class Solution {

    /**
     * Problem 405: Convert a Number to Hexadecimal
     * Approach: Bit Manipulation (Unsigned Right Shift)
     * 
     * Time Complexity: O(1) - max 8 loops
     * Space Complexity: O(1)
     */
    public String toHex(int num) {
        if (num == 0)
            return "0";

        char[] map = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        StringBuilder sb = new StringBuilder();

        while (num != 0) {
            // Mask the last 4 bits
            int digit = num & 0xf;
            sb.append(map[digit]);
            // Unsigned right shift to eventually reach 0 even for negative numbers
            num >>>= 4;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 26 -> "1a"
        runTest(solution, 26, "1a");

        // -1 -> "ffffffff"
        runTest(solution, -1, "ffffffff");

        // 0 -> "0"
        runTest(solution, 0, "0");

        // 16 -> "10"
        runTest(solution, 16, "10");

        // -2 -> "fffffffe"
        runTest(solution, -2, "fffffffe");
    }

    private static void runTest(Solution sol, int num, String expected) {
        String result = sol.toHex(num);
        System.out.println("num: " + num + " -> Result: " + result + " (Expected: " + expected + ")");
        if (result.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
