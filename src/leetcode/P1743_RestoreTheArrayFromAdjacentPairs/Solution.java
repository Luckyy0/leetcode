package leetcode.P1743_RestoreTheArrayFromAdjacentPairs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            adj.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
            adj.computeIfAbsent(pair[1], k -> new ArrayList<>()).add(pair[0]);
        }

        int start = 0;
        for (Map.Entry<Integer, List<Integer>> entry : adj.entrySet()) {
            if (entry.getValue().size() == 1) {
                start = entry.getKey();
                break;
            }
        }

        int n = adjacentPairs.length + 1;
        int[] result = new int[n];
        result[0] = start;

        int prev = Integer.MIN_VALUE; // Dummy

        for (int i = 0; i < n - 1; i++) {
            int curr = result[i];
            List<Integer> neighbors = adj.get(curr);
            for (int neighbor : neighbors) {
                if (neighbor != prev) {
                    result[i + 1] = neighbor;
                    prev = curr;
                    break;
                }
            }
        }

        return result;
    }
}
