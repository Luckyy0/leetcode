# Result for Longest Line of Consecutive One in Matrix
# *Kết quả cho bài toán Đường thẳng số 1 liên tiếp dài nhất trong Ma trận*

## Description
## *Mô tả*

Given an `m x n` binary matrix `mat`, return *the length of the longest line of consecutive one in the matrix*.
*Cho một ma trận nhị phân `m x n` `mat`, hãy trả về *độ dài của đường thẳng các số một liên tiếp dài nhất trong ma trận*.*

The line could be horizontal, vertical, diagonal, or anti-diagonal.
*Đường thẳng có thể theo chiều ngang, dọc, chéo chính hoặc chéo phụ.*

## Example 1:
## *Ví dụ 1:*

**Input:** `mat = [[0,1,1,0],[0,1,1,0],[0,0,0,1]]`
**Output:** `3`

## Example 2:
## *Ví dụ 2:*

**Input:** `mat = [[1,1,1,1],[0,1,1,0],[0,0,0,1]]`
**Output:** `4`

## Constraints:
## *Ràng buộc:*

*   `m == mat.length`
*   `n == mat[i].length`
*   `1 <= m, n <= 3 * 10^3`
*   `1 <= m * n <= 10^4`
*   `mat[i][j]` is either `0` or `1`.
