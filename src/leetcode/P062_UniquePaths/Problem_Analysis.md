# 62. Unique Paths / Các Đường Đi Duy Nhất

## Problem Description / Mô tả bài toán
There is a robot on an `m x n` grid. The robot is initially located at the **top-left corner** (i.e., `grid[0][0]`). The robot tries to move to the **bottom-right corner** (i.e., `grid[m - 1][n - 1]`). The robot can only move either down or right at any point in time.
Có một robot trên lưới `m x n`. Robot ban đầu nằm ở **góc trên bên trái** (tức là `grid[0][0]`). Robot cố gắng di chuyển đến **góc dưới bên phải** (tức là `grid[m - 1][n - 1]`). Robot chỉ có thể di chuyển xuống hoặc sang phải tại bất kỳ thời điểm nào.

Given the two integers `m` and `n`, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
Cho hai số nguyên `m` và `n`, trả về số lượng đường đi duy nhất có thể có mà robot có thể thực hiện để đến góc dưới bên phải.

The test cases are generated so that the answer will be less than or equal to `2 * 10^9`.
Các trường hợp kiểm tra được tạo sao cho câu trả lời sẽ nhỏ hơn hoặc bằng `2 * 10^9`.

### Example 1:
```text
Input: m = 3, n = 7
Output: 28
```

### Example 2:
```text
Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
```

## Constraints / Ràng buộc
- `1 <= m, n <= 100`

---

## Analysis / Phân tích

### Approach 1: Dynamic Programming / Quy Hoạch Động
- **Idea**: The number of ways to reach cell `(i, j)` is the sum of ways to reach `(i-1, j)` (from above) and `(i, j-1)` (from left).
- **Ý tưởng**: Số cách để đến ô `(i, j)` là tổng số cách để đến `(i-1, j)` (từ trên xuống) và `(i, j-1)` (từ trái sang).
- **Formula**: `dp[i][j] = dp[i-1][j] + dp[i][j-1]`.
- **Base Case**: `dp[0][j] = 1` and `dp[i][0] = 1` (only one straight path along edges).
- **Space Optimization**: We can use a 1D array `row[n]` where `row[j] += row[j-1]`.
- **Time Complexity**: O(m * n).
- **Space Complexity**: O(n).

### Approach 2: Combinatorics / Tổ Hợp
- **Idea**: To reach `(m-1, n-1)`, we must make `m-1` down moves and `n-1` right moves. Total moves = `m + n - 2`.
- **Formula**: Choose `m-1` down moves from total `m+n-2` positions: `C(m+n-2, m-1)`.
- **Time Complexity**: O(min(m, n)).
- **Space Complexity**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **m = 1 or n = 1**: 1 path.
