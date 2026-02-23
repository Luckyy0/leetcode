# Result for Sparse Matrix Multiplication
# *Kết quả cho bài toán Nhân Ma trận Thưa*

## Description
## *Mô tả*

Given two [sparse matrices](https://en.wikipedia.org/wiki/Sparse_matrix) `mat1` of size `m x k` and `mat2` of size `k x n`, return the result of `mat1 x mat2`.
*Cho hai [ma trận thưa](https://en.wikipedia.org/wiki/Sparse_matrix) `mat1` kích thước `m x k` và `mat2` kích thước `k x n`, hãy trả về kết quả của `mat1 x mat2`.*

You may assume that multiplication is always possible.
*Bạn có thể giả định rằng phép nhân luôn có thể thực hiện được.*

## Example 1:
## *Ví dụ 1:*

**Input:** `mat1 = [[1,0,0],[-1,0,3]], mat2 = [[7,0,0],[0,0,0],[0,0,1]]`
**Output:** `[[7,0,0],[-7,0,3]]`

## Example 2:
## *Ví dụ 2:*

**Input:** `mat1 = [[0]], mat2 = [[0]]`
**Output:** `[[0]]`

## Constraints:
## *Ràng buộc:*

*   `m == mat1.length`
*   `k == mat1[i].length == mat2.length`
*   `n == mat2[i].length`
*   `1 <= m, n, k <= 100`
*   `-100 <= mat1[i][j], mat2[i][j] <= 100`
