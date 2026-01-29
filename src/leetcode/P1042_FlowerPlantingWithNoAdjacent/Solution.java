package leetcode.P1042_FlowerPlantingWithNoAdjacent;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());

        for (int[] p : paths) {
            adj.get(p[0]).add(p[1]);
            adj.get(p[1]).add(p[0]);
        }

        int[] result = new int[n];
        for (int i = 1; i <= n; i++) {
            boolean[] used = new boolean[5]; // colors 1..4
            for (int neighbor : adj.get(i)) {
                if (result[neighbor - 1] != 0) { // neighbor - 1 is index
                    used[result[neighbor - 1]] = true;
                }
            }

            for (int c = 1; c <= 4; c++) {
                if (!used[c]) {
                    result[i - 1] = c;
                    break;
                }
            }
        }
        return result;
    }
}
