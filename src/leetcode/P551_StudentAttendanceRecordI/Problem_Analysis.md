# 551. Student Attendance Record I / Bản Ghi Điểm Danh Học Sinh I

## Problem Description / Mô tả bài toán
You are given a string `s` representing an attendance record for a student where each character signifies whether the student was absent, late, or present on that day. The record only contains the following three characters:
Bạn được cung cấp một chuỗi `s` đại diện cho bản ghi điểm danh của một học sinh, trong đó mỗi ký tự biểu thị việc học sinh vắng mặt, đi muộn hoặc có mặt vào ngày đó. Bản ghi chỉ chứa ba ký tự sau:

- `'A'`: Absent. / Vắng mặt.
- `'L'`: Late. / Đi muộn.
- `'P'`: Present. / Có mặt.

The student is eligible for an attendance award if they meet **both** of the following criteria:
Học sinh đủ điều kiện nhận giải thưởng chuyên cần nếu họ đáp ứng **cả hai** tiêu chí sau:

1. The student was absent (`'A'`) for **strictly fewer than 2 days** total. / Học sinh vắng mặt (`'A'`) **tổng cộng ít hơn 2 ngày**.
2. The student was **never** late (`'L'`) for 3 or more **consecutive** days. / Học sinh **không bao giờ** đi muộn (`'L'`) trong 3 ngày **liên tiếp** trở lên.

Return `true` if the student is eligible for the attendance award, or `false` otherwise.
Hãy trả về `true` nếu học sinh đủ điều kiện nhận giải thưởng chuyên cần, hoặc `false` nếu ngược lại.

### Example 1:
```text
Input: s = "PPALLP"
Output: true
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Simple Iteration / Lặp đơn giản
We can iterate through the string once and check conditions.

Algorithm:
1. Initialize `absentCount = 0`, `lateSeq = 0`.
2. Iterate char `c` in string:
   - If `c == 'A'`:
     - `absentCount++`. If `absentCount >= 2`, return `false`.
     - `lateSeq = 0`.
   - If `c == 'L'`:
     - `lateSeq++`. If `lateSeq >= 3`, return `false`.
   - If `c == 'P'`:
     - `lateSeq = 0`.
3. Return `true`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Single Pass Validation

**Algorithm**:
1.  Iterate through the string.
2.  Count total 'A's. Abort if >= 2.
3.  Track consecutive 'L's. Abort if >= 3.
4.  Return true if loop completes.

---
