package leetcode.P2059_MinimumOperationsToConvertNumber;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        boolean[] visited = new boolean[1001];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            steps++;
            for (int i = 0; i < size; i++) {
                int curr = q.poll();

                for (int x : nums) {
                    int next;

                    // Op 1: +
                    next = curr + x;
                    if (next == goal)
                        return steps;
                    if (next >= 0 && next <= 1000 && !visited[next]) {
                        visited[next] = true;
                        q.offer(next);
                    }

                    // Op 2: -
                    next = curr - x;
                    if (next == goal)
                        return steps;
                    if (next >= 0 && next <= 1000 && !visited[next]) {
                        visited[next] = true;
                        q.offer(next);
                    }

                    // Op 3: ^
                    next = curr ^ x;
                    if (next == goal)
                        return steps;
                    if (next >= 0 && next <= 1000 && !visited[next]) {
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }
        }

        return -1;
    }
}
