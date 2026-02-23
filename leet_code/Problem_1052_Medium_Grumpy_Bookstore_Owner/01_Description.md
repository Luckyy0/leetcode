# Grumpy Bookstore Owner
# *Lão Chủ Tiệu Sách Cáu Kỉnh*

## Description
## *Mô tả*

There is a bookstore owner that has a store open for `n` minutes. You are given an integer array `customers` of length `n` where `customers[i]` is the number of customers that enter the store at the start of the `ith` minute and all those customers leave after the end of that minute.
*Có một tay chủ tiệm sách mở cửa hàng làm ăn mưu sinh trong vỏn vẹn `n` phút. Bạn được cấp rọi sáng một mảng số nguyên `customers` cũng dài trọn `n` phút, trong đó `customers[i]` phơi bày tổng số lượng khách hàng lũn cũn nối đuôi nhau bước vào tiệm ngay tại phút thứ `i` (tính từ số 0) và tất cả nhóm khách này sẽ đồng loạt rời đi ngay khi phút đó vừa vặn khép lại trôi qua.*

During certain minutes, the bookstore owner is grumpy. You are given a binary array grumpy where `grumpy[i]` is `1` if the bookstore owner is grumpy during the `ith` minute, and is `0` otherwise.
*Trong một vài phút phát dồ điểm gở, lão chủ tiệm rất hay trái tính trái nết cáu bẳn cộc cằn. Dựa vào đó, Cần nhờ đến một mảng nhị phân thứ hai tên là `grumpy` (chứa toàn 0 với 1). Nếu `grumpy[i] == 1` thì Áy chà, chính vào cái phút thứ `i` đó lão ta đang bốc hỏa cáu gắt chửi bới khách! Ngược chiều, nếu mảng là `0` thì có nghĩa lão đang hiền khô nhỏ nhẹ như tờ.*

When the bookstore owner is grumpy, the customers of that minute are not satisfied. Otherwise, they are satisfied.
*Khoảnh Khắc Lão Phùng Xòe Cáu Gắt (grumpy = 1), Tất thảy Những vị Khách có mặt Lượn lờ Ngửi Cảm Mùi Sát Khí ngột ngạt ở đúng cái phút xui xẻo đó sẽ Mãi Không Mãn Nguyện (Not satisfied). Quay Đầu Hiền Lành, khi Lão Cười Khách Tức Thời Sẽ Hoan Hỉ Hài Lòng (Satisfied).*

The bookstore owner knows a secret technique to safely keep themselves **not grumpy** for exactly `minutes` consecutive minutes, but can only use it **once**.
*Bỗng Nhiên, Tin Mật Phím: Tay chủ tiệm lận lưng Luyện Thành MỘT Tuyệt Kĩ Bí Mật Giấu Nghề! Khi Bấm Nút Tung Bí Kíp Đó ra, lão có thể KHÓA MÕM CỐ TÌNH kìm nét MẶT 0 CÁU KỈNH Ép Nuốt Cơn Giận một chặng dài liên tục Xuyên suốt đúng Cứ `minutes` phút liền tù tì. Ngặt Nỗỉ, Quyền Năng này lão CHỈ CÓ THỂ KHAI VẬN SA CƠ DUY NHẤT 1 LẦN TRONG ĐỜI!*

Return the **maximum number of customers** that can be satisfied throughout the day.
*Cầm cân nảy mực: Hãy tìm Lệnh Rút Chốt xả Chiêu Bí Kíp sao cho Bạn Cứu Vớt Ráp Nối Tính Thêm Bước Phụ Được... **CON SỐ KHÁCH HÀNG THỎA MÃN ĐỈNH KỲ LỤC MAX CAO NHẤT** Thu Xếp Toàn Vẹn Cả Ngày!*

---

## Example 1:
## *Ví dụ 1:*

**Input:** customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3
**Output:** 16
**Explanation:** 
*Giải thích:*
The bookstore owner keeps themselves not grumpy for the last 3 minutes. 
*Tay chủ quyết định bung xõa Chiêu Bí Mật Kiềm Chế Nét Mặt ở Xuyên Cạn Lưng Chừng Đội Hình: Quả chốt chèn vào Đúng 3 Phút cuối cùng (Bắt đầu từ vị trí phút số 5 kéo Tới 7).*
The maximum number of customers that can be satisfied = 1 + 1 + 1 + 1 + 7 + 5 = 16.
*Nhờ cú Phanh Nhẫn Nhịn Cáu Thần Kỳ này, đám khách 7 đứa ở Phút 6 và 5 Đứa Cuối Phút 7 Được Cứu Rỗi Không Bị Chửi. Cộng Dồn Lệnh Lũy Kế Tích Tất Cả Đám Khách Hiện Hữu Lão Hiền Cũ Không Bị Cắn: Tổng càn quét Lượng Khách Hạnh Phúc Bão Đậu Đỉnh là: 1 (Lành) + 1 (Lành) + 1 (Dính Bí Kíp Chữa) + 1 (Lành) + 7 (Ráp Khắc Hiền) + 5 (Bí Kíp Chữa Cáu) = 16 Số Đại Thắng! (Những số vắng tích kia Là Vết Cắn Không Chữa Thấy Chửi Khách 2).*

## Example 2:
## *Ví dụ 2:*

**Input:** customers = [1], grumpy = [0], minutes = 1
**Output:** 1
**Explanation:** 
*Giải thích:*
Tất cả khách (đúng 1 người) đều không bị lão chủ Cáu Tiết chửi rủa nhăn thó.

---

## Constraints:
## *Ràng buộc:*

*   `n == customers.length == grumpy.length`
*   `1 <= minutes <= n <= 2 * 10^4`
*   `0 <= customers[i] <= 1000`
*   `grumpy[i]` is either `0` or `1`.
