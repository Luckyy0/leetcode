package leet_code.Problem_293_Easy_Flip_Game;

import java.util.ArrayList;
import java.util.List;

public class Solution_Simulation {

    /**
     * Generates all possible next states.
     * Uses linear scan and string concatenation.
     * Time: O(N^2), Space: O(N^2).
     * 
     * Tạo ra tất cả các trạng thái tiếp theo có thể.
     * Sử dụng quét tuyến tính và nối chuỗi.
     */
    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> moves = new ArrayList<>();
        int n = currentState.length();

        for (int i = 0; i < n - 1; i++) {
            // Check for consecutive "++"
            // Kiểm tra "++" liên tiếp
            if (currentState.charAt(i) == '+' && currentState.charAt(i + 1) == '+') {
                // Generate new state by replacing "++" with "--"
                // Tạo trạng thái mới bằng cách thay thế "++" bằng "--"
                // Java substring: beginIndex (inclusive), endIndex (exclusive)
                String nextState = currentState.substring(0, i) + "--" + currentState.substring(i + 2);
                moves.add(nextState);
            }
        }

        return moves;
    }

    public static void main(String[] args) {
        Solution_Simulation solution = new Solution_Simulation();

        // Test Case 1: "++++"
        System.out.println("Moves 1: " + solution.generatePossibleNextMoves("++++"));

        // Test Case 2: "+"
        System.out.println("Moves 2: " + solution.generatePossibleNextMoves("+"));
    }
}
