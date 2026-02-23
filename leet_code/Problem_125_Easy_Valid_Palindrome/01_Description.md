# Result for Valid Palindrome
# *Kết quả cho bài toán Chuỗi Đối Xứng Hợp Lệ*

## Description
## *Mô tả*

A phrase is a **palindrome** if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
*Một cụm từ là một **chuỗi đối xứng (palindrome)** nếu, sau khi chuyển đổi tất cả các chữ cái viết hoa thành chữ viết thường và loại bỏ tất cả các ký tự không phải chữ và số, nó đọc giống nhau cả khi đọc xuôi và đọc ngược. Các ký tự chữ và số bao gồm chữ cái và số.*

Given a string `s`, return `true` if it is a **palindrome**, or `false` otherwise.
*Cho một chuỗi `s`, trả về `true` nếu nó là một **chuỗi đối xứng**, hoặc `false` nếu ngược lại.*

## Example 1:
## *Ví dụ 1:*

**Input:** `s = "A man, a plan, a canal: Panama"`
**Output:** `true`
**Explanation:** "amanaplanacanalpanama" is a palindrome.

## Example 2:
## *Ví dụ 2:*

**Input:** `s = "race a car"`
**Output:** `false`
**Explanation:** "raceacar" is not a palindrome.

## Example 3:
## *Ví dụ 3:*

**Input:** `s = " "`
**Output:** `true`
**Explanation:** `s` is an empty string "" after removing non-alphanumeric characters. Since an empty string reads the same forward and backward, it is a palindrome.

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 2 * 10^5`
*   `s` consists only of printable ASCII characters.
