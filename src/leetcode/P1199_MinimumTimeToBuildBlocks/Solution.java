package leetcode.P1199_MinimumTimeToBuildBlocks;

import java.util.PriorityQueue;

class Solution {
    public int minBuildTime(int[] blocks, int split) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int b : blocks)
            pq.offer(b);

        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();
            // Combined cost is split + max(x, y). Since x <= y, it's split + y.
            pq.offer(split + y);
        }

        return pq.poll();
    }
}
