package leetcode.P1235_MaximumProfitInJobScheduling;

import java.util.Arrays;
import java.util.TreeMap;

class Solution {
    class Job {
        int start, end, profit;

        Job(int s, int e, int p) {
            this.start = s;
            this.end = e;
            this.profit = p;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, (a, b) -> a.end - b.end);

        TreeMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(0, 0);

        for (Job job : jobs) {
            int prevProfit = dp.floorEntry(job.start).getValue();
            int currentProfit = prevProfit + job.profit;

            if (currentProfit > dp.lastEntry().getValue()) {
                dp.put(job.end, currentProfit);
            }
        }

        return dp.lastEntry().getValue();
    }
}
