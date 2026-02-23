# Result for Rearrange String k Distance Apart
# *Kết quả cho bài toán Sắp xếp lại Chuỗi cách nhau khoảng k*

## Description
## *Mô tả*

Given a string `s` and an integer `k`, rearrange `s` such that the same characters are at least distance `k` from each other. If it is not possible to rearrange the string, return an empty string `""`.
*Cho một chuỗi `s` và một số nguyên `k`, hãy sắp xếp lại `s` sao cho những ký tự giống nhau cách nhau ít nhất một khoảng `k`. Nếu không thể sắp xếp lại chuỗi, hãy trả về một chuỗi rỗng `""`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `s = "aabbcc", k = 3`
**Output:** `"abcabc"`
**Explanation:** The same characters are at least distance 3 from each other.

## Example 2:
## *Ví dụ 2:*

**Input:** `s = "aaabc", k = 3`
**Output:** `""`
**Explanation:** It is not possible to rearrange the string.

## Example 3:
## *Ví dụ 3:*

**Input:** `s = "aaadbbcc", k = 2`
**Output:** `"abacabcd"`
**Explanation:** The same characters are at least distance 2 from each other.

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 3 * 10^5`
*   `0 <= k <= s.length`
*   `s` consists of only lowercase English letters.
