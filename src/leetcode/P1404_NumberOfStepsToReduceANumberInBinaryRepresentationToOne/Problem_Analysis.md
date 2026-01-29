# 1404. Number of Steps to Reduce a Number in Binary Representation to One / Số Bước để Giảm một Số ở Dạng Nhị phân về Một

## Problem Description / Mô tả bài toán
Binary string `s`.
If even (`s[last] == 0`), divide by 2 (remove last).
If odd, add 1.
Steps to reach 1.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Simulation with Carry
Iterate from right to left.
Track `carry`.
If `bit + carry == 0`: even, just divide (1 step). Carry remains 0.
If `bit + carry == 1`: odd, add 1 (become even -> divide). 2 steps. Carry becomes 1.
If `bit + carry == 2`: even (0 with carry 1). Divide (1 step). Carry remains 1.
Exception: Last bit (MSB). If carry is 1, it becomes 10 (divide -> 1).
Wait. If we stop at index 0 (MSB).
If `s[0] + carry == 1`? We reached 1. Steps don't count for last bit if value is 1. But `bit + carry = 1` implies we are at 1.
Actually simpler:
Loop `i` from `n-1` to `1` (not 0).
If `bit + carry == 1`: Need 2 steps (add 1, div 2) and carry sets to 1.
If `bit + carry == 0`: 1 step (div 2).
If `bit + carry == 2`: 1 step (div 2) and carry 1.
After loop: if `carry == 1`, add 1 step (because `s[0]` is 1, plus carry = 2 -> 10 -> 1).

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Reverse Iteration with Carry
Iterate from end of string to index 1.
Maintain `carry`.
Calculations for current `digit = s.charAt(i) - '0' + carry`:
- If `digit == 0` (even, no carry): 1 step (divide by 2). Carry = 0.
- If `digit == 1` (odd): 2 steps (add 1 -> even, divide by 2). Carry = 1.
- If `digit == 2` (was 1, plus carry-> 0 and carry): 1 step (divide). Carry = 1.
Final step check at index 0: If carry is 1, we have `1+1=10` -> `1`, so 1 more step.
Simpler logic:
If `digit % 2 == 1` (odd): `steps += 2`, `carry = 1`.
If `digit % 2 == 0` (even or 2): `steps += 1`.
Lặp lại từ cuối chuỗi đến chỉ số 1.
Duy trì `carry`.
Tính toán cho `digit = s.charAt(i) - '0' + carry`:
- Nếu `digit == 1` (lẻ): `steps += 2`, `carry = 1`.
- Nếu `digit == 0` hoặc `2`: `steps += 1`. (Nếu 2, carry vẫn là 1).
Kiểm tra bước cuối cùng tại chỉ số 0: Nếu carry là 1, thêm 1 bước.

---
