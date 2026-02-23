# Result for Student Attendance Record II
# *Kết quả cho bài toán Điểm danh Học sinh II*

## Description
## *Mô tả*

An attendance record for a student can be represented as a string where each character signifies whether the student was absent, late, or present on that day. The record only contains the following three characters:
*Hồ sơ điểm danh của một học sinh có thể được biểu diễn dưới dạng một chuỗi, trong đó mỗi ký tự biểu thị việc học sinh đó vắng mặt, đi muộn hoặc có mặt vào ngày đó. Hồ sơ chỉ chứa ba ký tự sau:*

*   `'A'`: Absent. (Vắng mặt)
*   `'L'`: Late. (Đi muộn)
*   `'P'`: Present. (Có mặt)

Any student is eligible for an attendance award if they meet **both** of the following criteria:
*Bất kỳ học sinh nào đều đủ điều kiện nhận giải thưởng chuyên cần nếu họ đáp ứng **cả hai** tiêu chí sau:*

1.  The student was absent (`'A'`) for **strictly fewer than 2 days** total.
    *Học sinh vắng mặt (`'A'`) **ít hơn 2 ngày** tổng cộng.*
2.  The student was **never** late (`'L'`) for **3 or more consecutive days**.
    *Học sinh **không bao giờ** đi muộn (`'L'`) trong **3 ngày liên tiếp trở lên**.*

Given an integer `n`, return *the number of possible attendance records of length* `n` *that make a student eligible for an attendance award. Since the answer may be very large, return it **modulo** `10^9 + 7`*.
*Cho một số nguyên `n`, hãy trả về *số lượng hồ sơ điểm danh có độ dài `n` có thể có khiến một học sinh đủ điều kiện nhận giải thưởng chuyên cần. Vì câu trả lời có thể rất lớn, hãy trả về nó theo **modulo** `10^9 + 7`*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `n = 2`
**Output:** `8`
**Explanation:** There are 8 records with length 2 that are eligible for an award:
"PP", "AP", "PA", "LP", "PL", "AL", "LA", "LL"
Only "AA" is not eligible because there are 2 'A' (absent) days.

## Example 2:
## *Ví dụ 2:*

**Input:** `n = 1`
**Output:** `3`

## Example 3:
## *Ví dụ 3:*

**Input:** `n = 10101`
**Output:** `183236314`

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 10^5`
