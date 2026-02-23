# Result for Minimum Falling Path Sum
# *Kết quả cho bài toán Tổng Đường đi Rơi Tối thiểu*

## Description
## *Mô tả*

Given an `n x n` array of integers `matrix`, return *the **minimum sum** of any **falling path** through `matrix`*.
*Cho một mảng số nguyên `n x n` `matrix`, hãy trả về ***tổng tối thiểu** của bất kỳ **đường đi rơi** nào qua `matrix`*.*

A **falling path** starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position `(row, col)` will be `(row + 1, col - 1)`, `(row + 1, col)`, or `(row + 1, col + 1)`.
*Một **đường đi rơi** bắt đầu tại bất kỳ phần tử nào trong hàng đầu tiên và chọn phần tử trong hàng tiếp theo nằm ngay bên dưới hoặc chéo trái/phải. Cụ thể, phần tử tiếp theo từ vị trí `(row, col)` sẽ là `(row + 1, col - 1)`, `(row + 1, col)`, hoặc `(row + 1, col + 1)`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** matrix = [[2,1,3],[6,5,4],[7,8,9]]
**Output:** 13
**Explanation:** There are two falling paths with a minimum sum as shown.
[[2,1,3],      [[2,1,3],
 [6,5,4],       [6,5,4],
 [7,8,9]]       [7,8,9]]
(1 -> 5 -> 7) or (1 -> 4 -> 8) are both 13 which is path 1+5+7 and 1+4+8.

## Example 2:
## *Ví dụ 2:*

**Input:** matrix = [[-19,57],[-40,-5]]
**Output:** -59
**Explanation:** The falling path with a minimum sum is shown.
[[-19,57],
 [-40,-5]]
The path is -19 -> -40 = -59.

---

## Constraints:
## *Ràng buộc:*

*   `n == matrix.length == matrix[i].length`
*   `1 <= n <= 100`
*   `-100 <= matrix[i][j] <= 100`
