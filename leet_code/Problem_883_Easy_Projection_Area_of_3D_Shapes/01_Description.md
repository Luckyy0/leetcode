# Result for Projection Area of 3D Shapes
# *Kết quả cho bài toán Diện tích Hình chiếu của Hình khối 3D*

## Description
## *Mô tả*

You are given an `n x n` `grid` where we place some `1 x 1 x 1` cubes that are axis-aligned with the `x`, `y`, and `z` axes.
*Bạn được cho một lưới `n x n`, trong đó chúng ta đặt một số khối lập phương `1 x 1 x 1` được căn chỉnh theo các trục `x`, `y`, và `z`.*

Each value `v = grid[i][j]` represents a tower of `v` cubes placed on top of the cell `(i, j)`.
*Mỗi giá trị `v = grid[i][j]` đại diện cho một tháp gồm `v` khối lập phương được đặt trên ô `(i, j)`.*

We view the projection of these cubes onto the `xy`, `yz`, and `zx` planes.
*Chúng ta xem hình chiếu của các khối lập phương này lên các mặt phẳng `xy`, `yz` và `zx`.*

A **projection** is like a shadow, that maps our 3-dimensional figure to a 2-dimensional plane. We are viewing the "shadow" when looking at the cubes from the top, the front, and the side.
*Một **hình chiếu** giống như một cái bóng, ánh xạ hình 3 chiều của chúng ta lên một mặt phẳng 2 chiều. Chúng ta đang xem "cái bóng" khi nhìn các khối lập phương từ trên xuống, từ phía trước và từ bên cạnh.*

Return *the total area of all three projections*.
*Hãy trả về *tổng diện tích của cả ba hình chiếu*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** grid = [[1,2],[3,4]]
**Output:** 17
**Explanation:** 
Here are the three projections ("shadows") of the shape made with each axis-aligned plane.
Top View (XY): 4 (all cells are non-zero)
Front View (XZ): 3 + 4 = 7 (max of row 0 is 2, max of row 1 is 4? Wait.
Row 0: [1, 2] -> Max is 2.
Row 1: [3, 4] -> Max is 4.
Sum = 6.
Side View (YZ): Max of col 0 is 3. Max of col 1 is 4. Sum = 7.
Total = 4 + 6 + 7 = 17.

## Example 2:
## *Ví dụ 2:*

**Input:** grid = [[2]]
**Output:** 5

## Example 3:
## *Ví dụ 3:*

**Input:** grid = [[1,0],[0,2]]
**Output:** 8

---

## Constraints:
## *Ràng buộc:*

*   `n == grid.length == grid[i].length`
*   `1 <= n <= 50`
*   `0 <= grid[i][j] <= 50`
