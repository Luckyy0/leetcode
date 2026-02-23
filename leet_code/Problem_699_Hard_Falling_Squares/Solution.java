package leet_code.Problem_699_Hard_Falling_Squares;

import java.util.*;

public class Solution {

    /**
     * Simulation of falling squares to track maximum height.
     */
    private static class Square {
        int left, right, top;

        Square(int l, int r, int t) {
            this.left = l;
            this.right = r;
            this.top = t;
        }
    }

    /**
     * Calculates maximum height after each square is dropped.
     * Strategy: O(N^2) simulation checking overlaps with previous squares.
     * Time: O(N^2), Space: O(N).
     */
    public List<Integer> fallingSquares(int[][] positions) {
        List<Square> history = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int maxSoFar = 0;

        for (int[] pos : positions) {
            int left = pos[0];
            int side = pos[1];
            int right = left + side;

            int baseHeight = 0;
            // Scan all previous squares for overlap
            for (Square prev : history) {
                // Check if intervals [left, right) and [prev.left, prev.right) overlap
                if (left < prev.right && right > prev.left) {
                    baseHeight = Math.max(baseHeight, prev.top);
                }
            }

            int currentTop = baseHeight + side;
            history.add(new Square(left, right, currentTop));

            // Maintain global max height
            maxSoFar = Math.max(maxSoFar, currentTop);
            result.add(maxSoFar);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] pos1 = { { 1, 2 }, { 2, 3 }, { 6, 1 } };
        System.out.println("Result 1: " + sol.fallingSquares(pos1)); // [2, 5, 5]

        int[][] pos2 = { { 100, 100 }, { 200, 100 } };
        System.out.println("Result 2: " + sol.fallingSquares(pos2)); // [100, 100]
    }
}
