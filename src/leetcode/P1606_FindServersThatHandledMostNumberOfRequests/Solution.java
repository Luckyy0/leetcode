package leetcode.P1606_FindServersThatHandledMostNumberOfRequests;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] counts = new int[k];
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < k; i++)
            available.add(i);

        // PriorityQueue stores [endTime, serverId]
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < arrival.length; i++) {
            int time = arrival[i];

            // Free up servers
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                int[] freed = busy.poll();
                available.add(freed[1]);
            }

            if (available.isEmpty())
                continue; // Drop request

            int target = i % k;
            Integer server = available.ceiling(target);
            if (server == null) {
                server = available.first();
            }

            counts[server]++;
            available.remove(server);
            busy.offer(new int[] { time + load[i], server });
        }

        int max = 0;
        for (int c : counts)
            max = Math.max(max, c);

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (counts[i] == max)
                result.add(i);
        }

        return result;
    }
}
