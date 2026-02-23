# Result for Construct Quad Tree
# *Kết quả cho bài toán Xây dựng Cây Tứ phân*

## Description
## *Mô tả*

Given an `n x n` matrix `grid` of `0's` and `1's` only. We want to represent the `grid` with a **Quad-Tree**.
*Cho một ma trận `n x n` `grid` chỉ gồm số `0` và `1`. Chúng ta muốn đại diện cho `grid` này bằng một **Cây Tứ phân (Quad-Tree)***.

Return *the root of the Quad-Tree representing the `grid`*.
*Hãy trả về *gốc của Cây Tứ phân đại diện cho `grid` đó*.*

Notice that you can assign the value of a node to **True** or **False** when `isLeaf` is **True**, and any value is accepted when `isLeaf` is **False**.
*Lưu ý rằng bạn có thể gán giá trị của một nút là **True** hoặc **False** khi `isLeaf` là **True**, và bất kỳ giá trị nào cũng được chấp nhận khi `isLeaf` là **False**.*

A Quad-Tree is a tree data structure in which each internal node has exactly four children. Besides, each node has two attributes:
*Một Cây Tứ phân là một cấu trúc dữ liệu cây trong đó mỗi nút nội bộ có đúng bốn con. Ngoài ra, mỗi nút có hai thuộc tính:*

-   `val`: **True** if the node represents a grid of all `1's` or **False** if the node represents a grid of all `0's`.
-   `isLeaf`: **True** if the node is a leaf node on the tree or **False** if the node has the four children.

We can construct a Quad-Tree from a two-dimensional area using the following steps:
1. If the current grid has the same value (all `1's` or all `0's`) set `isLeaf` True and set `val` to the value of the grid and set the four children to Null and stop.
2. If the current grid has different values, set `isLeaf` to False and set `val` to any value and divide the current grid into four sub-grids as shown in the photo.
3. Recurse for each of the four sub-grids with the appropriate area.

## Constraints:
## *Ràng buộc:*

*   `n == grid.length == grid[i].length`
*   `n == 2^x` where `0 <= x <= 6`
