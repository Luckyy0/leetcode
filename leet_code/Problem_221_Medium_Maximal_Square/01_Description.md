# Result for Maximal Square
# *Kết quả cho bài toán Hình vuông lớn nhất*

## Description
## *Mô tả*

Given an `m x n` binary matrix filled with `0`'s and `1`'s, find the largest square containing only `1`'s and return its area.
*Cho một ma trận nhị phân `m x n` chứa các số `0` và `1`, hãy tìm hình vuông lớn nhất chỉ chứa các số `1` và trả về diện tích của nó.*

## Example 1:
## *Ví dụ 1:*

**Input:** 
```
matrix = [
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
```
**Output:** `4`

## Example 2:
## *Ví dụ 2:*

**Input:** 
```
matrix = [
  ["0","1"],
  ["1","0"]
]
```
**Output:** `1`

## Example 3:
## *Ví dụ 3:*

**Input:** `matrix = [["0"]]`
**Output:** `0`

## Constraints:
## *Ràng buộc:*

*   `m == matrix.length`
*   `n == matrix[i].length`
*   `1 <= m, n <= 300`
*   `matrix[i][j]` is `'0'` or `'1'`.
