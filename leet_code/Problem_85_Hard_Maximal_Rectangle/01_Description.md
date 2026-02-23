# Result for Maximal Rectangle
# *Kết quả cho bài toán Hình Chữ Nhật Lớn Nhất*

## Description
## *Mô tả*

Given a `rows x cols` binary `matrix` filled with `0`'s and `1`'s, find the largest rectangle containing only `1`'s and return its area.
*Cho một ma trận nhị phân `rows x cols` chứa các số `0` và `1`, hãy tìm hình chữ nhật lớn nhất chỉ chứa toàn số `1` và trả về diện tích của nó.*

## Example 1:
## *Ví dụ 1:*

**Input:** `matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]`
**Output:** `6`
**Explanation:** The maximal rectangle is shown in the image with area = 6.

## Example 2:
## *Ví dụ 2:*

**Input:** `matrix = [["0"]]`
**Output:** `0`

## Example 3:
## *Ví dụ 3:*

**Input:** `matrix = [["1"]]`
**Output:** `1`

## Constraints:
## *Ràng buộc:*

*   `rows == matrix.length`
*   `cols == matrix[i].length`
*   `1 <= row, cols <= 200`
*   `matrix[i][j]` is `'0'` or `'1'`.
