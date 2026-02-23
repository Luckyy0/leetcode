# Result for Unique Paths
# *Kết quả cho bài toán Đường Đi Duy Nhất*

## Description
## *Mô tả*

There is a robot on an `m x n` grid. The robot is initially located at the **top-left corner** (i.e., `grid[0][0]`). The robot tries to move to the **bottom-right corner** (i.e., `grid[m - 1][n - 1]`). The robot can only move either **down** or **right** at any point in time.
*Có một rô-bốt trên một lưới `m x n`. Rô-bốt ban đầu nằm ở **góc trên cùng bên trái** (tức là `grid[0][0]`). Rô-bốt cố gắng di chuyển đến **góc dưới cùng bên phải** (tức là `grid[m - 1][n - 1]`). Rô-bốt chỉ có thể di chuyển **xuống dưới** hoặc **sang phải** tại bất kỳ thời điểm nào.*

Given the two integers `m` and `n`, return *the number of possible unique paths that the robot can take to reach the bottom-right corner*.
*Cho hai số nguyên `m` và `n`, hãy trả về *số lượng các đường đi duy nhất mà rô-bốt có thể thực hiện để đạt được góc dưới cùng bên phải**.*

## Example 1:
## *Ví dụ 1:*

**Input:** `m = 3, n = 7`
**Output:** `28`

## Example 2:
## *Ví dụ 2:*

**Input:** `m = 3, n = 2`
**Output:** `3`
**Explanation:** From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down

## Constraints:
## *Ràng buộc:*

*   `1 <= m, n <= 100`
