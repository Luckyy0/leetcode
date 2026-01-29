package leetcode.P1847_ClosestRoom;

import java.util.Arrays;
import java.util.TreeSet;

public class Solution {
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        int n = rooms.length;
        int k = queries.length;
        int[] result = new int[k];

        // Store query indices to restore order
        int[][] sortedQueries = new int[k][3];
        for (int i = 0; i < k; i++) {
            sortedQueries[i][0] = queries[i][0]; // pref id
            sortedQueries[i][1] = queries[i][1]; // min size
            sortedQueries[i][2] = i; // original index
        }

        // Sort rooms by size descending
        Arrays.sort(rooms, (a, b) -> Integer.compare(b[1], a[1]));
        // Sort queries by min size descending
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(b[1], a[1]));

        TreeSet<Integer> roomIds = new TreeSet<>();
        int roomIdx = 0;

        for (int i = 0; i < k; i++) {
            int prefId = sortedQueries[i][0];
            int minSize = sortedQueries[i][1];
            int origIdx = sortedQueries[i][2];

            // Add valid rooms
            while (roomIdx < n && rooms[roomIdx][1] >= minSize) {
                roomIds.add(rooms[roomIdx][0]);
                roomIdx++;
            }

            if (roomIds.isEmpty()) {
                result[origIdx] = -1;
            } else {
                Integer floor = roomIds.floor(prefId);
                Integer ceiling = roomIds.ceiling(prefId);

                int ans = -1;
                int minDiff = Integer.MAX_VALUE;

                if (floor != null) {
                    int diff = Math.abs(prefId - floor);
                    if (diff < minDiff) {
                        minDiff = diff;
                        ans = floor;
                    } else if (diff == minDiff) {
                        ans = Math.min(ans, floor);
                    }
                }

                if (ceiling != null) {
                    int diff = Math.abs(prefId - ceiling);
                    if (diff < minDiff) {
                        minDiff = diff;
                        ans = ceiling;
                    } else if (diff == minDiff) {
                        ans = Math.min(ans, ceiling);
                    }
                }

                result[origIdx] = ans;
            }
        }

        return result;
    }
}
