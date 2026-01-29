package leetcode.P1499_MaxValueOfEquation;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        Deque<int[]> dq = new ArrayDeque<>(); // stores {diff, x} where diff = y - x
        int maxVal = Integer.MIN_VALUE;

        for (int[] p : points) {
            int x = p[0];
            int y = p[1];

            // Remove outdated
            while (!dq.isEmpty() && x - dq.peekFirst()[1] > k) {
                dq.pollFirst();
            }

            if (!dq.isEmpty()) {
                maxVal = Math.max(maxVal, x + y + dq.peekFirst()[0]);
            }

            int diff = y - x;
            while (!dq.isEmpty() && dq.peekLast()[0] <= diff) {
                dq.pollLast();
            }
            dq.offerLast(new int[] { diff, x });
        }

        return maxVal;
    }
}
