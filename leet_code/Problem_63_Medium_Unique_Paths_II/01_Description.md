# Result for Unique Paths II
# *Kết quả cho bài toán Đường Đi Duy Nhất II*

## Description
## *Mô tả*

You are given an `m x n` integer array `grid`. There is a robot initially located at the **top-left corner** (i.e., `grid[0][0]`). The robot tries to move to the **bottom-right corner** (i.e., `grid[m - 1][n - 1]`). The robot can only move either **down** or **right** at any point in time.
*Bạn được cho một mảng số nguyên `m x n` gọi là `grid`. Có một rô-bốt ban đầu nằm ở **góc trên cùng bên trái** (tức là `grid[0][0]`). Rô-bốt cố gắng di chuyển đến **góc dưới cùng bên phải** (tức là `grid[m - 1][n - 1]`). Rô-bốt chỉ có thể di chuyển **xuống dưới** hoặc **sang phải** tại bất kỳ thời điểm nào.*

An obstacle and space are marked as `1` and `0` respectively in `grid`. A path that the robot takes cannot include **any** square that is an obstacle.
*Một chướng ngại vật và không gian lần lượt được đánh dấu là `1` và `0` trong `grid`. Một đường đi mà rô-bốt thực hiện không thể bao gồm **bất kỳ** ô nào là chướng ngại vật.*

Return *the number of possible unique paths that the robot can take to reach the bottom-right corner*.
*Hãy trả về *số lượng các đường đi duy nhất có thể có mà rô-bốt có thể thực hiện để đạt được góc dưới cùng bên phải**.*

The test cases are generated so that the answer will be less than or equal to `2 * 10^9`.

## Example 1:
## *Ví dụ 1:*

**Input:** `obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]`
**Output:** `2`
**Explanation:** There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right

## Example 2:
## *Ví dụ 2:*

**Input:** `obstacleGrid = [[0,1],[0,0]]`
**Output:** `1`

## Constraints:
## *Ràng buộc:*

*   `m == obstacleGrid.length`
*   `n == obstacleGrid[i].length`
*   `1 <= m, n <= 100`
*   `obstacleGrid[i][j]` is `0` or `1`.
