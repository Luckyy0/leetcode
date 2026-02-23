# Result for Valid Square
# *Kết quả cho bài toán Hình vuông Hợp lệ*

## Description
## *Mô tả*

Given the coordinates of four points in 2D space `p1`, `p2`, `p3` and `p4`, return `true` if the four points construct a square.
*Cho tọa độ của bốn điểm trong không gian 2 chiều `p1`, `p2`, `p3` và `p4`, hãy trả về `true` nếu bốn điểm này tạo thành một hình vuông.*

The coordinate of a point `pi` is represented as `[xi, yi]`. The input is **not** given in any specific order.
*Tọa độ của một điểm `pi` được đại diện bởi `[xi, yi]`. Đầu vào **không** được đưa ra theo bất kỳ thứ tự cụ thể nào.*

A valid square has four equal sides with positive length and four equal angles (90-degree angles).
*Một hình vuông hợp lệ có bốn cạnh bằng nhau với độ dài dương và bốn góc bằng nhau (góc 90 độ).*

---

## Example 1:
## *Ví dụ 1:*

**Input:** p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
**Output:** true

## Example 2:
## *Ví dụ 2:*

**Input:** p1 = [0,0], p2 = [1,1], p3 = [1,1], p4 = [0,0]
**Output:** false

---

## Constraints:
## *Ràng buộc:*

*   `p1.length == p2.length == p3.length == p4.length == 2`
*   `-104 <= xi, yi <= 104`
