# Minimum Score Triangulation of Polygon
# *Phân chia Đa giác thành các Tam giác với Điểm số Nhỏ nhất*

## Description
## *Mô tả*

You have a convex `n`-sided polygon where each vertex has an integer value. You are given an integer array `values` where `values[i]` is the value of the `i`th vertex (i.e., clockwise order).
*Bạn có một đa giác lồi `n` cạnh, trong đó mỗi đỉnh có một giá trị nguyên. Bạn được cung cấp một mảng số nguyên `values`, trong đó `values[i]` là giá trị của đỉnh thứ `i` (được sắp xếp theo chiều kim đồng hồ).*

You triangulate the polygon into `n - 2` triangles. For each triangle, the value of that triangle is the product of the values of its vertices, and the total score of the triangulation is the sum of these values over all `n - 2` triangles in the triangulation.
*Bạn thực hiện chia đa giác thành `n - 2` hình tam giác (phép đạc đại tam giác). Đối với mỗi tam giác, giá trị của nó là tích của trị số nằm ở ba đỉnh. Tổng điểm của phép chia đa giác là tổng các giá trị này qua tất cả `n - 2` tam giác nằm trong phép đạc đại.*

Return the smallest possible total score that you can achieve with some triangulation of the polygon.
*Trả về tổng điểm nhỏ nhất có thể đạt được với bất kỳ cách chia hình đa giác nào bạn chọn.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** values = [1,2,3]
**Output:** 6
**Explanation:** 
*Giải thích:*
The polygon is already a triangle, so the only triangulation is the triangle itself. Its score is 1 * 2 * 3 = 6.
*Đa giác này vốn dĩ đã là một tam giác, do vậy cách đạc đại duy nhất chính là bản thân nó. Điểm số là 1 * 2 * 3 = 6.*

## Example 2:
## *Ví dụ 2:*

**Input:** values = [3,7,4,5]
**Output:** 144
**Explanation:** 
*Giải thích:*
There are two triangulations, with possible scores: 3\*7\*5 + 4\*5\*7 = 245, or 3\*4\*5 + 3\*4\*7 = 144.
*Có hai cách vẽ tam giác, với các điểm số có thể: (3\*7\*5) + (4\*5\*7) = 105 + 140 = 245, hoặc (3\*4\*5) + (3\*4\*7) = 60 + 84 = 144.*
The minimum score is 144.
*Điểm số nhỏ nhất thu được là 144.*

## Example 3:
## *Ví dụ 3:*

**Input:** values = [1,3,1,4,1,5]
**Output:** 13
**Explanation:** 
*Giải thích:*
The minimum score triangulation has score 1\*1\*3 + 1\*1\*4 + 1\*1\*5 + 1\*1\*1 = 3 + 4 + 5 + 1 = 13.
*Trường hợp chia tam giác ngon ăn nhất có mức điểm là 1\*1\*3 + 1\*1\*4 + 1\*1\*5 + 1\*1\*1 = 13.*

---

## Constraints:
## *Ràng buộc:*

* `n == values.length`
* `3 <= n <= 50`
* `1 <= values[i] <= 100`
