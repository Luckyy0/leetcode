package leet_code.Problem_657_Easy_Robot_Return_to_Origin;

public class Solution_Coordinates {

    /**
     * Checks if a robot returns to the origin after a series of moves.
     * Strategy: Track net displacement in x and y coordinates.
     * Time: O(N), Space: O(1).
     */
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;

        for (char move : moves.toCharArray()) {
            if (move == 'U') {
                y++;
            } else if (move == 'D') {
                y--;
            } else if (move == 'L') {
                x--;
            } else if (move == 'R') {
                x++;
            }
        }

        return x == 0 && y == 0;
    }

    public static void main(String[] args) {
        Solution_Coordinates sol = new Solution_Coordinates();
        System.out.println("Result for 'UD': " + sol.judgeCircle("UD")); // true
        System.out.println("Result for 'LL': " + sol.judgeCircle("LL")); // false
    }
}
