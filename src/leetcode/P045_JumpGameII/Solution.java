package leetcode.P045_JumpGameII;

public class Solution {

    /**
     * Problem 45: Jump Game II
     * Approach: Greedy (BFS like)
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1)
            return 0;

        int n = nums.length;
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        // Loop until n-2 because if we are at n-1, we are already there
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;

                // If we can already reach the end, break early
                if (currentEnd >= n - 1) {
                    break;
                }
            }
        }

        return jumps;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, new int[] { 2, 3, 1, 1, 4 }, 2);
        runTest(solution, new int[] { 2, 3, 0, 1, 4 }, 2);
        runTest(solution, new int[] { 0 }, 0);
        runTest(solution, new int[] { 1, 2 }, 1);
    }

    private static void runTest(Solution s, int[] nums, int expected) {
        System.out.println("Input size: " + nums.length);
        int result = s.jump(nums);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
