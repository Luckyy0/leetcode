# 63. Unique Paths II / Các Đường Đi Duy Nhất II

## Problem Description / Mô tả bài toán
A robot is located at the top-left corner of a `m x n` grid.
Một robot nằm ở góc trên cùng bên trái của lưới `m x n`.

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner.
Robot chỉ có thể di chuyển xuống hoặc sang phải tại bất kỳ thời điểm nào. Robot đang cố gắng đi đến góc dưới cùng bên phải.

Now consider if some **obstacles** are added to the grids. How many unique paths would there be?
Bây giờ hãy xem xét nếu một số **chướng ngại vật** được thêm vào lưới. Sẽ có bao nhiêu đường đi duy nhất?

An obstacle and space are marked as `1` and `0` respectively in the grid.
Chướng ngại vật và khoảng trống lần lượt được đánh dấu là `1` và `0` trong lưới.

### Example 1:
```text
Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
```

### Example 2:
```text
Input: obstacleGrid = [[0,1],[0,0]]
Output: 1
```

## Constraints / Ràng buộc
- `m == obstacleGrid.length`
- `n == obstacleGrid[i].length`
- `1 <= m, n <= 100`
- `obstacleGrid[i][j]` is `0` or `1`.

---

## Analysis / Phân tích

### Approach: Dynamic Programming / Quy Hoạch Động
- **Idea**: Similar to Unique Paths I, but if a cell contains an obstacle (`1`), the number of paths to it is `0`.
- **Ý tưởng**: Tương tự như Unique Paths I, nhưng nếu một ô chứa chướng ngại vật (`1`), số đường đi đến nó là `0`.
- **Algorithm**:
    - Use 1D array `row` of size `n` for space optimization.
    - If `grid[0][0] == 1`, return 0 immediately.
    - Initialize `row[0] = 1`.
    - Iterate `i` from 0 to `m-1`, `j` from 0 to `n-1`:
        - If `grid[i][j] == 1`:
            - `row[j] = 0`.
        - Else if `j > 0`:
            - `row[j] += row[j-1]`.
        - (If `j == 0`, `row[0]` keeps its value unless it encountered an obstacle above it, which we handled by setting to 0 if grid[i][0] is 1... wait, logic for 1D:
            - If `grid[i][j] == 1`, `row[j] = 0`.
            - If `grid[i][j] == 0`: `row[j] = row[j] (from top) + row[j-1] (from left)`. (For `j=0`, `row[0] = row[0]`).
- **Time Complexity**: O(m * n).
- **Space Complexity**: O(n).

---

## Edge Cases / Các trường hợp biên
1.  **Start with Obstacle**: Return 0.
2.  **End with Obstacle**: Return 0.
3.  **Single Cell**: `[[0]]` -> 1, `[[1]]` -> 0.
