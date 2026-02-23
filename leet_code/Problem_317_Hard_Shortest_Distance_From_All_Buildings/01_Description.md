# Result for Shortest Distance from All Buildings
# *Kết quả cho bài toán Khoảng cách Ngắn nhất từ Tất cả Tòa nhà*

## Description
## *Mô tả*

You are given an `m x n` grid `grid` of values `0`, `1`, or `2`, where:
*   each `0` marks an **empty land** that you can pass by freely,
*   each `1` marks a **building** that you cannot pass through, and
*   each `2` marks an **obstacle** that you cannot pass through.
*Bạn được cho một lưới `m x n` `grid` gồm các giá trị `0`, `1`, hoặc `2`, trong đó:*
*   *mỗi số `0` đánh dấu một **vùng đất trống** mà bạn có thể đi qua tự do,*
*   *mỗi số `1` đánh dấu một **tòa nhà** mà bạn không thể đi qua, và*
*   *mỗi số `2` đánh dấu một **chướng ngại vật** mà bạn không thể đi qua.*

You want to build a house on an empty land that reaches all buildings in the shortest total travel distance. You can only move up, down, left, and right.
*Bạn muốn xây một ngôi nhà trên một vùng đất trống có thể đến được tất cả các tòa nhà với tổng khoảng cách di chuyển ngắn nhất. Bạn chỉ có thể di chuyển lên, xuống, trái và phải.*

Return *the shortest travel distance for such a house*. If it is not possible to build such a house according to the above rules, return `-1`.
*Trả về *khoảng cách di chuyển ngắn nhất cho ngôi nhà như vậy*. Nếu không thể xây ngôi nhà như vậy theo các quy tắc trên, trả về `-1`.*

The **total travel distance** is the sum of the distances between the houses of the friends and the meeting point.
* **Tổng khoảng cách di chuyển** là tổng khoảng cách giữa nhà của những người bạn và điểm gặp gỡ.*

The distance is calculated using [Manhattan Distance](http://en.wikipedia.org/wiki/Taxicab_geometry), where `distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|`.
*Khoảng cách được tính bằng [Khoảng cách Manhattan](http://en.wikipedia.org/wiki/Taxicab_geometry), trong đó `distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `grid = [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]`
**Output:** `7`
**Explanation:** Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2).
The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal.
So return 7.

## Example 2:
## *Ví dụ 2:*

**Input:** `grid = [[1,0]]`
**Output:** `1`

## Example 3:
## *Ví dụ 3:*

**Input:** `grid = [[1]]`
**Output:** `-1`

## Constraints:
## *Ràng buộc:*

*   `m == grid.length`
*   `n == grid[i].length`
*   `1 <= m, n <= 50`
*   `grid[i][j]` is either `0`, `1`, or `2`.
*   There will be **at least one** building in the `grid`.
