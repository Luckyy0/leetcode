package leet_code.Problem_79_Medium_Word_Search;

public class Solution_Backtracking {

    /**
     * Checks if the word exists in the board.
     * Uses Backtracking (DFS) with in-place visited marking.
     * Kiểm tra xem từ có tồn tại trong bảng không.
     * Sử dụng Quay lui (DFS) với việc đánh dấu đã truy cập tại chỗ.
     */
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Start searching if the first character matches
                // Bắt đầu tìm kiếm nếu ký tự đầu tiên khớp
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int index) {
        // Found all characters
        // Đã tìm thấy tất cả các ký tự
        if (index == word.length()) {
            return true;
        }

        // Boundary and character matching checks
        // Kiểm tra ranh giới và khớp ký tự
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(index)) {
            return false;
        }

        // Mark as visited (using a symbol that won't match any letter)
        // Đánh dấu là đã truy cập (sử dụng một biểu tượng không khớp với bất kỳ chữ cái
        // nào)
        char temp = board[r][c];
        board[r][c] = '#';

        // Explore neighbors
        // Khám phá các ô lân cận
        boolean found = dfs(board, word, r + 1, c, index + 1) ||
                dfs(board, word, r - 1, c, index + 1) ||
                dfs(board, word, r, c + 1, index + 1) ||
                dfs(board, word, r, c - 1, index + 1);

        // Restore the character (Backtrack)
        // Khôi phục ký tự (Quay lui)
        board[r][c] = temp;

        return found;
    }

    public static void main(String[] args) {
        Solution_Backtracking solution = new Solution_Backtracking();

        // Test Case 1
        char[][] b1 = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };
        System.out.println("Test Case 1: " + solution.exist(b1, "ABCCED"));
        // Expected: true

        // Test Case 2
        System.out.println("Test Case 2: " + solution.exist(b1, "SEE"));
        // Expected: true

        // Test Case 3
        char[][] b3 = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };
        System.out.println("Test Case 3: " + solution.exist(b3, "ABCB"));
        // Expected: false
    }
}
