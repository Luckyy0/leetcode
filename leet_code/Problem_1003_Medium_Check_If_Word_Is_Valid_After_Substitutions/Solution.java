package leet_code.Problem_1003_Medium_Check_If_Word_Is_Valid_After_Substitutions;

/**
 * Problem 1003: Check If Word Is Valid After Substitutions
 * https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/
 */
public class Solution {

    /**
     * Determines if the string can be built by inserting "abc".
     * Strategy: Primitive Array Stack parsing.
     * 
     * @param s The string to evaluate.
     * @return True if valid, false otherwise.
     * 
     *         Tóm tắt chiến lược:
     *         1. Chuỗi hợp lệ chỉ được xây dựng bằng cách chèn cụm "abc". Điều này
     *         đồng nghĩa với việc ta có thể phân rã ngược chuỗi đó bằng cách RÚT
     *         "abc" ra liên tục cho đến khi chuỗi trống rỗng ("").
     *         2. Phân rã kiểu này hoạt động y hệt như Kiểm tra Khớp Cặp Ngoặc () []
     *         {}. Cấu trúc dữ liệu tối ưu nhất là Ngăn Xếp (Stack).
     *         3. Thay vì dùng `java.util.Stack` khá chậm, ta dùng mảng nguyên thủy
     *         (primitive array) `char[] stack` và con trỏ `top = 0` (lưu vị trí
     *         hiện tại đang trỏ tới chỉ mục rỗng ở đỉnh).
     *         4. Duyệt qua từng ký tự `ch` của chuỗi:
     *         - Ý TƯỞNG: Nếu không phải `'c'`, ta đẩy `ch` vào đỉnh ngăn xếp.
     *         - Nếu `ch` lÀ `'c'`, ta phải kiểm tra xem CHỮ nào đang án ngữ ở 2 vị
     *         trí đỉnh trên ngăn xếp:
     *         - Ngăn xếp phải chứa ít nhất 2 ký tự (`top >= 2`).
     *         - Ký tự đỉnh kề liền trước đó phải là `'b'` (`stack[top - 1] ==
     *         'b'`).
     *         - Ký tự kề liền phía dưới nữa phải là `'a'` (`stack[top - 2] ==
     *         'a'`).
     *         - Nếu thỏa mãn TẤT CẢ điệu kiện trên, TỨC LÀ cụm "abc" đã đầy đủ. Ta
     *         triệt tiêu "a" và "b" bằng cách Kéo Tụt chỉ số `top` về phía sau 2 ô
     *         (`top -= 2`) mà không ghi 'c' vào.
     *         - Việc kéo tụt `top` đồng nghĩa với việc xóa bỏ "ab" ra khỏi bộ nhớ
     *         xử lý (mảng `stack[]` không cần xóa thật sự, lát sau có dữ liệu khác
     *         sẽ tự đè lên vị trí mới `top`).
     *         - Nếu `ch == 'c'` mà không thỏa mãn các chữ 'a' 'b' bên dưới, chuỗi
     *         sai cú pháp, ta vẫn lưu chữ `'c'` đó vào đỉnh stack.
     *         5. Khi lặp hết vòng lặp, NẾU toàn bộ cờ bị rút sạch theo lô "abc" thì
     *         đỉnh `top` phải trở về `0`. Nếu `top == 0` thì trả về `true`. Ngược
     *         lại là `false`.
     */
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int top = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Check if we hit the end character 'c' of the expected "abc"
            if (ch == 'c') {
                // To form "abc", we must have exactly 'a' and 'b' correctly positioned
                if (top >= 2 && stack[top - 1] == 'b' && stack[top - 2] == 'a') {
                    // Valid sequence formed, logical pop
                    top -= 2;
                } else {
                    // Invalid formation, push 'c' onto the stack
                    stack[top++] = ch;
                }
            } else {
                // Push 'a' or 'b'
                stack[top++] = ch;
            }
        }

        // If everything perfectly formed sets of "abc", stack is empty
        return top == 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result 1: " + sol.isValid("aabcbc")); // true
        System.out.println("Result 2: " + sol.isValid("abcabcababcc")); // true
        System.out.println("Result 3: " + sol.isValid("abccba")); // false
    }
}
