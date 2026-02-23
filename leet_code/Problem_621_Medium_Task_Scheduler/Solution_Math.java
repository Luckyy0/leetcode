package leet_code.Problem_621_Medium_Task_Scheduler;

import java.util.Arrays;

public class Solution_Math {

    /**
     * Calculates the minimum time to complete all tasks with n cooldown.
     * Strategy: Mathematical Frame calculation based on max frequency.
     * Time: O(Tasks), Space: O(1).
     */
    public int leastInterval(char[] tasks, int n) {
        // Count frequencies of each task (A-Z)
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }

        // Sort to find the max frequency easily
        Arrays.sort(freq);
        int maxFreq = freq[25];

        // Count how many tasks have that same max frequency
        int countMaxFreq = 0;
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == maxFreq) {
                countMaxFreq++;
            } else {
                break;
            }
        }

        // Calculate the minimum time needed based on the frame of max frequency tasks
        // Part 1: (maxFreq - 1) * (n + 1) -> This covers all full gaps + leading max
        // tasks
        // Part 2: countMaxFreq -> Adding the tail of the max tasks
        int frameTime = (maxFreq - 1) * (n + 1) + countMaxFreq;

        // The total time can't be less than the actual number of tasks
        return Math.max(tasks.length, frameTime);
    }

    public static void main(String[] args) {
        Solution_Math solution = new Solution_Math();
        char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'B' };
        int n = 2;
        System.out.println("Least interval: " + solution.leastInterval(tasks, n)); // Output: 8
    }
}
