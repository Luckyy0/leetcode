package leetcode.P497_RandomPointInNonOverlappingRectangles;

import java.util.Random;
import java.util.TreeMap;

public class Solution {

    private final int[][] rects;
    private final TreeMap<Integer, Integer> map;
    private final Random random;
    private int totalPoints;

    /**
     * Problem 497: Random Point in Non-overlapping Rectangles
     * Approach: Prefix Sum with TreeMap for weighted sampling
     */
    public Solution(int[][] rects) {
        this.rects = rects;
        this.map = new TreeMap<>();
        this.random = new Random();
        this.totalPoints = 0;

        for (int i = 0; i < rects.length; i++) {
            int pointsInRect = (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
            totalPoints += pointsInRect;
            map.put(totalPoints, i);
        }
    }

    public int[] pick() {
        // Find which rectangle using the random integer
        // ceilingKey returns the smallest key greater than or equal to the target
        int r = random.nextInt(totalPoints) + 1;
        int rectIdx = map.get(map.ceilingKey(r));

        int[] rect = rects[rectIdx];
        int x = rect[0] + random.nextInt(rect[2] - rect[0] + 1);
        int y = rect[1] + random.nextInt(rect[3] - rect[1] + 1);

        return new int[] { x, y };
    }

    public static void main(String[] args) {
        int[][] rects = { { -2, -2, -1, -1 }, { 1, 0, 3, 0 } };
        Solution sol = new Solution(rects);

        System.out.println("Pick 1: " + java.util.Arrays.toString(sol.pick()));
        System.out.println("Pick 2: " + java.util.Arrays.toString(sol.pick()));
        System.out.println("Pick 3: " + java.util.Arrays.toString(sol.pick()));
    }
}
