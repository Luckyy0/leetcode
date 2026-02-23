# Result for Regular Expression Matching
# *Kết quả cho bài toán Khớp Biểu Thức Chính Quy*

## Description
## *Mô tả*

Given an input string `s` and a pattern `p`, implement regular expression matching with support for `'.'` and `'*'`.
*Cho một chuỗi đầu vào `s` và một mẫu `p`, hãy triển khai khớp biểu thức chính quy với sự hỗ trợ cho `'.'` và `'*'`.

*   `'.'` Matches any single character.
    *`'.'` Khớp với bất kỳ ký tự đơn nào.*
*   `'*'` Matches zero or more of the preceding element.
    *`'*'` Khớp với không hoặc nhiều phần tử đứng trước nó.*

The matching should cover the **entire** input string (not partial).
*Việc khớp phải bao phủ **toàn bộ** chuỗi đầu vào (không phải một phần).*

## Example 1:
## *Ví dụ 1:*

**Input:** `s = "aa"`, `p = "a"`
**Output:** `false`
**Explanation:** "a" does not match the entire string "aa".
***Giải thích:** "a" không khớp với toàn bộ chuỗi "aa".*

## Example 2:
## *Ví dụ 2:*

**Input:** `s = "aa"`, `p = "a*"`
**Output:** `true`
**Explanation:** '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
***Giải thích:** '*' có nghĩa là không hoặc nhiều phần tử đứng trước nó, 'a'. Do đó, bằng cách lặp lại 'a' một lần, nó trở thành "aa".*

## Example 3:
## *Ví dụ 3:*

**Input:** `s = "ab"`, `p = ".*"`
**Output:** `true`
**Explanation:** ".*" means "zero or more (*) of any character (.)".
***Giải thích:** ".*" có nghĩa là "không hoặc nhiều (*) ký tự bất kỳ (.)".*

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 20`
*   `1 <= p.length <= 20`
*   `s` contains only lowercase English letters.
*   `p` contains only lowercase English letters, `'.'`, and `'*'`.
*   It is guaranteed for each appearance of the character `*`, there will be a previous valid character to match.
    *Đảm bảo rằng mỗi lần xuất hiện của ký tự `*`, sẽ có một ký tự hợp lệ trước đó để khớp.*
