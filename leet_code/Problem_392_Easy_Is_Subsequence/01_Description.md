# Result for Is Subsequence
# *Kết quả cho bài toán Chuỗi con*

## Description
## *Mô tả*

Given two strings `s` and `t`, return `true` if `s` is a **subsequence** of `t`, or `false` otherwise.
*Cho hai chuỗi `s` và `t`, hãy trả về `true` nếu `s` là một **chuỗi con** của `t`, ngược lại trả về `false`.*

A **subsequence** of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., `"ace"` is a subsequence of `"abcde"` while `"aec"` is not).
*Một **chuỗi con** của một chuỗi là một chuỗi mới được tạo thành từ chuỗi ban đầu bằng cách xóa một số (có thể không xóa) ký tự mà không làm xáo trộn vị trí tương đối của các ký tự còn lại. (ví dụ: `"ace"` là chuỗi con của `"abcde"` trong khi `"aec"` thì không).*

## Example 1:
## *Ví dụ 1:*

**Input:** `s = "abc", t = "ahbgdc"`
**Output:** `true`

## Example 2:
## *Ví dụ 2:*

**Input:** `s = "axc", t = "ahbgdc"`
**Output:** `false`

## Constraints:
## *Ràng buộc:*

*   `0 <= s.length <= 100`
*   `0 <= t.length <= 10^4`
*   `s` and `t` consist only of lowercase English letters.

**Follow up:** Suppose there are lots of incoming `s`, say `s1, s2, ..., sk` where `k >= 10^9`, and you want to check one by one to see if `t` has its subsequence. In this scenario, how would you change your code?
*   *Gợi ý: Giả sử có rất nhiều chuỗi `s` đến, ví dụ `s1, s2, ..., sk` trong đó `k >= 10^9`, và bạn muốn kiểm tra từng chuỗi xem `t` có chứa chuỗi con đó hay không. Trong trường hợp này, bạn sẽ thay đổi mã của mình như thế nào?*
*(Note: Binary search on indices is the common follow-up).*
