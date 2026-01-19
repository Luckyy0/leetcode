package leetcode.P254_FactorCombinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * Problem 254: Factor Combinations
     * Approach: Backtracking
     * 
     * Theoretical Basis:
     * - Try divisors starting from 2 (or 'start' to maintain order).
     * - If i divides n, then [i, n/i] is a candidate.
     * - Also recurse on n/i to break it down further.
     * 
     * Time Complexity: N/A (Output sensitive)
     * Space Complexity: O(log N)
     */
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 3) {
            return result;
        }
        dfs(n, 2, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int n, int start, List<Integer> current, List<List<Integer>> result) {
        // Try factors up to sqrt(n)
        for (int i = start; i * i <= n; i++) {
            if (n % i == 0) {
                // Found a factor i
                current.add(i);

                // Option 1: Combine i with the remaining part (n/i) and stop
                List<Integer> validCombo = new ArrayList<>(current);
                validCombo.add(n / i);
                result.add(validCombo);

                // Option 2: Keep splitting (n/i)
                dfs(n / i, i, current, result);

                // Backtrack
                current.remove(current.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 12 -> [[2, 6], [2, 2, 3], [3, 4]]
        runTest(solution, 12);

        // 37 -> []
        runTest(solution, 37);

        // 32 -> [[2, 16], [2, 2, 8], [2, 2, 2, 4], [2, 2, 2, 2, 2], [4, 8]]
        runTest(solution, 32);
    }

    private static void runTest(Solution s, int n) {
        List<List<Integer>> result = s.getFactors(n);
        System.out.println("n=" + n + " -> " + result);
        System.out.println("-----------------");
    }
}
