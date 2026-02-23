package leet_code.Problem_473_Medium_Matchsticks_to_Square;

import java.util.Arrays;
import java.util.Collections;

public class Solution_Backtracking {

    /**
     * Determines if matchsticks can form a square.
     * Strategy: Partition into 4 equal sum subsets using backtracking.
     * Time: O(4^N), Space: O(N).
     */
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length < 4)
            return false;

        int sum = 0;
        for (int m : matchsticks)
            sum += m;

        if (sum % 4 != 0)
            return false;
        int side = sum / 4;

        // Sort descending to optimize backtracking (try larger sticks first)
        // Convert to Integer array to use Collections.reverseOrder
        Integer[] sticks = new Integer[matchsticks.length];
        for (int i = 0; i < matchsticks.length; i++)
            sticks[i] = matchsticks[i];
        Arrays.sort(sticks, Collections.reverseOrder());

        return backtrack(sticks, 0, new int[4], side);
    }

    private boolean backtrack(Integer[] sticks, int index, int[] bucketSums, int target) {
        if (index == sticks.length) {
            // Check if all buckets are equal (actually if we validly placed all sticks,
            // and total sum is divisible, buckets must be equal, but safe check:
            // bucketSums[0] == target)
            return true;
        }

        for (int i = 0; i < 4; i++) {
            if (bucketSums[i] + sticks[index] <= target) {
                // Optimization: If this bucket has same sum as previous bucket,
                // trying this bucket is redundant (symmetry)
                // Note: ensuring we sort buckets or check i > 0 && bucketSums[i] ==
                // bucketSums[i-1]
                // helps, but generic check is usually enough for N=15.
                // However, a stronger pruning is: if this is the FIRST empty bucket we see,
                // putting it here is same as putting in any other empty bucket.

                bucketSums[i] += sticks[index];
                if (backtrack(sticks, index + 1, bucketSums, target))
                    return true;
                bucketSums[i] -= sticks[index];

                // If bucket is empty and we failed to fill it, no need to try other empty
                // buckets
                if (bucketSums[i] == 0)
                    break;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution_Backtracking solution = new Solution_Backtracking();
        int[] m1 = { 1, 1, 2, 2, 2 };
        System.out.println("Result 1: " + solution.makesquare(m1)); // true

        int[] m2 = { 3, 3, 3, 3, 4 };
        System.out.println("Result 2: " + solution.makesquare(m2)); // false
    }
}
