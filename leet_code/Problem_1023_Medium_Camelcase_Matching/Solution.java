package leet_code.Problem_1023_Medium_Camelcase_Matching;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 1023: Camelcase Matching
 * https://leetcode.com/problems/camelcase-matching/
 */
public class Solution {

    /**
     * Checks if each query matches the camelcase pattern.
     * Strategy: Optimal Two Pointers.
     * 
     * @param queries Array of query strings to be checked.
     * @param pattern The camelcase pattern string to match against.
     * @return A list of boolean values indicating matching results.
     * 
     *         Tóm tắt chiến lược:
     *         1. "Khớp Mẫu Camelcase" nghĩa là Mẫu (Pattern) là Dàn khung Xương
     *         Sống.
     *         Chuỗi Câu hỏi (Query) là phần Xác chắp vá.
     *         Quy định Sống Còn: Bạn được phép NHÉT THÊM bao nhiêu cũng được chữ
     *         cái
     *         "in thường" (lowercase) vào Dàn khung Xương sống để biến Xương thành
     *         Xác.
     *         (Tuyệt đối CẤM nhét chữ IN HOA!).
     *         2. Cách ngây thơ là dùng Regex (Biểu thức chính quy). Rất rườm rà
     *         và máy biên dịch phải hoạt động đồ sộ (chậm chạp).
     *         3. Cách Tối Ưu Tốc Độ Ánh Sáng: Dùng kỹ thuật Hai Con Trỏ (Two
     *         Pointers).
     *         - Cho con trỏ `p` canh gác bên chuỗi Mẫu (pattern).
     *         - Lướt từng Kí tự `c` trong chuỗi Xác (query).
     *         4. Luật Nhân Quả:
     *         - CHỤP TRÚNG CHỮ (TRÙNG KHỚP): Nếu `c` giống hệt kí tự mà `p` đang
     *         canh gác (phải kiểm tra `p` chưa lố độ dài Mẫu), ta tự hào nhấc
     *         bước `p` tiến lên canh gác chữ tiếp theo của Mẫu!
     *         - LỆCH PHA (CHỮ DƯ THỪA TRONG XÁC): Nếu xui xẻo `c` khác bọt hoàn
     *         toàn
     *         với `p`. Nó chính xác là món "hàng độ thêm" của Xác. Kẻ độ thêm này
     *         luật Ràng Buộc bắt buộc phải là Chữ Thường (lowercase)!
     *         Chộp kiểm tra `Character.isUpperCase(c)` ngay! Thấy cái Gai Chữ Hoa
     *         nào trồi lên vướng víu thì phán Án Tử `return false` (KHÔNG KHỚP!).
     *         Nếu nó chỉ là chữ in thường ngoan hiền, tha mạng cho nó và lờ cờ
     *         bỏ qua duyệt tiếp.
     *         5. Kết Mạc: Lướt sạch 1 vòng Xác. Về đích, đấm ngực xem con trỏ Khung
     *         Mẫu `p` đã bò mòn tới chót đích của chuỗi Mẫu chưa (`p ==
     *         pattern.length()`).
     *         Thiếu gạch xây Khung thì nhịn `false`. Khớp 100% Khung thì `true`.
     */
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList<>();

        for (String query : queries) {
            result.add(isMatch(query, pattern));
        }

        return result;
    }

    private boolean isMatch(String query, String pattern) {
        // Con trỏ p canh gác Chữ Mẫu
        int p = 0;
        int patternLen = pattern.length();

        // Rảo bước mổ xẻ trên Chuỗi Xác
        for (char c : query.toCharArray()) {
            // Nút Khớp: Nhấc bước p tiến sâu hơn
            if (p < patternLen && c == pattern.charAt(p)) {
                p++;
            }
            // Nút Lệch: Bắt thóp Chữ Dư Thừa IN HOA Cấm Kị
            else if (Character.isUpperCase(c)) {
                return false;
            }
            // (Chữ Dư in thường bị tàng hình, lơ đẹp đi tiếp)
        }

        // Thoát khỏi rừng Xác, chốt xem p đã ăn trọn 100% Khung Mẫu chưa
        return p == patternLen;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] queries = { "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack" };

        System.out.println("Result 1: " + sol.camelMatch(queries, "FB"));
        // expected [true,false,true,true,false]

        System.out.println("Result 2: " + sol.camelMatch(queries, "FoBa"));
        // expected [true,false,true,false,false]

        System.out.println("Result 3: " + sol.camelMatch(queries, "FoBaT"));
        // expected [false,true,false,false,false]
    }
}
