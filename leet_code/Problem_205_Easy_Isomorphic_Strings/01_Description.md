# Result for Isomorphic Strings
# *Kết quả cho bài toán Chuỗi đẳng cấu*

## Description
## *Mô tả*

Given two strings `s` and `t`, determine if they are isomorphic.
*Cho hai chuỗi `s` và `t`, hãy xác định xem chúng có đẳng cấu hay không.*

Two strings `s` and `t` are isomorphic if the characters in `s` can be replaced to get `t`.
*Hai chuỗi `s` và `t` là đẳng cấu nếu các ký tự trong `s` có thể được thay thế để tạo thành `t`.*

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
*Tất cả các lần xuất hiện của một ký tự phải được thay thế bằng một ký tự khác trong khi vẫn giữ nguyên thứ tự của các ký tự. Không được có hai ký tự nào ánh xạ tới cùng một ký tự, nhưng một ký tự có thể ánh xạ tới chính nó.*

## Example 1:
## *Ví dụ 1:*

**Input:** `s = "egg", t = "add"`
**Output:** `true`

## Example 2:
## *Ví dụ 2:*

**Input:** `s = "foo", t = "bar"`
**Output:** `false`

## Example 3:
## *Ví dụ 3:*

**Input:** `s = "paper", t = "title"`
**Output:** `true`

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 5 * 10^4`
*   `t.length == s.length`
*   `s` and `t` consist of any valid ascii character.
