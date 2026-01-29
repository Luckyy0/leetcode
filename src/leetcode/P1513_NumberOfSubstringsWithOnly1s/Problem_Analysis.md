# 1513. Number of Substrings With Only 1s / Số lượng Chuỗi con Chỉ Có Số 1

## Problem Description / Mô tả bài toán
String `s` of 0s and 1s.
Count substrings of only 1s. Mod 10^9+7.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Consecutive Ones
Group 1s. A block of `k` ones contributes `k*(k+1)/2` substrings.
Iterate and accumulate.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Linear Scan
Iterate string. Maintain `count` of consecutive 1s.
If '1', `count++`. `res += count`. (This adds 1, 2, 3... which sums to k(k+1)/2).
If '0', `count=0`.
Modulo at each step.
Lặp lại chuỗi. Duy trì `count` của 1 liên tiếp.
Nếu '1', `count++`. `res += count`.
Nếu '0', `count=0`.

---
