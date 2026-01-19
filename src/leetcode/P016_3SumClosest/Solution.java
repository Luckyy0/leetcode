package leetcode.P016_3SumClosest;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 16: 3Sum Closest
     * Approach: Sorting + Two Pointers
     * Time Complexity: O(n^2)
     * Space Complexity: O(log n)
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int lo = i + 1;
            int hi = nums.length - 1;

            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];

                if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                    closestSum = sum;
                }

                if (sum < target) {
                    lo++;
                } else if (sum > target) {
                    hi--;
                } else {
                    // sum == target, difference is 0, can't get better
                    return sum;
                }
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, new int[] { -1, 2, 1, -4 }, 1, 2);
        runTest(solution, new int[] { 0, 0, 0 }, 1, 0);
        runTest(solution, new int[] { 1, 1, 1, 0 }, 100, 3);
        runTest(solution, new int[] { 1, 1, -1, -1, 3 }, -1, -1);
    }

    private static void runTest(Solution s, int[] input, int target, int expected) {
        System.out.println("Input: " + Arrays.toString(input) + ", target = " + target);
        int result = s.threeSumClosest(input, target);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
