package leet_code.Problem_630_Hard_Course_Schedule_III;

import java.util.*;

public class Solution_Greedy {

    /**
     * Finds the maximum number of courses that can be taken within deadlines.
     * Strategy: Sort by deadline and use a Max-Heap to eject long courses.
     * Time: O(N log N), Space: O(N).
     */
    public int scheduleCourse(int[][] courses) {
        // Sort courses by their lastDay (deadline)
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);

        // Max-Heap to store durations of courses taken
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        int time = 0;
        for (int[] c : courses) {
            int duration = c[0];
            int lastDay = c[1];

            // Try adding the course
            time += duration;
            pq.offer(duration);

            // If the current schedule exceeds the deadline of this course
            if (time > lastDay) {
                // Remove the longest course taken so far to free up maximum time
                // This might be the new course or a previous one
                time -= pq.poll();
            }
        }

        // The size of the PriorityQueue represents the maximum courses we could fit
        return pq.size();
    }

    public static void main(String[] args) {
        Solution_Greedy sol = new Solution_Greedy();
        int[][] courses = { { 100, 200 }, { 200, 1300 }, { 1000, 1250 }, { 2000, 3200 } };
        System.out.println("Max courses: " + sol.scheduleCourse(courses)); // 3
    }
}
