package leetcode.P1462_CourseScheduleIV;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] reachable = new boolean[numCourses][numCourses];

        for (int[] p : prerequisites) {
            reachable[p[0]][p[1]] = true;
        }

        // Floyd-Warshall
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    if (reachable[i][k] && reachable[k][j]) {
                        reachable[i][j] = true;
                    }
                }
            }
        }

        List<Boolean> res = new ArrayList<>();
        for (int[] q : queries) {
            res.add(reachable[q[0]][q[1]]);
        }

        return res;
    }
}
