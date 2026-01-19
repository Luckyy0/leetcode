package leetcode.P218_TheSkylineProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class Solution {

    /**
     * Problem 218: The Skyline Problem
     * Approach: Sweep Line with TreeMap (Multiset)
     * 
     * Theoretical Basis:
     * - Process critical points (edges).
     * - Track active building heights using a TreeMap.
     * - Record points where the max height changes.
     * 
     * Time Complexity: O(N log N)
     * Space Complexity: O(N)
     */
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> points = new ArrayList<>();
        
        for (int[] b : buildings) {
            // Start point: height as negative to distinguish and help sorting
            points.add(new int[]{b[0], -b[2]});
            // End point: height as positive
            points.add(new int[]{b[1], b[2]});
        }
        
        // Sorting logic:
        // 1. Sort by x-coordinate.
        // 2. If x is same, sort by height.
        //    - If both start (neg), -H1 vs -H2. Smaller (more negative -> higher building) first.
        //    - If both end (pos), H1 vs H2. Smaller height first.
        //    - If one start, one end: Start (neg) vs End (pos). Start comes first.
        Collections.sort(points, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        
        // Use TreeMap to store heights and their counts (to handle duplicate heights)
        // Key: Height, Value: Count
        TreeMap<Integer, Integer> heightMap = new TreeMap<>();
        heightMap.put(0, 1); // Ground level
        int prevMaxHeight = 0;
        
        List<List<Integer>> result = new ArrayList<>();
        
        for (int[] p : points) {
            int x = p[0];
            int h = p[1];
            
            if (h < 0) {
                // Start event: add height (-h)
                heightMap.put(-h, heightMap.getOrDefault(-h, 0) + 1);
            } else {
                // End event: remove height (h)
                if (heightMap.get(h) == 1) {
                    heightMap.remove(h);
                } else {
                    heightMap.put(h, heightMap.get(h) - 1);
                }
            }
            
            int currMaxHeight = heightMap.lastKey();
            
            if (currMaxHeight != prevMaxHeight) {
                result.add(Arrays.asList(x, currMaxHeight));
                prevMaxHeight = currMaxHeight;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
        int[][] b1 = {{2,9,10}, {3,7,15}, {5,12,12}, {15,20,10}, {19,24,8}};
        System.out.println("Test 1: " + solution.getSkyline(b1)); 
        // Expected: [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]

        // [[0,2,3],[2,5,3]]
        int[][] b2 = {{0,2,3}, {2,5,3}};
        System.out.println("Test 2: " + solution.getSkyline(b2));
        // Expected: [[0,3],[5,0]]
    }
}
