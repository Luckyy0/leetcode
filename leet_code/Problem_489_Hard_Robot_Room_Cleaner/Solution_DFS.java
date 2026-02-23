package leet_code.Problem_489_Hard_Robot_Room_Cleaner;

import java.util.HashSet;
import java.util.Set;

// Mock interface for compilation
interface Robot {
    boolean move();

    void turnLeft();

    void turnRight();

    void clean();
}

public class Solution_DFS {

    // Up, Right, Down, Left
    private final int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    private Set<String> visited;

    /**
     * Cleans the room.
     * Strategy: DFS + Backtracking. Maintains relative (x, y) coordinates.
     * Time: O(N), Space: O(N).
     */
    public void cleanRoom(Robot robot) {
        visited = new HashSet<>();
        // Start DFS from (0, 0) facing Up (direction index 0)
        dfs(robot, 0, 0, 0);
    }

    private void dfs(Robot robot, int row, int col, int curDir) {
        String cell = row + "," + col;
        visited.add(cell);
        robot.clean();

        // Try all 4 directions: 0 (up), 1 (right), 2 (down), 3 (left) relative to
        // current orientation
        // Note: The loop iterates 4 times. 'i' represents turn counting.
        // The actual direction we try is 'curDir' initially, then 'curDir + 1', etc.

        for (int i = 0; i < 4; i++) {
            int nextDir = (curDir + i) % 4;
            int nextRow = row + dirs[nextDir][0];
            int nextCol = col + dirs[nextDir][1];

            if (!visited.contains(nextRow + "," + nextCol) && robot.move()) {
                // If moved successfully, recurse
                dfs(robot, nextRow, nextCol, nextDir);

                // Backtrack: Move back to the previous cell and restore facing direction
                // We are currently at (nextRow, nextCol), facing nextDir.
                // We need to return to (row, col) and face nextDir (to continue the loop
                // turning).

                // 1. Turn 180
                robot.turnRight();
                robot.turnRight();
                // 2. Move back
                robot.move();
                // 3. Turn 180 to restore original facing
                robot.turnRight();
                robot.turnRight();
            }

            // Turn right to check the next direction in the loop
            robot.turnRight();
        }
    }

    // Dummy main for testing logic (won't run without Robot implementation)
    public static void main(String[] args) {
        // Robot implementation is usually provided by the judge
        System.out.println("Robot cleaning logic implemented successfully.");
    }
}
