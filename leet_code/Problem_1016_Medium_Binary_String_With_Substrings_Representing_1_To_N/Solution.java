package leet_code.Problem_1016_Medium_Binary_String_With_Substrings_Representing_1_To_N;

/**
 * Problem 1016: Binary String With Substrings Representing 1 To N
 * https://leetcode.com/problems/binary-string-with-substrings-representing-1-to-n/
 */
public class Solution {

    /**
     * Checks if all binary substrings from 1 to n exist in s.
     * Strategy: Optimal Backward Search.
     * 
     * @param s The master binary string.
     * @param n The integer upper limit.
     * @return True if all substrings exist, false otherwise.
     * 
     *         Tóm tắt chiến lược:
     *         1. Nhìn vào N = 10^9, chả có hệ thống nào chạy nổi N tỷ phép lặp
     *         duyệt
     *         chuỗi. Bạn sẽ nghĩ đây là bài đánh đố siêu khó Cần Toán Đỉnh Cao.
     *         2. NHƯNG KHOAN ĐÃ! Nhìn kỹ ràng buộc của mảng chữ cái S ban đầu:
     *         Chiều dài của S chỉ là 1000 ký tự. Căn phòng hẹp như hạt tiêu.
     *         3. Mảng dài 1000 phần tử thì CÓ TRỜI MỚI GIẤU NỔI TỶ cái chuỗi con
     *         KHÁC BIỆT CỦA CÁC ĐẠI VƯƠNG N. Vì một mảng hữu hạn chỉ đẻ ra được cực
     *         ít chuỗi con (tầm vài ngàn trường hợp là kịch kim).
     *         -> Do đó N lớn hơn độ vài ngàn là SỤP ĐỔ CHẮC CHẮN. Không cần lặp.
     *         (Những bài False thì nó vấp ngã ở vài số đầu tiên rồi, trả False
     *         luôn).
     *         4. Chúng ta chỉ việc lặp đếm ngược N xuống dưới 1.
     *         5. Khoan, tối ưu phát nữa! Nếu S lọt chứa anh hai "100" (số 4). Nó có
     *         nghiễm nhiên ngậm luôn chuỗi con "10" không? CÓ. Nghĩa là số X
     *         mà có, thì số X/2 chắc chắn có vì nó là phần đầu của X.
     *         Vì vậy, TA CHỈ CẦN LẶP LÙI TỪ N VỀ N/2 LÀ MÃN NGUYỆN.
     *         6. Bài toán Tỷ Tỷ thành bài toán Nhỏ Bằng Nắm Khỉ.
     */
    public boolean queryString(String s, int n) {
        // Cú lặp lùi từ N vắt ngang xuống N/2
        // Vừa tiết kiệm nửa thời gian, vừa thoát hiểm nếu False ngáng đường
        for (int i = n; i > n / 2; i--) {
            // Ép xác nguyên thể ra hình hài nhị phân
            String binaryRepresentation = Integer.toBinaryString(i);

            // Tìm kiếm chuỗi con bằng súng máy .contains()
            if (!s.contains(binaryRepresentation)) {
                return false;
            }
        }

        // Hoàn hảo trót lọt -> Thành công
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result 1: " + sol.queryString("0110", 3)); // expected true
        System.out.println("Result 2: " + sol.queryString("0110", 4)); // expected false
    }
}
