package leet_code.Problem_36_Medium_Valid_Sudoku;

public class Solution_Validation {

    /**
     * Checks if the Sudoku board is valid.
     * Uses boolean arrays to track seen numbers.
     * Kiểm tra xem bảng Sudoku có hợp lệ không.
     * Sử dụng mảng boolean để theo dõi các số đã thấy.
     */
    public boolean isValidSudoku(char[][] board) {
        // Arrays to store whether a number has been seen in a row, column, or box
        // Các mảng để lưu trữ xem một số đã được nhìn thấy trong hàng, cột hoặc hộp
        // chưa
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char current = board[i][j];

                if (current != '.') {
                    int num = current - '1'; // Convert '1'-'9' to 0-8
                    int boxIndex = (i / 3) * 3 + j / 3;

                    // Check for repetition
                    // Kiểm tra sự lặp lại
                    if (rows[i][num] || cols[j][num] || boxes[boxIndex][num]) {
                        return false;
                    }

                    // Mark as seen
                    // Đánh dấu là đã thấy
                    rows[i][num] = true;
                    cols[j][num] = true;
                    boxes[boxIndex][num] = true;
                }
            }
        }

        return true;
    }

    /**
     * Main method for testing.
     * Hàm main để kiểm thử.
     */
    public static void main(String[] args) {
        Solution_Validation solution = new Solution_Validation();

        // Test Case 1
        char[][] board1 = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        System.out.println("Test Case 1: " + solution.isValidSudoku(board1));
        // Expected: true

        // Test Case 2
        char[][] board2 = {
                { '8', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        System.out.println("Test Case 2: " + solution.isValidSudoku(board2));
        // Expected: false
    }
}
