package leet_code.Problem_58_Easy_Length_Of_Last_Word;

public class Solution_Simple {

    /**
     * Returns the length of the last word.
     * Iterates from the end to avoid extra space.
     * Trả về độ dài của từ cuối cùng.
     * Duyệt từ cuối để tránh tốn thêm không gian.
     */
    public int lengthOfLastWord(String s) {
        int length = 0;
        int i = s.length() - 1;

        // Skip trailing spaces
        // Bỏ qua các khoảng trắng ở cuối
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Count non-space characters
        // Đếm các ký tự không phải khoảng trắng
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }

    public static void main(String[] args) {
        Solution_Simple solution = new Solution_Simple();

        // Test Case 1
        System.out.println("Test Case 1: " + solution.lengthOfLastWord("Hello World"));
        // Expected: 5

        // Test Case 2
        System.out.println("Test Case 2: " + solution.lengthOfLastWord("   fly me   to   the moon  "));
        // Expected: 4

        // Test Case 3
        System.out.println("Test Case 3: " + solution.lengthOfLastWord("luffy is still joyboy"));
        // Expected: 6
    }
}
