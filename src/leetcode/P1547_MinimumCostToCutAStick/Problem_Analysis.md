# 1547. Minimum Cost to Cut a Stick / Chi phí Tối thiểu để Cắt một Thanh gỗ

## Problem Description / Mô tả bài toán
Stick of length `n`. Array `cuts` of positions to make cuts.
Cost to make a cut is the length of the current stick part.
Find minimum total cost.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Interval Dynamic Programming
Similar to Matrix Chain Multiplication.
Sort `cuts` and add endpoints `0` and `n`. Let the new array be `A`.
`dp[i][j]` = minimum cost to make all cuts between `A[i]` and `A[j]`.
Transition:
`dp[i][j] = (A[j] - A[i]) + min(dp[i][k] + dp[k][j])` for all `k` such that `i < k < j`.
Base case: `dp[i][i+1] = 0` (no cuts between adjacent cut points).

### Complexity / Độ phức tạp
- **Time**: O(M^3), where M is the number of cuts.
- **Space**: O(M^2).

---

## Analysis / Phân tích

### Approach: Bottom-up DP
1. Sort `cuts` and pad with `0` and `n`.
2. Use a 2D DP table.
3. Iterate over the length of the segment, then the starting point, then the cut point.
Sắp xếp các điểm cắt và bỏ thêm 0 và n.
Sử dụng bảng DP 2D.
Lặp qua độ dài của đoạn, sau đó là điểm bắt đầu, sau đó là điểm cắt.

---
