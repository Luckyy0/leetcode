package leet_code.Problem_593_Medium_Valid_Square;

import java.util.Arrays;

public class Solution_Geometry {

    /**
     * Checks if four points form a valid square.
     * Strategy: Calculate all 6 pairwise distances, sort, and verify constraints.
     * Time: O(1), Space: O(1).
     */
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        long[] dists = new long[6];
        dists[0] = distSq(p1, p2);
        dists[1] = distSq(p1, p3);
        dists[2] = distSq(p1, p4);
        dists[3] = distSq(p2, p3);
        dists[4] = distSq(p2, p4);
        dists[5] = distSq(p3, p4);

        Arrays.sort(dists);

        // Post-sort conditions for a square:
        // 1. All four sides are equal: dists[0]==dists[1]==dists[2]==dists[3]
        // 2. Both diagonals are equal: dists[4]==dists[5]
        // 3. Side must be positive: dists[0] > 0
        // 4. Diagonal must be greater than side: dists[4] > dists[0]
        return dists[0] > 0 &&
                dists[0] == dists[1] &&
                dists[1] == dists[2] &&
                dists[2] == dists[3] &&
                dists[4] == dists[5] &&
                dists[4] > dists[0];
    }

    private long distSq(int[] a, int[] b) {
        return (long) (a[0] - b[0]) * (a[0] - b[0]) + (long) (a[1] - b[1]) * (a[1] - b[1]);
    }

    public static void main(String[] args) {
        Solution_Geometry solution = new Solution_Geometry();
        int[] p1 = { 0, 0 }, p2 = { 1, 1 }, p3 = { 1, 0 }, p4 = { 0, 1 };
        System.out.println("IsValidSquare: " + solution.validSquare(p1, p2, p3, p4)); // true
    }
}
