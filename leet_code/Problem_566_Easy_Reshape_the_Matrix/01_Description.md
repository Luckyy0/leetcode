# Result for Reshape the Matrix
# *Kết quả cho bài toán Thay đổi hình dạng Ma trận*

## Description
## *Mô tả*

In MATLAB, there is a handy function called `reshape` which can reshape an `m x n` matrix into a new one with a different size `r x c` keeping its original data.
*Trong MATLAB, có một hàm tiện lợi gọi là `reshape` có thể định dạng lại một ma trận `m x n` thành một ma trận mới với kích thước khác `r x c` mà vẫn giữ nguyên dữ liệu gốc.*

You are given an `m x n` matrix `mat` and two integers `r` and `c` representing the number of rows and the number of columns of the wanted reshaped matrix.
*Bạn được cho một ma trận `mat` kích thước `m x n` và hai số nguyên `r` và `c` đại diện cho số hàng và số cột của ma trận định dạng lại mong muốn.*

The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.
*Ma trận định dạng lại nên được lấp đầy bởi tất cả các phần tử của ma trận gốc theo cùng một thứ tự duyệt theo hàng như cũ.*

If the `reshape` operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
*Nếu thao tác `reshape` với các tham số đã cho là khả thi và hợp lệ, hãy xuất ma trận định dạng lại mới; Nếu không, hãy xuất ma trận gốc.*

## Example 1:
## *Ví dụ 1:*

**Input:** `mat = [[1,2],[3,4]], r = 1, c = 4`
**Output:** `[[1,2,3,4]]`

## Example 2:
## *Ví dụ 2:*

**Input:** `mat = [[1,2],[3,4]], r = 2, c = 4`
**Output:** `[[1,2],[3,4]]`

## Constraints:
## *Ràng buộc:*

*   `m == mat.length`
*   `n == mat[i].length`
*   `1 <= m, n <= 100`
*   `-1000 <= mat[i][j] <= 1000`
*   `1 <= r, c <= 300`
