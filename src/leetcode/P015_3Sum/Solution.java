package leetcode.P015_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     * Problem 15: 3Sum
     * Approach: Sorting + Two Pointers
     * Time Complexity: O(n^2)
     * Space Complexity: O(log n) to O(n) (sorting)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Optimization: If the smallest number is > 0, we can't sum to 0
            if (nums[i] > 0)
                break;

            // Skip duplicates for the first number
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int lo = i + 1;
            int hi = nums.length - 1;
            int sum = 0 - nums[i];

            while (lo < hi) {
                if (nums[lo] + nums[hi] == sum) {
                    res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));

                    // Skip duplicates for the second number
                    while (lo < hi && nums[lo] == nums[lo + 1])
                        lo++;
                    // Skip duplicates for the third number
                    while (lo < hi && nums[hi] == nums[hi - 1])
                        hi--;

                    lo++;
                    hi--;
                } else if (nums[lo] + nums[hi] < sum) {
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, new int[] { -1, 0, 1, 2, -1, -4 }, "[[-1, -1, 2], [-1, 0, 1]]");
        runTest(solution, new int[] { 0, 1, 1 }, "[]");
        runTest(solution, new int[] { 0, 0, 0 }, "[[0, 0, 0]]");
        runTest(solution, new int[] { -2, 0, 1, 1, 2 }, "[[-2, 0, 2], [-2, 1, 1]]");
    }

    private static void runTest(Solution s, int[] input, String expected) {
        System.out.print("Input: " + Arrays.toString(input));
        List<List<Integer>> result = s.threeSum(input);
        System.out.println("\nOutput: " + result);
        System.out.println("Expected (approx): " + expected);

        // Simple string comparison for verification (order might vary but sorting
        // helps)
        // Comparison is heuristic here
        System.out.println("-----------------");
    }
}
