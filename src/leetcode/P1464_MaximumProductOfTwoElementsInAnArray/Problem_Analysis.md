# 1464. Maximum Product of Two Elements in an Array / Tích Tối đa của Hai Phần tử trong Mảng

## Problem Description / Mô tả bài toán
Array `nums`. Return max `(nums[i]-1)*(nums[j]-1)` for distinct `i, j`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Find Two Largest
Need two largest elements `m1` and `m2`.
Result: `(m1-1) * (m2-1)`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: One Pass
Iterate to find largest and second largest.
Lặp lại để tìm phần tử lớn nhất và lớn thứ hai.

---
