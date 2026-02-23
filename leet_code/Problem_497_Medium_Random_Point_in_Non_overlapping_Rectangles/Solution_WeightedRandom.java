package leet_code.Problem_497_Medium_Random_Point_in_Non_overlapping_Rectangles;

import java.util.Random;
import java.util.TreeMap;

public class Solution_WeightedRandom {
    private int[][] rects;
    private TreeMap<Integer, Integer> map;
    private Random rand;
    private int totalArea;

    /**
     * Initializes the object with rectangles.
     * Strategy: Calculate prefix sums of point counts (areas). Use TreeMap for
     * weighted selection.
     */
    public Solution_WeightedRandom(int[][] rects) {
        this.rects = rects;
        this.map = new TreeMap<>();
        this.rand = new Random();
        this.totalArea = 0;

        for (int i = 0; i < rects.length; i++) {
            // Number of integer points = (x2 - x1 + 1) * (y2 - y1 + 1)
            int width = rects[i][2] - rects[i][0] + 1;
            int height = rects[i][3] - rects[i][1] + 1;
            // Area refers to number of points here
            int area = width * height;

            totalArea += area;
            map.put(totalArea, i);
        }
    }

    /**
     * Picks a random point.
     * Time: O(log N) due to TreeMap lookup.
     */
    public int[] pick() {
        // Pick a value in [0, totalArea - 1] -> +1 for ceiling map logic
        // TreeMap.ceilingKey returns least key >= input.
        // Keys are cumulative sums (end of ranges).
        // e.g., area 10. Key 10. Random 0..9.
        // random.nextInt(total) returns [0, total-1].
        // If we map sum to index, key 10 covers points 0..9?
        // Let's say map.put(10, 0). ceilingKey(X).
        // If rand=0, ceil(1) is 10? No.
        // Best practice: Keys are cumulative sums.
        // rand value k in [1, total]. ceilingKey(k).

        int r = rand.nextInt(totalArea) + 1;
        int idx = map.ceilingEntry(r).getValue();

        int[] rect = rects[idx];
        int width = rect[2] - rect[0] + 1;
        int height = rect[3] - rect[1] + 1;
        int pts = width * height;

        // Offset within the rectangle
        // The start of this rectangle's range is map.get(prev_key) + 1?
        // Or simply pick random within the rectangle independently.
        // Once we selected the rectangle based on weight, any point in it is uniform
        // relative to others *in it*.
        // Since rect selection probability was Area/Total, combining gives 1/Total for
        // any point.

        int x = rect[0] + rand.nextInt(width);
        int y = rect[1] + rand.nextInt(height);

        return new int[] { x, y };
    }

    public static void main(String[] args) {
        int[][] rects = { { -2, -2, 1, 1 }, { 2, 2, 4, 6 } };
        Solution_WeightedRandom solution = new Solution_WeightedRandom(rects);

        int[] p1 = solution.pick();
        System.out.println("Point 1: [" + p1[0] + ", " + p1[1] + "]");

        int[] p2 = solution.pick();
        System.out.println("Point 2: [" + p2[0] + ", " + p2[1] + "]");
    }
}
