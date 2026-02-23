# Result for Random Point in Non-overlapping Rectangles
# *Kết quả cho bài toán Điểm Ngẫu nhiên trong các Hình chữ nhật Không chồng lấn*

## Description
## *Mô tả*

You are given an array of non-overlapping axis-aligned rectangles `rects` where `rects[i] = [ai, bi, xi, yi]` indicates that `(ai, bi)` is the bottom-left corner point of the `i^th` rectangle and `(xi, yi)` is the top-right corner point of the `i^th` rectangle. Design an algorithm to pick a random integer point inside the space covered by one of the given rectangles. A point on the perimeter of a rectangle is included in the space covered by the rectangle.
*Bạn được cho một mảng các hình chữ nhật không chồng lấn `rects` trong đó `rects[i] = [ai, bi, xi, yi]`. Thiết kế một thuật toán để chọn một điểm nguyên ngẫu nhiên bên trong không gian được bao phủ bởi một trong các hình chữ nhật đã cho. Điểm trên chu vi của hình chữ nhật cũng được bao gồm trong không gian.*

Any integer point inside the space covered by one of the given rectangles should be equally likely to be returned.
*Mọi điểm nguyên bên trong không gian được bao phủ bởi các hình chữ nhật phải có cùng xác suất được trả về.*

Note that an integer point is a point that has integer coordinates.
*Lưu ý rằng điểm nguyên là điểm có tọa độ là số nguyên.*

Implement the `Solution` class:
*   `Solution(int[][] rects)` Initializes the object with the given rectangles `rects`.
*   `int[] pick()` Returns a random integer point `[u, v]` inside the space covered by one of the given rectangles.

## Example 1:
## *Ví dụ 1:*

**Input**
`["Solution", "pick", "pick", "pick", "pick", "pick"]`
`[[[[-2, -2, 1, 1], [2, 2, 4, 6]]], [], [], [], [], []]`
**Output**
`[null, [-1, -2], [2, 3], [-2, -1], [3, 4], [-2, 0]]`

## Constraints:
## *Ràng buộc:*

*   `1 <= rects.length <= 100`
*   `rects[i].length == 4`
*   `-10^9 <= ai < xi <= 10^9`
*   `-10^9 <= bi < yi <= 10^9`
*   `xi - ai <= 2000`
*   `yi - bi <= 2000`
*   All the rectangles do not overlap.
*   At most `10^4` calls will be made to `pick`.
