# Result for 01 Matrix
# *Kết quả cho bài toán Ma trận 01*

## Description
## *Mô tả*

Given an `m x n` binary matrix `mat`, return *the distance of the nearest* `0` *for each cell*.
*Cho một ma trận nhị phân `m x n` `mat`, hãy trả về *khoảng cách tới số* `0` *gần nhất cho mỗi ô*.*

The distance between two adjacent cells is `1`.
*Khoảng cách giữa hai ô liền kề là `1`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `mat = [[0,0,0],[0,1,0],[0,0,0]]`
**Output:** `[[0,0,0],[0,1,0],[0,0,0]]`

## Example 2:
## *Ví dụ 2:*

**Input:** `mat = [[0,0,0],[0,1,0],[1,1,1]]`
**Output:** `[[0,0,0],[0,1,0],[1,2,1]]`

## Constraints:
## *Ràng buộc:*

*   `m == mat.length`
*   `n == mat[i].length`
*   `1 <= m, n <= 10^4`
*   `1 <= m * n <= 10^4`
*   `mat[i][j]` is either `0` or `1`.
*   There is at least one `0` in `mat`.
