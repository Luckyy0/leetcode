# Result for Reverse Integer
# *Kết quả cho bài toán Đảo Ngược Số Nguyên*

## Description
## *Mô tả*

Given a signed 32-bit integer `x`, return `x` with its digits reversed.
*Cho một số nguyên 32-bit có dấu `x`, trả về `x` với các chữ số của nó bị đảo ngược.*

If reversing `x` causes the value to go outside the signed 32-bit integer range $[-2^{31}, 2^{31} - 1]$, then return 0.
*Nếu việc đảo ngược `x` làm cho giá trị vượt ra ngoài phạm vi số nguyên 32-bit có dấu $[-2^{31}, 2^{31} - 1]$, thì trả về 0.*

**Assume the environment does not allow you to store 64-bit integers (signed or unsigned).**
***Giả định rằng môi trường không cho phép bạn lưu trữ số nguyên 64-bit (có dấu hoặc không dấu).***

## Example 1:
## *Ví dụ 1:*

**Input:** `x = 123`
**Output:** `321`

## Example 2:
## *Ví dụ 2:*

**Input:** `x = -123`
**Output:** `-321`

## Example 3:
## *Ví dụ 3:*

**Input:** `x = 120`
**Output:** `21`

## Constraints:
## *Ràng buộc:*

*   $-2^{31} <= x <= 2^{31} - 1$
