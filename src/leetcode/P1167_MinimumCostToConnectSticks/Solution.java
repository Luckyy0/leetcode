package leetcode.P1167_MinimumCostToConnectSticks;

import java.util.PriorityQueue;

class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : sticks)
            pq.offer(s);

        int cost = 0;
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            int sum = a + b;
            cost += sum;
            pq.offer(sum);
        }

        return cost;
    }
}
