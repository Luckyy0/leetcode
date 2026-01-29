package leetcode.P1136_ParallelCourses;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        List<Integer>[] adj = new ArrayList[n + 1];
        int[] inDegree = new int[n + 1];

        for (int i = 1; i <= n; i++)
            adj[i] = new ArrayList<>();

        for (int[] r : relations) {
            adj[r[0]].add(r[1]);
            inDegree[r[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0)
                queue.add(i);
        }

        int semester = 0;
        int count = 0;

        while (!queue.isEmpty()) {
            semester++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int u = queue.poll();
                count++;
                for (int v : adj[u]) {
                    inDegree[v]--;
                    if (inDegree[v] == 0)
                        queue.add(v);
                }
            }
        }

        return count == n ? semester : -1;
    }
}
