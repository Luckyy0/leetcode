package leetcode.P216_CombinationSumIII;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * Problem 216: Combination Sum III
     * Approach: Backtracking
     * 
     * Theoretical Basis:
     * - Choose k numbers from 1-9 without replacement.
     * - Sum must equal n.
     * 
     * Time Complexity: O(C(9, k)) -> O(1) effectively since k <= 9
     * Space Complexity: O(k)
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int k, int remain, int start) {
        if (tempList.size() == k) {
            if (remain == 0) {
                result.add(new ArrayList<>(tempList));
            }
            return;
        }

        for (int i = start; i <= 9; i++) {
            // Pruning: if adding i exceeds remain, no need to continue (since i increases)
            if (remain - i < 0)
                break;

            tempList.add(i);
            backtrack(result, tempList, k, remain - i, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // k=3, n=7 -> [[1,2,4]]
        System.out.println("k=3, n=7: " + solution.combinationSum3(3, 7));

        // k=3, n=9 -> [[1,2,6], [1,3,5], [2,3,4]]
        System.out.println("k=3, n=9: " + solution.combinationSum3(3, 9));

        // k=4, n=1 -> []
        System.out.println("k=4, n=1: " + solution.combinationSum3(4, 1));
    }
}
