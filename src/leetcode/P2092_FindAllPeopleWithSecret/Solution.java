package leetcode.P2092_FindAllPeopleWithSecret;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        // Sort meetings by time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[2], b[2]));

        boolean[] known = new boolean[n];
        known[0] = true;
        known[firstPerson] = true;

        int m = meetings.length;
        int i = 0;

        while (i < m) {
            int time = meetings[i][2];
            int j = i;
            while (j < m && meetings[j][2] == time) {
                j++;
            }

            // Process chunk meetings[i...j-1]
            Map<Integer, List<Integer>> graph = new HashMap<>();
            Set<Integer> participants = new HashSet<>();

            for (int k = i; k < j; k++) {
                int u = meetings[k][0];
                int v = meetings[k][1];
                graph.computeIfAbsent(u, x -> new ArrayList<>()).add(v);
                graph.computeIfAbsent(v, x -> new ArrayList<>()).add(u);
                participants.add(u);
                participants.add(v);
            }

            Queue<Integer> q = new LinkedList<>();
            Set<Integer> visitedInChunk = new HashSet<>();

            for (int p : participants) {
                if (known[p]) {
                    q.offer(p);
                    visitedInChunk.add(p);
                }
            }

            while (!q.isEmpty()) {
                int u = q.poll();
                if (graph.containsKey(u)) {
                    for (int v : graph.get(u)) {
                        if (!visitedInChunk.contains(v)) {
                            known[v] = true;
                            visitedInChunk.add(v);
                            q.offer(v);
                        }
                    }
                }
            }

            i = j;
        }

        List<Integer> result = new ArrayList<>();
        for (int k = 0; k < n; k++) {
            if (known[k])
                result.add(k);
        }
        return result;
    }
}
