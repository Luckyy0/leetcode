package leetcode.P370_RangeAddition;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 370: Range Addition
     * Approach: Difference Array
     * 
     * Time Complexity: O(N + K)
     * Space Complexity: O(N)
     */
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];

        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int val = update[2];

            res[start] += val;
            if (end + 1 < length) {
                res[end + 1] -= val;
            }
        }

        for (int i = 1; i < length; i++) {
            res[i] += res[i - 1];
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]] -> [-2,0,3,5,3]
        int[][] updates = {
                { 1, 3, 2 },
                { 2, 4, 3 },
                { 0, 2, -2 }
        };
        runTest(solution, 5, updates, "[-2, 0, 3, 5, 3]");
    }

    private static void runTest(Solution s, int len, int[][] updates, String expected) {
        int[] result = s.getModifiedArray(len, updates);
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
