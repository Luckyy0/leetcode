package leetcode.P1345_JumpGameIV;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1)
            return 0;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.offer(0);
        visited[0] = true;

        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int u = q.poll();
                if (u == n - 1)
                    return steps;

                // Neighbors: u-1, u+1
                if (u + 1 < n && !visited[u + 1]) {
                    visited[u + 1] = true;
                    q.offer(u + 1);
                }
                if (u - 1 >= 0 && !visited[u - 1]) {
                    visited[u - 1] = true;
                    q.offer(u - 1);
                }

                // Same value jumps
                int val = arr[u];
                if (graph.containsKey(val)) {
                    for (int v : graph.get(val)) {
                        if (!visited[v]) {
                            visited[v] = true;
                            q.offer(v);
                        }
                    }
                    graph.remove(val); // Optimization: Don't process this value again
                }
            }
            steps++;
        }

        return -1;
    }
}
