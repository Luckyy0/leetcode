# 64. Minimum Path Sum / Tổng Đường Đi Nhỏ Nhất

## Problem Description / Mô tả bài toán
Given a `m x n` grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
Cho một lưới `m x n` chứa các số không âm, hãy tìm một đường đi từ góc trên bên trái đến góc dưới bên phải, sao cho tổng của tất cả các số dọc theo đường đi đó là nhỏ nhất.

**Note**: You can only move either down or right at any point in time.
**Lưu ý**: Bạn chỉ có thể di chuyển xuống hoặc sang phải tại bất kỳ thời điểm nào.

### Example 1:
```text
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 -> 3 -> 1 -> 1 -> 1 minimizes the sum.
```

### Example 2:
```text
Input: grid = [[1,2,3],[4,5,6]]
Output: 12
```

## Constraints / Ràng buộc
- `m == grid.length`
- `n == grid[i].length`
- `1 <= m, n <= 200`
- `0 <= grid[i][j] <= 100`

---

## Analysis / Phân tích

### Approach: Dynamic Programming / Quy Hoạch Động
- **Idea**: The min path to `(i, j)` is `grid[i][j]` plus the minimum of the path to `(i-1, j)` or `(i, j-1)`.
- **Ý tưởng**: Đường đi nhỏ nhất đến `(i, j)` là `grid[i][j]` cộng với giá trị nhỏ nhất của đường đi đến `(i-1, j)` hoặc `(i, j-1)`.
- **Formula**: `dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j-1])`.
- **Space Optimization**: Use 1D array `dp[n]`.
    - `dp[j] = grid[i][j] + min(dp[j], dp[j-1])`.
    - `dp[j]` represents value from top `(i-1, j)`.
    - `dp[j-1]` represents value from left `(i, j-1)`.
    - Need to handle edge cases `i=0` and `j=0`.
- **Time Complexity**: O(m * n).
- **Space Complexity**: O(n).

---

## Edge Cases / Các trường hợp biên
1.  **Single Cell**: Returns value of that cell.
2.  **Single Row/Column**: Only one path, sum of all.
