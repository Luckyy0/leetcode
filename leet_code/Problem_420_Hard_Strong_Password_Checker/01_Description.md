# Result for Strong Password Checker
# *Kết quả cho bài toán Kiểm tra Mật khẩu Mạnh*

## Description
## *Mô tả*

A password is said to be strong if it satisfies all the following conditions:
*Một mật khẩu được gọi là mạnh nếu nó đáp ứng tất cả các điều kiện sau:*

1.  It has at least `6` characters and at most `20` characters.
    *Nó có ít nhất `6` ký tự và tối đa `20` ký tự.*
2.  It contains at least one lowercase letter, at least one uppercase letter, and at least one digit.
    *Nó chứa ít nhất một chữ cái thường, ít nhất một chữ cái hoa và ít nhất một chữ số.*
3.  It does not contain three repeating characters in a row (i.e., `"...aaa..."` is weak, but `"...aa...a..."` is strong, provided there are no three consecutive `a`'s).
    *Nó không chứa ba ký tự lặp lại liên tiếp (ví dụ: `"...aaa..."` là yếu, nhưng `"...aa...a..."` là mạnh, miễn là không có ba chữ `a` liên tiếp).*

Given a string `password`, return *the minimum number of steps required to make `password` strong*. If `password` is already strong, return `0`.
*Cho một chuỗi `password`, hãy trả về *số bước tối thiểu cần thiết để làm cho `password` trở nên mạnh*. Nếu `password` đã mạnh, hãy trả về `0`.*

In one step, you can **insert**, **delete**, or **replace** one character of the password.
*Trong một bước, bạn có thể **chèn**, **xóa** hoặc **thay thế** một ký tự của mật khẩu.*

## Example 1:
## *Ví dụ 1:*

**Input:** `password = "a"`
**Output:** `5`

## Example 2:
## *Ví dụ 2:*

**Input:** `password = "aA1"`
**Output:** `3`

## Example 3:
## *Ví dụ 3:*

**Input:** `password = "1337C0d3"`
**Output:** `0`

## Constraints:
## *Ràng buộc:*

*   `1 <= password.length <= 50`
*   `password` consists of letters, digits, and punctuation marks.
