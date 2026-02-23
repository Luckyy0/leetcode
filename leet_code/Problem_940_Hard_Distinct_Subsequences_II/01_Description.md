# Result for Distinct Subsequences II
# *Kết quả cho bài toán Chuỗi con Riêng biệt II*

## Description
## *Mô tả*

Given a string `s`, return *the number of **distinct non-empty subsequences** of `s`*. Since the answer may be very large, return it **modulo** `10^9 + 7`.
*Cho một chuỗi `s`, trả về *số lượng **chuỗi con không rỗng riêng biệt** của `s`*. Vì câu trả lời có thể rất lớn, hãy trả về câu trả lời **modulo** `10^9 + 7`.*

A **subsequence** of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., `"ace"` is a subsequence of `"abcde"` while `"aec"` is not).
*Một **chuỗi con** của một chuỗi là một chuỗi mới được tạo thành từ chuỗi ban đầu bằng cách xóa một số (có thể không có) các ký tự mà không làm thay đổi vị trí tương đối của các ký tự còn lại. (Tức là, `"ace"` là một chuỗi con của `"abcde"` trong khi `"aec"` thì không).*

---

## Example 1:
## *Ví dụ 1:*

**Input:** s = "abc"
**Output:** 7
**Explanation:** The 7 distinct subsequences are "a", "b", "c", "ab", "ac", "bc", "abc".

## Example 2:
## *Ví dụ 2:*

**Input:** s = "aba"
**Output:** 6
**Explanation:** The 6 distinct subsequences are "a", "b", "ab", "aa", "ba", "aba".

## Example 3:
## *Ví dụ 3:*

**Input:** s = "aaa"
**Output:** 3
**Explanation:** The 3 distinct subsequences are "a", "aa", "aaa".

---

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 2000`
*   `s` consists of lowercase English letters.
