# 1260. Shift 2D Grid / Dịch chuyển Lưới 2D

## Problem Description / Mô tả bài toán
2D grid `m x n` and integer `k`. Shift grid `k` times.
Element at `(i, j)` moves to `(i, j+1)`.
Element at `(i, n-1)` moves to `(i+1, 0)`.
Element at `(m-1, n-1)` moves to `(0, 0)`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### 1D Flattening and Modulo
Flatten grid to 1D array of size `m * n`.
Shift `k` is simply shifting 1D array by `k`.
New position `new_idx = (old_idx + k) % (m * n)`.
Map back `new_idx` to 2D `(r, c)`.
`r = new_idx / n`, `c = new_idx % n`.

### Complexity / Độ phức tạp
- **Time**: O(M * N).
- **Space**: O(M * N) for result.

---
