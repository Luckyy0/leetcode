# Result for Convex Polygon
# *Kết quả cho bài toán Đa giác Lồi*

## Description
## *Mô tả*

Given a list of points that form a polygon when joined sequentially, find if this polygon is convex [Convex polygon definition](https://en.wikipedia.org/wiki/Convex_polygon).
*Cho một danh sách các điểm tạo thành một đa giác khi được nối tuần tự, hãy tìm xem đa giác này có phải là đa giác lồi hay không.*

Note:
1.  There are at least 3 and at most 10,000 points.
2.  Coordinates are in the range -10,000 to 10,000.
3.  You may assume the polygon formed by given points is always a simple polygon (In other words, we ensure that exactly two edges intersect at each vertex, and that edges otherwise **don't intersect each other**).
    *Bạn có thể giả định đa giác được tạo bởi các điểm đã cho luôn là đa giác đơn (Nói cách khác, chúng tôi đảm bảo rằng có đúng hai cạnh giao nhau tại mỗi đỉnh và các cạnh **không giao nhau** ở bất kỳ nơi nào khác).*

## Example 1:
## *Ví dụ 1:*

**Input:** `[[0,0],[0,1],[1,1],[1,0]]`
**Output:** `true`
**Explanation:** A square is convex.

## Example 2:
## *Ví dụ 2:*

**Input:** `[[0,0],[0,10],[10,10],[10,0],[5,5]]`
**Output:** `false`
**Explanation:** The vertex [5,5] creates a concave angle.

## Constraints:
## *Ràng buộc:*

*   `3 <= points.length <= 10^4`
*   `-10^4 <= points[i][0], points[i][1] <= 10^4`
