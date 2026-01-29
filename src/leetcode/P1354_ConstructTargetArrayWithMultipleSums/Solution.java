package leetcode.P1354_ConstructTargetArrayWithMultipleSums;

import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public boolean isPossible(int[] target) {
        if (target.length == 1)
            return target[0] == 1;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        for (int x : target) {
            sum += x;
            pq.offer(x);
        }

        while (pq.peek() > 1) {
            int max = pq.poll();
            long rest = sum - max;

            if (rest == 1)
                return true;
            if (rest == 0 || max <= rest)
                return false;

            int next = (int) (max % rest);
            if (next == 0)
                return false; // Elements must be positive

            sum = rest + next;
            pq.offer(next);
        }

        return true;
    }
}
