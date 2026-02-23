package leet_code.Problem_418_Medium_Sentence_Screen_Fitting;

public class Solution_CursorSimulation {

    /**
     * Determines how many times a sentence fits on a screen.
     * Uses joined string with space backtracking.
     * Time: O(Rows + total_len), Space: O(total_len).
     * 
     * Xác định số lần một câu có thể được lắp vừa trên màn hình.
     * Sử dụng chuỗi nối kết hợp với kỹ thuật lùi con trỏ tại khoảng trắng.
     */
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int n = s.length();
        int start = 0;

        for (int i = 0; i < rows; i++) {
            start += cols;
            // Case 1: row ends at a space
            if (s.charAt(start % n) == ' ') {
                start++;
            }
            // Case 2: row ends in middle of a word
            else {
                while (start > 0 && s.charAt((start - 1) % n) != ' ') {
                    start--;
                }
            }
        }

        return start / n;
    }

    public static void main(String[] args) {
        Solution_CursorSimulation solution = new Solution_CursorSimulation();

        // Test Case 1: 1
        System.out.println("Result 1: " + solution.wordsTyping(new String[] { "hello", "world" }, 2, 8));

        // Test Case 2: 2
        System.out.println("Result 2: " + solution.wordsTyping(new String[] { "a", "bcd", "e" }, 3, 6));
    }
}
