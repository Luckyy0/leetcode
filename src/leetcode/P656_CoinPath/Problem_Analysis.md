# 656. Coin Path / Đường Đi Xu

## Problem Description / Mô tả bài toán
Given an array `A` of integers and integer `B`, find the lexicographically smallest path from index 0 to n-1 with cost at most B.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / Quy Hoạch Động
DP to find min cost, then backtrack for lexicographically smallest path.

### Complexity / Độ phức tạp
- **Time**: O(N * maxJump).
- **Space**: O(N).

---
