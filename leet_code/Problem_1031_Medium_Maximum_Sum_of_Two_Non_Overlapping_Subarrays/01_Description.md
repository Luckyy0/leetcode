# Result for Maximum Sum of Two Non-Overlapping Subarrays
# *Kết quả bài toán Tổng Trọng Lượng Max Của 2 Chuỗi Con Rời Nhau*

## Description
## *Mô tả*

Given an integer array `nums` and two integers `firstLen` and `secondLen`, return *the maximum sum of elements in two **non-overlapping** subarrays with lengths `firstLen` and `secondLen`*.
*Được cấp một mảng số nguyên `nums` trĩu quả và hai con số nguyên quy định khuôn mẫu `firstLen` cùng `secondLen`. Hãy đi lùng sục và móc túi trả về **Tổng Số Điểm Trọng Lượng LỚN NHẤT** kết tủa từ việc bốc lên đúng Hai Mảng Con Cục Bộ (Subarrays) có độ dài nẹp chặt chuẩn y chang bằng `firstLen` và `secondLen`, với điều lệnh khốc liệt: Hai mảng con này **TUYỆT ĐỐI KHÔNG ĐƯỢC CHỒNG LÊN NHAU** (Non-overlapping).*

The array with length `firstLen` could occur before or after the array with length `secondLen`, but they have to be non-overlapping.
*Trật tự tùy hỉ: Mảng kích cỡ `firstLen` thích nằm xếp hàng trước rồi đến mảng `secondLen` đuổi theo sau bụng cũng được, HOẶC hoán thế cho mảng `secondLen` đứng chễm chệ đầu hàng rồi `firstLen` chạy bám ráp rứa phía đuôi sau. Miễn sao Vách Ngăn Phân Ranh không Đạp chồng lấp 1 bước chân nào lên phần đất nhau!*

A **subarray** is a contiguous part of an array.
*(Ghi nhớ: Một "Subarray" - Mảng con là một đoạn ruột dính liền mạch liền khúc cắt ra từ mảng Mẹ).*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [0,6,5,2,2,5,1,9,4], firstLen = 1, secondLen = 2
**Output:** 20
**Explanation:** One choice of subarrays is [9] with length 1, and [6,5] with length 2.
*Giải thích: Mảng $firstLen = 1$ chỉ ăn cắp đúng 1 cục gạch. Chọn cục bá đạo nhất là `[9]`. Mảng $secondLen = 2$ ăn nối 2 cục, luồn lách nhặt lấy `[6,5]`. Tổng cực phẩm sinh ra: $9 + (6+5) = 20$. Để ý tụi nó đứt lìa không giành đồ của nhau.*

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [3,8,1,3,2,1,8,9,0], firstLen = 3, secondLen = 2
**Output:** 29
**Explanation:** One choice of subarrays is [3,8,1] with length 3, and [8,9] with length 2.
*Giải thích: Đoạn $firstLen = 3$ cuỗm được túi `[3,8,1]` (Tổng $= 12$). Đoạn $secondLen = 2$ quơ sạch khúc đuôi `[8,9]` (Tổng $= 17$). Hai khối này cắn sát đuôi nhưng không hề lấn vạch. Cúp vinh quang $= 12 + 17 = 29$.*

## Example 3:
## *Ví dụ 3:*

**Input:** nums = [2,1,5,6,0,9,5,0,3,8], firstLen = 4, secondLen = 3
**Output:** 31
**Explanation:** One choice of subarrays is [5,6,0,9] with length 4, and [0,3,8] with length 3.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= firstLen, secondLen <= 1000`
*   `2 <= firstLen + secondLen <= 1000`
*   `firstLen + secondLen <= nums.length <= 1000`
*   `0 <= nums[i] <= 1000`
