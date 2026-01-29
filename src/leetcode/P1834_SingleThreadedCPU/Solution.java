package leetcode.P1834_SingleThreadedCPU;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] sortedTasks = new int[n][3];
        for (int i = 0; i < n; i++) {
            sortedTasks[i][0] = tasks[i][0]; // enqueue
            sortedTasks[i][1] = tasks[i][1]; // processing
            sortedTasks[i][2] = i; // index
        }

        Arrays.sort(sortedTasks, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1])
                return Integer.compare(a[1], b[1]);
            return Integer.compare(a[2], b[2]);
        });

        int[] result = new int[n];
        int resultIdx = 0;
        int taskIdx = 0;
        int time = 0;

        while (resultIdx < n) {
            // Check if we need to fast forward time if CPU idle
            if (pq.isEmpty() && taskIdx < n && time < sortedTasks[taskIdx][0]) {
                time = sortedTasks[taskIdx][0];
            }

            // Add available tasks
            while (taskIdx < n && sortedTasks[taskIdx][0] <= time) {
                pq.offer(sortedTasks[taskIdx]);
                taskIdx++;
            }

            // Process
            if (!pq.isEmpty()) {
                int[] task = pq.poll();
                result[resultIdx++] = task[2];
                time += task[1];
            }
        }

        return result;
    }
}
