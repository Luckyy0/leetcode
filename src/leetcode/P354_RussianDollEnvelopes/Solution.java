package leetcode.P354_RussianDollEnvelopes;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    /**
     * Problem 354: Russian Doll Envelopes
     * Approach: Sorting + LIS (O(N log N))
     * 
     * Time Complexity: O(N log N)
     * Space Complexity: O(N)
     */
    public int maxEnvelopes(int[][] envelopes) {
        // Sort: Ascending Width. If Width same, Descending Height.
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                } else {
                    return a[0] - b[0];
                }
            }
        });

        // LIS on heights
        int[] tails = new int[envelopes.length];
        int len = 0;

        for (int[] env : envelopes) {
            int h = env[1];

            // Binary Search insertion point in tails[0...len-1]
            int i = 0, j = len;
            while (i < j) {
                int m = (i + j) / 2;
                if (tails[m] < h) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }

            // If i == len, append
            if (i == len)
                len++;
            tails[i] = h;
        }

        return len;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [[5,4],[6,4],[6,7],[2,3]] -> 3
        int[][] e1 = { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } };
        runTest(solution, e1, 3);

        // [[1,1],[1,1],[1,1]] -> 1
        int[][] e2 = { { 1, 1 }, { 1, 1 }, { 1, 1 } };
        runTest(solution, e2, 1);
    }

    private static void runTest(Solution s, int[][] envs, int expected) {
        int result = s.maxEnvelopes(envs);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
