# 1318. Minimum Flips to Make a OR b Equal to c / Số lần Lật tối thiểu để a HOẶC b Bằng c

## Problem Description / Mô tả bài toán
Integers `a, b, c`.
Flip bits of `a` and `b` to make `a | b == c`.
Min flips.
Values up to $10^9$.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Bit Manipulation
Process bit by bit (0 to 29).
Let `bitA`, `bitB`, `bitC` be values at position `i`.
Desired: `bitA | bitB == bitC`.
Current: `bitA | bitB`.
- If `bitC == 0`:
  - `bitA` must be 0, `bitB` must be 0.
  - Flips needed = `bitA + bitB`.
- If `bitC == 1`:
  - We need at least one of `bitA`, `bitB` to be 1.
  - If `bitA == 0` and `bitB == 0`, need 1 flip (change either).
  - Else (one is already 1), 0 flips.

### Complexity / Độ phức tạp
- **Time**: O(30).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Bitwise Comparison
Iterate through the bits of `a`, `b`, and `c` (typically up to 30 or 31 bits). At each bit position:
- If the bit in `c` is 0, both `a` and `b` must have 0 at this position. If `a` has 1, add 1 flip. If `b` has 1, add 1 flip.
- If the bit in `c` is 1, at least one of `a` or `b` must have 1. If both are 0, add 1 flip. If either is 1, 0 flips are needed.
Lặp lại qua các bit của `a`, `b` và `c` (thường lên đến 30 hoặc 31 bit). Tại mỗi vị trí bit:
- Nếu bit trong `c` là 0, cả `a` và `b` đều phải có 0 tại vị trí này. Nếu `a` có 1, thêm 1 lần lật. Nếu `b` có 1, thêm 1 lần lật.
- Nếu bit trong `c` là 1, ít nhất một trong `a` hoặc `b` phải có 1. Nếu cả hai đều là 0, thêm 1 lần lật. Nếu có 1, cần 0 lần lật.

---
