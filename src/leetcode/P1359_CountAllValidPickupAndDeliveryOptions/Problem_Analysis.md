# 1359. Count All Valid Pickup and Delivery Options / Đếm Tất cả Các Tùy chọn Nhận và Giao hàng Hợp lệ

## Problem Description / Mô tả bài toán
`n` orders. Each has Pickup `Pi` and Delivery `Di`.
`Pi` must be before `Di`.
Count permutations of `P1, D1, ..., Pn, Dn`.
Modulo `10^9 + 7`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Combinatorics
Consider adding pairs one by one.
For 1 pair: (P1, D1) -> 1 way.
For 2 pairs:
We have slots around current pair `_ P1 _ D1 _`. 3 slots.
We place P2 and D2.
P2 can go in any of 3 slots.
If P2 in slot 1 (before P1), D2 can be in slot 1 (after P2), 2, 3.
Generally, for `n` items (2n slots total for final), adding step `i`:
We have `2(i-1)` existing items. `2i - 1` gaps (plus ends = `2i - 1` positions available? No, `2(i-1) + 1` positions).
Wait. existing sequence length `L = 2(i-1)`. Positions: `L+1`.
We place `Pi` and `Di`.
Sum of possibilities to place 2 items in `K` available spots.
Equivalent to placing 2 items in `K` spots with replacement allowed if ordering matters?
Order: Pi must be before Di.
If we pick 2 distinct spots, Pi is left, Di is right (1 way). `C(K, 2)`.
If we pick 1 spot, Pi then Di (1 way in that spot). `K`.
Total ways = `K + K(K-1)/2 = K(K+1)/2`.
Where `K = 2(i-1) + 1`.
So `ways[i] = ways[i-1] * (2i-1) * i`.
(Since `K(K+1)/2` with `K=2i-1` simplifies to `(2i-1)(2i)/2 = (2i-1)i`).
Multiply for `i=1` to `n`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Iterative Multiplication
Start with `res = 1`. Iteratively multiply by `i` and `(2 * i - 1)` for `i` from 1 to `n`. Use modulo at each step.
Bắt đầu với `res = 1`. Lặp lại nhân `i` và `(2 * i - 1)` cho `i` từ 1 đến `n`. Sử dụng modulo ở mỗi bước.

---
