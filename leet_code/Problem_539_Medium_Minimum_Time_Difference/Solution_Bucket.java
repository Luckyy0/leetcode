package leet_code.Problem_539_Medium_Minimum_Time_Difference;

import java.util.List;

public class Solution_Bucket {

    /**
     * Finds min time difference.
     * Strategy: Use boolean array[1440] for O(N) sort.
     * Time: O(N), Space: O(1).
     */
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 1440) {
            return 0; // Pigeonhole principle
        }

        boolean[] seen = new boolean[1440];

        for (String time : timePoints) {
            int h = Integer.parseInt(time.substring(0, 2));
            int m = Integer.parseInt(time.substring(3, 5));
            int mins = h * 60 + m;

            if (seen[mins])
                return 0; // Duplicate time
            seen[mins] = true;
        }

        int first = -1;
        int prev = -1;
        int minDiff = Integer.MAX_VALUE;

        // Linear scan 0 to 1439
        for (int i = 0; i < 1440; i++) {
            if (seen[i]) {
                if (first == -1) {
                    first = i;
                } else {
                    minDiff = Math.min(minDiff, i - prev);
                }
                prev = i;
            }
        }

        // Circular difference: (first + 1440) - last
        minDiff = Math.min(minDiff, (first + 1440) - prev);

        return minDiff;
    }

    public static void main(String[] args) {
        Solution_Bucket solution = new Solution_Bucket();
        List<String> times = List.of("23:59", "00:00");
        System.out.println("Result: " + solution.findMinDifference(times)); // 1
    }
}
