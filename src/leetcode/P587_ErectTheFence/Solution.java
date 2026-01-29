package leetcode.P587_ErectTheFence;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[][] outerTrees(int[][] trees) {
        if (trees.length <= 1)
            return trees;

        // Sort by x-coordinate, then y-coordinate
        // Sắp xếp theo tọa độ x, sau đó tọa độ y
        Arrays.sort(trees, (a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });

        Stack<int[]> hull = new Stack<>();

        // Build lower hull
        // Xây dựng bao lồi dưới
        for (int i = 0; i < trees.length; i++) {
            while (hull.size() >= 2 && crossProduct(hull.get(hull.size() - 2), hull.peek(), trees[i]) < 0) {
                hull.pop();
            }
            hull.push(trees[i]);
        }

        // Build upper hull
        // Xây dựng bao lồi trên
        // Note: The loop starts from n-2 because n-1 (last point) is already in hull
        // from lower pass
        // However, standard Monotone Chain includes duplicates at start/end, we remove
        // later.
        // Or simply pop last element before starting upper hull?
        // Actually, for collinear points handling, we need care.
        // Problem asks to output all points on perimeter.
        // So crossProduct == 0 should be KEPT? No, crossProduct < 0 means right turn
        // (concave).
        // If > 0 (Left Turn) -> Good.
        // If < 0 (Right Turn) -> Bad, pop.
        // If = 0 (Collinear) -> Keep? Yes, we need all points on fence.
        // So condition to pop is ONLY STRICTLY LESS THAN 0.

        // Remove duplicate start point?
        // Let's just build upper hull separately and merge.

        Stack<int[]> upper = new Stack<>();
        for (int i = trees.length - 1; i >= 0; i--) {
            while (upper.size() >= 2 && crossProduct(upper.get(upper.size() - 2), upper.peek(), trees[i]) < 0) {
                upper.pop();
            }
            upper.push(trees[i]);
        }

        // Combine results
        // Kết hợp kết quả
        java.util.Set<int[]> unique = new java.util.HashSet<>();
        unique.addAll(hull);
        unique.addAll(upper);

        int[][] res = new int[unique.size()][2];
        int idx = 0;
        for (int[] p : unique) {
            res[idx++] = p;
        }

        return res;
    }

    // Cross product of vectors OA and OB
    // Tích có hướng của các vectơ OA và OB
    // Value > 0: Counter-clockwise (Left turn)
    // Value < 0: Clockwise (Right turn)
    // Value = 0: Collinear
    private int crossProduct(int[] o, int[] a, int[] b) {
        return (a[0] - o[0]) * (b[1] - o[1]) - (a[1] - o[1]) * (b[0] - o[0]);
    }
}
