# Result for Rotate String
# *Kết quả cho bài toán Xoay Chuỗi*

## Description
## *Mô tả*

Given two strings `s` and `goal`, return `true` *if and only if* `s` *can become* `goal` *after some number of shifts on* `s`.
*Cho hai chuỗi `s` và `goal`, trả về `true` *khi và chỉ khi* `s` *có thể trở thành* `goal` *sau một số lần dịch chuyển trên* `s`.*

A shift on `s` consists of moving the leftmost character of `s` to the rightmost position.
*Một lần dịch chuyển trên `s` bao gồm việc di chuyển ký tự ngoài cùng bên trái của `s` sang vị trí ngoài cùng bên phải.*

*   For example, if `s = "abcde"`, then it will be `"bcdea"` after one shift.
*   *Ví dụ, nếu `s = "abcde"`, thì nó sẽ là `"bcdea"` sau một lần dịch chuyển.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** s = "abcde", goal = "cdeab"
**Output:** true

## Example 2:
## *Ví dụ 2:*

**Input:** s = "abcde", goal = "abced"
**Output:** false

---

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length, goal.length <= 100`
*   `s` and `goal` consist of lowercase English letters.
