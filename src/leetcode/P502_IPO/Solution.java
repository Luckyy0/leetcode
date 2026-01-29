package leetcode.P502_IPO;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    private static class Project {
        int capital, profit;

        Project(int c, int p) {
            this.capital = c;
            this.profit = p;
        }
    }

    /**
     * Problem 502: IPO
     * Approach: Greedy with Max-Heap for profit and sorted list for capital
     * 
     * Time Complexity: O(N log N + K log N)
     * Space Complexity: O(N)
     */
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Project[] projects = new Project[n];
        for (int i = 0; i < n; i++) {
            projects[i] = new Project(capital[i], profits[i]);
        }

        // Sort by capital requirement ascending
        Arrays.sort(projects, (a, b) -> Integer.compare(a.capital, b.capital));

        // Max-Heap for profits of available projects
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        int currentProjectIdx = 0;
        for (int i = 0; i < k; i++) {
            // Add all affordable projects to the heap
            while (currentProjectIdx < n && projects[currentProjectIdx].capital <= w) {
                maxProfitHeap.offer(projects[currentProjectIdx].profit);
                currentProjectIdx++;
            }

            if (maxProfitHeap.isEmpty())
                break;

            // Pick the most profitable one
            w += maxProfitHeap.poll();
        }

        return w;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // k=2, w=0, profits=[1,2,3], capital=[0,1,1] -> 4
        int[] p1 = { 1, 2, 3 };
        int[] c1 = { 0, 1, 1 };
        System.out.println("Result: " + sol.findMaximizedCapital(2, 0, p1, c1) + " (Expected: 4)");
    }
}
