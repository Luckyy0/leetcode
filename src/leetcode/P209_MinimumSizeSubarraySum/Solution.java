package leetcode.P209_MinimumSizeSubarraySum;

public class Solution {

    /**
     * Problem 209: Minimum Size Subarray Sum
     * Approach: Sliding Window
     * 
     * Theoretical Basis:
     * - Expand right until sum >= target.
     * - Shrink left while sum >= target to find minimal length.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                int currentLength = right - left + 1;
                minLength = Math.min(minLength, currentLength);

                sum -= nums[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // target = 7, nums = [2,3,1,2,4,3] -> 2 ([4,3])
        runTest(solution, 7, new int[] { 2, 3, 1, 2, 4, 3 }, 2);

        // target = 4, nums = [1,4,4] -> 1 ([4])
        runTest(solution, 4, new int[] { 1, 4, 4 }, 1);

        // target = 11, nums = [1,1,1,1] -> 0
        runTest(solution, 11, new int[] { 1, 1, 1, 1 }, 0);
    }

    private static void runTest(Solution s, int target, int[] nums, int expected) {
        int result = s.minSubArrayLen(target, nums);
        System.out.print("Target: " + target + ", Nums: [");
        for (int i = 0; i < Math.min(nums.length, 5); i++)
            System.out.print(nums[i] + (i < nums.length - 1 ? "," : ""));
        System.out.println(nums.length > 5 ? "...]" : "]");
        System.out.println("Result: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
