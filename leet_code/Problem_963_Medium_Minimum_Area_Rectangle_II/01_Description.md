# Result for Minimum Area Rectangle II
# *Kết quả cho bài toán Diện tích Hình chữ nhật Nhỏ nhất II*

## Description
## *Mô tả*

You are given an array of points in the X-Y plane `points` where `points[i] = [xi, yi]`.
*Bạn được cho một mảng các điểm trên mặt phẳng X-Y `points` trong đó `points[i] = [xi, yi]`.*

Return *the minimum area of any rectangle formed from these points, with sides **not necessarily parallel** to the X and Y axes*. If there is not any such rectangle, return `0`.
*Trả về *diện tích nhỏ nhất của bất kỳ hình chữ nhật nào được tạo thành từ các điểm này, với các cạnh **không nhất thiết phải song song** với các trục X và Y*. Nếu không có hình chữ nhật nào như vậy, hãy trả về `0`.*

Answers within `10^-5` of the actual answer will be accepted.
*Các câu trả lời trong khoảng `10^-5` so với câu trả lời thực tế sẽ được chấp nhận.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** points = [[1,2],[2,1],[1,0],[0,1]]
**Output:** 2.00000
**Explanation:** The 4 points form a rectangle with area 2.00000.

## Example 2:
## *Ví dụ 2:*

**Input:** points = [[0,1],[2,1],[1,1],[1,0],[2,0]]
**Output:** 1.00000
**Explanation:** The only rectangle is formed by [1,0], [1,1], [2,1], and [2,0] with area 1.00000.

## Example 3:
## *Ví dụ 3:*

**Input:** points = [[0,3],[1,2],[3,1],[1,3],[2,1]]
**Output:** 0
**Explanation:** There is no rectangle.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= points.length <= 50`
*   `points[i].length == 2`
*   `0 <= xi, yi <= 40000`
*   All the given points are **unique**.
