package leet_code.Problem_679_Hard_24_Game;

import java.util.*;

public class Solution {

    /**
     * Determines if 4 cards can result in 24 using arithmetic operators.
     * Strategy: Recursive backtracking by picking two numbers and replacing them
     * with result.
     * Time: O(1) (small constant number of combinations), Space: O(1).
     */
    public boolean judgePoint24(int[] cards) {
        List<Double> list = new ArrayList<>();
        for (int card : cards) {
            list.add((double) card);
        }
        return solve(list);
    }

    private boolean solve(List<Double> list) {
        // Base case: only one number left, check if it's 24
        if (list.size() == 1) {
            return Math.abs(list.get(0) - 24.0) < 1e-6;
        }

        // Pick any two numbers i and j
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i == j)
                    continue;

                List<Double> nextList = new ArrayList<>();
                // Copy remaining numbers in the pool
                for (int k = 0; k < list.size(); k++) {
                    if (k != i && k != j) {
                        nextList.add(list.get(k));
                    }
                }

                Double a = list.get(i);
                Double b = list.get(j);

                // Try all 6 operator combinations (subtraction and division commute-sensitive)
                List<Double> results = new ArrayList<>();
                results.add(a + b);
                results.add(a - b);
                results.add(b - a);
                results.add(a * b);
                if (Math.abs(b) > 1e-6)
                    results.add(a / b);
                if (Math.abs(a) > 1e-6)
                    results.add(b / a);

                for (Double res : results) {
                    nextList.add(res);
                    if (solve(nextList))
                        return true;
                    nextList.remove(nextList.size() - 1); // backtrack
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result [4,1,8,7]: " + sol.judgePoint24(new int[] { 4, 1, 8, 7 })); // true
        System.out.println("Result [1,2,1,2]: " + sol.judgePoint24(new int[] { 1, 2, 1, 2 })); // false
    }
}
