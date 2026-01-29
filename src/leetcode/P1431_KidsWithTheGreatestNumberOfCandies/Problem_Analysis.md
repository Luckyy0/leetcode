# 1431. Kids With the Greatest Number of Candies / Những Đứa trẻ Với Số Kẹo Nhiều Nhất

## Problem Description / Mô tả bài toán
Array `candies`, integer `extraCandies`.
For each kid, if giving them extra candies makes them have greatest number of candies (>= all others), true.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Simulation
Find max of `candies` -> `maxCandy`.
For each kid `i`:
Check if `candies[i] + extraCandies >= maxCandy`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N) or O(1).

---

## Analysis / Phân tích

### Approach: Linear Scan
First pass find max. Second pass check condition.
Lượt đầu tìm tối đa. Lượt thứ hai kiểm tra điều kiện.

---
