# 1544. Make The String Great / Làm cho Chuỗi trở nên Tuyệt vời

## Problem Description / Mô tả bài toán
String `s`. Remove adjacent pairs of same char but different case ('a' and 'A').
Repeat until good.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Stack
Iterate char. If `stack.peek()` is bad pair with current, pop. Else push.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Stack / StringBuilder
Use StringBuilder as stack.
For char `c`:
Check last char `last`.
If `abs(c - last) == 32`, remove `last`.
Else append `c`.
Sử dụng StringBuilder làm ngăn xếp.
Đối với char `c`:
Kiểm tra char cuối `last`. Nếu `abs(c - last) == 32`, loại bỏ `last`.

---
