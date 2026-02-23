package leet_code.Problem_874_Medium_Walking_Robot_Simulation;

import java.util.*;

/**
 * Problem 874: Walking Robot Simulation
 * https://leetcode.com/problems/walking-robot-simulation/
 */
public class Solution {

    /**
     * Simulates robot movement and tracks max squared distance.
     * Strategy: Use a HashSet to store obstacles. Perform a unit-by-unit
     * simulation for each movement command.
     * 
     * @param commands  Sequence of commands (-2, -1, or 1..9).
     * @param obstacles Coordinates of obstacles.
     * @return Max Euclidean distance squared.
     * 
     *         Tóm tắt chiến lược:
     *         1. Lưu các chướng ngại vật vào một HashSet dưới dạng chuỗi "x,y" để
     *         tra cứu O(1).
     *         2. Dùng mảng dirs để quản lý 4 hướng: Bắc (0,1), Đông (1,0), Nam
     *         (0,-1), Tây (-1,0).
     *         3. Với mỗi lệnh di chuyển, robot đi từng bước một. Nếu bước kế tiếp
     *         là
     *         chướng ngại vật, robot dừng lại tại vị trí hiện tại.
     *         4. Liên tục cập nhật bình phương khoảng cách xa nhất từng đạt được.
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        // Directions: [dy, dx] pairs for North, East, South, West
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        // Store obstacles as "x,y" strings in a Set for fast lookup
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obs : obstacles) {
            obstacleSet.add(obs[0] + "," + obs[1]);
        }

        int x = 0, y = 0; // Starting position
        int d = 0; // Starting direction index (North)
        int maxDistSq = 0;

        for (int cmd : commands) {
            if (cmd == -2) {
                // Turn left 90 deg
                d = (d + 3) % 4;
            } else if (cmd == -1) {
                // Turn right 90 deg
                d = (d + 1) % 4;
            } else {
                // Move forward cmd units
                for (int i = 0; i < cmd; i++) {
                    int nx = x + dirs[d][0];
                    int ny = y + dirs[d][1];

                    // If no obstacle at next step, move
                    if (!obstacleSet.contains(nx + "," + ny)) {
                        x = nx;
                        y = ny;
                        maxDistSq = Math.max(maxDistSq, x * x + y * y);
                    } else {
                        // Hit an obstacle, stop moving for this command
                        break;
                    }
                }
            }
        }

        return maxDistSq;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] c1 = { 4, -1, 3 };
        int[][] o1 = {};
        System.out.println("Max Dist Sq: " + sol.robotSim(c1, o1)); // 25

        int[] c2 = { 4, -1, 4, -2, 4 };
        int[][] o2 = { { 2, 4 } };
        System.out.println("Max Dist Sq: " + sol.robotSim(c2, o2)); // 65
    }
}
