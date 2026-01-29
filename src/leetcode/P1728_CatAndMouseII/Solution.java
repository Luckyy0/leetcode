package leetcode.P1728_CatAndMouseII;

public class Solution {
    private int rows, cols;
    private int catJump, mouseJump;
    private char[][] grid;
    private Boolean[][][][][] memo;
    private int[] dirs = { 0, 1, 0, -1, 0 };

    public boolean canMouseWin(String[] gridStr, int catJump, int mouseJump) {
        this.rows = gridStr.length;
        this.cols = gridStr[0].length();
        this.catJump = catJump;
        this.mouseJump = mouseJump;
        this.grid = new char[rows][cols];

        int mx = 0, my = 0, cx = 0, cy = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char ch = gridStr[i].charAt(j);
                grid[i][j] = ch;
                if (ch == 'M') {
                    mx = i;
                    my = j;
                } else if (ch == 'C') {
                    cx = i;
                    cy = j;
                }
            }
        }

        // Limits: 8x8 grid. Turns limit ~ 100 enough? Set 128 (2*64).
        // 1000 in prompt, but state cycles/redundancy means effective depth lower.
        memo = new Boolean[rows][cols][rows][cols][150];

        return solve(mx, my, cx, cy, 0);
    }

    private boolean solve(int mx, int my, int cx, int cy, int turn) {
        if (turn >= 140)
            return false; // Cat wins by timeout

        if (memo[mx][my][cx][cy][turn] != null)
            return memo[mx][my][cx][cy][turn];

        // Immediate checks
        if (mx == cx && my == cy)
            return memo[mx][my][cx][cy][turn] = false; // Cat catches
        if (grid[mx][my] == 'F')
            return memo[mx][my][cx][cy][turn] = true; // Mouse reaches
        if (grid[cx][cy] == 'F')
            return memo[mx][my][cx][cy][turn] = false; // Cat reaches

        boolean mouseTurn = (turn % 2 == 0);

        if (mouseTurn) {
            // Mouse tries to win (return true)
            // Try stay
            if (solve(mx, my, cx, cy, turn + 1))
                return memo[mx][my][cx][cy][turn] = true;

            for (int d = 0; d < 4; d++) {
                for (int jump = 1; jump <= mouseJump; jump++) {
                    int nx = mx + dirs[d] * jump;
                    int ny = my + dirs[d + 1] * jump;

                    if (nx < 0 || nx >= rows || ny < 0 || ny >= cols || grid[nx][ny] == '#')
                        break;

                    if (solve(nx, ny, cx, cy, turn + 1))
                        return memo[mx][my][cx][cy][turn] = true;
                }
            }
            return memo[mx][my][cx][cy][turn] = false;
        } else {
            // Cat tries to win (make solve return false)
            // If Cat can force false, optimal play will do so.
            // If ALL moves result in True (Mouse wins), then Cat returns True.

            // Try stay
            if (!solve(mx, my, cx, cy, turn + 1))
                return memo[mx][my][cx][cy][turn] = false;

            for (int d = 0; d < 4; d++) {
                for (int jump = 1; jump <= catJump; jump++) {
                    int nx = cx + dirs[d] * jump;
                    int ny = cy + dirs[d + 1] * jump;

                    if (nx < 0 || nx >= rows || ny < 0 || ny >= cols || grid[nx][ny] == '#')
                        break;

                    if (!solve(mx, my, nx, ny, turn + 1))
                        return memo[mx][my][cx][cy][turn] = false;
                }
            }
            return memo[mx][my][cx][cy][turn] = true;
        }
    }
}
