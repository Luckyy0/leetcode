# Result for Number Of Corner Rectangles
# *Kết quả cho bài toán Số lượng Hình chữ nhật Góc*

## Description
## *Mô tả*

Given an `m x n` integer matrix `grid` where each entry is at most `1`, return *the number of **corner rectangles***.
*Cho một ma trận số nguyên `m x n` `grid` trong đó mỗi phần tử tối đa là `1`, hãy trả về *số lượng **hình chữ nhật góc***.*

A **corner rectangle** is a rectangle with four distinct corner cells on the grid so that:
*   All four corner cells have a value of `1`.
*   The four corners have the same row or column indices as the other corners (i.e., they are axis-aligned).
*Một **hình chữ nhật góc** là hình chữ nhật có bốn ô góc riêng biệt trên lưới sao cho:*
*   *Cả bốn ô góc đều có giá trị `1`.*
*   *Bốn góc có cùng chỉ số hàng hoặc cột với các góc khác (nghĩa là chúng thẳng hàng theo trục).*

Also note that only the corners need to have the value `1`. The cells inside the rectangle do not need to be `1`.
*Lưu ý rằng chỉ các góc cần có giá trị `1`. Các ô bên trong hình chữ nhật không cần phải là `1`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** grid = [[1,0,0,1],[0,0,1,0],[0,0,1,0],[1,0,0,1]]
**Output:** 1
**Explanation:** There is only one corner rectangle, with corners at grid[0][0], grid[0][3], grid[3][0], and grid[3][3].

## Example 2:
## *Ví dụ 2:*

**Input:** grid = [[1,1,1],[1,1,1],[1,1,1]]
**Output:** 9
**Explanation:** There are four 2x2 rectangles, four 2x3 and 3x2 rectangles, and one 3x3 rectangle.

---

## Constraints:
## *Ràng buộc:*

*   `m == grid.length`
*   `n == grid[i].length`
*   `1 <= m, n <= 200`
*   `grid[i][j]` is either `0` or `1`.
*   The number of `1`s in the grid is in the range `[1, 6000]`.
