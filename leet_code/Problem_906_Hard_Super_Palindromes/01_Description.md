# Result for Super Palindromes
# *Kết quả cho bài toán Siêu Palindrome*

## Description
## *Mô tả*

Let's say a positive integer is a **super-palindrome** if it is a palindrome, and it is also the square of a palindrome.
*Giả sử một số nguyên dương là một **siêu palindrome** nếu nó là một palindrome, và nó cũng là bình phương của một palindrome.*

Given two strings `left` and `right` that represent two integers `L` and `R`, return *the number of super-palindromes in the inclusive range `[L, R]`*.
*Cho hai chuỗi `left` và `right` đại diện cho hai số nguyên `L` và `R`, hãy trả về *số lượng siêu palindrome trong khoảng `[L, R]`*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** left = "4", right = "1000"
**Output:** 4
**Explanation:** 4, 9, 121, and 484 are superpalindromes.
Note that 676 is not a superpalindrome: 26 * 26 = 676, but 26 is not a palindrome.

## Example 2:
## *Ví dụ 2:*

**Input:** left = "1", right = "2"
**Output:** 1

---

## Constraints:
## *Ràng buộc:*

*   `1 <= left.length, right.length <= 18`
*   `left` and `right` consist of only digits.
*   `left` and `right` cannot have leading zeros.
*   `left` and `right` represent integers in the range `[1, 10^18]`.
*   `left` is less than or equal to `right`.
