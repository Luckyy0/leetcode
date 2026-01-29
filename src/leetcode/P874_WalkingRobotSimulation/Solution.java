package leetcode.P874_WalkingRobotSimulation;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // N, E, S, W
        Set<String> obsSet = new HashSet<>();
        for (int[] obs : obstacles)
            obsSet.add(obs[0] + "," + obs[1]);

        int x = 0, y = 0, d = 0;
        int maxDistSq = 0;

        for (int cmd : commands) {
            if (cmd == -2) { // left
                d = (d + 3) % 4;
            } else if (cmd == -1) { // right
                d = (d + 1) % 4;
            } else {
                for (int i = 0; i < cmd; i++) {
                    int nx = x + dirs[d][0];
                    int ny = y + dirs[d][1];
                    if (obsSet.contains(nx + "," + ny))
                        break;
                    x = nx;
                    y = ny;
                    maxDistSq = Math.max(maxDistSq, x * x + y * y);
                }
            }
        }

        return maxDistSq;
    }
}
