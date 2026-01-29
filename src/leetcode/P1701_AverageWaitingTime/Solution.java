package leetcode.P1701_AverageWaitingTime;

public class Solution {
    public double averageWaitingTime(int[][] customers) {
        long currentTime = 0;
        long totalWait = 0;

        for (int[] c : customers) {
            int arrival = c[0];
            int time = c[1];

            long start = Math.max(currentTime, arrival);
            long finish = start + time;

            totalWait += (finish - arrival);
            currentTime = finish;
        }

        return (double) totalWait / customers.length;
    }
}
