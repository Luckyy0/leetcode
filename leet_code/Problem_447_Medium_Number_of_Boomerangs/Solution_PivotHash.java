package leet_code.Problem_447_Medium_Number_of_Boomerangs;

import java.util.*;

public class Solution_PivotHash {

    /**
     * Finds the number of tuples (i, j, k) where dist(i,j) == dist(i,k).
     * Strategy: For each point i, group other points by distance squared.
     * Time: O(n^2), Space: O(n).
     */
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>(); // SquaredDistance -> Count

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j)
                    continue;

                int d = getDistance(points[i], points[j]);
                map.put(d, map.getOrDefault(d, 0) + 1);
            }

            // for each distance with m points, there are m*(m-1) ways
            for (int val : map.values()) {
                res += val * (val - 1);
            }

            map.clear();
        }

        return res;
    }

    private int getDistance(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];
        return dx * dx + dy * dy;
    }

    public static void main(String[] args) {
        Solution_PivotHash solution = new Solution_PivotHash();
        int[][] pts = { { 0, 0 }, { 1, 0 }, { 2, 0 } };
        System.out.println("Result: " + solution.numberOfBoomerangs(pts)); // 2
    }
}
