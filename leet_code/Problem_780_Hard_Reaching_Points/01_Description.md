# Result for Reaching Points
# *Kết quả cho bài toán Đạt đến Điểm*

## Description
## *Mô tả*

Given four integers `sx`, `sy`, `tx`, and `ty`, return `true` *if it is possible to convert the point* `(sx, sy)` *to the point* `(tx, ty)` *through some operations*, *or* `false` *otherwise*.
*Cho bốn số nguyên `sx`, `sy`, `tx`, và `ty`, trả về `true` *nếu có thể chuyển đổi điểm* `(sx, sy)` *thành điểm* `(tx, ty)` *thông qua một số phép biến đổi*, *hoặc* `false` *nếu ngược lại*.*

The allowed operation on some point `(x, y)` is to convert it to either `(x, x + y)` or `(x + y, y)`.
*Phép biến đổi cho phép trên một điểm `(x, y)` là chuyển nó thành `(x, x + y)` hoặc `(x + y, y)`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** sx = 1, sy = 1, tx = 3, ty = 5
**Output:** true
**Explanation:**
One series of moves that transforms the starting point to the target is:
(1, 1) -> (1, 2)
(1, 2) -> (3, 2)
(3, 2) -> (3, 5)

## Example 2:
## *Ví dụ 2:*

**Input:** sx = 1, sy = 1, tx = 2, ty = 2
**Output:** false

## Example 3:
## *Ví dụ 3:*

**Input:** sx = 1, sy = 1, tx = 1, ty = 1
**Output:** true

---

## Constraints:
## *Ràng buộc:*

*   `1 <= sx, sy, tx, ty <= 10^9`
