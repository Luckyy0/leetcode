package leet_code.Problem_348_Medium_Design_Tic_Tac_Toe;

public class TicTacToe {

    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;
    private int n;

    /**
     * Initializes the Tic-Tac-Toe game board.
     * Khởi tạo bàn cờ Tic-Tac-Toe.
     */
    public TicTacToe(int n) {
        this.n = n;
        this.rows = new int[n];
        this.cols = new int[n];
        this.diagonal = 0;
        this.antiDiagonal = 0;
    }

    /**
     * Players make a move. Returns the winner or 0.
     * Người chơi thực hiện nước đi. Trả về người thắng hoặc 0.
     * Time: O(1), Space: O(n).
     */
    public int move(int row, int col, int player) {
        int val = (player == 1) ? 1 : -1;

        rows[row] += val;
        cols[col] += val;

        if (row == col) {
            diagonal += val;
        }

        if (row + col == n - 1) {
            antiDiagonal += val;
        }

        // Winning condition: check if absolute value is n
        // Điều kiện thắng: kiểm tra xem giá trị tuyệt đối có bằng n không
        if (Math.abs(rows[row]) == n ||
                Math.abs(cols[col]) == n ||
                Math.abs(diagonal) == n ||
                Math.abs(antiDiagonal) == n) {
            return player;
        }

        return 0;
    }

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe(3);
        System.out.println("Result (0,0,1): " + ticTacToe.move(0, 0, 1)); // 0
        System.out.println("Result (0,2,2): " + ticTacToe.move(0, 2, 2)); // 0
        System.out.println("Result (2,2,1): " + ticTacToe.move(2, 2, 1)); // 0
        System.out.println("Result (1,1,2): " + ticTacToe.move(1, 1, 2)); // 0
        System.out.println("Result (2,0,1): " + ticTacToe.move(2, 0, 1)); // 0
        System.out.println("Result (1,0,2): " + ticTacToe.move(1, 0, 2)); // 0
        System.out.println("Result (2,1,1): " + ticTacToe.move(2, 1, 1)); // 1 (player 1 wins)
    }
}
