package leetcode.P223_RectangleArea;

public class Solution {

    /**
     * Problem 223: Rectangle Area
     * Approach: Area(A) + Area(B) - Area(Overlap)
     * 
     * Theoretical Basis:
     * - Overlap width = min(rights) - max(lefts)
     * - Overlap height = min(tops) - max(bottoms)
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int areaA = (ax2 - ax1) * (ay2 - ay1);
        int areaB = (bx2 - bx1) * (by2 - by1);

        // Calculate overlap dimensions
        int overlapWidth = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        int overlapHeight = Math.min(ay2, by2) - Math.max(ay1, by1);

        int areaOverlap = 0;
        if (overlapWidth > 0 && overlapHeight > 0) {
            areaOverlap = overlapWidth * overlapHeight;
        }

        // Note: Intermediate addition might exceed int range if coordinates were
        // larger,
        // but constraints say sum fits in int?
        // Max coordinate 10^4 -> Side 2*10^4 -> Area 4*10^8 -> Sum < 10^9 (fits in
        // int).
        return areaA + areaB - areaOverlap;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        // A: (-3, 0) to (3, 4) -> 6 * 4 = 24
        // B: (0, -1) to (9, 2) -> 9 * 3 = 27
        // Overlap: x(0 to 3)=3, y(0 to 2)=2 -> 6
        // Total: 24 + 27 - 6 = 45
        runTest(solution, -3, 0, 3, 4, 0, -1, 9, 2, 45);

        // Example 2
        // A: (-2, -2) to (2, 2) -> 4 * 4 = 16
        // B: (-2, -2) to (2, 2) -> 16
        // Overlap: 16
        // Total: 16
        runTest(solution, -2, -2, 2, 2, -2, -2, 2, 2, 16);
    }

    private static void runTest(Solution s, int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2,
            int expected) {
        int result = s.computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
