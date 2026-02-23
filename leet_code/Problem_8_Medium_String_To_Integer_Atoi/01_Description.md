# Result for String to Integer (atoi)
# *Kết quả cho bài toán Chuỗi thành Số Nguyên (atoi)*

## Description
## *Mô tả*

Implement the `myAtoi(string s)` function, which converts a string to a 32-bit signed integer (similar to C/C++'s `atoi` function).
*Triển khai hàm `myAtoi(string s)`, chuyển đổi một chuỗi thành một số nguyên 32-bit có dấu (tương tự hàm `atoi` của C/C++).*

The algorithm is as follows:
*Thuật toán như sau:*

1.  **Read in and ignore any leading whitespace.**
    *Đọc và bỏ qua bất kỳ khoảng trắng nào ở đầu.*
2.  **Check if the next character (if not already at the end of the string) is '-' or '+'.** Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
    *Kiểm tra xem ký tự tiếp theo (nếu chưa đến cuối chuỗi) có phải là '-' hoặc '+' không. Đọc ký tự này nếu có. Điều này xác định kết quả cuối cùng là âm hay dương. Giả sử kết quả là dương nếu không có ký tự nào.*
3.  **Read in next the characters until the next non-digit character or the end of the input is reached.** The rest of the string is ignored.
    *Đọc các ký tự tiếp theo cho đến khi gặp ký tự không phải số hoặc kết thúc đầu vào. Phần còn lại của chuỗi bị bỏ qua.*
4.  **Convert these digits into an integer** (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
    *Chuyển đổi các chữ số này thành số nguyên (ví dụ "123" -> 123, "0032" -> 32). Nếu không đọc được chữ số nào, thì số nguyên là 0. Thay đổi dấu nếu cần thiết (từ bước 2).*
5.  **If the integer is out of the 32-bit signed integer range** $[-2^{31}, 2^{31} - 1]$, then clamp the integer so that it remains in the range. Specifically, integers less than $-2^{31}$ should be clamped to $-2^{31}$, and integers greater than $2^{31} - 1$ should be clamped to $2^{31} - 1$.
    *Nếu số nguyên nằm ngoài phạm vi số nguyên 32-bit có dấu $[-2^{31}, 2^{31} - 1]$, hãy giới hạn số nguyên để nó nằm trong phạm vi. Cụ thể, số nguyên nhỏ hơn $-2^{31}$ sẽ được giới hạn thành $-2^{31}$, và số nguyên lớn hơn $2^{31} - 1$ sẽ được giới hạn thành $2^{31} - 1$.*
6.  **Return the integer as the final result.**
    *Trả về số nguyên là kết quả cuối cùng.*

## Example 1:
## *Ví dụ 1:*

**Input:** `s = "42"`
**Output:** `42`

## Example 2:
## *Ví dụ 2:*

**Input:** `s = "   -42"`
**Output:** `-42`

## Example 3:
## *Ví dụ 3:*

**Input:** `s = "4193 with words"`
**Output:** `4193`

## Constraints:
## *Ràng buộc:*

*   `0 <= s.length <= 200`
*   `s` consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.
*   *`s` bao gồm các chữ cái tiếng Anh (chữ thường và chữ hoa), chữ số (0-9), ' ', '+', '-', và '.'.*
