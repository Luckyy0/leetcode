# Result for Longest Uncommon Subsequence I
# *Kết quả cho bài toán Dãy con Không chung Dài nhất I*

## Description
## *Mô tả*

Given two strings `a` and `b`, return *the length of the **longest uncommon subsequence** between* `a` *and* `b`. If the longest uncommon subsequence does not exist, return `-1`.
*Cho hai chuỗi `a` và `b`, hãy trả về *độ dài của **dãy con không chung dài nhất** giữa* `a` *và* `b`. Nếu dãy con không chung dài nhất không tồn tại, trả về `-1`.*

An **uncommon subsequence** between two strings is a string that is a **subsequence of one but not the other**.
*Một **dãy con không chung** giữa hai chuỗi là một chuỗi là **dãy con của một trong hai chuỗi nhưng không phải của chuỗi kia**.*

A **subsequence** of a string `s` is a string that can be obtained after deleting any number of characters from `s`.
*Một **dãy con** của chuỗi `s` là một chuỗi có thể thu được sau khi xóa bất kỳ số lượng ký tự nào từ `s`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `a = "aba", b = "cdc"`
**Output:** `3`
**Explanation:** One longest uncommon subsequence is "aba" because "aba" is a subsequence of "aba" but not "cdc".
Note that "cdc" is also a longest uncommon subsequence.

## Example 2:
## *Ví dụ 2:*

**Input:** `a = "aaa", b = "bbb"`
**Output:** `3`
**Explanation:** The longest uncommon subsequences are "aaa" and "bbb".

## Example 3:
## *Ví dụ 3:*

**Input:** `a = "aaa", b = "aaa"`
**Output:** `-1`
**Explanation:** Every subsequence of string a is also a subsequence of string b. Similarly, every subsequence of string b is also a subsequence of string a.

## Constraints:
## *Ràng buộc:*

*   `1 <= a.length, b.length <= 100`
*   `a` and `b` consist of lower-case English letters.
