package leetcode.P2018_CheckIfWordCanBePlacedInCrossword;

public class Solution {
    public boolean placeWordInCrossword(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        // Rows
        for (int i = 0; i < m; i++) {
            if (checkSequence(board[i], word))
                return true;
        }

        // Cols
        for (int j = 0; j < n; j++) {
            char[] col = new char[m];
            for (int i = 0; i < m; i++)
                col[i] = board[i][j];
            if (checkSequence(col, word))
                return true;
        }

        return false;
    }

    private boolean checkSequence(char[] seq, String word) {
        int n = seq.length;
        int len = word.length();
        int j = 0;

        while (j < n) {
            // Find start of segment
            if (seq[j] == '#') {
                j++;
                continue;
            }

            int start = j;
            while (j < n && seq[j] != '#')
                j++;
            int end = j; // exclusive

            // Segment is [start, end)
            if (end - start == len) {
                if (match(seq, start, end, word) || matchRev(seq, start, end, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean match(char[] seq, int start, int end, String word) {
        for (int i = 0; i < word.length(); i++) {
            char c = seq[start + i];
            if (c != ' ' && c != word.charAt(i))
                return false;
        }
        return true;
    }

    private boolean matchRev(char[] seq, int start, int end, String word) {
        for (int i = 0; i < word.length(); i++) {
            char c = seq[end - 1 - i];
            if (c != ' ' && c != word.charAt(i))
                return false;
        }
        return true;
    }
}
