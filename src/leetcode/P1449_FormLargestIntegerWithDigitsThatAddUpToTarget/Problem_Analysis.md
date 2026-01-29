# 1449. Form Largest Integer With Digits That Add up to Target / Tạo Số Nguyên Lớn nhất Với Các Chữ số Cộng lại thành Target

## Problem Description / Mô tả bài toán
Array `cost` (9 elements for digits 1-9). Target `target`.
Maximize integer whose digit costs sum to `target`.
Largest integer: More digits > Less digits. Tie: Higher digits first.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming (Unbounded Knapsack)
We want to maximize number of digits first. Then value.
`dp[t]`: Max digits possible with cost `t`. Initialize with -Infinity. `dp[0] = 0`.
Iterate `t` from 1 to `target`. Iterate digits 1 to 9.
Transition: `dp[t] = max(dp[t], dp[t - cost[d-1]] + 1)`.
After filling `dp`, reconstruct solution to get largest number.
Reconstruct greedily from `9` down to `1`.
If `dp[target] == dp[target - cost[d-1]] + 1`, then digit `d` is optimal to pick first (since we check 9 first).
Append `d`, reduce target.

### Complexity / Độ phức tạp
- **Time**: O(Target * 9).
- **Space**: O(Target).

---

## Analysis / Phân tích

### Approach: DP for Max Digits
Use DP to find max number of digits for any cost.
`dp[i]` = max digits for cost `i`.
Initialize `dp` with very small number, `dp[0]=0`.
Loop `t` 1..target. Loop `val` 1..9. `c = cost[val-1]`.
If `t >= c` and `dp[t-c]` valid: `dp[t] = max(dp[t], dp[t-c] + 1)`.
If `dp[target] < 0`, impossible ("0").
Reconstruct:
Start `curr = target`. Loop while `curr > 0`.
Iterate `d` from 9 down to 1.
If `curr >= cost[d-1]` and `dp[curr] == dp[curr - cost[d-1]] + 1`:
Append `d`. `curr -= cost[d-1]`. Break inner loop (pick largest digit).
Sử dụng DP để tìm số chữ số tối đa cho bất kỳ chi phí nào.
`dp[i]` = số chữ số tối đa cho chi phí `i`.
Khởi tạo `dp` với số rất nhỏ, `dp[0]=0`.
Tái tạo:
Bắt đầu `curr = target`. Vòng lặp trong khi `curr > 0`.
Lặp lại `d` từ 9 xuống 1.
Nếu `curr >= cost[d-1]` và `dp[curr] == dp[curr - cost[d-1]] + 1`:
Nối `d`. `curr -= cost[d-1]`.

---
