# Result for Rotate Image
# *Kết quả cho bài toán Xoay Hình Ảnh*

## Description
## *Mô tả*

You are given an `n x n` 2D `matrix` representing an image, rotate the image by **90** degrees (clockwise).
*Bạn được cho một mảng 2 chiều `n x n` `matrix` đại diện cho một hình ảnh, hãy xoay hình ảnh đó **90** độ (theo chiều kim đồng hồ).*

You have to rotate the image **in-place**, which means you have to modify the input 2D matrix directly. **DO NOT** allocate another 2D matrix and do the rotation.
*Bạn phải xoay hình ảnh **tại chỗ**, có nghĩa là bạn phải sửa đổi trực tiếp mảng 2 chiều đầu vào. **KHÔNG** cấp phát một mảng 2 chiều khác và thực hiện xoay.*

## Example 1:
## *Ví dụ 1:*

**Input:** `matrix = [[1,2,3],[4,5,6],[7,8,9]]`
**Output:** `[[7,4,1],[8,5,2],[9,6,3]]`

## Example 2:
## *Ví dụ 2:*

**Input:** `matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]`
**Output:** `[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]`

## Constraints:
## *Ràng buộc:*

*   `n == matrix.length == matrix[i].length`
*   `1 <= n <= 20`
*   `-1000 <= matrix[i][j] <= 1000`
