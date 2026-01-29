# 1486. XOR Operation in an Array / Hoạt động XOR trong Mảng

## Problem Description / Mô tả bài toán
Define array `nums` where `nums[i] = start + 2*i` (0-indexed).
Return bitwise XOR of all elements. `n` elements.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Simulation or Math
Simulate loop. Or use math (O(1)).
Math approach uses pattern `4k ^ (4k+1) ^ (4k+2) ^ (4k+3) = 0`.
Can compute range XOR.
Given N small (1000), loop is optimal O(N).

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Linear XOR
Loop `i` from 0 to `n-1`. Calculate `val = start + 2*i`. XOR into result.
Lặp lại `i` từ 0 đến `n-1`. Tính `val = start + 2*i`. XOR vào kết quả.

---
