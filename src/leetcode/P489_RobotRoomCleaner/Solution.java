package leetcode.P489_RobotRoomCleaner;

import java.util.HashSet;
import java.util.Set;

/**
 * Mock Robot interface for the problem structure
 */
interface Robot {
    boolean move();

    void turnLeft();

    void turnRight();

    void clean();
}

public class Solution {

    // Directions: 0: up, 1: right, 2: down, 3: left
    private static final int[][] DIRS = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    /**
     * Problem 489: Robot Room Cleaner
     * Approach: DFS with backtracking and relative coordinates
     */
    public void cleanRoom(Robot robot) {
        dfs(robot, 0, 0, 0, new HashSet<>());
    }

    private void dfs(Robot robot, int x, int y, int d, Set<String> visited) {
        String key = x + "," + y;
        visited.add(key);
        robot.clean();

        // Try 4 directions starting from 'd'
        for (int i = 0; i < 4; i++) {
            int newD = (d + i) % 4;
            int nx = x + DIRS[newD][0];
            int ny = y + DIRS[newD][1];

            if (!visited.contains(nx + "," + ny) && robot.move()) {
                dfs(robot, nx, ny, newD, visited);
                // Backtrack to previous position and direction
                goBack(robot);
            }

            // Turn to next direction
            robot.turnRight();
        }
    }

    private void goBack(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    public static void main(String[] args) {
        // This is a template-based interactive problem,
        // usually verified by a mock judge on LeetCode.
        System.out.println("Robot Room Cleaner logic implemented.");
    }
}
