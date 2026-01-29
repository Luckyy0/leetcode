# 1446. Consecutive Characters / Các Ký tự Liên tiếp

## Problem Description / Mô tả bài toán
String `s`. Power of string = max length of substring containing only one unique character.
Return power.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Iteration
Count consecutive same characters. Update max.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: One Pass
Iterate string. If `s[i] == s[i-1]`, count++. Else `count = 1`. Update global max.
Lặp lại chuỗi. Nếu `s[i] == s[i-1]`, count++. Ngược lại `count = 1`. Cập nhật max toàn cục.

---
