# Analysis for Unique Paths II
# *Phân tích cho bài toán Đường Đi Duy Nhất II*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** `m x n` grid with 0 (empty) and 1 (obstacle). *Lưới `m x n` với 0 (trống) và 1 (vật cản).*
*   **Output:** Total unique paths avoiding obstacles. *Tổng số đường đi duy nhất tránh vật cản.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   `m, n` up to 100.
*   The start and end cells can also be obstacles. Handle these edge cases.
*   *`m, n` lên tới 100.*
*   *Ô bắt đầu và ô kết thúc cũng có thể là vật cản. Cần xử lý các trường hợp biên này.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Dynamic Programming
### *Hướng tiếp cận: Quy Hoạch Động*

*   **Intuition:** Similar to Unique Paths I, but if a cell is an obstacle (`grid[i][j] == 1`), the number of ways to reach it is `0`.
*   *Ý tưởng: Tương tự như bài Đường Đi Duy Nhất I, nhưng nếu một ô là vật cản (`grid[i][j] == 1`), số cách để đạt tới nó là `0`.*

*   **Algorithm Steps:**
    1.  Handle start cell: If `grid[0][0] == 1`, return `0`.
    2.  Use a DP array `dp[n]`. Initialize `dp[0] = 1`.
    3.  Iterate `i` from 0 to `m-1`:
        *   Iterate `j` from 0 to `n-1`:
            *   If `grid[i][j] == 1`: `dp[j] = 0`.
            *   Else if `j > 0`: `dp[j] += dp[j-1]`.
    4.  Return `dp[n-1]`.

*   **Complexity:**
    *   Time: $O(m \cdot n)$.
    *   Space: $O(n)$.

### Dry Run
### *Chạy thử*
`grid = [[0,0],[1,0]]`
- Row 0: `dp[0]=1, dp[1]=1`.
- Row 1:
    - `j=0`: `grid[1][0] == 1` -> `dp[0]=0`.
    - `j=1`: `dp[1] = dp[1] + dp[0] = 1 + 0 = 1`.
Result: 1.
---
*Việc kiểm tra vật cản tại mỗi ô là điểm khác biệt cốt lõi.*
Checking for obstacles at each cell is the core difference.
