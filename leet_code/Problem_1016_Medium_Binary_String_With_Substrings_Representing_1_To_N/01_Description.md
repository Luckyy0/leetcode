# Result for Binary String With Substrings Representing 1 To N
# *Kết quả cho bài toán Chuỗi Nhị Phân có các chuỗi con chứa từ 1 đến N*

## Description
## *Mô tả*

Given a binary string `s` and a positive integer `n`, return `true` *if the binary representation of all the integers in the range* `[1, n]` *are **substrings** of* `s`*, or* `false` *otherwise*.
*Cho một chuỗi nhị phân `s` và một số nguyên dương `n`, trả về `true` **nếu biểu diễn nhị phân của mọi số nguyên trong phạm vi `[1, n]` đều là **chuỗi con** của `s`, ngược lại trả về `false`.*

A **substring** is a contiguous sequence of characters within a string.
*Một **chuỗi con** là một dãy các ký tự liền kề bên trong một chuỗi lớn.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** s = "0110", n = 3
**Output:** true
**Explanation:** The numbers from 1 to 3 are represented as "1", "10", and "11" in binary. All of these substrings are beautifully embedded inside "0110".
*Giải thích: Các số từ 1 đến 3 có hệ nhị phân lần lượt là "1", "10" và "11". Cả ba chuỗi con này đều nằm gọn bên trong "0110".*

## Example 2:
## *Ví dụ 2:*

**Input:** s = "0110", n = 4
**Output:** false
**Explanation:** The number 4 is "100" in binary, which is absolutely missing from "0110".
*Giải thích: Số 4 hệ nhị phân là "100", chuỗi này hoàn toàn vắng mặt trong "0110".*

---

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 1000`
*   `s[i]` is either `'0'` or `'1'`.
*   `1 <= n <= 10^9`
