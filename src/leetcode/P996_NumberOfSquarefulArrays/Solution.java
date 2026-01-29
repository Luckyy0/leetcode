package leetcode.P996_NumberOfSquarefulArrays;

import java.util.*;

class Solution {
    int count = 0;

    public int numSquarefulPerms(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums)
            freq.put(x, freq.getOrDefault(x, 0) + 1);

        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int x : freq.keySet()) {
            for (int y : freq.keySet()) {
                double s = Math.sqrt(x + y);
                if (s == (int) s) {
                    adj.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
                }
            }
        }

        for (int x : freq.keySet()) {
            dfs(x, nums.length - 1, freq, adj);
        }
        return count;
    }

    private void dfs(int x, int remaining, Map<Integer, Integer> freq, Map<Integer, List<Integer>> adj) {
        freq.put(x, freq.get(x) - 1);
        if (remaining == 0) {
            count++;
        } else if (adj.containsKey(x)) {
            for (int y : adj.get(x)) {
                if (freq.get(y) > 0) {
                    dfs(y, remaining - 1, freq, adj);
                }
            }
        }
        freq.put(x, freq.get(x) + 1);
    }
}
