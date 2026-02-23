# Result for Count Different Palindromic Subsequences
# *Kết quả cho bài toán Đếm các Dãy con Đối xứng khác nhau*

## Description
## *Mô tả*

Given a string `s`, return the number of different non-empty palindromic subsequences in `s`. Since the answer may be very large, return it **modulo 10^9 + 7**.
*Cho một chuỗi `s`, hãy trả về số lượng các dãy con đối xứng khác nhau, không rỗng trong `s`. Vì kết quả có thể rất lớn, hãy trả về kết quả theo **modulo 10^9 + 7**.*

A subsequence of a string is obtained by deleting zero or more characters from the string.
*Một dãy con của một chuỗi thu được bằng cách xóa đi không hoặc nhiều ký tự của chuỗi đó.*

A sequence is palindromic if it is the same whether read forwards or backwards.
*Một dãy được gọi là đối xứng (palindromic) nếu nó giống nhau khi đọc từ trái sang phải hoặc từ phải sang trái.*

Two sequences are different if there is some `i` for which the $i^{th}$ characters are different.
*Hai dãy con được gọi là khác nhau nếu tồn tại một vị trí `i` mà tại đó các ký tự thứ `i` khác nhau.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** s = "bccb"
**Output:** 6
**Explanation:** The 6 different non-empty palindromic subsequences are 'b', 'c', 'bb', 'cc', 'bcb', 'bccb'.
Note that 'bcb' is formed using indices (0, 1, 3) or (0, 2, 3), but it counts as one because the resulting strings are the same.

## Example 2:
## *Ví dụ 2:*

**Input:** s = "abcdabcdabcdabcdabcdabcdabcdabcddcba"
**Output:** 104860361
**Explanation:** There are 3104860382 different non-empty palindromic subsequences, which is 104860361 modulo 10^9 + 7.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 1000`
*   `s` consists of lowercase English letters 'a', 'b', 'c', and 'd'.
