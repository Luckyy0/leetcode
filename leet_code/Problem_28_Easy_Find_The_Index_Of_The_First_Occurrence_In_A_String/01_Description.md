# Result for Find the Index of the First Occurrence in a String
# *Kết quả cho bài toán Tìm Chỉ Số Của Lần Xuất Hiện Đầu Tiên trong Chuỗi*

## Description
## *Mô tả*

Given two strings `haystack` and `needle`, return the index of the first occurrence of `needle` in `haystack`, or `-1` if `needle` is not part of `haystack`.
*Cho hai chuỗi `haystack` và `needle`, trả về chỉ số của lần xuất hiện đầu tiên của `needle` trong `haystack`, hoặc `-1` nếu `needle` không phải là một phần của `haystack`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `haystack = "sadbutsad"`, `needle = "sad"`
**Output:** `0`
**Explanation:** "sad" occurs at index 0 and 6. The first occurrence is at index 0, so we return 0.
***Giải thích:** "sad" xuất hiện tại chỉ số 0 và 6. Lần xuất hiện đầu tiên là tại chỉ số 0, vì vậy chúng ta trả về 0.*

## Example 2:
## *Ví dụ 2:*

**Input:** `haystack = "leetcode"`, `needle = "leeto"`
**Output:** `-1`
**Explanation:** "leeto" did not occur in "leetcode", so we return -1.
***Giải thích:** "leeto" không xuất hiện trong "leetcode", vì vậy chúng ta trả về -1.*

## Constraints:
## *Ràng buộc:*

*   `1 <= haystack.length, needle.length <= 10^4`
*   `haystack` and `needle` consist of only lowercase English characters.
    *`haystack` và `needle` chỉ bao gồm các ký tự tiếng Anh chữ thường.*
