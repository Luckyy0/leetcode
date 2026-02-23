# Result for Search a 2D Matrix
# *Kết quả cho bài toán Tìm Kiếm Trong Ma Trận 2 Chiều*

## Description
## *Mô tả*

You are given an `m x n` integer matrix `matrix` with the following two properties:
*Bạn được cho một ma trận số nguyên `m x n` `matrix` với hai đặc điểm sau:*

*   Each row is sorted in non-decreasing order.
    *Mỗi hàng được sắp xếp theo thứ tự không giảm.*
*   The first integer of each row is greater than the last integer of the previous row.
    *Số nguyên đầu tiên của mỗi hàng lớn hơn số nguyên cuối cùng của hàng trước đó.*

Given an integer `target`, return `true` *if `target` is in `matrix` or `false` otherwise*.
*Cho một số nguyên `target`, trả về `true` *nếu `target` nằm trong `matrix`, ngược lại trả về `false`**.*

You must write a solution in `O(log(m * n))` time complexity.
*Bạn phải viết một giải pháp với độ phức tạp thời gian `O(log(m * n))`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]`, `target = 3`
**Output:** `true`

## Example 2:
## *Ví dụ 2:*

**Input:** `matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]`, `target = 13`
**Output:** `false`

## Constraints:
## *Ràng buộc:*

*   `m == matrix.length`
*   `n == matrix[i].length`
*   `1 <= m, n <= 100`
*   `-10^4 <= matrix[i][j], target <= 10^4`
