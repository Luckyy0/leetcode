# Result for Count Unique Characters of All Substrings of a Given String
# *Kết quả cho bài toán Đếm các ký tự duy nhất của tất cả các chuỗi con của một chuỗi cho trước*

## Description
## *Mô tả*

Let's define a function `countUniqueChars(s)` that returns the number of unique characters in `s`.
*Hãy định nghĩa hàm `countUniqueChars(s)` trả về số lượng các ký tự duy nhất trong `s`.*

*   For example, calling `countUniqueChars("LEETCODE")` returns `5` because characters `'L'`, `'T'`, `'C'`, `'O'`, `'D'` are unique, while 'E' and 'E' are not unique since they appear multiple times.
*   *Ví dụ, gọi `countUniqueChars("LEETCODE")` trả về `5` vì các ký tự 'L', 'T', 'C', 'O', 'D' là duy nhất.*

Given a string `s`, return *the sum of `countUniqueChars(t)` where `t` is every substring of `s`*. Since the answer can be very large, return the answer **modulo** `10^9 + 7`.
*Cho một chuỗi `s`, trả về *tổng của `countUniqueChars(t)` trong đó `t` là mọi chuỗi con của `s`*. Vì câu trả lời có thể rất lớn, hãy trả về kết quả theo **modulo** `10^9 + 7`.*

Notice that some substrings can be repeated so on this case you have to count them separately.
*Lưu ý rằng một số chuỗi con có thể lặp lại, trong trường hợp đó bạn phải đếm chúng một cách riêng biệt.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** s = "ABC"
**Output:** 10
**Explanation:** All possible substrings are: "A","B","C","AB","BC" and "ABC".
Every substring is composed with only unique letters.
Sum of lengths is 1 + 1 + 1 + 2 + 2 + 3 = 10

## Example 2:
## *Ví dụ 2:*

**Input:** s = "ABA"
**Output:** 8
**Explanation:** All possible substrings are: "A","B","A","AB","BA" and "ABA".
countUniqueChars("A") = 1
countUniqueChars("B") = 1
countUniqueChars("A") = 1
countUniqueChars("AB") = 2
countUniqueChars("BA") = 2
countUniqueChars("ABA") = 1
Sum = 1 + 1 + 1 + 2 + 2 + 1 = 8

---

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 10^5`
*   `s` consists of uppercase English letters only.
