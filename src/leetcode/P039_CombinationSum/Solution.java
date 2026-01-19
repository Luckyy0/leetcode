package leetcode.P039_CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     * Problem 39: Combination Sum
     * Approach: Backtracking
     * Time Complexity: O(N^(T/M))
     * Space Complexity: O(T/M)
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Sorting is optional but helps in pruning if we iterate
        // Sắp xếp là tùy chọn nhưng giúp cắt tỉa nếu chúng ta lặp
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
            // Pruning: if current candidate is greater than remaining target, no need to
            // proceed (since sorted)
            if (candidates[i] > remaining) {
                break;
            }

            current.add(candidates[i]);
            // Recursive call: pass 'i' as start to allow reusing the same element
            // Gọi đệ quy: truyền 'i' làm start để cho phép sử dụng lại cùng một phần tử
            backtrack(result, current, candidates, remaining - candidates[i], i);
            current.remove(current.size() - 1); // Backtrack
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, new int[] { 2, 3, 6, 7 }, 7, "[[2, 2, 3], [7]]");
        runTest(solution, new int[] { 2, 3, 5 }, 8, "[[2, 2, 2, 2], [2, 3, 3], [3, 5]]");
        runTest(solution, new int[] { 2 }, 1, "[]");
    }

    private static void runTest(Solution s, int[] candidates, int target, String expected) {
        System.out.println("Input: " + Arrays.toString(candidates) + ", target = " + target);
        List<List<Integer>> result = s.combinationSum(candidates, target);
        System.out.println("Output: " + result);
        System.out.println("Expected: " + expected);
        System.out.println("-----------------");
    }
}
