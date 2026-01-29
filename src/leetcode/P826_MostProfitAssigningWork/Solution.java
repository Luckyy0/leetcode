package leetcode.P826_MostProfitAssigningWork;

import java.util.Arrays;

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] jobs = new int[n][2];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }

        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        Arrays.sort(worker);

        int totalProfit = 0;
        int maxProfit = 0;
        int jobIdx = 0;

        for (int ability : worker) {
            while (jobIdx < n && jobs[jobIdx][0] <= ability) {
                maxProfit = Math.max(maxProfit, jobs[jobIdx][1]);
                jobIdx++;
            }
            totalProfit += maxProfit;
        }

        return totalProfit;
    }
}
