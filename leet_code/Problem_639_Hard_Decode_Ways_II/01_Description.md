# Result for Decode Ways II
# *Kết quả cho bài toán Giải mã Cách II*

## Description
## *Mô tả*

A message containing letters from `A-Z` can be encoded into numbers using the following mapping:
*Một thông báo chứa các chữ cái từ `A-Z` có thể được mã hóa thành các con số bằng cách sử dụng ánh xạ sau:*
`'A' -> "1"`, `'B' -> "2"`, ..., `'Z' -> "26"`

To **decode** an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, `"11106"` can be mapped into:
*Để **giải mã** một tin nhắn đã mã hóa, tất cả các chữ số phải được nhóm lại sau đó được ánh xạ ngược lại thành các chữ cái (có thể có nhiều cách). Ví dụ: `"11106"` có thể được ánh xạ thành:*
- `"AAJF"` with the grouping `(1 1 10 6)`
- `"KJF"` with the grouping `(11 10 6)`

Note that the grouping `(1 11 0 6)` is invalid because `"06"` cannot be mapped into `'F'` since `"6"` is different from `"06"`.
*Lưu ý rằng việc nhóm `(1 11 0 6)` là không hợp lệ vì `"06"` không thể được ánh xạ thành `'F'` vì `"6"` khác với `"06"`.*

In addition to the digits, the encoded message can also contain the `'*'` character, which can be treated as one of the digits from `'1'` to `'9'`.
*Ngoài các chữ số, thông báo được mã hóa cũng có thể chứa ký tự `'*'`, ký tự này có thể được coi là một trong các chữ số từ `'1'` đến `'9'`.*

Given a string `s` containing digits and `'*'` characters, return the number of ways to **decode** it. Since the answer may be very large, return it **modulo** `10^9 + 7`.
*Cho một chuỗi `s` chứa các chữ số và ký tự `'*'`, hãy trả về số lượng cách để **giải mã** nó. Vì câu trả lời có thể rất lớn, hãy trả về kết quả theo **modulo** `10^9 + 7`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** s = "*"
**Output:** 9
**Explanation:** The encoded message can be "1", "2", "3", "4", "5", "6", "7", "8", or "9".
Each of these can be decoded to the strings "A", "B", "C", "D", "E", "F", "G", "H", and "I" respectively.
Hence, there are 9 ways to decode "*".

## Example 2:
## *Ví dụ 2:*

**Input:** s = "1*"
**Output:** 18
**Explanation:** The encoded message can be "11", "12", "13", "14", "15", "16", "17", "18", or "19".
Each of these can be decoded to "K", "L", "M", "N", "O", "P", "Q", "R", and "S" respectively.
Additionally, "1*" can be decoded as "1" followed by "*". There are 9 ways for this.
So total = 9 + 9 = 18.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 10^5`
*   `s[i]` is a digit or `'*'`.
