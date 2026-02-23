# Result for Number of Matching Subsequences
# *Kết quả cho bài toán Số lượng Chuỗi con Khớp*

## Description
## *Mô tả*

Given a string `s` and an array of strings `words`, return *the number of* `words[i]` *that is a subsequence of* `s`.
*Cho một chuỗi `s` và một mảng các chuỗi `words`, trả về *số lượng* `words[i]` *là một chuỗi con của* `s`.*

A **subsequence** of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
*Một **chuỗi con** của một chuỗi là một chuỗi mới được tạo ra từ chuỗi ban đầu với một số ký tự (có thể không có ký tự nào) bị xóa mà không làm thay đổi thứ tự tương đối của các ký tự còn lại.*

*   For example, `"ace"` is a subsequence of `"abcde"`.
*   *Ví dụ, `"ace"` là một chuỗi con của `"abcde"`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** s = "abcde", words = ["a","bb","acd","ace"]
**Output:** 3
**Explanation:** There are three strings in words that are a subsequence of s: "a", "acd", "ace".

## Example 2:
## *Ví dụ 2:*

**Input:** s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
**Output:** 2

---

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 5 * 10^4`
*   `1 <= words.length <= 5000`
*   `1 <= words[i].length <= 50`
*   `s` and `words[i]` consist of only lowercase English letters.
