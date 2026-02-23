# Result for Student Attendance Record I
# *Kết quả cho bài toán Điểm danh Học sinh I*

## Description
## *Mô tả*

You are given a string `s` representing an attendance record for a student where each character signifies whether the student was absent, late, or present on that day. The record only contains the following three characters:
*Bạn được cho một chuỗi `s` đại diện cho hồ sơ điểm danh của một học sinh, trong đó mỗi ký tự biểu thị việc học sinh đó vắng mặt, đi muộn hoặc có mặt vào ngày đó. Hồ sơ chỉ chứa ba ký tự sau:*

*   `'A'`: Absent. (Vắng mặt)
*   `'L'`: Late. (Đi muộn)
*   `'P'`: Present. (Có mặt)

The student is eligible for an attendance award if they meet **both** of the following criteria:
*Học sinh đủ điều kiện nhận giải thưởng chuyên cần nếu họ đáp ứng **cả hai** tiêu chí sau:*

1.  The student was absent (`'A'`) for **strictly fewer than 2 days** total.
    *Học sinh vắng mặt (`'A'`) **ít hơn 2 ngày** tổng cộng.*
2.  The student was **never** late (`'L'`) for **3 or more consecutive days**.
    *Học sinh **không bao giờ** đi muộn (`'L'`) trong **3 ngày liên tiếp trở lên**.*

Return `true` if the student is eligible for an attendance award, or `false` otherwise.
*Trả về `true` nếu học sinh đủ điều kiện nhận giải thưởng chuyên cần, ngược lại trả về `false`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `s = "PPALLP"`
**Output:** `true`
**Explanation:** The student has fewer than 2 absences and was never late 3 or more consecutive days.

## Example 2:
## *Ví dụ 2:*

**Input:** `s = "PPALLL"`
**Output:** `false`
**Explanation:** The student was late 3 consecutive days in the last 3 days, so is not eligible for the award.

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 1000`
*   `s[i]` is either `'A'`, `'L'`, or `'P'`.
