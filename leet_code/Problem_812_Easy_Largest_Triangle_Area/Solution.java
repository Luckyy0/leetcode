package leet_code.Problem_812_Easy_Largest_Triangle_Area;

public class Solution {

    /**
     * Finds the largest triangle area from a given set of points.
     * Strategy: Iterate through all triplets and calculate area using the Shoelace
     * formula.
     * Time: O(N^3), Space: O(1).
     */
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double maxArea = 0;

        // Loop through all points for the first vertex
        for (int i = 0; i < n - 2; i++) {
            // Loop through remaining points for the second vertex
            for (int j = i + 1; j < n - 1; j++) {
                // Loop through remaining points for the third vertex
                for (int k = j + 1; k < n; k++) {
                    // Update maxArea if current triangle is larger
                    maxArea = Math.max(maxArea, calculateArea(
                            points[i], points[j], points[k]));
                }
            }
        }

        return maxArea;
    }

    /**
     * Calculates the area of a triangle given its three vertices.
     * Uses the Shoelace Formula: Area = 0.5 * |x1(y2-y3) + x2(y3-y1) + x3(y1-y2)|
     */
    private double calculateArea(int[] p1, int[] p2, int[] p3) {
        return 0.5 * Math.abs(
                p1[0] * (p2[1] - (double) p3[1]) +
                        p2[0] * (p3[1] - (double) p1[1]) +
                        p3[0] * (p1[1] - (double) p2[1]));
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] p1 = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 0, 2 }, { 2, 0 } };
        System.out.println("Result 1: " + sol.largestTriangleArea(p1));

        int[][] p2 = { { 1, 0 }, { 0, 0 }, { 0, 1 } };
        System.out.println("Result 2: " + sol.largestTriangleArea(p2));
    }
}
