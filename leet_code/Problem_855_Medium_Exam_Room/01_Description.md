# Result for Exam Room
# *Kết quả cho bài toán Phòng thi*

## Description
## *Mô tả*

There is an exam room with `n` seats in a single row labeled from `0` to `n - 1`.
*Có một phòng thi với `n` ghế xếp thành một hàng duy nhất được gắn nhãn từ `0` đến `n - 1`.*

When a student enters the room, they must sit in the seat that maximizes the distance to the closest person. If there is more than one such seat, they sit in the seat with the lowest number. If no one is in the room, then the student sits at seat number 0.
*Khi một sinh viên vào phòng, họ phải ngồi vào ghế giúp tối đa hóa khoảng cách đến người gần nhất. Nếu có nhiều hơn một chiếc ghế như vậy, họ sẽ ngồi vào ghế có số hiệu thấp nhất. Nếu không có ai trong phòng, sinh viên sẽ ngồi ở ghế số 0.*

Design a class that simulates the exam room to support two functions:
*Thiết kế một lớp mô phỏng phòng thi để hỗ trợ hai chức năng:*

1.  `public int seat()`: Returns the seat number where the student will sit.
2.  `public void leave(int p)`: Indicates that the student at seat number `p` leaves the room. It is guaranteed that someone is sitting in seat `p`.

---

## Example 1:
## *Ví dụ 1:*

**Input:** ["ExamRoom", "seat", "seat", "seat", "seat", "leave", "seat"], [[10], [], [], [], [], [4], []]
**Output:** [null, 0, 9, 4, 2, null, 5]
**Explanation:** 
- ExamRoom(10) -> n = 10
- seat() -> 0, no one is in the room, sit at 0.
- seat() -> 9, distance to 0 is 9, sit at 9.
- seat() -> 4, distance to 0 and 9 is 4, sit at 4.
- seat() -> 2, distance to 0 and 4 is 2, sit at 2.
- leave(4) -> seat 4 becomes empty.
- seat() -> 5, distance to 4 is not applicable, distance to 2 and 9 is 3.5, but closest person is at distance 3, sit at 5.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 10^9`
*   It is guaranteed that `leave(p)` is called for a seat `p` where a student is currently sitting.
*   At most `10^4` calls will be made to `seat` and `leave`.
