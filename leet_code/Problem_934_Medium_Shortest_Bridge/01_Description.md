# Result for Shortest Bridge
# *Kết quả cho bài toán Cây Cầu Ngắn nhất*

## Description
## *Mô tả*

You are given an `n x n` binary matrix `grid` where `1` represents land and `0` represents water.
*Bạn được cho một ma trận nhị phân `n x n` `grid` trong đó `1` đại diện cho đất liền và `0` đại diện cho nước.*

An **island** is a 4-directionally connected group of `1`'s not connected to any other `1`'s. There are **exactly two islands** in `grid`.
*Một **đảo** là một nhóm các số `1` được kết nối theo 4 hướng không kết nối với bất kỳ số `1` nào khác. Có **chính xác hai hòn đảo** trong `grid`.*

You may change `0`'s to `1`'s to connect the two islands to form **one island**.
*Bạn có thể thay đổi `0` thành `1` để kết nối hai hòn đảo tạo thành **một hòn đảo**.*

Return *the smallest number of `0`'s you must flip to connect the two islands*.
*Hãy trả về *số lượng nhỏ nhất các số `0` bạn phải lật để kết nối hai hòn đảo*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** grid = [[0,1],[1,0]]
**Output:** 1

## Example 2:
## *Ví dụ 2:*

**Input:** grid = [[0,1,0],[0,0,0],[0,0,1]]
**Output:** 2

## Example 3:
## *Ví dụ 3:*

**Input:** grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
**Output:** 1

---

## Constraints:
## *Ràng buộc:*

*   `n == grid.length == grid[i].length`
*   `2 <= n <= 100`
*   `grid[i][j]` is either `0` or `1`.
*   There are exactly two islands in `grid`.
