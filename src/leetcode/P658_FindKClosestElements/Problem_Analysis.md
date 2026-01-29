# 658. Find K Closest Elements / Tìm K Phần Tử Gần Nhất

## Problem Description / Mô tả bài toán
Given a sorted integer array `arr`, two integers `k` and `x`, return the `k` closest integers to `x` in the array. The result should also be sorted in ascending order.

---

## Theoretical Foundation / Cơ sơ lý thuyết
### Binary Search + Two Pointers / Tìm Kiếm Nhị Phân + Hai Con Trỏ
Binary search to find position, then expand window to k elements.

### Complexity / Độ phức tạp
- **Time**: O(log N + k).
- **Space**: O(1).
---
