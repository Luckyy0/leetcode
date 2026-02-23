package leet_code.Problem_502_Hard_IPO;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Collections;

public class Solution_Greedy {

    private static class Project {
        int capital;
        int profit;

        public Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }

    /**
     * Maximizes capital after k projects.
     * Strategy: Greedy using Max-Heap for available profits and Sorting for capital
     * requirements.
     * Time: O(N log N + K log N), Space: O(N).
     */
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Project[] projects = new Project[n];

        for (int i = 0; i < n; i++) {
            projects[i] = new Project(capital[i], profits[i]);
        }

        // Sort by capital ascending
        Arrays.sort(projects, (a, b) -> Integer.compare(a.capital, b.capital));

        // Max-heap for profits (reverse order)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int ptr = 0;

        for (int i = 0; i < k; i++) {
            // Add all projects we can afford with current capital w
            while (ptr < n && projects[ptr].capital <= w) {
                pq.offer(projects[ptr].profit);
                ptr++;
            }

            // If no projects available, we can't increase capital anymore
            if (pq.isEmpty()) {
                break;
            }

            // Pick the most profitable one
            w += pq.poll();
        }

        return w;
    }

    public static void main(String[] args) {
        Solution_Greedy solution = new Solution_Greedy();
        int[] profits = { 1, 2, 3 };
        int[] capital = { 0, 1, 1 };
        // k=2, w=0 -> Start (0,1) -> w=1. Options (1,2), (1,3). Pick (1,3) -> w=4.
        System.out.println("Result: " + solution.findMaximizedCapital(2, 0, profits, capital)); // 4
    }
}
