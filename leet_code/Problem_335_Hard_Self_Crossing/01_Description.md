# Result for Self Crossing
# *Kết quả cho bài toán Tự Cắt*

## Description
## *Mô tả*

You are given an array of integers `distance`.
*Bạn được cho một mảng các số nguyên `distance`.*

You start at the point `(0, 0)` on an **X-Y plane**, and you move `distance[0]` meters to the north, then `distance[1]` meters to the west, `distance[2]` meters to the south, `distance[3]` meters to the east, and so on. In other words, after each move, your direction changes counter-clockwise.
*Bạn bắt đầu tại điểm `(0, 0)` trên **mặt phẳng X-Y**, và bạn di chuyển `distance[0]` mét về phía bắc, sau đó `distance[1]` mét về phía tây, `distance[2]` mét về phía nam, `distance[3]` mét về phía đông, v.v. Nói cách khác, sau mỗi lần di chuyển, hướng của bạn thay đổi ngược chiều kim đồng hồ.*

Return `true` *if your path crosses itself, or* `false` *if it does not*.
*Trả về `true` *nếu đường đi của bạn tự cắt chính nó, hoặc* `false` *nếu không*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `distance = [2,1,1,2]`
**Output:** `true`
**Explanation:** The path crosses itself at the point (0, 1).

## Example 2:
## *Ví dụ 2:*

**Input:** `distance = [1,2,3,4]`
**Output:** `false`

## Example 3:
## *Ví dụ 3:*

**Input:** `distance = [1,1,1,1]`
**Output:** `true`

## Constraints:
## *Ràng buộc:*

*   `1 <= distance.length <= 10^5`
*   `1 <= distance[i] <= 10^5`
