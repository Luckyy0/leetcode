# Result for Mirror Reflection
# *Kết quả cho bài toán Phản xạ Gương*

## Description
## *Mô tả*

There is a special square room with mirrors on all four walls. Except for the corners, there are receptors on each wall. The square room has a side length `p`. A laser ray starts at corner 0 (bottom-left) and hits the right wall at a distance `q` from receptor 0 (bottom-right).
*Có một phòng hình vuông đặc biệt với gương trên cả bốn bức tường. Ngoại trừ các góc, có các bộ thu trên mỗi bức tường. Phòng hình vuông có độ dài cạnh là `p`. Một tia laser bắt đầu tại góc 0 (dưới cùng bên trái) và chạm vào bức tường bên phải tại một khoảng cách `q` so với bộ thu 0 (dưới cùng bên phải).*

A receptor is located at each corner:
- Receptor 0 is at `(p, 0)`
- Receptor 1 is at `(p, p)`
- Receptor 2 is at `(0, p)`

Return the number of the receptor that the ray hits first. It is guaranteed that the ray will eventually hit one of the receptors.
*Hãy trả về số hiệu của bộ thu mà tia laser chạm vào đầu tiên. Đảm bảo rằng tia laser cuối cùng sẽ chạm vào một trong các bộ thu.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** p = 2, q = 1
**Output:** 2
**Explanation:** The ray meets receptor 2 the first time it gets reflected back to the left wall.

## Example 2:
## *Ví dụ 2:*

**Input:** p = 3, q = 1
**Output:** 1

---

## Constraints:
## *Ràng buộc:*

*   `1 <= q <= p <= 1000`
