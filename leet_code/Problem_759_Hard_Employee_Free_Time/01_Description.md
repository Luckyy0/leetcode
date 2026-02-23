# Result for Employee Free Time
# *Kết quả cho bài toán Thời gian Rảnh của Nhân viên*

## Description
## *Mô tả*

We are given a list `schedule` of employees, which represents the working time for each employee.
*Chúng ta được cung cấp một danh sách `schedule` của các nhân viên, đại diện cho thời gian làm việc của mỗi nhân viên.*

Each employee has a list of non-overlapping `Intervals`, and these intervals are in sorted order.
*Mỗi nhân viên có một danh sách các `Intervals` (Khoảng thời gian) không chồng lấp, và các khoảng này đã được sắp xếp.*

Return the list of finite intervals representing **common, positive-length free time** for *all* employees, also in sorted order.
*Trả về danh sách các khoảng hữu hạn đại diện cho **thời gian rảnh chung, có độ dài dương** cho *tất cả* nhân viên, cũng theo thứ tự sắp xếp.*

(Even though we are representing `Intervals` in the form `[x, y]`, the objects inside are `Intervals`, not lists or arrays. For example, `schedule[0][0].start = 1`, `schedule[0][0].end = 2`, and `schedule[0][0][0]` is not defined).
*(Mặc dù chúng ta biểu diễn `Intervals` dưới dạng `[x, y]`, các đối tượng bên trong là `Intervals`, không phải danh sách hay mảng).*

Also, we wouldn't include intervals like [5, 5] in our answer, as they have zero length.
*Ngoài ra, chúng ta sẽ không bao gồm các khoảng như [5, 5] trong câu trả lời, vì chúng có độ dài bằng không.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
**Output:** [[3,4]]
**Explanation:**
There are a total of three employees, and all common free time intervals would be [-inf, 1], [3, 4], [10, inf].
We discard any interval that contains inf as they aren't finite.

## Example 2:
## *Ví dụ 2:*

**Input:** schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
**Output:** [[5,6],[7,9]]

---

## Constraints:
## *Ràng buộc:*

*   `1 <= schedule.length, schedule[i].length <= 50`
*   `0 <= schedule[i].start < schedule[i].end <= 10^8`
