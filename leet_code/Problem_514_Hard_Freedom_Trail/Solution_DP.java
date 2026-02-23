package leet_code.Problem_514_Hard_Freedom_Trail;

import java.util.*;

public class Solution_DP {

    private Map<Character, List<Integer>> charToIndices;
    private Integer[][] memo;

    /**
     * Finds min steps to spell key.
     * Strategy: Top-down DP (Memoization).
     * Time: O(K * N^2) worst case, effectively less. Space: O(K * N).
     */
    public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int k = key.length();

        charToIndices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = ring.charAt(i);
            charToIndices.computeIfAbsent(c, x -> new ArrayList<>()).add(i);
        }

        memo = new Integer[k][n];

        return solve(ring, key, 0, 0);
    }

    private int solve(String ring, String key, int keyIdx, int ringIdx) {
        if (keyIdx == key.length()) {
            return 0;
        }

        if (memo[keyIdx][ringIdx] != null) {
            return memo[keyIdx][ringIdx];
        }

        char target = key.charAt(keyIdx);
        int minSteps = Integer.MAX_VALUE;
        int n = ring.length();

        List<Integer> nextIndices = charToIndices.get(target);

        for (int nextIdx : nextIndices) {
            // Calculate distance
            int dist = Math.abs(ringIdx - nextIdx);
            int rotate = Math.min(dist, n - dist);

            // 1 step for pressing button + rotation steps + recursion
            int steps = rotate + 1 + solve(ring, key, keyIdx + 1, nextIdx);

            minSteps = Math.min(minSteps, steps);
        }

        memo[keyIdx][ringIdx] = minSteps;
        return minSteps;
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();
        String ring = "godding";
        String key = "gd";
        System.out.println("Result: " + solution.findRotateSteps(ring, key)); // 4
    }
}
