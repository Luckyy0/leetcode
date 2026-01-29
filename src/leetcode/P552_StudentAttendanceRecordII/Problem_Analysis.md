# 552. Student Attendance Record II / Bản Ghi Điểm Danh Học Sinh II

## Problem Description / Mô tả bài toán
An attendance record for a student can be represented as a string where each character signifies whether the student was absent, late, or present on that day. The record only contains the following three characters: `'A'`, `'L'`, `'P'`.
Một bản ghi điểm danh cho một học sinh có thể được biểu diễn dưới dạng một chuỗi, trong đó mỗi ký tự biểu thị việc học sinh vắng mặt, đi muộn hoặc có mặt vào ngày đó. Bản ghi chỉ chứa ba ký tự sau: `'A'`, `'L'`, `'P'`.

Given an integer `n`, return the number of possible attendance records of length `n` that make a student eligible for an attendance award. The answer may be very large, so return it modulo `10^9 + 7`.
Cho một số nguyên `n`, hãy trả về số lượng bản ghi điểm danh có thể có độ dài `n` giúp học sinh đủ điều kiện nhận giải thưởng chuyên cần. Câu trả lời có thể rất lớn, vì vậy hãy trả về theo modulo `10^9 + 7`.

A student is eligible for an attendance award if they meet **both** of the following criteria:
1. The student was absent (`'A'`) for **strictly fewer than 2 days** total.
2. The student was **never** late (`'L'`) for 3 or more **consecutive** days.

### Example 1:
```text
Input: n = 2
Output: 8
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / Quy hoạch động
We need to construct a string of length `n` while tracking:
1. The number of 'A's used so far (0 or 1).
2. The number of consecutive 'L's ending at the current position (0, 1, or 2).

State: `dp[len][numA][consecL]`
- `len`: current length (1 to n).
- `numA`: number of Absents (0 or 1).
- `consecL`: consecutive Lates ending current string (0, 1, 2).

Transitions for state `dp[i][j][k]`:
- **Add 'P'**: `numA` remains `j`, `consecL` becomes `0`.
  - contributing to `dp[i+1][j][0]`.
- **Add 'A'**: `numA` becomes `j+1`, `consecL` becomes `0`.
  - Only allowed if `j == 0`.
  - contributing to `dp[i+1][j+1][0]`.
- **Add 'L'**: `numA` remains `j`, `consecL` becomes `k+1`.
  - Only allowed if `k < 2`.
  - contributing to `dp[i+1][j][k+1]`.

Can optimize space to O(1) since `i` only depends on `i-1`. There are only 2 * 3 = 6 states.

### Complexity / Độ phức tạp
- **Time**: O(N). Matrix Exponentiation can solve in O(log N).
- **Space**: O(N) or O(1).

---

## Analysis / Phân tích

### Approach: 3D Dynamic Programming

**Algorithm**:
1.  Define DP states considering constraints.
2.  Iterate from length 1 to n.
3.  Apply state transitions for 'P', 'A', 'L'.
4.  Apply modulo arithmetic.
5.  Sum up all valid final states.

---
