package leetcode.P338_CountingBits;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 338: Counting Bits
     * Approach: DP
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 2 -> [0,1,1]
        runTest(solution, 2, "[0, 1, 1]");

        // 5 -> [0,1,1,2,1,2]
        runTest(solution, 5, "[0, 1, 1, 2, 1, 2]");
    }

    private static void runTest(Solution s, int n, String expected) {
        int[] result = s.countBits(n);
        String resStr = Arrays.toString(result);
        System.out.println("Result: " + resStr + " (Expected: " + expected + ")");
        if (resStr.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
