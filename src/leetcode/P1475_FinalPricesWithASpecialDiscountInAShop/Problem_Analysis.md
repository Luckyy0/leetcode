# 1475. Final Prices With a Special Discount in a Shop / Giá Cuối cùng Với Giảm giá Đặc biệt trong Cửa hàng

## Problem Description / Mô tả bài toán
Array `prices`. Discount for `prices[i]` is `prices[j]` where `j > i` is the MINIMUM index such that `prices[j] <= prices[i]`.
If no such `j`, no discount.
Return final prices.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Monotonic Stack (Next Less Element)
For each element, find the first smaller-or-equal element to the right.
Use a Stack to store indices.
Iterate `i` from 0 to n.
While `stack` not empty and `prices[stack.peek()] >= prices[i]`:
  `top = stack.pop()`.
  `prices[top] -= prices[i]` (Apply discount).
Push `i`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Monotonic Stack
Iterate through the array. Maintain a stack of indices for which we haven't found a discount yet. The prices at these indices are increasing (monotonic stack). When we encounter a price `p` smaller than or equal to `prices[stack.top()]`, it means `p` is the discount for `stack.top()`. Pop and apply discount.
Lặp qua mảng. Duy trì ngăn xếp các chỉ số chưa tìm thấy giảm giá. Khi gặp giá `p` <= `prices[stack.top()]`, `p` là giảm giá. Pop và áp dụng.

---
