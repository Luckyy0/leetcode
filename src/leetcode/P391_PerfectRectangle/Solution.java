package leetcode.P391_PerfectRectangle;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * Problem 391: Perfect Rectangle
     * Approach: Area + Corner Set
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public boolean isRectangleCover(int[][] rectangles) {
        long area = 0;
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
        Set<String> points = new HashSet<>();

        for (int[] r : rectangles) {
            int x1 = r[0], y1 = r[1], x2 = r[2], y2 = r[3];
            // update bounding box
            minX = Math.min(minX, x1);
            minY = Math.min(minY, y1);
            maxX = Math.max(maxX, x2);
            maxY = Math.max(maxY, y2);

            area += (long) (x2 - x1) * (y2 - y1);

            // four corners
            String[] corners = { x1 + ":" + y1, x1 + ":" + y2, x2 + ":" + y1, x2 + ":" + y2 };
            for (String p : corners) {
                if (!points.add(p)) {
                    points.remove(p);
                }
            }
        }

        // The bounding rectangle area
        long expected = (long) (maxX - minX) * (maxY - minY);
        if (area != expected)
            return false;

        // The set should contain exactly the four corners of the bounding rectangle
        if (points.size() != 4)
            return false;
        String[] finalCorners = { minX + ":" + minY, minX + ":" + maxY, maxX + ":" + minY, maxX + ":" + maxY };
        for (String p : finalCorners) {
            if (!points.contains(p))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        // Example 1: true
        int[][] rect1 = { { 1, 1, 3, 3 }, { 3, 1, 4, 2 }, { 3, 2, 4, 4 }, { 1, 3, 2, 4 }, { 2, 3, 3, 4 } };
        runTest(sol, rect1, true);
        // Example 2: false (gap)
        int[][] rect2 = { { 1, 1, 2, 3 }, { 1, 3, 2, 4 }, { 3, 1, 4, 2 }, { 3, 2, 4, 4 } };
        runTest(sol, rect2, false);
        // Overlap case
        int[][] rect3 = { { 0, 0, 2, 2 }, { 1, 1, 3, 3 } }; // overlap
        runTest(sol, rect3, false);
    }

    private static void runTest(Solution s, int[][] rects, boolean expected) {
        boolean result = s.isRectangleCover(rects);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        System.out.println(result == expected ? "PASS" : "FAIL");
        System.out.println("-----------------");
    }
}
