# Result for Online Election
# *Kết quả cho bài toán Bầu cử Trực tuyến*

## Description
## *Mô tả*

You are given two integer arrays `persons` and `times`. In an election, the `i`-th vote was cast for `persons[i]` at time `times[i]`.
*Bạn được cho hai mảng số nguyên `persons` và `times`. Trong một cuộc bầu cử, lá phiếu thứ `i` được bầu cho `persons[i]` tại thời điểm `times[i]`.*

For each query at a time `t`, find the person that was leading the election at time `t`. Votes cast at time `t` will count towards our query. In the case of a tie, the most recent vote (among tied candidates) wins.
*Đối với mỗi truy vấn tại thời điểm `t`, hãy tìm người dẫn đầu cuộc bầu cử tại thời điểm `t`. Các lá phiếu được bỏ tại thời điểm `t` sẽ được tính vào truy vấn của chúng tôi. Trong trường hợp hòa, lá phiếu gần đây nhất (trong số các ứng cử viên hòa) sẽ thắng.*

Implement the `TopVotedCandidate` class:
*Triển khai lớp `TopVotedCandidate`:*

*   `TopVotedCandidate(int[] persons, int[] times)` Initializes the object with the `persons` and `times` arrays.
    *   `TopVotedCandidate(int[] persons, int[] times)` Khởi tạo đối tượng với các mảng `persons` và `times`.*
*   `int q(int t)` Returns the number of the person that was leading the election at time `t` according to the mentioned rules.
    *   `int q(int t)` Trả về số của người dẫn đầu cuộc bầu cử tại thời điểm `t` theo các quy tắc đã đề cập.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** ["TopVotedCandidate", "q", "q", "q", "q", "q", "q"]
[[[0, 1, 1, 0, 0, 1, 0], [0, 5, 10, 15, 20, 25, 30]], [3], [12], [25], [15], [24], [8]]
**Output:** [null, 0, 1, 1, 0, 0, 1]
**Explanation:** 
TopVotedCandidate topVotedCandidate = new TopVotedCandidate([0, 1, 1, 0, 0, 1, 0], [0, 5, 10, 15, 20, 25, 30]);
topVotedCandidate.q(3); // return 0, At time 3, the votes are [0], and 0 is leading.
topVotedCandidate.q(12); // return 1, At time 12, the votes are [0,1,1], and 1 is leading.
topVotedCandidate.q(25); // return 1, At time 25, the votes are [0,1,1,0,0,1], and 1 is leading (as ties go to the most recent vote).
topVotedCandidate.q(15); // return 0
topVotedCandidate.q(24); // return 0
topVotedCandidate.q(8); // return 1

---

## Constraints:
## *Ràng buộc:*

*   `1 <= persons.length <= 5000`
*   `times.length == persons.length`
*   `0 <= persons[i] < persons.length`
*   `0 <= times[i] <= 10^9`
*   `times` is sorted in a strictly increasing order.
*   `times[0] <= t <= 10^9`
*   At most `10^4` calls will be made to `q`.
