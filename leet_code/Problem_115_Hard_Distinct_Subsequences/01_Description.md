# Result for Distinct Subsequences
# *Kết quả cho bài toán Các Chuỗi Con Phân Biệt*

## Description
## *Mô tả*

Given two strings `s` and `t`, return *the number of distinct **subsequences** of `s` which equals `t`*.
*Cho hai chuỗi `s` và `t`, hãy trả về *số lượng các **chuỗi con** phân biệt của `s` mà bằng `t`**.*

The test cases are generated so that the answer fits in a 32-bit signed integer.
*Các trường hợp kiểm thử được tạo ra sao cho câu trả lời khớp với một số nguyên có dấu 32-bit.*

## Example 1:
## *Ví dụ 1:*

**Input:** `s = "rabbbit", t = "rabbit"`
**Output:** `3`
**Explanation:**
As shown below, there are 3 ways you can generate "rabbit" from `s`.
`rabbbit`
`rabbbit`
`rabbbit`

## Example 2:
## *Ví dụ 2:*

**Input:** `s = "babgbag", t = "bag"`
**Output:** `5`
**Explanation:**
There are 5 ways you can generate "bag" from `s`.
`babgbag`
`babgbag`
`babgbag`
`babgbag`
`babgbag`

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length, t.length <= 1000`
*   `s` and `t` consist of English letters.
