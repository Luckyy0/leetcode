# 568. Maximum Vacation Days / Số Ngày Nghỉ Lễ Tối Đa

## Problem Description / Mô tả bài toán
LeetCode wants to give one of its best employees the option to travel among `n` cities to collect algorithm problems. But all work and no play makes Jack a dull boy, you could take vacations in some particular cities and weeks. Your job is to schedule the traveling to maximize the number of vacation days you could take, but there are certain rules and restrictions:
LeetCode muốn cung cấp cho một trong những nhân viên xuất sắc nhất của mình tùy chọn đi du lịch giữa `n` thành phố để thu thập các bài toán thuật toán. Nhưng làm việc mà không chơi sẽ khiến Jack trở nên buồn chán, bạn có thể nghỉ lễ ở một số thành phố và tuần cụ thể. Công việc của bạn là lên lịch đi lại để tối đa hóa số ngày nghỉ lễ bạn có thể nhận được, nhưng có một số quy tắc và hạn chế nhất định:

1. You can only travel among `n` cities, represented by indexes from `0` to `n-1`. Initially, you are in the city indexed `0` on Monday.
2. The cities are connected by flights. The flights are represented as a `n x n` matrix (not necessarily symmetrical) where `flights[i][j] = 1` if there is a flight from city `i` to city `j`, and `0` otherwise. You can take flights on Mondays.
3. You are given an `n x k` matrix `days` representing this year's vacation plan. `days[i][j]` is the number of vacation days you could take in city `i` in the week `j`.
4. Check valid moves: You can stay in city `i` or fly to city `j` if `flights[i][j] == 1`.

Return the maximum vacation days.

### Example 1:
```text
Input: flights = [[0,1,1],[1,0,1],[1,1,0]], days = [[1,3,1],[6,0,3],[3,3,3]]
Output: 12
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / Quy hoạch động
State: `dp[i][j]` = max vacation days we can get ending at week `j` in city `i`.
Wait, better: `dp[w][c]` = max vacation days after week `w` ending up in city `c`.

Values:
- `w` from 0 to `k-1`.
- `c` from 0 to `n-1`.

Transitions:
`dp[w][c] = days[c][w] + max(dp[w-1][prev_c])` for all `prev_c` such that we can fly from `prev_c` to `c` (or `prev_c == c`).
Base Case: `dp[-1][0] = 0`, all other `dp[-1][...] = -infinity` (since we start at city 0).

Since `dp[w]` only depends on `dp[w-1]`, we can optimize space to O(N).

### Complexity / Độ phức tạp
- **Time**: O(K * N^2). K weeks, N cities, N transitions.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Weekly State DP

**Algorithm**:
1.  Initialize DP array for current week.
2.  Set start condition (City 0 reachable).
3.  Iterate through weeks.
4.  For each week, compute max days for each city based on previous week's reachable cities/flights.
5.  Return max value in the last week.

---
