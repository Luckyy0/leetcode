package leet_code.Problem_130_Medium_Surrounded_Regions;

import java.util.Arrays;

public class Solution_DFS {

    /**
     * Captures surrounded regions by flipping 'O' to 'X'.
     * A region is NOT surrounded if it's connected to the board border.
     * 
     * Chiếm các vùng bị bao vây bằng cách lật 'O' thành 'X'.
     * Một vùng KHÔNG bị bao vây nếu nó được kết nối với biên của bảng.
     */
    public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;
        int rows = board.length;
        int cols = board[0].length;

        // Step 1: Mark border-connected 'O's as '#'
        // Bước 1: Đánh dấu các 'O' kết nối với biên là '#'

        // Check first and last columns
        // Kiểm tra cột đầu tiên và cột cuối cùng
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O')
                dfs(board, i, 0);
            if (board[i][cols - 1] == 'O')
                dfs(board, i, cols - 1);
        }

        // Check first and last rows
        // Kiểm tra hàng đầu tiên và hàng cuối cùng
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O')
                dfs(board, 0, j);
            if (board[rows - 1][j] == 'O')
                dfs(board, rows - 1, j);
        }

        // Step 2: Final pass - Flip remaining 'O' to 'X', and '#' back to 'O'
        // Bước 2: Duyệt lần cuối - Lật 'O' còn lại thành 'X', và '#' quay lại thành 'O'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        int rows = board.length;
        int cols = board[0].length;

        // Boundary check and color check
        // Kiểm tra biên và kiểm tra màu
        if (r < 0 || r >= rows || c < 0 || c >= cols || board[r][c] != 'O') {
            return;
        }

        // Mark as "safe" or "traversed from border"
        // Đánh dấu là "an toàn" hoặc "đã được duyệt từ biên"
        board[r][c] = '#';

        // Explore 4 directions
        // Khám phá theo 4 hướng
        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }

    public static void main(String[] args) {
        Solution_DFS solution = new Solution_DFS();

        char[][] b1 = {
                { 'X', 'X', 'X', 'X' },
                { 'X', 'O', 'O', 'X' },
                { 'X', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'X' }
        };

        solution.solve(b1);

        System.out.println("Test Case 1 Result:");
        for (char[] row : b1) {
            System.out.println(Arrays.toString(row));
        }
        /*
         * Expected:
         * [X, X, X, X]
         * [X, X, X, X]
         * [X, X, X, X]
         * [X, O, X, X]
         */
    }
}
