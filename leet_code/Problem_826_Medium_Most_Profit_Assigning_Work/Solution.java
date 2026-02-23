package leet_code.Problem_826_Medium_Most_Profit_Assigning_Work;

import java.util.Arrays;

public class Solution {

    /**
     * Calculates the maximum profit by assigning workers to suitable jobs.
     * Strategy: Sort both jobs (by difficulty) and workers (by capability).
     * Use two pointers to keep track of the best profit found so far.
     * Time: O(N log N + M log M), Space: O(N).
     */
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int m = worker.length;

        // Combine difficulty and profit into single objects
        int[][] jobs = new int[n][2];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }

        // Step 1: Sort jobs by difficulty (ascending)
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Sort workers by capability (ascending)
        Arrays.sort(worker);

        int totalProfit = 0;
        int jobIdx = 0;
        int maxProfitFound = 0;

        // Step 3: Iterate through sorted workers
        for (int capability : worker) {
            // Traverse all jobs that this worker can perform
            while (jobIdx < n && jobs[jobIdx][0] <= capability) {
                // Keep track of the highest profit available among all jobs done so far
                maxProfitFound = Math.max(maxProfitFound, jobs[jobIdx][1]);
                jobIdx++;
            }
            // Assign the best profit found to this worker
            totalProfit += maxProfitFound;
        }

        return totalProfit;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] d1 = { 2, 4, 6, 8, 10 }, p1 = { 10, 20, 30, 40, 50 }, w1 = { 4, 5, 6, 7 };
        System.out.println("Result 1: " + sol.maxProfitAssignment(d1, p1, w1)); // 100

        int[] d2 = { 85, 47, 57 }, p2 = { 24, 66, 99 }, w2 = { 40, 25, 25 };
        System.out.println("Result 2: " + sol.maxProfitAssignment(d2, p2, w2)); // 0
    }
}
