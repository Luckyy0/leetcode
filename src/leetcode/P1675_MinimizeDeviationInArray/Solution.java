package leetcode.P1675_MinimizeDeviationInArray;

import java.util.PriorityQueue;

public class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // Max Heap
        int minVal = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num % 2 != 0) {
                num *= 2;
            }
            pq.offer(num);
            minVal = Math.min(minVal, num);
        }

        int minDeviation = Integer.MAX_VALUE;

        while (true) {
            int maxVal = pq.poll();
            minDeviation = Math.min(minDeviation, maxVal - minVal);

            if (maxVal % 2 != 0) {
                break;
            }

            int newVal = maxVal / 2;
            pq.offer(newVal);
            minVal = Math.min(minVal, newVal);
        }

        return minDeviation;
    }
}
