package leetcode.P849_MaximizeDistanceToClosestPerson;

class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int maxDist = 0;
        int last = -1;

        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                if (last == -1) {
                    // Leading zeros
                    maxDist = i;
                } else {
                    // Interior zero block
                    maxDist = Math.max(maxDist, (i - last) / 2);
                }
                last = i;
            }
        }

        // Trailing zeros
        maxDist = Math.max(maxDist, n - 1 - last);

        return maxDist;
    }
}
