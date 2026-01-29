package leetcode.P2061_NumberOfSpacesCleaningRobotCleaned;

public class Solution {
    public int numberOfCleanRooms(int[][] room) {
        int m = room.length;
        int n = room[0].length;
        boolean[][][] visited = new boolean[m][n][4];
        boolean[][] cleaned = new boolean[m][n];

        int r = 0, c = 0, dir = 0; // 0: Right, 1: Down, 2: Left, 3: Up
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        while (!visited[r][c][dir]) {
            visited[r][c][dir] = true;
            cleaned[r][c] = true;

            // Try to move
            int nr = r + dirs[dir][0];
            int nc = c + dirs[dir][1];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n && room[nr][nc] == 0) {
                // Move forward
                r = nr;
                c = nc;
            } else {
                // Turn right (stay at same cell)
                dir = (dir + 1) % 4;
                // Don't mark visited immediately?
                // Wait. Simulation step: Clean -> Check move -> If blocked turn -> loop.
                // If we turned, we are at same (r, c) with new dir.
                // Next iteration will check visited for this new state.
                // If new state visited, stop. Correct.

                // Wait. Problem says "Clean current cell". Done.
                // "If blocked ... turn right".
                // Does it try to move *immediately* after turn? Usually yes in cleaning robot
                // problems.
                // But loop structure handles it.
                // Step 1: visit/clean logic.
                // Step 2: Attempt move. Success -> update r,c. Fail -> update dir.
                // Loop repeats.

                // Edge case: Surrounded by 4 walls.
                // (0,0) -> Blocked. Dir 1. (0,0,1).
                // Blocked. Dir 2. (0,0,2).
                // ...
                // Dir 0. (0,0,0) visited. Stop.
                // Correct.

                // One issue: If simply "Turn Right", do we execute move same tick?
                // Usually "Move OR Turn". It's one action.
                // My logic does exactly that. Update r,c OR update dir.
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (cleaned[i][j])
                    count++;
            }
        }
        return count;
    }
}
