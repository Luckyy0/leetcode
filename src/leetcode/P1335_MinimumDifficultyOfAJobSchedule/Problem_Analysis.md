# 1335. Minimum Difficulty of a Job Schedule / Độ khó Tối thiểu của Lịch trình Công việc

## Problem Description / Mô tả bài toán
Array `jobDifficulty`. Split into `d` days.
Must finish all jobs in order.
Need exactly `d` days. At least 1 job per day.
Difficulty of a day = Max difficulty of jobs done that day.
Total difficulty = Sum of daily difficulties.
Minimize total difficulty.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming
`dp[i][k]` = min difficulty to schedule jobs `i` through `n-1` in `k` days.
Transition:
Try splitting first day at `j` (from `i` to `n-k`).
`cost = max(jobs[i...j])`.
`dp[i][k] = min(cost + dp[j+1][k-1])`.
Base cases:
`dp[i][1]`: Max of `jobs[i...n-1]`.
If `n < d`, return -1.

### Complexity / Độ phức tạp
- **Time**: O(D * N^2). N=300, D=10. Fast enough.
- **Space**: O(N * D) or O(N).

---

## Analysis / Phân tích

### Approach: DP with Partitioning
Use dynamic programming where `dp[k][i]` is the minimum difficulty to schedule the first `i` jobs using `k` days.
`dp[k][i] = min(dp[k-1][j] + max(jobDifficulty[j+1...i]))` for all valid `j < i`.
Or use `dp[i][k]` = min difficulty for jobs `i..n-1` with `k` days remaining.
Let's use the suffix recursion with memoization or iterative table.
`memo[i][d]`: min difficulty for `jobDifficulty[i:]` with `d` days left.
Loop `j` from `i` to `n - d`. `current_day_max = max(current_day_max, jobDifficulty[j])`.
`res = min(res, current_day_max + solve(j + 1, d - 1))`.
Sử dụng quy hoạch động trong đó `dp[k][i]` là độ khó tối thiểu để lên lịch cho `i` công việc đầu tiên bằng cách sử dụng `k` ngày.
`dp[k][i] = min(dp[k-1][j] + max(jobDifficulty[j+1...i]))` cho tất cả các `j < i` hợp lệ.
Hoặc sử dụng `dp[i][k]` = độ khó tối thiểu cho các công việc `i..n-1` với `k` ngày còn lại.
Hãy sử dụng đệ quy hậu tố với ghi nhớ hoặc bảng lặp.
`memo[i][d]`: độ khó tối thiểu cho `jobDifficulty[i:]` với `d` ngày còn lại.
Lặp lại `j` từ `i` đến `n - d`. `current_day_max = max(current_day_max, jobDifficulty[j])`.
`res = min(res, current_day_max + solve(j + 1, d - 1))`.

---
