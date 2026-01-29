# 1217. Minimum Cost to Move Chips to The Same Position / Chi phí Tối thiểu để Di chuyển Các Chip đến Cùng Một Vị trí

## Problem Description / Mô tả bài toán
We have `n` chips, where the position of the `i-th` chip is `position[i]`.
We need to move all the chips to the same position.
Cost:
- position `i` to `i + 2` or `i - 2`: cost 0.
- position `i` to `i + 1` or `i - 1`: cost 1.
Return min cost.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Parity Analysis / Phân tích Tính chẵn lẻ
Moving by 2 is free.
So all chips at even positions can move to any even position for free.
All chips at odd positions can move to any odd position for free.
We essentially have two piles: `Even pile` and `Odd pile`.
To merge them, we must move one pile to the other (cost 1 per chip).
Cost = `min(count(odd), count(even))`.

---
