package leetcode.P213_HouseRobberII;

public class Solution {

    /**
     * Problem 213: House Robber II
     * Approach: Two Linear Scans (0 to n-2) and (1 to n-1)
     * 
     * Theoretical Basis:
     * - Break the circle by assuming we definitely don't rob last (case 1)
     * or definitely don't rob first (case 2).
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        int max1 = robLinear(nums, 0, nums.length - 2);
        int max2 = robLinear(nums, 1, nums.length - 1);

        return Math.max(max1, max2);
    }

    private int robLinear(int[] nums, int start, int end) {
        int prevPrev = 0;
        int prev = 0;

        for (int i = start; i <= end; i++) {
            int current = Math.max(prev, nums[i] + prevPrev);
            prevPrev = prev;
            prev = current;
        }

        return prev;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [2,3,2] -> 3
        runTest(solution, new int[] { 2, 3, 2 }, 3);

        // [1,2,3,1] -> 4
        runTest(solution, new int[] { 1, 2, 3, 1 }, 4);

        // [1,2,3] -> 3
        runTest(solution, new int[] { 1, 2, 3 }, 3);

        // [0] -> 0
        runTest(solution, new int[] { 0 }, 0);
    }

    private static void runTest(Solution s, int[] nums, int expected) {
        int result = s.rob(nums);
        System.out.print("Input: [");
        for (int i = 0; i < Math.min(nums.length, 5); i++)
            System.out.print(nums[i] + (i < nums.length - 1 ? "," : ""));
        System.out.println(nums.length > 5 ? "...]" : "]");
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
