package leetcode.P1962_RemoveStonesToMinimizeTheTotal;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long currentSum = 0;
        for (int p : piles) {
            pq.offer(p);
            currentSum += p;
        }

        for (int i = 0; i < k; i++) {
            if (pq.isEmpty())
                break;
            int max = pq.poll();
            int remove = max / 2;
            currentSum -= remove;
            pq.offer(max - remove);
        }

        return (int) currentSum;
        // Problem says return int, sum fits in int?
        // 10^5 * 10^4 = 10^9. Fits in int.
    }
}
