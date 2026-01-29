# 1492. The kth Factor of n / Hệ số thứ k của n

## Problem Description / Mô tả bài toán
Int `n`, `k`. Return k-th factor of n. If fewer than k, return -1.
1 and n are factors.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Iteration
Loop `i` from 1 to `n`. Count factors. If `count == k`, return `i`.
Optimization: Loop up to `sqrt(n)`.
Factors come in pairs `(i, n/i)`.
1. Iterate `i` from 1 to `sqrt(n)`. If `i` divides `n`
   - Decrement k. If k=0, return `i`.
   - Store `n/i` for later (as they are large factors).
2. If loop finishes, check stored large factors in reverse order.
Input limits: n <= 1000. Loop 1 to 1000 is O(N) acceptable.
For small n, sqrt opt not critical.

### Complexity / Độ phức tạp
- **Time**: O(N) or O(sqrt(N)).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Linear Scan
Iterate `i` from 1 to `n`.
If `n % i == 0`:
  `k--`.
  If `k == 0`, return `i`.
Return -1.
Lặp `i` từ 1 đến `n`.
Nếu `n % i == 0`, giảm `k`.
Nếu `k == 0`, trả về `i`.

---
