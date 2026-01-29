# 1536. Minimum Swaps to Arrange a Binary Grid / Số lượng Hoán đổi Tối thiểu để Sắp xếp Lưới Nhị phân

## Problem Description / Mô tả bài toán
Binary Grid `n x n`. Swap adjacent rows.
Goal: Make grid valid (upper triangle is all zeros).
i.e., row `i` must have `n - 1 - i` trailing zeros.
Min swaps.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Selection
For each row position `i` (from 0 to n-1), we need a row that has at least `n - 1 - i` trailing zeros.
Find the NEAREST row (from `i` downwards) that satisfies this requirement.
Swap it up to `i` (bubble up). Add swaps to count.
Why greedy? Pulling the nearest valid row minimizes disturbance for future rows. If we pick a further row, we move more rows which might have been useful for later. Nearest is optimal.

### Complexity / Độ phức tạp
- **Time**: O(N^2).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Precompute Zeros + Greedy Bubble Sort
1. Calculate trailing zeros for each row. Store in array `zeros`.
2. Iterate `i` from 0 to n-1. Needed zeros: `req = n - 1 - i`.
3. Search `j` from `i` to n-1 such that `zeros[j] >= req`.
   - If not found, return -1.
4. Move row `j` to `i` by swapping with neighbors.
   - Cost: `j - i`.
   - Shift `zeros` array elements from `i` to `j-1` one step right. Place `zeros[j]` at `i`.
   - Add `j - i` to total.

Tính toán số không ở cuối cho mỗi hàng.
Lặp lại `i` từ 0 đến n-1. Số không cần thiết: `req = n - 1 - i`.
Tìm kiếm `j` từ `i` đến n-1 sao cho `zeros[j] >= req`.
Di chuyển hàng `j` thành `i` bằng cách hoán đổi với các hàng xóm.

---
