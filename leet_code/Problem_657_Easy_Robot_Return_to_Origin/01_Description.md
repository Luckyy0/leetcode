# Result for Robot Return to Origin
# *Kết quả cho bài toán Robot Quay về Vị trí Ban đầu*

## Description
## *Mô tả*

There is a robot starting at the position `(0, 0)`, the origin, on a 2D plane. Given a sequence of its moves, judge if this robot **ends up at (0, 0)** after it completes all of its moves.
*Có một robot bắt đầu tại vị trí `(0, 0)`, điểm gốc, trên một mặt phẳng 2D. Cho một chuỗi các chuyển động của nó, hãy đánh giá liệu robot này có **kết thúc tại (0, 0)** sau khi hoàn thành tất cả các chuyển động của nó hay không.*

You are given a string `moves` that represents the move sequence of the robot where `moves[i]` represents its `i-th` move. Valid moves are `'R'` (right), `'L'` (left), `'U'` (up), and `'D'` (down).
*Bạn được cho một chuỗi `moves` đại diện cho chuỗi chuyển động của robot, trong đó `moves[i]` đại diện cho chuyển động thứ `i` của nó. Các chuyển động hợp lệ là `'R'` (phải), `'L'` (trái), `'U'` (lên) và `'D'` (xuống).*

Return `true` if the robot returns to the origin after it finishes all of its moves, or `false` otherwise.
*Hãy trả về `true` nếu robot quay lại điểm gốc sau khi hoàn thành tất cả các chuyển động, ngược lại trả về `false`.*

**Note:** The way that the robot is "facing" is irrelevant. `'R'` will always make the robot move to the right once, `'L'` will always make it move left, etc. Also, assume that the magnitude of every move is the same.
***Lưu ý:** Hướng mà robot "đối mặt" là không quan trọng. `'R'` sẽ luôn khiến robot di chuyển sang phải một lần, `'L'` sẽ luôn khiến nó di chuyển sang trái, v.v. Ngoài ra, giả sử rằng độ lớn của mỗi chuyển động là như nhau.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** moves = "UD"
**Output:** true
**Explanation:** The robot moves up once, and then down once. All moves have the same magnitude, so it ended up at the origin where it started. Therefore, we return true.

## Example 2:
## *Ví dụ 2:*

**Input:** moves = "LL"
**Output:** false

---

## Constraints:
## *Ràng buộc:*

*   `1 <= moves.length <= 2 * 10^4`
*   `moves` only contains the characters `'U'`, `'D'`, `'L'`, and `'R'`.
