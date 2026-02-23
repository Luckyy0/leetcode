# Analysis for Minimum Path Sum
# *Phân tích cho bài toán Tổng Đường Đi Nhỏ Nhất*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** `m x n` grid of non-negative integers. *Lưới `m x n` gồm các số nguyên không âm.*
*   **Output:** Minimum path sum. *Tổng đường đi nhỏ nhất.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   `m, n` up to 200.
*   Only Move Down or Right.
*   *`m, n` lên tới 200.*
*   *Chỉ có thể di chuyển Xuống hoặc Sang phải.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Dynamic Programming
### *Hướng tiếp cận: Quy Hoạch Động*

*   **Intuition:** The minimum sum to reach cell `(i, j)` is the value of `grid[i][j]` plus the minimum of the sums to reach its top neighbor `(i-1, j)` or its left neighbor `(i, j-1)`.
*   *Ý tưởng: Tổng nhỏ nhất để đạt tới ô `(i, j)` là giá trị của ô `grid[i][j]` cộng với giá trị nhỏ nhất trong các tổng để đạt tới ô bên trên nó `(i-1, j)` hoặc ô bên trái nó `(i, j-1)`.*

*   **Algorithm Steps:**
    1.  Initialize a DP table (or modify `grid` in-place).
    2.  `dp[0][0] = grid[0][0]`.
    3.  Init first row: `dp[0][j] = dp[0][j-1] + grid[0][j]`.
    4.  Init first column: `dp[i][0] = dp[i-1][0] + grid[i][0]`.
    5.  For `i` from 1 to `m-1`:
        *   For `j` from 1 to `n-1`:
            *   `dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j-1])`.
    6.  Return `dp[m-1][n-1]`.

*   **Complexity:**
    *   Time: $O(m \cdot n)$.
    *   Space: $O(1)$ if in-place, else $O(n)$ if optimized.

### Dry Run
### *Chạy thử*
`[[1,3,1],[1,5,1],[4,2,1]]`
- Row 0 (Prefix sums): `[1, 4, 5]`
- Row 1:
    - `j=0`: `1 + 1 = 2`.
    - `j=1`: `5 + min(2, 4) = 7`.
    - `j=2`: `1 + min(7, 5) = 6`.
- Row 2:
    - `j=0`: `4 + 2 = 6`.
    - `j=1`: `2 + min(6, 7) = 8`.
    - `j=2`: `1 + min(8, 6) = 7`.
Result: 7.
---
*Bài toán này là một ví dụ kinh điển về Quy hoạch động trên ma trận.*
This problem is a classic example of Dynamic Programming on a matrix.
