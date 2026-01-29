package leetcode.P360_SortTransformedArray;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 360: Sort Transformed Array
     * Approach: Two Pointers
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;

        // If a >= 0: Ends are largest. Fill from end.
        // If a < 0: Ends are smallest. Fill from start.
        int idx = (a >= 0) ? n - 1 : 0;

        while (left <= right) {
            int y1 = quad(nums[left], a, b, c);
            int y2 = quad(nums[right], a, b, c);

            if (a >= 0) {
                // Pick larger to put at end
                if (y1 > y2) {
                    result[idx--] = y1;
                    left++;
                } else {
                    result[idx--] = y2;
                    right--;
                }
            } else {
                // Pick smaller to put at start
                if (y1 < y2) {
                    result[idx++] = y1;
                    left++;
                } else {
                    result[idx++] = y2;
                    right--;
                }
            }
        }

        return result;
    }

    private int quad(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [-4,-2,2,4], 1, 3, 5 -> [3,9,15,33]
        runTest(solution, new int[] { -4, -2, 2, 4 }, 1, 3, 5, "[3, 9, 15, 33]");

        // [-4,-2,2,4], -1, 3, 5 -> [-23,-5,1,7]
        runTest(solution, new int[] { -4, -2, 2, 4 }, -1, 3, 5, "[-23, -5, 1, 7]");
    }

    private static void runTest(Solution s, int[] nums, int a, int b, int c, String expected) {
        int[] result = s.sortTransformedArray(nums, a, b, c);
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
