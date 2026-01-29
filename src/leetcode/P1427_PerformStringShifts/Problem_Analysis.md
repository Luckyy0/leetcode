# 1427. Perform String Shifts / Thực hiện Dịch chuyển Chuỗi

## Problem Description / Mô tả bài toán
String `s`, `shift` array `[direction, amount]`.
0: Left shift.
1: Right shift.
Return final string.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Modulo Arithmetic
Calculate net shift.
Left shift `d` is equivalent to Right shift `-d`.
Sum all shifts.
Normalize total shift to `[0, length-1]`.
Perform substring concatenation.

### Complexity / Độ phức tạp
- **Time**: O(N + L) where L is string length.
- **Space**: O(L).

---

## Analysis / Phân tích

### Approach: Calculate Net Shift
Iterate `shift` array. Accumulate total right shift.
If direction 0 (left), subtract amount.
If direction 1 (right), add amount.
`totalShift %= len`. If negative, add `len`.
Result is `s.substring(len - shift) + s.substring(0, len - shift)`.
Wait. Net right shift `k`.
Last `k` chars move to front.
`s.substring(len - k) + s.substring(0, len - k)`.
Lặp lại mảng `shift`. Tích lũy tổng độ dịch chuyển sang phải.
Nếu hướng 0 (trái), trừ số lượng.
Nếu hướng 1 (phải), cộng số lượng.
`totalShift %= len`. Nếu âm, cộng `len`.
Kết quả là `s.substring(len - shift) + s.substring(0, len - shift)`.

---
