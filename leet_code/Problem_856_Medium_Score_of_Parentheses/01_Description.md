# Result for Score of Parentheses
# *Kết quả cho bài toán Điểm của Dấu ngoặc*

## Description
## *Mô tả*

Given a balanced parentheses string `s`, return the **score** of the string.
*Cho một chuỗi dấu ngoặc cân bằng `s`, hãy trả về **điểm** của chuỗi đó.*

The score of a balanced parentheses string is based on the following rules:
*Điểm của một chuỗi dấu ngoặc cân bằng được dựa trên các quy tắc sau:*

- `()` has score `1`.
- `AB` has score `A + B`, where `A` and `B` are balanced parentheses strings.
- `(A)` has score `2 * A`, where `A` is a balanced parentheses string.

---

## Example 1:
## *Ví dụ 1:*

**Input:** s = "()"
**Output:** 1

## Example 2:
## *Ví dụ 2:*

**Input:** s = "(())"
**Output:** 2

## Example 3:
## *Ví dụ 3:*

**Input:** s = "()()"
**Output:** 2

---

## Constraints:
## *Ràng buộc:*

*   `2 <= s.length <= 50`
*   `s` consists of only `'('` and `')'`.
*   `s` is a balanced parentheses string.
