package leet_code.Problem_465_Hard_Optimal_Account_Balancing;

import java.util.*;

public class Solution_DFS {

    /**
     * Minimizes the number of transactions to settle all debts.
     * Strategy: Backtracking on non-zero net balances.
     * Time: O(N!), Space: O(N).
     */
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] t : transactions) {
            map.put(t[0], map.getOrDefault(t[0], 0) - t[2]);
            map.put(t[1], map.getOrDefault(t[1], 0) + t[2]);
        }

        List<Integer> list = new ArrayList<>();
        for (int val : map.values()) {
            if (val != 0)
                list.add(val);
        }

        return dfs(0, list);
    }

    private int dfs(int k, List<Integer> list) {
        // Skip people with balance 0
        if (k == list.size())
            return 0;
        if (list.get(k) == 0)
            return dfs(k + 1, list);

        int res = Integer.MAX_VALUE;
        for (int i = k + 1; i < list.size(); i++) {
            // Only try if they have opposite signs (one gives, one receives)
            if (list.get(k) * list.get(i) < 0) {
                list.set(i, list.get(i) + list.get(k));
                res = Math.min(res, 1 + dfs(k + 1, list));
                list.set(i, list.get(i) - list.get(k)); // Backtrack

                // Optimization: if we found a perfect match that makes a balance zero,
                // we've likely found a very good path.
                if (list.get(k) + list.get(i) == 0)
                    break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution_DFS solution = new Solution_DFS();
        int[][] t = { { 0, 1, 10 }, { 2, 0, 5 } };
        System.out.println("Result: " + solution.minTransfers(t)); // 2
    }
}
