# Result for Wildcard Matching
# *Kết quả cho bài toán Khớp Chuỗi Ký Tự Đại Diện*

## Description
## *Mô tả*

Given an input string (`s`) and a pattern (`p`), implement wildcard pattern matching with support for `'?'` and `'*'`.
*Cho một chuỗi đầu vào (`s`) và một mẫu (`p`), hãy triển khai khớp mẫu ký tự đại diện với sự hỗ trợ cho `'?'` và `'*'`.

*   `'?'` Matches any single character.
    *`'?'` Khớp với bất kỳ ký tự đơn nào.*
*   `'*'` Matches any sequence of characters (including the empty sequence).
    *`'*'` Khớp với bất kỳ chuỗi ký tự nào (bao gồm cả chuỗi rỗng).*

The matching should cover the **entire** input string (not partial).
*Việc khớp phải bao phủ **toàn bộ** chuỗi đầu vào (không phải một phần).*

## Example 1:
## *Ví dụ 1:*

**Input:** `s = "aa"`, `p = "a"`
**Output:** `false`
**Explanation:** "a" does not match the entire string "aa".

## Example 2:
## *Ví dụ 2:*

**Input:** `s = "aa"`, `p = "*"`
**Output:** `true`
**Explanation:** '*' matches any sequence.

## Example 3:
## *Ví dụ 3:*

**Input:** `s = "cb"`, `p = "?a"`
**Output:** `false`
**Explanation:** '?' matches 'c', but the second letter is 'a', which does not match 'b'.

## Constraints:
## *Ràng buộc:*

*   `0 <= s.length, p.length <= 2000`
*   `s` contains only lowercase English letters.
*   `p` contains only lowercase English letters, `'?'` or `'*'`.
