# 1420. Build Array Where You Can Find The Maximum Exactly K Comparisons / Xây dựng Mảng Nơi Bạn Có Thể Tìm Thấy Giá trị Lớn nhất Chính xác K Lần So sánh

## Problem Description / Mô tả bài toán
Build array length `n`. Values 1 to `m`.
Search cost = number of times max increases.
Cost exactly `k`.
Count arrays modulo 10^9 + 7.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming
`dp[i][currentMax][cost]`
`i`: index (1 to n).
`currentMax`: max value so far (1 to m).
`cost`: cost so far (1 to k).
Transition:
For position `i+1`, pick value `v` (1 to m).
- If `v > currentMax`: new max `v`, cost `cost + 1`.
- If `v <= currentMax`: max `currentMax`, cost `cost`.
Base case: `dp[0][0][0] = 1`.
Or `dp[1][v][1] = 1` for `v` in 1..m.

### Complexity / Độ phức tạp
- **Time**: O(N * M^2 * K) or O(N * M * K) with optimization.
- **Space**: O(N * M * K).

---

## Analysis / Phân tích

### Approach: 3D DP
`dp[i][maxVal][cost]`
To fill `dp[i][maxVal][cost]`:
1. We picked `v == maxVal` at step `i`. Before this, max was `prevMax < maxVal`. Cost increased.
   - Sum over `prevMax` in `0..maxVal-1` of `dp[i-1][prevMax][cost-1]`.
2. We picked `v <= maxVal` at step `i`. Before this, max was `maxVal`. Cost unchanged.
   - `dp[i-1][maxVal][cost] * maxVal` (since choice can be 1..maxVal).
Wait. "New element x".
If `x > cur_max`: cost++, cur_max = x.
If `x <= cur_max`: cost unchanged, cur_max unchanged.
State `dp[i][cur_max][c]`.
At step `i`, value `v`:
If `v > cur_max`: `dp[i][v][c+1] += dp[i-1][cur_max][c]`.
If `v <= cur_max`: `dp[i][cur_max][c] += dp[i-1][cur_max][c]`.
Optimization:
Loop `i` (1 to n), `c` (1 to k), `maxVal` (1 to m).
Part 1: `dp[i][maxVal][c] += dp[i-1][maxVal][c] * maxVal`.
Part 2: `dp[i][maxVal][c] += sum(dp[i-1][p][c-1])` for `p < maxVal`.
Prefix sum for sum of `dp[i-1][p][c-1]` can reduce complexity to O(N*M*K).

### Optimization
`prev_sum[c-1][p]` stores sum `dp[i-1][0...p][c-1]`.

`dp[i][maxVal][c]`
Phần 1: `dp[i][maxVal][c] += dp[i-1][maxVal][c] * maxVal`.
Phần 2: `dp[i][maxVal][c] += sum(dp[i-1][p][c-1])`.
Tổng tiền tố có thể giảm độ phức tạp xuống O(N*M*K).

---
