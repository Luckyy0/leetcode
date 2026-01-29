package leetcode.P757_SetIntersectionSizeAtLeastTwo;

import java.util.Arrays;

class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);

        int count = 0;
        int p1 = -1, p2 = -1; // Two largest values in our set S

        for (int[] iv : intervals) {
            int s = iv[0], e = iv[1];

            // Check how many points from our set S are in [s, e]
            // Kiểm tra xem có bao nhiêu điểm từ tập hợp S của chúng ta nằm trong [s, e]
            if (s > p2) {
                // No points in [s, e]
                count += 2;
                p1 = e - 1;
                p2 = e;
            } else if (s > p1) {
                // Only one point (p2) is in [s, e]
                count += 1;
                p1 = p2;
                p2 = e;
            }
            // If s <= p1, then both p1 and p2 are in [s, e] since p1 < p2 <= e
        }

        return count;
    }
}
