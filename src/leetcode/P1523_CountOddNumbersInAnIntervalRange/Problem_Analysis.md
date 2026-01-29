# 1523. Count Odd Numbers in an Interval Range / Đếm Số Lẻ trong Khoảng

## Problem Description / Mô tả bài toán
Range `[low, high]`. Count odd numbers.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Mathematical Formula
Count odds in `[0, x]` is `(x + 1) / 2`.
Result = `Count(high) - Count(low - 1)`.

### Complexity / Độ phức tạp
- **Time**: O(1).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Formula
Function `countOdds(n) = (n + 1) / 2`.
Return `countOdds(high) - countOdds(low - 1)`.
Hàm `countOdds(n) = (n + 1) / 2`.
Trả về `countOdds(high) - countOdds(low - 1)`.

---
