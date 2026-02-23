# Result for Unique Paths III
# *Kết quả cho bài toán Các Đường đi Duy nhất III*

## Description
## *Mô tả*

You are given an `m x n` integer array `grid` where `grid[i][j]` could be:
*Bạn được cho một mảng số nguyên `m x n` `grid` trong đó `grid[i][j]` có thể là:*

*   `1`: The starting square. There is exactly one starting square.
    *   *`1`: Ô bắt đầu. Có chính xác một ô bắt đầu.*
*   `2`: The ending square. There is exactly one ending square.
    *   *`2`: Ô kết thúc. Có chính xác một ô kết thúc.*
*   `0`: Empty squares we can walk over.
    *   *`0`: Các ô trống mà chúng ta có thể đi qua.*
*   `-1`: Obstacles that we cannot walk over.
    *   *`-1`: Các chướng ngại vật mà chúng ta không thể đi qua.*

Return *the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once*.
*Trả về *số lượng đường đi 4 hướng từ ô bắt đầu đến ô kết thúc, đi qua mỗi ô không phải chướng ngại vật chính xác một lần*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
**Output:** 2
**Explanation:** We have the following two paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)

## Example 2:
## *Ví dụ 2:*

**Input:** grid = [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
**Output:** 4
**Explanation:** We have the following four paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)

## Example 3:
## *Ví dụ 3:*

**Input:** grid = [[0,1],[2,0]]
**Output:** 0
**Explanation:** There is no path that walks over every empty square exactly once.
Note that the starting and ending square can be anywhere in the grid.

---

## Constraints:
## *Ràng buộc:*

*   `m == grid.length`
*   `n == grid[i].length`
*   `1 <= m, n <= 20`
*   `1 <= m * n <= 20`
*   `-1 <= grid[i][j] <= 2`
*   There is exactly one starting cell and one ending cell.
