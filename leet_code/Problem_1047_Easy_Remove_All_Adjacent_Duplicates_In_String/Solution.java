package Problem_1047_Easy_Remove_All_Adjacent_Duplicates_In_String;

/**
 * 1047. Remove All Adjacent Duplicates In String
 * 
 * You are given a string s consisting of lowercase English letters. A duplicate
 * removal consists of choosing two adjacent and equal letters and removing
 * them.
 * We repeatedly make duplicate removals on s until we no longer can.
 * Return the final string after all such duplicate removals have been made.
 */
public class Solution {

    /**
     * Dùng Cấu trúc dữ liệu Ngăn Xếp (Stack) - Thực tế trong Java dùng
     * StringBuilder làm Stack để hiệu năng cực đỉnh.
     * Trượt qua từng ký tự, thấy phần tử trước đó (trên Đỉnh Stack) giống y xì đúc
     * phần tử hiện tại thì
     * tiêu diệt cả hai (Pop khỏi Stack và vứt bỏ thằng hiện tại).
     * 
     * @param s Chuỗi ký tự cần xử lý
     * @return Chuỗi cuối cùng sau khi đã nổ tung toàn bộ các cặp trùng lặp
     */
    public String removeDuplicates(String s) {
        // StringBuilder đóng vai rổ chứa Đóng Giả Ngăn Xếp (Stack) để tiện đính thêm
        // (push) và chặt đuôi (pop)
        StringBuilder stack = new StringBuilder();

        for (char currentChar : s.toCharArray()) {
            int stackSize = stack.length();

            // Nếu Rổ Ngăn Xếp Đang CÓ ĐỒ (lớn hơn 0) VÀ Cái Vỏ Bánh ở sát Mép Đỉnh Rổ Giống
            // Hệt Cái Bánh Mình Đang Cầm
            if (stackSize > 0 && stack.charAt(stackSize - 1) == currentChar) {
                // BÙM!! Cả 2 cùng văng. Thằng Đang cầm bị quăng sọt rác,
                // Đồng Thời Đập Nát Chặt Cái Vỏ ở Đỉnh Rổ Ngăn Xếp Ra Khỏi Chuỗi! (Xoáy Pop)
                stack.deleteCharAt(stackSize - 1);
            } else {
                // Nếu khác mặt nhau, hoặc rổ đang trống rỗng?
                // Cưỡng chế nhồi thằng này Vào nằm Chiếm Đỉnh MỚI trong Rổ Ngăn Xếp! (Đẩy Push)
                stack.append(currentChar);
            }
        }

        // Mọi thứ ứ đọng còn sót lại chính là Xác Chuỗi Cương Thi cần tìm!
        return stack.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String s1 = "abbaca";
        System.out.println("Test 1: " + sol.removeDuplicates(s1)); // Expected: "ca"

        String s2 = "azxxzy";
        System.out.println("Test 2: " + sol.removeDuplicates(s2)); // Expected: "ay"
    }
}
