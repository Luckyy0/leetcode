# 1534. Count Good Triplets / Đếm Bộ ba Tốt

## Problem Description / Mô tả bài toán
Array `arr`. `a, b, c`.
`|arr[i] - arr[j]| <= a`
`|arr[j] - arr[k]| <= b`
`|arr[i] - arr[k]| <= c`
Count triplets.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Brute Force
Nested loops `i, j, k`.
Conditions check.

### Complexity / Độ phức tạp
- **Time**: O(N^3).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Triple Loop
Constraints N <= 100. $N^3 = 10^6$. OK.
Lặp ba vòng.

---
