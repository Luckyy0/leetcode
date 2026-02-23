package leet_code.Problem_391_Hard_Perfect_Rectangle;

import java.util.HashSet;
import java.util.Set;

public class Solution_CornerSet {

    /**
     * Perfect Rectangle check.
     * Logic: Area sum must match bounding box, and only the 4 main corners remain.
     * Time: O(N), Space: O(N).
     * 
     * Kiểm tra Hình chữ nhật Hoàn hảo.
     * Logic: Tổng diện tích phải trùng với hộp bao quanh, và chỉ 4 góc chính còn
     * lại.
     */
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles == null || rectangles.length == 0)
            return false;

        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y2 = Integer.MIN_VALUE;

        Set<String> set = new HashSet<>();
        long totalArea = 0;

        for (int[] r : rectangles) {
            x1 = Math.min(x1, r[0]);
            y1 = Math.min(y1, r[1]);
            x2 = Math.max(x2, r[2]);
            y2 = Math.max(y2, r[3]);

            totalArea += (long) (r[2] - r[0]) * (r[3] - r[1]);

            String[] corners = {
                    r[0] + " " + r[1],
                    r[0] + " " + r[3],
                    r[2] + " " + r[1],
                    r[2] + " " + r[3]
            };

            for (String s : corners) {
                if (!set.add(s)) {
                    set.remove(s);
                }
            }
        }

        // 1. Check if the 4 main corners are the only ones left
        if (!set.contains(x1 + " " + y1) || !set.contains(x1 + " " + y2) ||
                !set.contains(x2 + " " + y1) || !set.contains(x2 + " " + y2) ||
                set.size() != 4) {
            return false;
        }

        // 2. Check Area
        return totalArea == (long) (x2 - x1) * (y2 - y1);
    }

    public static void main(String[] args) {
        Solution_CornerSet solution = new Solution_CornerSet();

        // Example 1
        int[][] rect1 = { { 1, 1, 3, 3 }, { 3, 1, 4, 2 }, { 3, 2, 4, 4 }, { 1, 3, 2, 4 }, { 2, 3, 4, 4 } };
        System.out.println("Result 1: " + solution.isRectangleCover(rect1)); // true

        // Example 2
        int[][] rect2 = { { 1, 1, 2, 3 }, { 1, 3, 2, 4 }, { 3, 1, 4, 2 }, { 3, 2, 4, 4 } };
        System.out.println("Result 2: " + solution.isRectangleCover(rect2)); // false
    }
}
