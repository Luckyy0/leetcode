package leetcode.P1298_MaximumCandiesYouCanGetFromBoxes;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        boolean[] boxFound = new boolean[n];
        boolean[] keyFound = new boolean[n];
        boolean[] opened = new boolean[n];
        boolean[] inQueue = new boolean[n];

        Queue<Integer> q = new LinkedList<>();

        for (int b : initialBoxes) {
            boxFound[b] = true;
            if (status[b] == 1) { // Open box
                q.offer(b);
                inQueue[b] = true;
            }
        }

        int totalCandies = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            if (opened[curr])
                continue;
            opened[curr] = true;
            totalCandies += candies[curr];

            // Process keys found in this box
            for (int k : keys[curr]) {
                keyFound[k] = true;
                if (boxFound[k] && !inQueue[k] && !opened[k]) {
                    q.offer(k);
                    inQueue[k] = true;
                }
            }

            // Process contained boxes
            for (int b : containedBoxes[curr]) {
                boxFound[b] = true;
                if (!inQueue[b] && !opened[b]) {
                    if (status[b] == 1 || keyFound[b]) {
                        q.offer(b);
                        inQueue[b] = true;
                    }
                }
            }
        }

        return totalCandies;
    }
}
