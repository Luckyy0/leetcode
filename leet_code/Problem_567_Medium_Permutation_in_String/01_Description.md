# Result for Permutation in String
# *Kết quả cho bài toán Hoán vị trong Chuỗi*

## Description
## *Mô tả*

Given two strings `s1` and `s2`, return `true` *if* `s2` *contains a permutation of* `s1`*, or* `false` *otherwise*.
*Cho hai chuỗi `s1` và `s2`, hãy trả về `true` *nếu* `s2` *chứa một hoán vị của* `s1`*, ngược lại trả về* `false`*.*

In other words, return `true` if one of `s1`'s permutations is the substring of `s2`.
*Nói cách khác, trả về `true` nếu một trong các hoán vị của `s1` là chuỗi con của `s2`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `s1 = "ab", s2 = "eidbaooo"`
**Output:** `true`
**Explanation:** s2 contains one permutation of s1 ("ba").

## Example 2:
## *Ví dụ 2:*

**Input:** `s1 = "ab", s2 = "eidboaoo"`
**Output:** `false`

## Constraints:
## *Ràng buộc:*

*   `1 <= s1.length, s2.length <= 10^4`
*   `s1` and `s2` consist of lowercase English letters.
