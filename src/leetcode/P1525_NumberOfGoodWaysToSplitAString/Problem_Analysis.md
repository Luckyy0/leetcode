# 1525. Number of Good Ways to Split a String / Số cách Tốt để Tách một Chuỗi

## Problem Description / Mô tả bài toán
String `s`. Split into 2 non-empty parts `left` and `right`.
Good split: `distinct(left) == distinct(right)`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Prefix and Suffix Counts
Compute distinct characters in prefix `[0...i]` for all `i`.
Compute distinct characters in suffix `[i+1...n-1]` for all `i`.
Count indices where `prefix[i] == suffix[i]`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: 2 Arrays
Array `pre` size n. `post` size n.
Fill value. Iterate compare.
Mảng `pre` kích thước n. `post` kích thước n.
Điền giá trị. Lặp lại so sánh.

---
