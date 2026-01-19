package leetcode.P077_Combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * Problem 77: Combinations
     * Approach: Backtracking with Pruning
     * Time Complexity: O(C(n, k) * k)
     * Space Complexity: O(k)
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int n, int k, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Optimization: The upper bound of search is n - (k - current.size()) + 1.
        // If we have less elements remaining than needed to complete the combination,
        // we can stop.
        int limit = n - (k - current.size()) + 1;

        for (int i = start; i <= limit; i++) {
            current.add(i);
            backtrack(i + 1, n, k, current, result);
            current.remove(current.size() - 1); // Backtrack
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, 4, 2, 6);
        runTest(solution, 1, 1, 1);
        runTest(solution, 5, 3, 10);
    }

    private static void runTest(Solution s, int n, int k, int expectedCount) {
        System.out.println("Input: n=" + n + ", k=" + k);
        List<List<Integer>> result = s.combine(n, k);
        System.out.println("Output count: " + result.size() + " (Expected: " + expectedCount + ")");
        System.out.println("Result: " + result);

        if (result.size() == expectedCount) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
