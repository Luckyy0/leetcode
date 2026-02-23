# Result for Decode Ways
# *Kết quả cho bài toán Cách Giải Mã*

## Description
## *Mô tả*

A message containing letters from `A-Z` can be **encoded** into numbers using the following mapping:
*Một thông điệp chứa các chữ cái từ `A-Z` có thể được **mã hóa** thành các số bằng cách sử dụng ánh xạ sau:*

```
'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
```

To **decode** an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, `"11106"` can be mapped into:
*Để **giải mã** một thông điệp đã mã hóa, tất cả các chữ số phải được nhóm lại rồi ánh xạ ngược lại thành các chữ cái bằng ánh xạ ngược của ánh xạ trên (có thể có nhiều cách). Ví dụ, `"11106"` có thể được ánh xạ thành:*

*   `"AAJF"` with the grouping `(1 1 10 6)`
*   `"KJF"` with the grouping `(11 10 6)`

Note that the grouping `(1 11 06)` is invalid because `"06"` cannot be mapped into `'F'` since `"6"` is different from `"06"`.
*Lưu ý rằng cách nhóm `(1 11 06)` là không hợp lệ vì `"06"` không thể được ánh xạ thành `'F'` do `"6"` khác với `"06"`.*

Given a string `s` containing only digits, return *the **number** of ways to **decode** it*.
*Cho một chuỗi `s` chỉ chứa các chữ số, hãy trả về *số** cách để **giải mã** nó**.*

The test cases are generated so that the answer fits in a **32-bit** integer.
*Các trường hợp kiểm thử được tạo ra sao cho câu trả lời khớp với một số nguyên **32-bit**.*

## Example 1:
## *Ví dụ 1:*

**Input:** `s = "12"`
**Output:** `2`
**Explanation:** "12" could be decoded as "AB" (1 2) or "L" (12).

## Example 2:
## *Ví dụ 2:*

**Input:** `s = "226"`
**Output:** `3`
**Explanation:** "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

## Example 3:
## *Ví dụ 3:*

**Input:** `s = "06"`
**Output:** `0`
**Explanation:** "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 100`
*   `s` contains only digits and may contain leading zero(s).
