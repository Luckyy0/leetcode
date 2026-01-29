# 1200. Minimum Absolute Difference / Chênh lệch Tuyệt đối Tối thiểu

## Problem Description / Mô tả bài toán
Given an array of distinct integers `arr`, find all pairs of elements with the minimum absolute difference of any pair in the array.
Return pairs in ascending order.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sorting / Sắp xếp
1. Sort `arr`.
2. Find min diff between adjacent elements.
3. Collect all adjacent pairs with that difference.

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(log N) sorting (or O(N) output).

---
