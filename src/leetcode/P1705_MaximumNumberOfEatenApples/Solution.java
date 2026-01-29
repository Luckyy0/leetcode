package leetcode.P1705_MaximumNumberOfEatenApples;

import java.util.PriorityQueue;

public class Solution {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // [rotDay, count]
        int eaten = 0;
        int n = apples.length;

        int i = 0;
        while (i < n || !pq.isEmpty()) {
            // Add apples if within range
            if (i < n && apples[i] > 0) {
                pq.offer(new int[] { i + days[i], apples[i] });
            }

            // Remove rotten
            while (!pq.isEmpty() && pq.peek()[0] <= i) {
                pq.poll();
            }

            // Eat
            if (!pq.isEmpty()) {
                int[] curr = pq.peek();
                curr[1]--;
                eaten++;
                if (curr[1] == 0) {
                    pq.poll();
                }
            }

            i++;
        }

        return eaten;
    }
}
