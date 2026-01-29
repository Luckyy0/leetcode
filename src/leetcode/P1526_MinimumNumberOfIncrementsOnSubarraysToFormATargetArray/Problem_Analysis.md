# 1526. Minimum Number of Increments on Subarrays to Form a Target Array / Số lượng Tăng Tối thiểu trên các Mảng con để Tạo Mảng mục tiêu

## Problem Description / Mô tả bài toán
Array `target`. Start with Array `[0...0]`.
Operation: Choose subarray and increment by 1.
Min operations to get `target`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Height Difference Logic
Imagine building the array layer by layer.
Essentially similar to "Trapping Rain Water" or building blocks.
Cost to build height `h` at `i` depends on `h` at `i-1`.
If `target[i] > target[i-1]`, we need `target[i] - target[i-1]` EXTRA operations started at `i`.
If `target[i] <= target[i-1]`, operations from `i-1` can extend to `i`. No extra cost.
Total ops = `target[0] + sum(max(0, target[i] - target[i-1]))` for `i > 0`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Difference Accumulation
Initialize `ops = target[0]`.
Iterate `i` from 1 to n.
If `target[i] > target[i-1]`, add difference.
Return ops.
Khởi tạo `ops = target[0]`.
Lặp lại `i` từ 1 đến n.
Nếu `target[i] > target[i-1]`, thêm sự khác biệt.

---
