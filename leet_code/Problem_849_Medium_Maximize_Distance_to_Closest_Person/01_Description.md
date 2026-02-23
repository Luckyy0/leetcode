# Result for Maximize Distance to Closest Person
# *Kết quả cho bài toán Tối đa hóa Khoảng cách đến Người gần nhất*

## Description
## *Mô tả*

You are given an array representing a row of `seats` where `seats[i] = 1` represents a person sitting in the `i`-th seat, and `seats[i] = 0` represents that the `i`-th seat is empty (0-indexed).
*Bạn được cho một mảng đại diện cho một hàng `ghế` trong đó `seats[i] = 1` đại diện cho một người đang ngồi ở ghế thứ `i`, và `seats[i] = 0` đại diện cho ghế thứ `i` đang trống.*

There is at least one empty seat, and at least one person sitting.
*Có ít nhất một ghế trống và ít nhất một người đang ngồi.*

Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized. 
*Alex muốn ngồi vào ghế sao cho khoảng cách giữa anh ta và người gần anh ta nhất là lớn nhất.*

Return *that maximum distance to the closest person*.
*Hãy trả về *khoảng cách tối đa đó đến người gần nhất*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** seats = [1,0,0,0,1,0,1]
**Output:** 2
**Explanation:** 
If Alex sits in the second empty seat (i.e. seats[2]), the closest person is at seats[0] and seats[4]. The distance is 2.
If Alex sits in any other empty seat, the closest person at distance 1.
Thus, the maximum distance is 2.

## Example 2:
## *Ví dụ 2:*

**Input:** seats = [1,0,0,0]
**Output:** 3
**Explanation:** 
If Alex sits in the last seat (i.e. seats[3]), the closest person is 3 seats away.
This is the maximum distance possible, so the answer is 3.

---

## Constraints:
## *Ràng buộc:*

*   `2 <= seats.length <= 2 * 10^4`
*   `seats[i]` is `0` or `1`.
*   At least one seat is empty.
*   At least one seat is occupied.
