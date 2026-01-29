package leetcode.P453_MinimumMovesToEqualArrayElements;

public class Solution {

    /**
     * Problem 453: Minimum Moves to Equal Array Elements
     * Approach: Mathematical (Sum(nums) - n * minVal)
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int minMoves(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int min = nums[0];
        long sum = 0;

        for (int num : nums) {
            if (num < min)
                min = num;
            sum += num;
        }

        return (int) (sum - (long) min * nums.length);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // [1,2,3] -> 3
        int[] nums1 = { 1, 2, 3 };
        runTest(sol, nums1, 3);

        // [1,1,1] -> 0
        int[] nums2 = { 1, 1, 1 };
        runTest(sol, nums2, 0);

        // [1, 10] -> 9
        int[] nums3 = { 1, 10 };
        runTest(sol, nums3, 9);
    }

    private static void runTest(Solution sol, int[] nums, int expected) {
        int result = sol.minMoves(nums);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
