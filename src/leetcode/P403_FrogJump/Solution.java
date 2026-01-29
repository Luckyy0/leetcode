package leetcode.P403_FrogJump;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    /**
     * Problem 403: Frog Jump
     * Approach: Dynamic Programming using Map of Sets
     * 
     * Time Complexity: O(N^2)
     * Space Complexity: O(N^2)
     */
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0)
            return false;

        int n = stones.length;
        // Map: stone position -> set of jump sizes that reached this stone
        Map<Integer, Set<Integer>> dp = new HashMap<>();

        for (int stone : stones) {
            dp.put(stone, new HashSet<>());
        }

        // Initial state: at stone 0, imaginary last jump was 0
        dp.get(0).add(0);

        for (int i = 0; i < n; i++) {
            int currentStone = stones[i];
            Set<Integer> jumps = dp.get(currentStone);

            for (int k : jumps) {
                // Possible next jumps: k-1, k, k+1
                for (int nextStep = k - 1; nextStep <= k + 1; nextStep++) {
                    if (nextStep > 0) {
                        int nextStone = currentStone + nextStep;
                        if (dp.containsKey(nextStone)) {
                            dp.get(nextStone).add(nextStep);
                        }
                    }
                }
            }
        }

        return !dp.get(stones[n - 1]).isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // stones = [0,1,3,5,6,8,12,17] -> true
        runTest(solution, new int[] { 0, 1, 3, 5, 6, 8, 12, 17 }, true);

        // stones = [0,1,2,3,4,8,9,11] -> false
        runTest(solution, new int[] { 0, 1, 2, 3, 4, 8, 9, 11 }, false);
    }

    private static void runTest(Solution sol, int[] stones, boolean expected) {
        boolean result = sol.canCross(stones);
        System.out.println("Stones: " + java.util.Arrays.toString(stones) + " -> Result: " + result + " (Expected: "
                + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
