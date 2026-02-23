# Result for Longest Substring with At Least K Repeating Characters
# *Kết quả cho bài toán Chuỗi con Dài nhất có Ít nhất K Ký tự Lặp lại*

## Description
## *Mô tả*

Given a string `s` and an integer `k`, return *the length of the longest substring of `s` such that the frequency of each character in this substring is greater than or equal to `k`*.
*Cho một chuỗi `s` và một số nguyên `k`, hãy trả về *độ dài của chuỗi con dài nhất của `s` sao cho tần suất của mỗi ký tự trong chuỗi con này lớn hơn hoặc bằng `k`*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `s = "aaabb", k = 3`
**Output:** `3`
**Explanation:** The longest substring is "aaa", as 'a' is repeated 3 times.

## Example 2:
## *Ví dụ 2:*

**Input:** `s = "ababbc", k = 2`
**Output:** `5`
**Explanation:** The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 10^4`
*   `s` consists of only lowercase English letters.
*   `1 <= k <= 10^5`
