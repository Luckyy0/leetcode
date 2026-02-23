# Result for Valid Number
# *Kết quả cho bài toán Số Hợp Lệ*

## Description
## *Mô tả*

A **valid number** can be split up into these components (in order):
1.  A **decimal number** or an **integer**.
2.  (Optional) An **exponent part** (starts with 'e' or 'E', followed by an **integer**).

An **integer** can be split up into these components (in order):
1.  (Optional) A sign character (either '+' or '-').
2.  One or more digits.

A **decimal number** can be split up into these components (in order):
1.  (Optional) A sign character (either '+' or '-').
2.  One of the following formats:
    *   One or more digits, followed by a dot '.'.
    *   One or more digits, followed by a dot '.', followed by one or more digits.
    *   A dot '.', followed by one or more digits.

For example, all the following are valid numbers: `["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"]`, while the following are not valid numbers: `["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"]`.

Given a string `s`, return `true` if `s` is a **valid number**.
*Cho một chuỗi `s`, trả về `true` nếu `s` là một **số hợp lệ**.*

## Example 1:
## *Ví dụ 1:*

**Input:** `s = "0"`
**Output:** `true`

## Example 2:
## *Ví dụ 2:*

**Input:** `s = "e"`
**Output:** `false`

## Example 3:
## *Ví dụ 3:*

**Input:** `s = "."`
**Output:** `false`

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 20`
*   `s` consists of only English letters (upper and lower case), digits (`0-9`), plus `'+'`, minus `'-'`, or dot `'.'`.
