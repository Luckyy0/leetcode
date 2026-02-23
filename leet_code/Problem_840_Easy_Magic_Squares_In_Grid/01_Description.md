# Result for Magic Squares In Grid
# *Kết quả cho bài toán Hình vuông Ma thuật trong Lưới*

## Description
## *Mô tả*

A **3 x 3** magic square is a `3 x 3` grid filled with distinct numbers **from 1 to 9** such that each row, column, and both diagonals all have the same sum.
*Một hình vuông ma thuật **3 x 3** là một lưới `3 x 3` chứa các số khác nhau **từ 1 đến 9** sao cho tổng của mỗi hàng, mỗi cột và cả hai đường chéo đều bằng nhau.*

Given a `row x col` `grid` of integers, how many `3 x 3` **magic square** subgrids are there? (Each subgrid is contiguous).
*Cho một `grid` các số nguyên kích thước `row x col`, hỏi có bao nhiêu lưới con `3 x 3` là **hình vuông ma thuật**? (Mỗi lưới con phải liên tiếp).*

---

## Example 1:
## *Ví dụ 1:*

**Input:** grid = [[4,3,8,4],[9,5,1,9],[2,7,6,2]]
**Output:** 1
**Explanation:** 
The following subgrid is a 3 x 3 magic square:
4 3 8
9 5 1
2 7 6
In this square:
- Each row sums to 15.
- Each column sums to 15.
- Both diagonals sum to 15.
- All numbers are distinct and between 1 and 9.

## Example 2:
## *Ví dụ 2:*

**Input:** grid = [[8]]
**Output:** 0

---

## Constraints:
## *Ràng buộc:*

*   `row == grid.length`
*   `col == grid[i].length`
*   `1 <= row, col <= 10`
*   `0 <= grid[i][j] <= 15`
