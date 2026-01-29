package leetcode.P1632_RankTransformOfAMatrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public int[][] matrixRankTransform(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        TreeMap<Integer, List<int[]>> valueMap = new TreeMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                valueMap.computeIfAbsent(matrix[i][j], k -> new ArrayList<>()).add(new int[] { i, j });
            }
        }

        int[] rowMax = new int[m];
        int[] colMax = new int[n];
        int[][] rankMatrix = new int[m][n];

        for (int val : valueMap.keySet()) {
            List<int[]> cells = valueMap.get(val);

            // Union Find to group connected rows and cols
            // Map row/col ID to parent
            // Row i is i, Col j is j + m
            // But we only care about active rows/cols in this batch

            // Improvised Union-Find using a Map
            Map<Integer, Integer> p = new HashMap<>();

            for (int[] cell : cells) {
                int r = cell[0];
                int c = cell[1] + m;

                p.putIfAbsent(r, r);
                p.putIfAbsent(c, c);

                union(p, r, c);
            }

            // Group cells by their root representitive
            Map<Integer, List<int[]>> components = new HashMap<>();
            for (int[] cell : cells) {
                int r = cell[0];
                int root = find(p, r);
                components.computeIfAbsent(root, k -> new ArrayList<>()).add(cell);
            }

            // Process each component
            for (List<int[]> group : components.values()) {
                int maxRank = 0;
                for (int[] cell : group) {
                    maxRank = Math.max(maxRank, rowMax[cell[0]]);
                    maxRank = Math.max(maxRank, colMax[cell[1]]);
                }

                int newRank = maxRank + 1;
                for (int[] cell : group) {
                    rankMatrix[cell[0]][cell[1]] = newRank;
                    rowMax[cell[0]] = newRank;
                    colMax[cell[1]] = newRank;
                }
            }
        }

        return rankMatrix;
    }

    private int find(Map<Integer, Integer> p, int x) {
        if (p.get(x) != x) {
            p.put(x, find(p, p.get(x)));
        }
        return p.get(x);
    }

    private void union(Map<Integer, Integer> p, int x, int y) {
        int rx = find(p, x);
        int ry = find(p, y);
        if (rx != ry) {
            p.put(rx, ry);
        }
    }
}
