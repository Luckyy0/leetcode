package leet_code.Problem_372_Medium_Super_Pow;

import java.util.Arrays;

public class Solution_Recursion {

    private final int MOD = 1337;

    /**
     * Calculates a^b % 1337.
     * Uses recursive decomposition: a^123 = (a^12)^10 * a^3.
     * Time: O(L), Space: O(L).
     * 
     * Tính a^b % 1337.
     * Sử dụng phân rã đệ quy: a^123 = (a^12)^10 * a^3.
     */
    public int superPow(int a, int[] b) {
        if (b.length == 0)
            return 1;

        int lastDigit = b[b.length - 1];
        int[] bWithoutLast = Arrays.copyOfRange(b, 0, b.length - 1);

        int part1 = myPow(superPow(a, bWithoutLast), 10);
        int part2 = myPow(a, lastDigit);

        return (part1 * part2) % MOD;
    }

    // Standard modular exponentiation
    private int myPow(int a, int k) {
        a %= MOD;
        int res = 1;
        for (int i = 0; i < k; i++) {
            res = (res * a) % MOD;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution_Recursion solution = new Solution_Recursion();

        // Test Case 1: 2, [3] -> 8
        System.out.println("2^[3] % 1337 = " + solution.superPow(2, new int[] { 3 }));

        // Test Case 2: 2, [1,0] -> 1024
        System.out.println("2^[1,0] % 1337 = " + solution.superPow(2, new int[] { 1, 0 }));

        // Test Case 3: 1, [4,3,3,8,5,2] -> 1
        System.out.println("1^[4,...] % 1337 = " + solution.superPow(1, new int[] { 4, 3, 3, 8, 5, 2 }));
    }
}
