# Result for Word Pattern
# *Kết quả cho bài toán Mẫu Từ*

## Description
## *Mô tả*

Given a `pattern` and a string `s`, find if `s` follows the same pattern.
*Cho một `pattern` và một chuỗi `s`, hãy tìm xem `s` có tuân theo cùng một mẫu hay không.*

Here **follow** means a full match, such that there is a bijection between a letter in `pattern` and a **non-empty** word in `s`.
*Ở đây **tuân theo** có nghĩa là khớp hoàn toàn, sao cho có một song ánh giữa một chữ cái trong `pattern` và một từ **không rỗng** trong `s`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `pattern = "abba", s = "dog cat cat dog"`
**Output:** `true`

## Example 2:
## *Ví dụ 2:*

**Input:** `pattern = "abba", s = "dog cat cat fish"`
**Output:** `false`

## Example 3:
## *Ví dụ 3:*

**Input:** `pattern = "aaaa", s = "dog cat cat dog"`
**Output:** `false`

## Constraints:
## *Ràng buộc:*

*   `1 <= pattern.length <= 300`
*   `pattern` contains only lower-case English letters.
*   `1 <= s.length <= 3000`
*   `s` contains only lowercase English letters and spaces `' '`.
*   `s` does not contain any leading or trailing spaces.
*   All the words in `s` are separated by a single space.
