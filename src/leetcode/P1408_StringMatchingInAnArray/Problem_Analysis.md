# 1408. String Matching in an Array / Khớp Chuỗi trong Mảng

## Problem Description / Mô tả bài toán
Array of strings `words`. Return all strings in `words` that are a substring of another word in `words`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Brute Force / String Search
For each word `w1`, check if it is substring of any other `w2`.
Optimization: Sort by length maybe?
Constraints small (n <= 100). O(N^2 * L) is fine.

### Complexity / Độ phức tạp
- **Time**: O(N^2 * L).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Nested Loop Contains
Iterate through the array. For each word `words[i]`, iterate through `words[j]` where `i != j`. If `words[j].contains(words[i])`, add `words[i]` to result (avoid duplicates) and break inner loop.
Lặp qua mảng. Đối với mỗi từ `words[i]`, lặp qua `words[j]` trong đó `i != j`. Nếu `words[j].contains(words[i])`, thêm `words[i]` vào kết quả (tránh trùng lặp) và thoát khỏi vòng lặp bên trong.

---
