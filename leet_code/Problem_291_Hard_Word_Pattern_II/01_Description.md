# Result for Word Pattern II
# *Kết quả cho bài toán Mẫu Từ II*

## Description
## *Mô tả*

Given a `pattern` and a string `s`, return `true` *if* `s` *matches the* `pattern`.
*Cho một `pattern` và một chuỗi `s`, trả về `true` *nếu* `s` *khớp với* `pattern`.*

This is a **full match**, where there is a bijection between a letter in `pattern` and a **non-empty** substring in `s`.
*Đây là một **sự khớp hoàn toàn**, trong đó có một song ánh giữa một chữ cái trong `pattern` và một chuỗi con **không rỗng** trong `s`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `pattern = "abab", s = "redblueredblue"`
**Output:** `true`
**Explanation:** One possible mapping is as follows:
'a' -> "red"
'b' -> "blue"

## Example 2:
## *Ví dụ 2:*

**Input:** `pattern = "aaaa", s = "asdasdasdasd"`
**Output:** `true`
**Explanation:** One possible mapping is as follows:
'a' -> "asd"

## Example 3:
## *Ví dụ 3:*

**Input:** `pattern = "aabb", s = "xyzabcxzyabc"`
**Output:** `false`

## Constraints:
## *Ràng buộc:*

*   `1 <= pattern.length, s.length <= 20`
*   `pattern` and `s` consist of only lowercase English letters.
