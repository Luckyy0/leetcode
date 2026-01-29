package leetcode.P473_MatchsticksToSquare;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 473: Matchsticks to Square
     * Approach: Backtracking (DFS)
     * 
     * Time Complexity: O(4^N)
     * Space Complexity: O(N)
     */
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length < 4)
            return false;

        long sum = 0;
        for (int m : matchsticks)
            sum += m;
        if (sum % 4 != 0)
            return false;

        int target = (int) (sum / 4);

        // Sort descending to prune early
        Arrays.sort(matchsticks);
        reverse(matchsticks);

        return dfs(matchsticks, 0, new int[4], target);
    }

    private boolean dfs(int[] matchsticks, int index, int[] sides, int target) {
        if (index == matchsticks.length) {
            return sides[0] == target && sides[1] == target && sides[2] == target;
        }

        for (int i = 0; i < 4; i++) {
            // Pruning: skip if current side + stick > target
            if (sides[i] + matchsticks[index] > target)
                continue;

            // Optimization: If two sides have the same length, trying both is redundant
            int j = i - 1;
            while (j >= 0) {
                if (sides[j] == sides[i])
                    break;
                j--;
            }
            if (j != -1)
                continue;

            sides[i] += matchsticks[index];
            if (dfs(matchsticks, index + 1, sides, target))
                return true;
            sides[i] -= matchsticks[index];
        }

        return false;
    }

    private void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // [1,1,2,2,2] -> true
        int[] m1 = { 1, 1, 2, 2, 2 };
        System.out.println("Result: " + sol.makesquare(m1) + " (Expected: true)");

        // [3,3,3,3,4] -> false
        int[] m2 = { 3, 3, 3, 3, 4 };
        System.out.println("Result: " + sol.makesquare(m2) + " (Expected: false)");
    }
}
