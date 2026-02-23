# Analysis for Unique Paths
# *Phân tích cho bài toán Đường Đi Duy Nhất*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Integers `m` (rows), `n` (columns). *Các số nguyên `m` (hàng), `n` (cột).*
*   **Output:** Number of unique paths. *Số lượng đường đi duy nhất.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   `m, n` up to 100.
*   The robot can only move Down or Right.
*   *`m, n` lên tới 100.*
*   *Rô-bốt chỉ có thể di chuyển Xuống hoặc Sang phải.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Dynamic Programming
### *Hướng tiếp cận: Quy Hoạch Động*

*   **Intuition:** The number of ways to reach a cell `(i, j)` is the sum of ways to reach its top neighbor `(i-1, j)` and its left neighbor `(i, j-1)`.
*   *Ý tưởng: Số cách để đạt đến một ô `(i, j)` là tổng số cách để đạt đến ô lân cận bên trên `(i-1, j)` và ô lân cận bên trái `(i, j-1)`.*

*   **Algorithm Steps:**
    1.  Initialize a DP table `dp[m][n]`.
    2.  Set `dp[0][j] = 1` for all `j` (only one way to move right along the top edge).
    3.  Set `dp[i][0] = 1` for all `i` (only one way to move down along the left edge).
    4.  For `i` from 1 to `m-1`:
        *   For `j` from 1 to `n-1`:
            *   `dp[i][j] = dp[i-1][j] + dp[i][j-1]`.
    5.  Return `dp[m-1][n-1]`.

*   **Optimization:** We only need the previous row to calculate the current row. Space can be optimized to $O(n)$.
*   *Tối ưu hóa: Chúng ta chỉ cần hàng trước đó để tính toán hàng hiện tại. Không gian có thể được tối ưu hóa xuống $O(n)$.*

*   **Complexity:**
    *   Time: $O(m \cdot n)$.
    *   Space: $O(n)$.

### Dry Run
### *Chạy thử*
`m = 3, n = 3`
Row 0: `[1, 1, 1]`
Row 1: `[1, 2, 3]` (1+1=2, 2+1=3)
Row 2: `[1, 3, 6]` (1+2=3, 3+3=6)
Result: 6.
---
*Quy hoạch động giúp chia nhỏ bài toán thành các bài toán con chồng lấn.*
Dynamic programming helps break down the problem into overlapping subproblems.
