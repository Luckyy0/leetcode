package leetcode.P1046_LastStoneWeight;

import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : stones)
            pq.add(x);

        while (pq.size() > 1) {
            int y = pq.poll();
            int x = pq.poll();
            if (y > x) {
                pq.add(y - x);
            }
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }
}
