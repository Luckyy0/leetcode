# Result for Divide Two Integers
# *Kết quả cho bài toán Chia Hai Số Nguyên*

## Description
## *Mô tả*

Given two integers `dividend` and `divisor`, divide two integers without using multiplication, division, and mod operator.
*Cho hai số nguyên `dividend` và `divisor`, hãy chia hai số nguyên mà không sử dụng phép nhân, phép chia và phép mod.*

The integer division should truncate toward zero, which means losing its fractional part. For example, `8.345` would be truncated to `8`, and `-2.7335` would be truncated to `-2`.
*Phép chia số nguyên nên làm tròn về không, có nghĩa là mất phần thập phân. Ví dụ, `8.345` sẽ được làm tròn thành `8`, và `-2.7335` sẽ được làm tròn thành `-2`.*

Return the quotient after dividing `dividend` by `divisor`.
*Trả về thương sau khi chia `dividend` cho `divisor`.*

**Note:** Assume we are dealing with an environment that could only store integers within the **32-bit** signed integer range: $[-2^{31}, 2^{31} - 1]$. For this problem, if the quotient is strictly greater than $2^{31} - 1$, then return $2^{31} - 1$, and if the quotient is strictly less than $-2^{31}$, then return $-2^{31}$.
***Lưu ý:** Giả sử chúng ta đang làm việc trong môi trường chỉ có thể lưu trữ số nguyên trong phạm vi số nguyên có dấu **32-bit**: $[-2^{31}, 2^{31} - 1]$. Đối với bài toán này, nếu thương lớn hơn hẳn $2^{31} - 1$, thì trả về $2^{31} - 1$, và nếu thương nhỏ hơn hẳn $-2^{31}$, thì trả về $-2^{31}$.*

## Example 1:
## *Ví dụ 1:*

**Input:** `dividend = 10`, `divisor = 3`
**Output:** `3`
**Explanation:** 10/3 = 3.33333.. which is truncated to 3.

## Example 2:
## *Ví dụ 2:*

**Input:** `dividend = 7`, `divisor = -3`
**Output:** `-2`
**Explanation:** 7/-3 = -2.33333.. which is truncated to -2.

## Constraints:
## *Ràng buộc:*

*   $-2^{31} <= dividend, divisor <= 2^{31} - 1$
*   `divisor != 0`
