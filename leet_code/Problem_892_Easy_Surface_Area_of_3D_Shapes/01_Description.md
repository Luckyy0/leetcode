# Result for Surface Area of 3D Shapes
# *Kết quả cho bài toán Diện tích Bề mặt của Hình khối 3D*

## Description
## *Mô tả*

You are given an `n x n` `grid` where you have placed some `1 x 1 x 1` cubes. Each value `v = grid[i][j]` represents a tower of `v` cubes placed on top of cell `(i, j)`.
*Bạn được cho một lưới `n x n` trong đó bạn đã đặt một số khối lập phương `1 x 1 x 1`. Mỗi giá trị `v = grid[i][j]` đại diện cho một tháp gồm `v` khối lập phương được đặt trên ô `(i, j)`.*

After placing these cubes, you have decided to glue any directly adjacent cubes to each other, forming several irregular 3D shapes.
*Sau khi đặt các khối lập phương này, bạn quyết định dán bất kỳ khối lập phương nào liền kề trực tiếp với nhau, tạo thành một số hình dạng 3D không đều.*

Return *the total surface area of the resulting shapes*.
*Hãy trả về *tổng diện tích bề mặt của các hình dạng thu được*.*

**Note:** The bottom face of each shape counts toward its surface area.
*Lưu ý: Mặt đáy của mỗi hình dạng cũng được tính vào diện tích bề mặt của nó.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** grid = [[1,2],[3,4]]
**Output:** 34

## Example 2:
## *Ví dụ 2:*

**Input:** grid = [[1,1,1],[1,0,1],[1,1,1]]
**Output:** 32

## Example 3:
## *Ví dụ 3:*

**Input:** grid = [[2,2,2],[2,1,2],[2,2,2]]
**Output:** 46

---

## Constraints:
## *Ràng buộc:*

*   `n == grid.length == grid[i].length`
*   `1 <= n <= 50`
*   `0 <= grid[i][j] <= 50`
