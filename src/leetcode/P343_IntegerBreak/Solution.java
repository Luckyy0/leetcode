package leetcode.P343_IntegerBreak;

public class Solution {

    /**
     * Problem 343: Integer Break
     * Approach: Math (Greedy 3s)
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int integerBreak(int n) {
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;

        int product = 1;
        while (n > 4) {
            product *= 3;
            n -= 3;
        }

        product *= n;

        return product;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 2 -> 1
        runTest(solution, 2, 1);

        // 10 -> 36 (= 3*3*4)
        runTest(solution, 10, 36);

        // 5 -> 6 (= 2*3)
        runTest(solution, 5, 6);

        // 8 -> 18 (= 3*3*2)
        runTest(solution, 8, 18);
    }

    private static void runTest(Solution s, int n, int expected) {
        int result = s.integerBreak(n);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
