# Result for Valid Parentheses
# *Kết quả cho bài toán Ngoặc Hợp Lệ*

## Description
## *Mô tả*

Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.
*Cho một chuỗi `s` chỉ chứa các ký tự `'('`, `')'`, `'{'`, `'}'`, `'['` và `']'`, hãy xác định xem chuỗi đầu vào có hợp lệ hay không.*

An input string is valid if:
*Một chuỗi đầu vào là hợp lệ nếu:*

1.  Open brackets must be closed by the same type of brackets.
    *Các dấu ngoặc mở phải được đóng bởi cùng loại dấu ngoặc.*
2.  Open brackets must be closed in the correct order.
    *Các dấu ngoặc mở phải được đóng theo đúng thứ tự.*
3.  Every close bracket has a corresponding open bracket of the same type.
    *Mọi dấu ngoặc đóng đều có một dấu ngoặc mở tương ứng cùng loại.*

## Example 1:
## *Ví dụ 1:*

**Input:** `s = "()"`
**Output:** `true`

## Example 2:
## *Ví dụ 2:*

**Input:** `s = "()[]{}"`
**Output:** `true`

## Example 3:
## *Ví dụ 3:*

**Input:** `s = "(]"`
**Output:** `false`

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 10^4`
*   `s` consists of parentheses only `'()[]{}'`.
