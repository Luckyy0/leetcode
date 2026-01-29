package leetcode.P475_Heaters;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 475: Heaters
     * Approach: Binary Search for Nearest Heater
     * 
     * Time Complexity: O(M log M + N log M)
     * Space Complexity: O(1)
     */
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int maxRadius = 0;

        for (int house : houses) {
            int idx = Arrays.binarySearch(heaters, house);

            if (idx < 0) {
                int insertPos = -(idx + 1);
                int leftDist = (insertPos > 0) ? house - heaters[insertPos - 1] : Integer.MAX_VALUE;
                int rightDist = (insertPos < heaters.length) ? heaters[insertPos] - house : Integer.MAX_VALUE;

                maxRadius = Math.max(maxRadius, Math.min(leftDist, rightDist));
            }
            // If idx >= 0, dist is 0, so no update to maxRadius
        }

        return maxRadius;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // [1,2,3], [2] -> 1
        int[] houses1 = { 1, 2, 3 };
        int[] heaters1 = { 2 };
        runTest(sol, houses1, heaters1, 1);

        // [1,2,3,4], [1,4] -> 1
        int[] houses2 = { 1, 2, 3, 4 };
        int[] heaters2 = { 1, 4 };
        runTest(sol, houses2, heaters2, 1);

        // [1,5], [2] -> 3
        int[] houses3 = { 1, 5 };
        int[] heaters3 = { 2 };
        runTest(sol, houses3, heaters3, 3);
    }

    private static void runTest(Solution sol, int[] houses, int[] heaters, int expected) {
        int result = sol.findRadius(houses, heaters);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
