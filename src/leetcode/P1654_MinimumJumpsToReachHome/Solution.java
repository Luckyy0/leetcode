package leetcode.P1654_MinimumJumpsToReachHome;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> forbiddenSet = new HashSet<>();
        int maxVal = x + a + b;
        for (int f : forbidden) {
            forbiddenSet.add(f);
            maxVal = Math.max(maxVal, f + a + b);
        }

        // Slightly heuristic upper limit. 6000 is safe for constraints x<=2000.
        int LIMIT = Math.max(maxVal, 6000);

        // Queue stores {position, 1 if last was back else 0}
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, 0 });

        boolean[][] visited = new boolean[LIMIT + 1][2];
        visited[0][0] = true;
        visited[0][1] = true; // effectively irrelevant start state

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int pos = curr[0];
                int back = curr[1];

                if (pos == x)
                    return steps;

                // Jump Forward
                int nextFwd = pos + a;
                if (nextFwd <= LIMIT && !forbiddenSet.contains(nextFwd) && !visited[nextFwd][0]) {
                    visited[nextFwd][0] = true;
                    q.offer(new int[] { nextFwd, 0 });
                }

                // Jump Backward
                if (back == 0) { // Can only jump back if last wasn't back
                    int nextBack = pos - b;
                    if (nextBack >= 0 && !forbiddenSet.contains(nextBack) && !visited[nextBack][1]) {
                        visited[nextBack][1] = true;
                        q.offer(new int[] { nextBack, 1 });
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}
