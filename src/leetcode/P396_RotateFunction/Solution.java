package leetcode.P396_RotateFunction;

public class Solution {

    /**
     * Problem 396: Rotate Function
     * Approach: Math Formula F(k) = F(k-1) + S - n * nums[n-k]
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int maxRotateFunction(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        long sum = 0;
        long f = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f += (long) i * nums[i];
        }

        long max = f;
        for (int k = 1; k < n; k++) {
            // F(k) = F(k-1) + sum - n * last_element_of_previous_rotation
            // The last element of F(k-1) is nums[n-k]
            f = f + sum - (long) n * nums[n - k];
            max = Math.max(max, f);
        }

        return (int) max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [4,3,2,6] -> 26
        runTest(solution, new int[] { 4, 3, 2, 6 }, 26);

        // [100] -> 0
        runTest(solution, new int[] { 100 }, 0);
    }

    private static void runTest(Solution sol, int[] nums, int expected) {
        int result = sol.maxRotateFunction(nums);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
