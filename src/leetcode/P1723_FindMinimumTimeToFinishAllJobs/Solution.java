package leetcode.P1723_FindMinimumTimeToFinishAllJobs;

import java.util.Arrays;

public class Solution {
    public int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        // Reverse for desc order
        for (int i = 0; i < jobs.length / 2; i++) {
            int temp = jobs[i];
            jobs[i] = jobs[jobs.length - 1 - i];
            jobs[jobs.length - 1 - i] = temp;
        }

        int low = jobs[0];
        int high = 0;
        for (int j : jobs)
            high += j;

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canDistribute(jobs, new int[k], 0, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean canDistribute(int[] jobs, int[] workers, int idx, int limit) {
        if (idx == jobs.length)
            return true;

        int job = jobs[idx];
        for (int i = 0; i < workers.length; i++) {
            if (workers[i] + job <= limit) {
                workers[i] += job;
                if (canDistribute(jobs, workers, idx + 1, limit))
                    return true;
                workers[i] -= job;
            }

            // Optimization: if worker was empty and we failed, don't try other empty
            // workers
            if (workers[i] == 0)
                return false;
            // Optimization: if adding job makes worker exactly full limit, further branches
            // unlikely better? No strict.
        }
        return false;
    }
}
