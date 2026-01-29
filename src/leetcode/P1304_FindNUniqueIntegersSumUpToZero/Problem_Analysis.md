# 1304. Find N Unique Integers Sum up to Zero / Tìm N Số nguyên Duy nhất có Tổng bằng Không

## Problem Description / Mô tả bài toán
Return array of `n` unique integers sum to 0.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Symmetry
If `n` is odd: include 0.
Then pairs `x` and `-x`. `1, -1, 2, -2...`.
Iterate `i` from 1 to `n/2`. Add `i` and `-i`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Symmetric Pairs
Generate pairs of positive numbers and their negations: `1, -1, 2, -2, ...` up to `n/2` pairs. If `n` is odd, add `0`. This ensures uniqueness and a sum of zero.
Tạo các cặp số dương và phủ định của chúng: `1, -1, 2, -2, ...` tối đa `n/2` cặp. Nếu `n` là số lẻ, hãy cộng thêm `0`. Điều này đảm bảo tính duy nhất và tổng bằng không.

---
