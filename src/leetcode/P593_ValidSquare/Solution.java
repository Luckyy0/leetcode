package leetcode.P593_ValidSquare;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] points = { p1, p2, p3, p4 };
        Map<Long, Integer> distCounts = new HashMap<>();

        // Calculate all 6 pairwise distances
        // Tính tất cả 6 khoảng cách theo cặp
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                long distSq = distSq(points[i], points[j]);
                if (distSq == 0)
                    return false; // Points cannot overlap
                distCounts.put(distSq, distCounts.getOrDefault(distSq, 0) + 1);
            }
        }

        // Should have exactly 2 distinct distances
        // Phải có chính xác 2 khoảng cách khác biệt
        if (distCounts.size() != 2)
            return false;

        long[] dists = new long[2];
        int idx = 0;
        for (long d : distCounts.keySet()) {
            dists[idx++] = d;
        }
        Arrays.sort(dists);

        long side = dists[0];
        long diag = dists[1];

        // Check counts: 4 sides, 2 diagonals
        // Kiểm tra số lượng: 4 cạnh, 2 đường chéo
        return distCounts.get(side) == 4 && distCounts.get(diag) == 2 && diag == 2 * side; // Optional pythagoras check:
                                                                                           // d^2 = s^2 + s^2 = 2s^2.
                                                                                           // But long type check is
                                                                                           // sufficient? Precision
                                                                                           // issues? Integers are
                                                                                           // exact.
        // Wait, diag length^2 = 2 * side length^2 is mathematically true for square.
        // Coordinates are ints, so distances are exact ints.
    }

    private long distSq(int[] p1, int[] p2) {
        return (long) (p1[0] - p2[0]) * (p1[0] - p2[0]) + (long) (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}
