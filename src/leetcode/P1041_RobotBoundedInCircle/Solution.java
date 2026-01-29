package leetcode.P1041_RobotBoundedInCircle;

class Solution {
    public boolean isRobotBounded(String instructions) {
        // 0: North, 1: East, 2: South, 3: West
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int x = 0, y = 0;
        int d = 0; // facing North

        for (char c : instructions.toCharArray()) {
            if (c == 'G') {
                x += dirs[d][0];
                y += dirs[d][1];
            } else if (c == 'L') {
                d = (d + 3) % 4;
            } else if (c == 'R') {
                d = (d + 1) % 4;
            }
        }

        // Returns true if back at origin OR facing different direction
        return (x == 0 && y == 0) || (d != 0);
    }
}
