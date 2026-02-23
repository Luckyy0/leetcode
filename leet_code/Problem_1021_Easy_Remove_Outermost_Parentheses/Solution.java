package leet_code.Problem_1021_Easy_Remove_Outermost_Parentheses;

/**
 * Problem 1021: Remove Outermost Parentheses
 * https://leetcode.com/problems/remove-outermost-parentheses/
 */
public class Solution {

    /**
     * Removes the outermost parentheses of every primitive string.
     * Strategy: One-Pass Balance Tracking (O(N) time).
     * 
     * @param s The input valid parentheses string.
     * @return The string after removing outermost parentheses.
     * 
     *         Tóm tắt chiến lược:
     *         1. "Chuỗi nguyên thủy" (Primitive substring) là 1 khối ngoặc kín
     *         chặt 2 đầu, không thể bị chẻ làm đôi thành 2 khối hợp lệ.
     *         VD: "(()())" là 1 khối nguyên thủy. Lột vỏ ngoài cùng của nó sẽ
     *         được "()()".
     *         2. Đề bài bắt lột vỏ của TOÀN BỘ các "củ hành" nguyên thủy nằm
     *         xoắn xuýt kề nhau trong cái mảng khủng lồ `s`.
     *         3. Cách ngây thơ: Cắt cái mảng khổng lồ đó thành từng củ hành một.
     *         Sau đó cầm kéo `substring(1, length - 1)` cắt phăng vỏ từng củ,
     *         ráp lại. Rất tốn Ram (tạo mảng List, rác String chập chờn).
     *         4. Cách Tối Ưu Thần Sầu (One-Pass O(N)): Ta hoàn toàn KHÔNG CẦN phải
     *         cắt khối.
     *         - Chỉ cần dùng 1 cái "Cân bằng" (`balance = 0`) để đo lường.
     *         - Vỏ ngoài cùng của một Củ hành LÀ GÌ? Đó là dấu ngoặc Mở Hàng `(`
     *         đầu tiên (ở lúc `balance == 0`) VÀ dấu ngoặc Đóng Chốt `)` cuối cùng
     *         (ngay khoảng khắc ấn `balance` tuột về đúng bằng 0).
     *         - Mẹo:
     *         -> Gặp dấu `(`. XEM TRƯỚC HẲN, nếu `balance > 0` thì xin chúc
     *         mừng mày không phải vỏ! Tống xéo mày vào Đáp Án Cốt Lõi. Sau đó
     *         mới TĂNG nấc Cân bằng `balance++`.
     *         -> Gặp dấu `)`. GIÁNG NGAY MỘT ĐÒN `balance--`. Giáng xong rồi
     *         ngó coi `balance > 0` không? Nếu vẫn còn Dương điểm, tức là còn
     *         chóp `(` nhô ra chưa đóng kín! Mày không phải Vỏ Chốt cuối! Đưa
     *         mày vào Đáp Án Cốt Lõi. Dưới 0 thì bye bye lột mày luôn.
     */
    public String removeOuterParentheses(String s) {
        // Cần trục lắp ráp chuỗi Siêu cấp
        StringBuilder result = new StringBuilder();
        int balance = 0; // Thước Cân bằng

        // Diều hâu lượn trọn bộ khung
        for (char c : s.toCharArray()) {
            if (c == '(') {
                // Ai đó đã "Mở cửa" trước tui rồi, tui chỉ là hàng Nội Mạc (ruột)!
                if (balance > 0) {
                    result.append(c);
                }
                balance++; // Sập chốt cân bằng nhô thêm 1 trượng
            } else {
                // c == ')'
                balance--; // Đầu tiên phải tháo gỡ chốt cân bằng đi 1 nấc

                // Mặc kệ tao đóng 1 cửa, ngoài kia VẪN CÒN CỔNG CHÍNH CHƯA ĐÓNG! Tao chỉ là
                // ruột.
                if (balance > 0) {
                    result.append(c);
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result 1: " + sol.removeOuterParentheses("(()())(())")); // expected "()()()"
        System.out.println("Result 2: " + sol.removeOuterParentheses("(()())(())(()(()))")); // expected "()()()()(())"
        System.out.println("Result 3: " + sol.removeOuterParentheses("()()")); // expected ""
    }
}
