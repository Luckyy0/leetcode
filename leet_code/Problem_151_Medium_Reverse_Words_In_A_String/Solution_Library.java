package leet_code.Problem_151_Medium_Reverse_Words_In_A_String;

public class Solution_Library {

    /**
     * Reverses the order of words in a string.
     * Handles multiple whitespaces and leading/trailing spaces.
     * Uses O(N) time and O(N) space.
     * 
     * Đảo ngược thứ tự các từ trong một chuỗi.
     * Xử lý nhiều khoảng trắng và khoảng trắng ở đầu/cuối.
     * Thời gian O(N) và không gian O(N).
     */
    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        // 1. Trim leading and trailing spaces
        // 1. Loại bỏ khoảng trắng ở đầu và cuối
        s = s.trim();

        // 2. Split by one or more spaces
        // 2. Tách chuỗi bởi một hoặc nhiều khoảng trắng
        String[] words = s.split("\\s+");

        // 3. Build the reversed string
        // 3. Xây dựng chuỗi đảo ngược
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            // Append space if it's not the last word horizontally (first in output)
            // Thêm dấu cách nếu không phải là từ cuối cùng (đầu tiên trong kết quả)
            if (i > 0) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution_Library solution = new Solution_Library();

        // Test Case 1: "the sky is blue"
        System.out.println("Test Case 1: [" + solution.reverseWords("the sky is blue") + "]");
        // Expected: "blue is sky the"

        // Test Case 2: " hello world "
        System.out.println("Test Case 2: [" + solution.reverseWords("  hello world  ") + "]");
        // Expected: "world hello"

        // Test Case 3: "a good example"
        System.out.println("Test Case 3: [" + solution.reverseWords("a good   example") + "]");
        // Expected: "example good a"
    }
}
