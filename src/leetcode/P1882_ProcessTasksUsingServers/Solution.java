package leetcode.P1882_ProcessTasksUsingServers;

import java.util.PriorityQueue;

public class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        // [weight, index]
        PriorityQueue<int[]> available = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        // [freeTime, weight, index]
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            if (a[1] != b[1])
                return Integer.compare(a[1], b[1]);
            return Integer.compare(a[2], b[2]);
        });

        for (int i = 0; i < servers.length; i++) {
            available.offer(new int[] { servers[i], i });
        }

        int[] result = new int[tasks.length];
        long time = 0;

        for (int i = 0; i < tasks.length; i++) {
            time = Math.max(time, i);

            // Release busy servers
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                int[] s = busy.poll();
                available.offer(new int[] { s[1], s[2] }); // weight, index
            }

            if (available.isEmpty()) {
                // Must wait
                time = busy.peek()[0];
                while (!busy.isEmpty() && busy.peek()[0] <= time) {
                    int[] s = busy.poll();
                    available.offer(new int[] { s[1], s[2] });
                }
            }

            int[] s = available.poll();
            result[i] = s[1];

            // Add to busy
            busy.offer(new int[] { (int) (time + tasks[i]), s[0], s[1] });
        }

        return result;
    }
}
