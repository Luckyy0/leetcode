package leetcode.P040_CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     * Problem 40: Combination Sum II
     * Approach: Backtracking with Duplicate Pruning
     * Time Complexity: O(2^N)
     * Space Complexity: O(N)
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] candidates, int remaining,
            int start) {
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Pruning: if candidate > remaining, stop
            if (candidates[i] > remaining) {
                break;
            }

            // Skip duplicates: if the current element is same as previous and we are not at
            // the start of this loop iteration
            // Bỏ qua trùng lặp: nếu phần tử hiện tại giống phần tử trước và chúng ta không
            // ở đầu vòng lặp này
            // This ensures we only use the first instance of a duplicated number for the
            // current position
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            current.add(candidates[i]);
            backtrack(result, current, candidates, remaining - candidates[i], i + 1); // Move to i + 1
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8, "[[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]]");
        runTest(solution, new int[] { 2, 5, 2, 1, 2 }, 5, "[[1, 2, 2], [5]]");
    }

    private static void runTest(Solution s, int[] candidates, int target, String expected) {
        System.out.println("Input: " + Arrays.toString(candidates) + ", target = " + target);
        List<List<Integer>> result = s.combinationSum2(candidates, target);
        System.out.println("Output: " + result);
        System.out.println("Expected: " + expected);
        System.out.println("-----------------");
    }
}
