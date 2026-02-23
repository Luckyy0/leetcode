package leet_code.Problem_529_Medium_Minesweeper;

import java.util.Arrays;

public class Solution_DFS {

    private int m, n;
    private int[][] dirs = {
            { -1, -1 }, { -1, 0 }, { -1, 1 },
            { 0, -1 }, { 0, 1 },
            { 1, -1 }, { 1, 0 }, { 1, 1 }
    };

    /**
     * Updates board based on click.
     * Strategy: DFS for recursive reveal.
     * Time: O(M*N), Space: O(M*N).
     */
    public char[][] updateBoard(char[][] board, int[] click) {
        m = board.length;
        n = board[0].length;
        int row = click[0];
        int col = click[1];

        if (board[row][col] == 'M') {
            board[row][col] = 'X';
        } else {
            // It must be 'E' based on problem description (unrevealed)
            // But good to be safe. Only reveal if E.
            dfs(board, row, col);
        }

        return board;
    }

    private void dfs(char[][] board, int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n || board[r][c] != 'E') {
            return;
        }

        int mines = countMines(board, r, c);

        if (mines > 0) {
            board[r][c] = (char) ('0' + mines);
        } else {
            board[r][c] = 'B';
            for (int[] d : dirs) {
                dfs(board, r + d[0], c + d[1]);
            }
        }
    }

    private int countMines(char[][] board, int r, int c) {
        int count = 0;
        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                if (board[nr][nc] == 'M') {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution_DFS solution = new Solution_DFS();
        char[][] board = {
                { 'E', 'E', 'E', 'E', 'E' },
                { 'E', 'E', 'M', 'E', 'E' },
                { 'E', 'E', 'E', 'E', 'E' },
                { 'E', 'E', 'E', 'E', 'E' }
        };
        int[] click = { 3, 0 };
        char[][] res = solution.updateBoard(board, click);

        System.out.println("Result Board:");
        for (char[] row : res) {
            System.out.println(Arrays.toString(row));
        }
    }
}
