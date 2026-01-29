# 1374. Generate a String With Characters That Have Odd Counts / Tạo Chuỗi với Các Ký tự Có Số lần Xuất hiện Lẻ

## Problem Description / Mô tả bài toán
Integer `n`. Generate string of length `n`. Each char occurs odd number of times.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Parity
If `n` is odd: `n` chars 'a'. ('a' appears `n` times, which is odd).
If `n` is even: `n-1` chars 'a' and 1 char 'b'.
'a' appears `n-1` (odd). 'b' appears 1 (odd).
Works for all `n >= 1`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Check Parity
If `n` is odd, return string repeating 'a' `n` times.
If `n` is even, return string repeating 'a' `n-1` times followed by 'b'.
Nếu `n` là số lẻ, hãy trả về chuỗi lặp lại 'a' `n` lần.
Nếu `n` là số chẵn, hãy trả về chuỗi lặp lại 'a' `n-1` lần theo sau là 'b'.

---
