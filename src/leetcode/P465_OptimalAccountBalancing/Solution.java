package leetcode.P465_OptimalAccountBalancing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    /**
     * Problem 465: Optimal Account Balancing
     * Approach: Backtracking (DFS)
     * 
     * Time Complexity: O((N-1)!)
     * Space Complexity: O(N)
     */
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] t : transactions) {
            map.put(t[0], map.getOrDefault(t[0], 0) - t[2]);
            map.put(t[1], map.getOrDefault(t[1], 0) + t[2]);
        }

        List<Integer> debts = new ArrayList<>();
        for (int balance : map.values()) {
            if (balance != 0) {
                debts.add(balance);
            }
        }

        return dfs(0, debts);
    }

    private int dfs(int start, List<Integer> debts) {
        // Skip people with 0 balance
        while (start < debts.size() && debts.get(start) == 0) {
            start++;
        }

        if (start == debts.size())
            return 0;

        int min = Integer.MAX_VALUE;
        for (int i = start + 1; i < debts.size(); i++) {
            // Try matching start with i if they have opposite signs
            if (debts.get(start) * debts.get(i) < 0) {
                // Settle start using i
                debts.set(i, debts.get(i) + debts.get(start));
                min = Math.min(min, 1 + dfs(start + 1, debts));
                // Backtrack
                debts.set(i, debts.get(i) - debts.get(start));
            }
        }

        return min;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // [[0,1,10],[2,0,5]] -> 2
        int[][] t1 = { { 0, 1, 10 }, { 2, 0, 5 } };
        System.out.println("Result: " + sol.minTransfers(t1) + " (Expected: 2)");

        // [[0,1,10],[1,0,1],[1,2,5],[2,0,5]] -> 1
        // Balances: 0: -10+1+5 = -4, 1: 10-1-5 = 4, 2: 5-5 = 0.
        // Debts: [-4, 4]. Min transfers: 1.
        int[][] t2 = { { 0, 1, 10 }, { 1, 0, 1 }, { 1, 2, 5 }, { 2, 0, 5 } };
        System.out.println("Result: " + sol.minTransfers(t2) + " (Expected: 1)");
    }
}
