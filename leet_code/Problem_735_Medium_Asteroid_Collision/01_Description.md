# Result for Asteroid Collision
# *Kết quả cho bài toán Va chạm Thiên thạch (Asteroid Collision)*

## Description
## *Mô tả*

We are given an array `asteroids` of integers representing asteroids in a row.
*Chúng ta được cho một mảng các số nguyên `asteroids` đại diện cho các thiên thạch trong một hàng.*

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
*Với mỗi thiên thạch, giá trị tuyệt đối đại diện cho kích thước của nó, và dấu của nó đại diện cho hướng di chuyển (dương nghĩa là sang phải, âm nghĩa là sang trái). Mỗi thiên thạch di chuyển với cùng một tốc độ.*

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
*Hãy tìm ra trạng thái của các thiên thạch sau tất cả các cuộc va chạm. Nếu hai thiên thạch gặp nhau, cái nhỏ hơn sẽ phát nổ. Nếu cả hai có cùng kích thước, cả hai đều sẽ phát nổ. Hai thiên thạch di chuyển cùng chiều sẽ không bao giờ va chạm.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** asteroids = [5,10,-5]
**Output:** [5,10]
**Explanation:** The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

## Example 2:
## *Ví dụ 2:*

**Input:** asteroids = [8,-8]
**Output:** []
**Explanation:** The 8 and -8 collide exploding each other.

---

## Constraints:
## *Ràng buộc:*

*   `2 <= asteroids.length <= 10^4`
*   `-1000 <= asteroids[i] <= 1000`
*   `asteroids[i] != 0`
