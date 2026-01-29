package leetcode.P1183_MaximumNumberOfOnes;

import java.util.PriorityQueue;

class Solution {
    public int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int r = 0; r < sideLength; r++) {
            for (int c = 0; c < sideLength; c++) {
                // Determine how many times (r, c) repeats in the grid
                int rows = (height - 1 - r) / sideLength + 1;
                int cols = (width - 1 - c) / sideLength + 1;
                pq.offer(rows * cols);
            }
        }

        int total = 0;
        for (int i = 0; i < maxOnes; i++) {
            if (!pq.isEmpty()) {
                total += pq.poll();
            }
        }
        return total;
    }
}
