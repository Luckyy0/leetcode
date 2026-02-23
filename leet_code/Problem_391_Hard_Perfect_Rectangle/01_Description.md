# Result for Perfect Rectangle
# *Kết quả cho bài toán Hình chữ nhật Hoàn hảo*

## Description
## *Mô tả*

Given an array `rectangles` where `rectangles[i] = [xi, yi, ai, bi]` represents an axis-aligned rectangle. The bottom-left point of the rectangle is `(xi, yi)` and the top-right point is `(ai, bi)`.
*Cho một mảng `rectangles` trong đó `rectangles[i] = [xi, yi, ai, bi]` đại diện cho một hình chữ nhật căn chỉnh theo trục. Điểm dưới cùng bên trái của hình chữ nhật là `(xi, yi)` và điểm trên cùng bên phải là `(ai, bi)`.*

Return `true` if all the rectangles together form an exact cover of a rectangular region.
*Trả về `true` nếu tất cả các hình chữ nhật cùng nhau tạo thành một lớp phủ chính xác cho một vùng hình chữ nhật.*

## Example 1:
## *Ví dụ 1:*

**Input:** `rectangles = [[1,1,3,3],[3,1,4,2],[3,2,4,4],[1,3,2,4],[2,3,4,4]]`
**Output:** `true`
**Explanation:** All 5 rectangles together form an exact cover of a rectangular region.

## Example 2:
## *Ví dụ 2:*

**Input:** `rectangles = [[1,1,2,3],[1,3,2,4],[3,1,4,2],[3,2,4,4]]`
**Output:** `false`
**Explanation:** Because there is a gap between the two rectangular regions.

## Example 3:
## *Ví dụ 3:*

**Input:** `rectangles = [[1,1,3,3],[3,1,4,2],[1,3,2,4],[2,2,4,4]]`
**Output:** `false`
**Explanation:** Because two of the rectangles overlap with each other.

## Constraints:
## *Ràng buộc:*

*   `1 <= rectangles.length <= 2 * 10^4`
*   `rectangles[i].length == 4`
*   `-10^5 <= xi, yi, ai, bi <= 10^5`
