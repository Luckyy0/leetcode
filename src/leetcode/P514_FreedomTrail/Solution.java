package leetcode.P514_FreedomTrail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    /**
     * Problem 514: Freedom Trail
     * Approach: DP with Memoization
     * 
     * Time Complexity: O(keyLength * ringLength * occurrences)
     * Space Complexity: O(keyLength * ringLength)
     */
    public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int m = key.length();

        // Character positions in the ring
        Map<Character, List<Integer>> posMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            posMap.computeIfAbsent(ring.charAt(i), k -> new ArrayList<>()).add(i);
        }

        return dfs(0, 0, ring, key, posMap, new Integer[m][n]);
    }

    private int dfs(int kIdx, int rIdx, String ring, String key, Map<Character, List<Integer>> posMap,
            Integer[][] memo) {
        if (kIdx == key.length())
            return 0;
        if (memo[kIdx][rIdx] != null)
            return memo[kIdx][rIdx];

        int n = ring.length();
        int minSteps = Integer.MAX_VALUE;

        for (int nextRIdx : posMap.get(key.charAt(kIdx))) {
            int diff = Math.abs(nextRIdx - rIdx);
            int dist = Math.min(diff, n - diff);

            int res = dfs(kIdx + 1, nextRIdx, ring, key, posMap, memo);
            minSteps = Math.min(minSteps, dist + 1 + res);
        }

        return memo[kIdx][rIdx] = minSteps;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // ring = "godding", key = "gd" -> 4
        System.out.println("Result: " + sol.findRotateSteps("godding", "gd") + " (Expected: 4)");
    }
}
