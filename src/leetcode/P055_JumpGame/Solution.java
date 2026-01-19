package leetcode.P055_JumpGame;

public class Solution {

    /**
     * Problem 55: Jump Game
     * Approach: Greedy
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public boolean canJump(int[] nums) {
        int farthest = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // If current index is beyond the farthest reachable point, we are stuck
            // Nếu chỉ số hiện tại vượt quá điểm xa nhất có thể đạt được, chúng ta bị mắc
            // kẹt
            if (i > farthest) {
                return false;
            }

            farthest = Math.max(farthest, i + nums[i]);

            // Optimization: If we can reach the end, return true
            if (farthest >= n - 1) {
                return true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, new int[] { 2, 3, 1, 1, 4 }, true);
        runTest(solution, new int[] { 3, 2, 1, 0, 4 }, false);
        runTest(solution, new int[] { 0 }, true);
        runTest(solution, new int[] { 0, 2, 3 }, false);
    }

    private static void runTest(Solution s, int[] nums, boolean expected) {
        System.out.println("Input size: " + nums.length);
        boolean result = s.canJump(nums);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
