# Result for Repeated String Match
# *Kết quả cho bài toán Khớp Chuỗi lặp lại*

## Description
## *Mô tả*

Given two strings `a` and `b`, return the minimum number of times `a` has to be repeated such that `b` is a substring of it. If it is impossible for `b` to be a substring of `a` after repeating it, return `-1`.
*Cho hai chuỗi `a` và `b`, hãy trả về số lần tối thiểu `a` phải lặp lại sao cho `b` là một chuỗi con của nó. Nếu không thể để `b` trở thành chuỗi con của `a` sau khi lặp lại, hãy trả về `-1`.*

**Notice:** string `"abc"` repeated 0 times is `""`, repeated 1 time is `"abc"` and repeated 2 times is `"abcabc"`.
*Lưu ý: chuỗi `"abc"` lặp lại 0 lần là `""`, lặp lại 1 lần là `"abc"` và lặp lại 2 lần là `"abcabc"`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** a = "abcd", b = "cdabcdab"
**Output:** 3
**Explanation:** After repeating a three times, we get "abcdabcdabcd", which contains b as a substring.

## Example 2:
## *Ví dụ 2:*

**Input:** a = "a", b = "aa"
**Output:** 2

---

## Constraints:
## *Ràng buộc:*

*   `1 <= a.length, b.length <= 10^4`
*   `a` and `b` consist of lowercase English letters.
