# Result for Next Closest Time
# *Kết quả cho bài toán Thời gian Gần nhất Tiếp theo*

## Description
## *Mô tả*

Given a `time` represented in the format `"HH:MM"`, form the next closest time by reusing the current digits. There is no limit on how many times a digit can be reused.
*Cho một `time` được biểu diễn dưới định dạng `"HH:MM"`, hãy tạo thời gian gần nhất tiếp theo bằng cách sử dụng lại các chữ số hiện có. Không có giới hạn về số lần một chữ số có thể được sử dụng lại.*

You may assume the given input string is always valid. For example, `"01:34"`, `"12:09"` are all valid. `"1:34"`, `"12:9"` are all invalid.
*Bạn có thể giả định rằng chuỗi đầu vào luôn hợp lệ. Ví dụ: `"01:34"`, `"12:09"` đều hợp lệ.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** time = "19:34"
**Output:** "19:39"
**Explanation:** The next closest time choosing from digits 1, 9, 3, 4 is 19:39, which occurs 5 minutes later.
It is not 19:33, because this occurs 23 hours and 59 minutes later.

## Example 2:
## *Ví dụ 2:*

**Input:** time = "23:59"
**Output:** "22:22"
**Explanation:** The next closest time choosing from digits 2, 3, 5, 9 is 22:22.
It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.

---

## Constraints:
## *Ràng buộc:*

*   `time.length == 5`
*   `time` is a valid time in the format `"HH:MM"`.
*   `time` consists of digits and a colon `':'`.
