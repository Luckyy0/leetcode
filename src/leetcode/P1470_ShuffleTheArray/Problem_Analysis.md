# 1470. Shuffle the Array / Trộn Mảng

## Problem Description / Mô tả bài toán
Array `nums`, size `2n`: `[x1, x2... xn, y1, y2... yn]`.
Return `[x1, y1, x2, y2... xn, yn]`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Iteration
Create new array.
`res[2*i] = nums[i]`.
`res[2*i+1] = nums[i+n]`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N). In-place possible with bit manipulation if values small.

---

## Analysis / Phân tích

### Approach: New Array
Construct new array using the formula.
Xây dựng mảng mới bằng công thức.

---
