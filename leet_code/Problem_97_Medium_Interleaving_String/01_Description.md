# Result for Interleaving String
# *Kết quả cho bài toán Chuỗi Xen Kẽ*

## Description
## *Mô tả*

Given strings `s1`, `s2`, and `s3`, find whether `s3` is formed by an **interleaving** of `s1` and `s2`.
*Cho các chuỗi `s1`, `s2` và `s3`, hãy tìm xem `s3` có được tạo thành bởi sự **xen kẽ** của `s1` và `s2` hay không.*

An **interleaving** of two strings `s` and `t` is a configuration where they are divided into **non-empty** substrings such that:
*Sự **xen kẽ** của hai chuỗi `s` và `t` là một cấu hình mà chúng được chia thành các chuỗi con **không trống** sao cho:*

*   `s = s1 + s2 + ... + sn`
*   `t = t1 + t2 + ... + tm`
*   |n - m| <= 1
*   The **interleaving** is `s1 + t1 + s2 + t2 + s3 + t3 + ...` or `t1 + s1 + t2 + s2 + t3 + s3 + ...`

**Note:** `a + b` is the concatenation of strings `a` and `b`.
*Lưu ý: `a + b` là sự nối các chuỗi `a` và `b`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"`
**Output:** `true`

## Example 2:
## *Ví dụ 2:*

**Input:** `s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"`
**Output:** `false`

## Example 3:
## *Ví dụ 3:*

**Input:** `s1 = "", s2 = "", s3 = ""`
**Output:** `true`

## Constraints:
## *Ràng buộc:*

*   `0 <= s1.length, s2.length <= 100`
*   `0 <= s3.length <= 200`
*   `s1`, `s2`, and `s3` consist of lowercase English letters.

## Follow up:
*   Could you solve it using only $O(s2.length)$ additional memory space?
