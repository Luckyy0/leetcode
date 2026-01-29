# 1342. Number of Steps to Reduce a Number to Zero / Số Bước để Giảm một Số về Không

## Problem Description / Mô tả bài toán
Integer `num`.
If even, divide by 2.
If odd, subtract 1.
Count steps to reach 0.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Simulation / Bitwise
If `num` is odd (last bit 1), subtracting 1 makes last bit 0.
Then dividing by 2 (shift right) removes last bit.
So for each bit:
- If 1: 2 steps (subtract then divide) - except for MSB (just subtract then 0, no divide? No, loop until 0. MSB 1 -> 0, loop ends. Just 1 step for MSB if it is 1).
- If 0: 1 step (divide).
Actually simpler: just simulate loop.
Complexity O(log N).

### Complexity / Độ phức tạp
- **Time**: O(log N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Simulation
While `num > 0`:
If `num % 2 == 0`, `num /= 2`.
Else `num -= 1`.
Increment count.
Return count.
Trong khi `num > 0`:
Nếu `num % 2 == 0`, `num /= 2`.
Ngược lại `num -= 1`.
Tăng số đếm.
Trả về số đếm.

---
