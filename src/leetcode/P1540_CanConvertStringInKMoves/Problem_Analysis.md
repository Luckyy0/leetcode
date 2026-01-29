# 1540. Can Convert String in K Moves / Có thể Chuyển đổi Chuỗi trong K lần Di chuyển

## Problem Description / Mô tả bài toán
Strings `s`, `t`. Length must match.
At i-th move ($1 \le i \le k$), choose index in s, shift char by `i`.
Can choose each move `i` at most once for some index. Can skip moves.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Frequency of Shifts
For each index `j`, calculate shift needed `diff = (t[j] - s[j] + 26) % 26`.
If `diff == 0`, no move.
If `diff > 0`, we need a move `x` such that `x % 26 == diff`.
Values `diff, diff+26, diff+26*2 ...` are suitable.
We need to satisfy all requirements using available moves up to `k`.
Count frequencies of each required `diff` (1 to 25).
Max value needed for `diff` with count `c`: `diff + 26 * (c - 1)`.
Check if `max_needed <= k`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Count Shifts
Check lengths.
Count `shift` frequencies in array `count[26]`.
For `i` 1 to 25:
If `count[i] > 0`: max move is `i + 26 * (count[i] - 1)`.
If `max > k`, return false.

---
