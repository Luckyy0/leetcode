package leet_code.Problem_836_Easy_Rectangle_Overlap;

public class Solution {

    /**
     * Checks if two axis-aligned rectangles overlap.
     * Strategy: A overlap in 2D occurs if and only if both X and Y projections
     * overlap.
     * Time: O(1), Space: O(1).
     */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // rec format: [x1, y1, x2, y2]

        // Check X-axis projection overlap:
        // Max of start coordinates should be less than Min of end coordinates.
        boolean xOverlap = Math.max(rec1[0], rec2[0]) < Math.min(rec1[2], rec2[2]);

        // Check Y-axis projection overlap:
        boolean yOverlap = Math.max(rec1[1], rec2[1]) < Math.min(rec1[3], rec2[3]);

        return xOverlap && yOverlap;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] r1 = { 0, 0, 2, 2 }, r2 = { 1, 1, 3, 3 };
        System.out.println("Result 1: " + sol.isRectangleOverlap(r1, r2)); // true

        int[] r3 = { 0, 0, 1, 1 }, r4 = { 1, 0, 2, 1 };
        System.out.println("Result 2: " + sol.isRectangleOverlap(r3, r4)); // false
    }
}
