package leetcode.P372_SuperPow;

public class Solution {

    /**
     * Problem 372: Super Pow
     * Approach: Modular Exponentiation
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    private static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        a %= MOD;
        int res = 1;
        for (int digit : b) {
            res = (pow(res, 10) * pow(a, digit)) % MOD;
        }
        return res;
    }

    private int pow(int a, int k) {
        int res = 1;
        a %= MOD;
        while (k > 0) {
            if ((k & 1) == 1) {
                res = (res * a) % MOD;
            }
            a = (a * a) % MOD;
            k >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 2, [3] -> 8
        runTest(solution, 2, new int[] { 3 }, 8);

        // 2, [1,0] -> 1024
        runTest(solution, 2, new int[] { 1, 0 }, 1024);

        // 1, [4,3...] -> 1
        runTest(solution, 1, new int[] { 4, 3, 3, 8 }, 1);

        // 2147483647, [2,0,0] -> Test large a
        // 2147483647 % 1337 = 191
        // 191^200 % 1337
        runTest(solution, 2147483647, new int[] { 2, 0, 0 }, 1198);
    }

    private static void runTest(Solution s, int a, int[] b, int expected) {
        int result = s.superPow(a, b);
        System.out.println(
                "a:" + a + ", b length:" + b.length + " -> Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
