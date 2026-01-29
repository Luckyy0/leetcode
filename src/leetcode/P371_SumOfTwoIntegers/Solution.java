package leetcode.P371_SumOfTwoIntegers;

public class Solution {

    /**
     * Problem 371: Sum of Two Integers
     * Approach: Bit Manipulation
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 1 + 2 = 3
        runTest(solution, 1, 2, 3);

        // 2 + 3 = 5
        runTest(solution, 2, 3, 5);

        // -1 + 1 = 0
        runTest(solution, -1, 1, 0);
    }

    private static void runTest(Solution s, int a, int b, int expected) {
        int result = s.getSum(a, b);
        System.out.println("a:" + a + ", b:" + b + " -> Sum: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
