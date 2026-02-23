# Result for Line Reflection
# *Kết quả cho bài toán Đối xứng qua Đường thẳng*

## Description
## *Mô tả*

Given `n` points on a 2D plane, find if there is such a vertical line that reflects the given points.
*Cho `n` điểm trên mặt phẳng 2D, hãy tìm xem có tồn tại một đường thẳng thẳng đứng nào đối xứng các điểm đã cho hay không.*

A point `(x1, y1)` is reflected across the vertical line `x = k` if `x1 + x2 = 2k` and `y1 = y2`.
*Một điểm `(x1, y1)` được đối xứng qua đường thẳng thẳng đứng `x = k` nếu `x1 + x2 = 2k` và `y1 = y2`.*

**Note:** If there are duplicate points, they should be treated as a single point.
**Lưu ý:** Nếu có các điểm trùng lặp, chúng nên được xử lý như một điểm duy nhất.

## Example 1:
## *Ví dụ 1:*

**Input:** `points = [[1,1],[-1,1]]`
**Output:** `true`

## Example 2:
## *Ví dụ 2:*

**Input:** `points = [[1,1],[-1,-1]]`
**Output:** `false`

## Constraints:
## *Ràng buộc:*

*   `n == points.length`
*   `1 <= n <= 10^4`
*   `-10^8 <= points[i][j] <= 10^8`
