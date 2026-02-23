package leet_code.Problem_921_Medium_Minimum_Add_to_Make_Parentheses_Valid;

/**
 * Problem 921: Minimum Add to Make Parentheses Valid
 * https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
 */
public class Solution {

    /**
     * Calculates the minimum number of insertions to make the string valid.
     * Strategy: Greedy Balance Counting.
     * 
     * @param s Input parentheses string.
     * @return Minimum moves.
     * 
     *         Tóm tắt chiến lược:
     *         1. Ta cần theo dõi số lượng dấu ngoặc mở '(' chưa được đóng
     *         (`openCount`).
     *         2. Ta cũng cần theo dõi số lượng dấu ngoặc đóng ')' không có cặp
     *         (`neededOpen`).
     *         3. Duyệt qua từng ký tự:
     *         - Nếu gặp '(': Tăng số lượng `openCount` (chờ đóng).
     *         - Nếu gặp ')':
     *         - Nếu `openCount > 0` (có ngoặc mở chờ sẵn): Giảm `openCount` (ghép
     *         cặp thành công).
     *         - Nếu `openCount == 0` (không có ngoặc mở nào): Tăng `neededOpen`
     *         (cần chèn thêm '(' phía trước).
     *         4. Kết quả cuối cùng là tổng số ngoặc cần chèn thêm:
     *         - `neededOpen` (số ngoặc mở cần thêm cho các ngoặc đóng lẻ tẻ).
     *         - `openCount` (số ngoặc đóng cần thêm cho các ngoặc mở còn dư).
     */
    public int minAddToMakeValid(String s) {
        int openCount = 0; // Tracks unmatched '(' that need a closing ')'
        int neededOpen = 0; // Tracks unmatched ')' that need an opening '('

        for (char c : s.toCharArray()) {
            if (c == '(') {
                openCount++;
            } else {
                // Current char is ')'
                if (openCount > 0) {
                    // Match with a previous '('
                    openCount--;
                } else {
                    // No match available, so we need to insert a '('
                    neededOpen++;
                }
            }
        }

        // Total moves = needed '(' + needed ')'
        return neededOpen + openCount;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result: " + sol.minAddToMakeValid("())")); // 1 (need '(')
        System.out.println("Result: " + sol.minAddToMakeValid("(((")); // 3 (need ')))')
        System.out.println("Result: " + sol.minAddToMakeValid("()")); // 0
        System.out.println("Result: " + sol.minAddToMakeValid("()))((")); // 4
    }
}
