# Result for Search a 2D Matrix II
# *Kết quả cho bài toán Tìm kiếm trong Ma trận 2D II*

## Description
## *Mô tả*

Write an efficient algorithm that searches for a value `target` in an `m x n` integer matrix `matrix`. This matrix has the following properties:
*Viết một thuật toán hiệu quả để tìm kiếm giá trị `target` trong ma trận số nguyên `m x n` `matrix`. Ma trận này có các tính chất sau:*

*   Integers in each row are sorted in ascending from left to right.
*   Integers in each column are sorted in ascending from top to bottom.
*   *Các số nguyên trong mỗi hàng được sắp xếp tăng dần từ trái sang phải.*
*   *Các số nguyên trong mỗi cột được sắp xếp tăng dần từ trên xuống dưới.*

## Example 1:
## *Ví dụ 1:*

**Input:** 
```
matrix = [
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
target = 5
```
**Output:** `true`

## Example 2:
## *Ví dụ 2:*

**Input:** 
```
matrix = [
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
target = 20
```
**Output:** `false`

## Constraints:
## *Ràng buộc:*

*   `m == matrix.length`
*   `n == matrix[i].length`
*   `1 <= n, m <= 300`
*   `-10^9 <= matrix[i][j] <= 10^9`
*   All the integers in each row are **sorted** in ascending order.
*   All the integers in each column are **sorted** in ascending order.
*   `-10^9 <= target <= 10^9`
