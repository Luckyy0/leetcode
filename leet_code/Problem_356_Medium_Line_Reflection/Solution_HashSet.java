package leet_code.Problem_356_Medium_Line_Reflection;

import java.util.HashSet;
import java.util.Set;

public class Solution_HashSet {

    /**
     * Checks if points reflect across a vertical line.
     * Uses min/max trick and HashSet for O(N) time.
     * Time: O(N), Space: O(N).
     * 
     * Kiểm tra xem các điểm có đối xứng qua một đường thẳng đứng không.
     * Sử dụng mẹo min/max và HashSet để đạt thời gian O(N).
     */
    public boolean isReflected(int[][] points) {
        if (points == null || points.length == 0)
            return true;

        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        Set<String> set = new HashSet<>();

        for (int[] p : points) {
            minX = Math.min(minX, p[0]);
            maxX = Math.max(maxX, p[0]);
            set.add(p[0] + "," + p[1]);
        }

        // The sum S = x1 + x2 = 2k (where x = k is the line)
        int sum = minX + maxX;

        for (int[] p : points) {
            // Check if reflected point exists
            String reflected = (sum - p[0]) + "," + p[1];
            if (!set.contains(reflected)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution_HashSet solution = new Solution_HashSet();

        // Test Case 1: [[1,1],[-1,1]] -> true
        int[][] p1 = { { 1, 1 }, { -1, 1 } };
        System.out.println("Result 1: " + solution.isReflected(p1));

        // Test Case 2: [[1,1],[-1,-1]] -> false
        int[][] p2 = { { 1, 1 }, { -1, -1 } };
        System.out.println("Result 2: " + solution.isReflected(p2));
    }
}
