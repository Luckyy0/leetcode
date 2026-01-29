# 1432. Max Difference You Can Get From Changing an Integer / Sự Khác biệt Tối đa Bạn có thể Nhận được Từ Việc Thay đổi một Số nguyên

## Problem Description / Mô tả bài toán
Integer `num`. Pick a digit `x` (0-9) and replacement `y` (0-9). Replace all occurrences of `x` with `y`.
Do this twice: once to maximize (get `a`), once to minimize (get `b`).
Rule: No leading zeros (unless num is 0).
Return `a - b`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Replacement
Maximize:
Scan digits L->R. Find first digit `d` NOT 9. Replace `d` with 9.
If all 9s, change nothing.
Minimize:
Scan digits L->R.
If first digit is NOT 1:
- Replace first digit `d` with 1? Yes, to make it smaller.
- E.g. 555 -> 111.
Wait. If first digit is 1. Scan for first non-zero non-1 digit. Replace with 0.
Example: 123 -> Change 2 to 0 -> 103.
Example: 111 -> Change nothing (if allowed, but wait "You are choosing x and y").
Can change any digit.
Minimization logic:
- If first digit `d` != 1: Replace all `d` with `1`. (Leading with 0 forbidden).
- If first digit is 1: Find first digit `k` != 0 and `k` != 1. Replace all `k` with `0`. (Since leading 1 remains 1, internal digits become 0 is safe).

### Complexity / Độ phức tạp
- **Time**: O(log Val). (Number of digits).
- **Space**: O(log Val).

---

## Analysis / Phân tích

### Approach: String Manipulation
Convert num to string/digits.
Get Max:
- Find first digit != '9'. Replace it with '9'.
Get Min:
- If first digit != '1': Replace it with '1'.
- If first digit == '1': Find first digit != '0' and != '1'. Replace it with '0'.
Compute difference.
Chuyển đổi số thành chuỗi/chữ số.
Lấy Max:
- Tìm chữ số đầu tiên != '9'. Thay thế nó bằng '9'.
Lấy Min:
- Nếu chữ số đầu tiên != '1': Thay thế bằng '1'.
- Nếu chữ số đầu tiên == '1': Tìm chữ số đầu tiên != '0' và != '1'. Thay thế bằng '0'.
Tính toán sự khác biệt.

---
