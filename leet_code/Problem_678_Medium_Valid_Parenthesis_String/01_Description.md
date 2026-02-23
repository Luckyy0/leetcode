# Result for Valid Parenthesis String
# *Kết quả cho bài toán Chuỗi Ngoặc Hợp lệ*

## Description
## *Mô tả*

Given a string `s` containing only three types of characters: `'('`, `')'` and `'*'`, return `true` if `s` is **valid**.
*Cho một chuỗi `s` chỉ chứa ba loại ký tự: `'('`, `')'` và `'*'`, hãy trả về `true` nếu `s` là **hợp lệ**.*

The following rules define a **valid** string:
*Các quy tắc sau đây định nghĩa một chuỗi **hợp lệ**:*

1.  Any left parenthesis `'('` must have a corresponding right parenthesis `')'`.
    *   *Bất kỳ dấu ngoặc trái `'('` nào cũng phải có một dấu ngoặc phải `')'` tương ứng.*
2.  Any right parenthesis `')'` must have a corresponding left parenthesis `'('`.
    *   *Bất kỳ dấu ngoặc phải `')'` nào cũng phải có một dấu ngoặc trái `'('` tương ứng.*
3.  Left parenthesis `'('` must go before the corresponding right parenthesis `')'`.
    *   *Dấu ngoặc trái `'('` phải đứng trước dấu ngoặc phải `')'` tương ứng.*
4.  `'*'` could be treated as a single right parenthesis `')'` or a single left parenthesis `'('` or an empty string `""`.
    *   *`'*'` có thể được coi là một dấu ngoặc phải `')'`, hoặc một dấu ngoặc trái `'('`, hoặc một chuỗi rỗng `""`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** s = "()"
**Output:** true

## Example 2:
## *Ví dụ 2:*

**Input:** s = "(*)"
**Output:** true

## Example 3:
## *Ví dụ 3:*

**Input:** s = "(*))"
**Output:** true

---

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 100`
*   `s[i]` is `'('`, `')'` or `'*'`.
