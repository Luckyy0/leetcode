# Result for Longest Valid Parentheses
# *Kết quả cho bài toán Chuỗi Ngoặc Hợp Lệ Dài Nhất*

## Description
## *Mô tả*

Given a string containing just the characters `'('` and `')'`, return the length of the longest valid (well-formed) parentheses substring.
*Cho một chuỗi chỉ chứa các ký tự `'('` và `')'`, trả về độ dài của chuỗi con ngoặc hợp lệ dài nhất.*

## Example 1:
## *Ví dụ 1:*

**Input:** `s = "(()"`
**Output:** `2`
**Explanation:** The longest valid parentheses substring is "()".
***Giải thích:** Chuỗi con ngoặc hợp lệ dài nhất là "()".*

## Example 2:
## *Ví dụ 2:*

**Input:** `s = ")()())"`
**Output:** `4`
**Explanation:** The longest valid parentheses substring is "()()".
***Giải thích:** Chuỗi con ngoặc hợp lệ dài nhất là "()()".*

## Example 3:
## *Ví dụ 3:*

**Input:** `s = ""`
**Output:** `0`

## Constraints:
## *Ràng buộc:*

*   `0 <= s.length <= 3 * 10^4`
*   `s[i]` is `'('`, or `')'`.
