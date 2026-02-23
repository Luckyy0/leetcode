package leet_code.Problem_469_Medium_Convex_Polygon;

import java.util.List;

public class Solution_CrossProduct {

    /**
     * Checks if the given points form a convex polygon.
     * Strategy: Verify that all consecutive edges turn in the same direction (cross
     * product sign).
     * Time: O(N), Space: O(1).
     */
    public boolean isConvex(List<List<Integer>> points) {
        int n = points.size();
        long prev = 0;
        long curr;

        for (int i = 0; i < n; i++) {
            List<Integer> p1 = points.get(i);
            List<Integer> p2 = points.get((i + 1) % n);
            List<Integer> p3 = points.get((i + 2) % n);

            curr = crossProduct(p1, p2, p3);

            // If collinear, curr is 0, we just continue (doesn't determine direction)
            if (curr != 0) {
                // If we already have a direction (prev != 0) and signs don't match
                if (prev != 0 && (curr > 0) != (prev > 0)) {
                    return false;
                }
                prev = curr;
            }
        }

        return true;
    }

    // Calculates the cross product of vectors (p2-p1) and (p3-p2)
    // Formula: (x2-x1)*(y3-y2) - (y2-y1)*(x3-x2)
    private long crossProduct(List<Integer> p1, List<Integer> p2, List<Integer> p3) {
        long x1 = p1.get(0), y1 = p1.get(1);
        long x2 = p2.get(0), y2 = p2.get(1);
        long x3 = p3.get(0), y3 = p3.get(1);

        return (x2 - x1) * (y3 - y2) - (y2 - y1) * (x3 - x2);
    }
}
