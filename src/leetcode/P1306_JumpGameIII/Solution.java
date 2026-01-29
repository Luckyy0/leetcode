package leetcode.P1306_JumpGameIII;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        if (arr[start] == 0)
            return true;

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        boolean[] visited = new boolean[n];
        visited[start] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            if (arr[curr] == 0)
                return true;

            int[] nextMoves = { curr + arr[curr], curr - arr[curr] };
            for (int next : nextMoves) {
                if (next >= 0 && next < n && !visited[next]) {
                    if (arr[next] == 0)
                        return true;
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }

        return false;
    }
}
