# Shortest Way to Form String
# *Con Đường Ngắn Nhất Để Nuôi Dương Thành Chuỗi*

## Description
## *Mô tả*

**NOTE**: This is a LeetCode Premium problem.
**LƯU Ý:** Đây là một bài toán được liệt kê trong danh sách Độc Quyền (Premium) của hệ thống LeetCode.

From any string, we can form a subsequence of that string by deleting some number of characters (possibly no deletions).
*Xuất phát từ một chuỗi (string) vô kỳ bất định, ta hoàn toàn có thể tự bóc tách nhặt ra một "Chuỗi Con Đứt Đoạn" (Subsequence) cắm rễ từ chính hạt giống của nó. Hành động cắt ghép bòn rút này được phép tiến hành bằng việc xóa sổ tự do một cơ số lượng ký tự cản đường bất kỳ - Thậm chí là chả thèm xén đi ký tự nào.*

Given two strings `source` and `target`, return the minimum number of subsequences of `source` such that their concatenation equals `target`. If the task is impossible, return `-1`.
*Bạn được nhận vào tay hai chuỗi ký tự cụ thể: Dây Chuyền Mẹ mang tên `source`, và Dây Đích mong muốn là `target`. Bổn phận của bạn là tìm ra chính xác CON SỐ NHỎ NHẤT ĐẾM ĐƯỢC Các Lượng Chuỗi Con (Subsequences) đục cạy từ Dải `source`... để đến Khi Bạn nối Cụp Đuôi Cụp Đầu Hết những dải rác rời rạc này lại với nhau sẽ Đùn Trào Ghép Nối Vừa Khít Sinh Ra Tuyệt Tác Dây `target` hoàn chỉnh.*
*Trường hợp Tàn Tật Dã Man (Trong Kho `source` Tuyệt Nhiên thiếu vắng hẳn chữ cái cấu thành nên `target`), dẫn đến Bế Tắc Hóa Trống -> Quăng Khúc Củi Khô Cụt Mủn `-1` vào mặt hệ thống Trả kết Cục!*

---

## Example 1:
## *Ví dụ 1:*

**Input:** source = "abc", target = "abcbc"
**Output:** 2
**Explanation:** 
*Giải thích:*
The target "abcbc" can be formed by "abc" and "bc", which are subsequences of source "abc".
*Màn Hợp Thể Chắp Vá thành con Thủy Quái Chuỗi Mới `target = "abcbc"` hoàn toàn có thể được nặn Nháp từ Cú Ghép Đuôi Của "abc" và Cặn Mảnh "bc". Mà Lùng Ra Thì Ấy Chà Cả hai cục Rác này đều vốn LÀ con Đẻ của Cái Lồng Nguồn `source = "abc"` rụng ra. Tổn hao Ráp Cụm bằng 2. Xong Nhiệm vụ.*

## Example 2:
## *Ví dụ 2:*

**Input:** source = "abc", target = "acdbc"
**Output:** -1
**Explanation:** 
*Giải thích:*
The target string cannot be constructed from the subsequences of source string due to the character "d" in target string.
*Chuỗi khát vọng Bờ Bến Mới Đòi Ghép Xoay Vần Ép Giá Mọc Lên Khối Chữ Cái tên là `d` trong Lõi Nhựa. Éo le thay, Nhìn đi Cạo Lại Rãnh Thùng Lõi Gốc Trọng Điểm Mẹ Nguồn `source` chỉ Thấy toàn Có Cỏ Ba Lá Khô Rỗng Tuếch là 'a', 'b', 'c'. Lấy Gì Nung Cụt Xây Thành? Giấc Mơ Xóa Sổ Phá Sản -> Hủy Lệnh, Quăng Chốt Đẩy `-1`!*

## Example 3:
## *Ví dụ 3:*

**Input:** source = "xyz", target = "xzyxz"
**Output:** 3
**Explanation:** 
*Giải thích:*
The target string can be constructed as follows "xz" + "y" + "xz".
*Một Bãi Rác Nhặt Liên Kết Từ Dải `source = "xyz"` Lợp Ngang Phân Giải Lần Lượt Thấy Rớt Đc: Ráp Băng Dính Lập Ghép 3 Cuộn Lẻ: Mảnh Lướt "xz" HÀN CHUỖI NỐI Sang Mảnh "y" CẮM MÁNG GĂM VÀO Mảnh Lặp Kéo Đuôi "xz". Ráp Lại Đủ Chữ Đích Nhắm. Đếm Số Phát Mạch Là 3.*

---

## Constraints:
## *Ràng buộc:*

*   `1 <= source.length, target.length <= 1000`
*   `source` and `target` consist of lowercase English letters.
*   `source` và `target` được nhào nặn thắt nút cấu thành độc quyền chỉ thông qua các mẫu Tự Ghi Bằng Chữ Tiếng Anh Phổ Thông Thường Xoang Khối Nhỏ Cụt Vụn Mực.
