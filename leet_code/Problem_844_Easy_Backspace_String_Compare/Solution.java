package leet_code.Problem_844_Easy_Backspace_String_Compare;

/**
 * Problem 844: Backspace String Compare
 * https://leetcode.com/problems/backspace-string-compare/
 */
public class Solution {

    /**
     * Compares two strings after applying backspace operations.
     * Strategy: Two Pointers (starting from the end).
     * 
     * @param s First string.
     * @param t Second string.
     * @return True if final results are equal.
     * 
     *         Tóm tắt chiến lược:
     *         1. Duyệt ngược từ cuối chuỗi về đầu.
     *         2. Khi gặp ký tự '#', ta tăng biến đếm 'skip' để biết cần bỏ qua bao
     *         nhiêu
     *         ký tự chữ cái tiếp theo.
     *         3. Tìm ký tự "hợp lệ" tiếp theo của cả hai chuỗi (là ký tự không bị
     *         xóa
     *         bởi bất kỳ dấu '#' nào).
     *         4. So sánh hai ký tự hợp lệ này. Nếu khác nhau, trả về false.
     *         5. Nếu một chuỗi hết ký tự mà chuỗi kia vẫn còn ký tự hợp lệ, trả về
     *         false.
     *         6. Lặp lại cho đến hết cả hai chuỗi.
     */
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int skipS = 0;
        int skipT = 0;

        while (i >= 0 || j >= 0) {

            // Find next valid character in s
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }

            // Find next valid character in t
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }

            // If both characters are found and valid, compare them
            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j))
                    return false;
            } else {
                // If one string is empty and the other is not (after backspacing)
                if ((i >= 0) != (j >= 0))
                    return false;
            }

            i--;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result: " + sol.backspaceCompare("ab#c", "ad#c")); // true
        System.out.println("Result: " + sol.backspaceCompare("ab##", "c#d#")); // true
        System.out.println("Result: " + sol.backspaceCompare("a#c", "b")); // false
    }
}
