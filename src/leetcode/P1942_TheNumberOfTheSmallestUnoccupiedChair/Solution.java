package leetcode.P1942_TheNumberOfTheSmallestUnoccupiedChair;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        // int[3]: {time, type, friendIdx}
        // type 1: arrive, type 0: leave
        // Sort by time. If tie, process leave (0) before arrive (1).

        int[][] events = new int[2 * n][3];
        for (int i = 0; i < n; i++) {
            events[2 * i] = new int[] { times[i][0], 1, i };
            events[2 * i + 1] = new int[] { times[i][1], 0, i };
        }

        Arrays.sort(events, (a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        // Initially no chairs are explicitly "available" in PQ, we use a counter
        // for "next new chair". But to keep it simple, just add recycled chairs.
        // Or fill PQ with 0..N? N is 10^4. Feasible.
        for (int i = 0; i < n; i++)
            availableChairs.offer(i);

        int[] assignedChair = new int[n];

        for (int[] e : events) {
            int time = e[0];
            int type = e[1];
            int friend = e[2];

            if (type == 1) { // Arrive
                int chair = availableChairs.poll();
                assignedChair[friend] = chair;
                if (friend == targetFriend)
                    return chair;
            } else { // Leave
                availableChairs.offer(assignedChair[friend]);
            }
        }

        return -1;
    }
}
