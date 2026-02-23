# Result for Numbers At Most N Given Digit Set
# *Kết quả cho bài toán Các Số Nhỏ Nhất N Được Cho Bởi Tập Hợp Chữ Số*

## Description
## *Mô tả*

Given an array of `digits` which is a subset of the digits `1`-`9`, and an integer `n`, return *the number of positive integers that can be generated* that are less than or equal to `n`, using only the digits in `digits`.
*Cho một mảng `digits` là tập con của các chữ số từ `1` đến `9`, và một số nguyên `n`, hãy trả về *số lượng các số nguyên dương có thể được tạo ra* nhỏ hơn hoặc bằng `n`, bằng cách sử dụng chỉ các chữ số trong `digits`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** digits = ["1","3","5","7"], n = 100
**Output:** 20
**Explanation:** 
The 20 numbers that can be written are:
1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.

## Example 2:
## *Ví dụ 2:*

**Input:** digits = ["1","4","9"], n = 1000000000
**Output:** 29523
**Explanation:** 
We can write 3 one-digit numbers, 9 two-digit numbers, 27 three-digit numbers,
81 four-digit numbers, 243 five-digit numbers, 729 six-digit numbers,
2187 seven-digit numbers, 6561 eight-digit numbers, and 19683 nine-digit numbers.
In total, this is 29523 integers.

## Example 3:
## *Ví dụ 3:*

**Input:** digits = ["7"], n = 8
**Output:** 1

---

## Constraints:
## *Ràng buộc:*

*   `1 <= digits.length <= 9`
*   `digits[i].length == 1`
*   `digits[i]` is a digit from `'1'` to `'9'`.
*   All the values in `digits` are **unique**.
*   `digits` is sorted in **non-decreasing** order.
*   `1 <= n <= 10^9`
