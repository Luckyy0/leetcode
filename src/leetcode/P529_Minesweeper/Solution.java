package leetcode.P529_Minesweeper;

class Solution {
    // Directions for 8 adjacent cells
    // Hướng cho 8 ô lân cận
    int[][] dirs = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

    public char[][] updateBoard(char[][] board, int[] click) {
        int r = click[0], c = click[1];

        // If clicked on a Mine ('M'), change it to 'X' and game over
        // Nếu nhấp vào Mìn ('M'), đổi thành 'X' và kết thúc trò chơi
        if (board[r][c] == 'M') {
            board[r][c] = 'X';
            return board;
        }

        // Use DFS to reveal squares
        // Sử dụng DFS để tiết lộ các ô
        dfs(board, r, c);

        return board;
    }

    private void dfs(char[][] board, int r, int c) {
        // Only process unrevealed empty squares ('E')
        // Chỉ xử lý các ô trống chưa được tiết lộ ('E')
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'E') {
            return;
        }

        int mineCount = getAdjacentMines(board, r, c);

        if (mineCount > 0) {
            // If there are adjacent mines, show the count and stop recursion
            // Nếu có mìn lân cận, hiển thị số lượng và dừng đệ quy
            board[r][c] = (char) (mineCount + '0');
        } else {
            // If no adjacent mines, mark as 'B' and recursively reveal neighbors
            // Nếu không có mìn lân cận, đánh dấu là 'B' và đệ quy tiết lộ các ô lân cận
            board[r][c] = 'B';
            for (int[] dir : dirs) {
                dfs(board, r + dir[0], c + dir[1]);
            }
        }
    }

    private int getAdjacentMines(char[][] board, int r, int c) {
        int count = 0;
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length) {
                if (board[nr][nc] == 'M') {
                    count++;
                }
            }
        }
        return count;
    }
}
