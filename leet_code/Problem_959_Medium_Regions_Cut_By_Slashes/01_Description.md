# Result for Regions Cut By Slashes
# *Kết quả cho bài toán Các Vùng bị Cắt bởi Dấu gạch chéo*

## Description
## *Mô tả*

An `n x n` grid is composed of `1 x 1` squares where each `1 x 1` square consists of a `'/'`, `'\'`, or blank space `' '`. These characters divide the square into contiguous regions.
*Một lưới `n x n` được tạo thành từ các ô vuông `1 x 1`, trong đó mỗi ô vuông `1 x 1` chứa một dấu `'/'`, `'\'`, hoặc khoảng trắng `' '`. Các ký tự này chia ô vuông thành các vùng liên tiếp.*

Given the grid `grid` represented as a string array, return *the number of regions*.
*Cho lưới `grid` được biểu diễn dưới dạng mảng chuỗi, hãy trả về *số lượng vùng*.*

Note that backslash characters are escaped, so a `\` is represented as `\\`.
*Lưu ý rằng các ký tự gạch chéo ngược được thoát, vì vậy `\` được biểu diễn là `\\`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** grid = [" /","/ "]
**Output:** 2

## Example 2:
## *Ví dụ 2:*

**Input:** grid = [" /","  "]
**Output:** 1

## Example 3:
## *Ví dụ 3:*

**Input:** grid = ["/\\","\\/"]
**Output:** 5
**Explanation:** Recall that because \ characters are escaped, "\\/" is represented as "/\\", and "/\\" is represented as "\\/".

---

## Constraints:
## *Ràng buộc:*

*   `n == grid.length == grid[i].length`
*   `1 <= n <= 30`
*   `grid[i][j]` is either `'/'`, `'\'`, or `' '`.
