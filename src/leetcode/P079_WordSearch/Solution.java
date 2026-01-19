package leetcode.P079_WordSearch;

public class Solution {

    /**
     * Problem 79: Word Search
     * Approach: Backtracking (DFS)
     * Time Complexity: O(M * N * 3^L)
     * Space Complexity: O(L)
     */
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        // Base case: matched all characters
        if (index == word.length()) {
            return true;
        }

        // Boundary check and mismatches
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        // Mark as visited
        char temp = board[i][j];
        board[i][j] = '#';

        // Explore 4 directions
        boolean found = dfs(board, word, i + 1, j, index + 1) ||
                dfs(board, word, i - 1, j, index + 1) ||
                dfs(board, word, i, j + 1, index + 1) ||
                dfs(board, word, i, j - 1, index + 1);

        // Backtrack
        board[i][j] = temp;

        return found;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        char[][] board = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };

        runTest(solution, board, "ABCCED", true);
        runTest(solution, board, "SEE", true);
        runTest(solution, board, "ABCB", false);
    }

    private static void runTest(Solution s, char[][] board, String word, boolean expected) {
        System.out.println("Input word: " + word);
        // Note: board is modified and restored, safe to reuse
        boolean result = s.exist(board, word);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
