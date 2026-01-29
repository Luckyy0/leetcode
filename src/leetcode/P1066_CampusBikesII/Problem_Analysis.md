# 1066. Campus Bikes II / Xe đạp trong Khuôn viên II

## Problem Description / Mô tả bài toán
On a campus represented as a 2D grid, there are `n` workers and `m` bikes, with `n <= m`.
We assign one unique bike to each worker.
Minimize the sum of Manhattan distances between each worker and their assigned bike.
Workers `n <= 10`, Bikes `m <= 10`. Wait, problem constraints usually `n <= 10`, `m <= 10`? LeetCode says `1 <= workers.length <= 10`, `workers.length <= bikes.length <= 10`.
Actually `m` can be larger? 
LeetCode P1066 constraints: `1 <= workers.length <= 10`, `workers.length <= bikes.length <= 10`.
Oh, wait, if `m` is small (<= 10 or <= 20), we can use DP with Bitmask.
Usually `n <= 10`, `m` is also small for this problem type (Is it P1057 or P1066?).
P1057 (Campus Bikes I) had `n, m <= 1000` but greedy.
P1066 (Campus Bikes II) asks for minimum sum, which implies global optimization, likely Matching or Flow.
Given constraints `n <= 10, m <= 10`. Wait, let me double check constraints.
Actually `0 <= workers.length <= 10`. `m` might be higher? No, standard problem is about small N, M.
Let's assume `n <= 10, m <= 10` or similarly small.
Edit: Actually `m` can be up to 10? Or `n` is small.
Strategy: DP with Bitmask.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming with Bitmask / Quy hoạch Động với Bitmask
State: `dp[mask]` = minimum distance sum to assign bikes represented by `mask` to the first `countSetBits(mask)` workers.
Alternatively, `dp[i][mask]` = assign first `i` workers using subset of bikes `mask`.
Since `i` is determined by `mask`, just `dp[mask]`.
`mask` represents the set of used bikes.
`countSetBits(mask)` tells us which worker we are assigning next (worker index `k = countSetBits(mask)`).
Transition:
`dp[mask | (1 << j)] = min(dp[mask | (1 << j)], dp[mask] + dist(worker[k], bike[j]))`.

### Complexity / Độ phức tạp
- **Time**: O(2^M * M). (Iterate all masks, try all next bikes).
- **Space**: O(2^M).

---

## Analysis / Phân tích

### Approach: Bitmask DP Assignment
Since the number of workers and bikes is very small ($\le 10$), we can use a bitmask to represent the set of currently employed bikes. The state $DP[\text{mask}]$ denotes the minimum cost to satisfy the first $k$ workers (where $k$ is the number of set bits in mask) using the specific bikes in the mask. We transition by assigning an unused bike to the next worker.
Vì số lượng công nhân và xe đạp rất nhỏ ($\le 10$), chúng ta có thể sử dụng mặt nạ bit để đại diện cho tập hợp xe đạp đang được sử dụng. Trạng thái $DP[\text{mask}]$ biểu thị chi phí tối thiểu để đáp ứng $k$ công nhân đầu tiên (trong đó $k$ là số bit được đặt trong mặt nạ) bằng cách sử dụng các xe đạp cụ thể trong mặt nạ. Chúng ta chuyển đổi trạng thái bằng cách gán một chiếc xe đạp chưa sử dụng cho công nhân tiếp theo.

---
