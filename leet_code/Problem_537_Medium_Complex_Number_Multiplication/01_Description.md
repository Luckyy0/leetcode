# Result for Complex Number Multiplication
# *Kết quả cho bài toán Nhân Số Phức*

## Description
## *Mô tả*

A [complex number](https://en.wikipedia.org/wiki/Complex_number) can be represented as a string on the form `"real+imaginaryi"` where:
*Một [số phức](https://en.wikipedia.org/wiki/Complex_number) có thể được biểu diễn dưới dạng chuỗi `"thực+ảoi"` trong đó:*

*   `real` is the real part and is an integer in the range `[-100, 100]`.
    *`thực` là phần thực và là một số nguyên trong khoảng `[-100, 100]`.*
*   `imaginary` is the imaginary part and is an integer in the range `[-100, 100]`.
    *`ảo` là phần ảo và là một số nguyên trong khoảng `[-100, 100]`.*
*   `i^2 == -1`.

Given two complex numbers `num1` and `num2` as strings, return *a string of the complex number that represents their multiplications*.
*Cho hai số phức `num1` và `num2` dưới dạng chuỗi, hãy trả về *một chuỗi của số phức đại diện cho phép nhân của chúng*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `num1 = "1+1i", num2 = "1+1i"`
**Output:** `"0+2i"`
**Explanation:** `(1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i`, and you need convert it to the form of 0+2i.

## Example 2:
## *Ví dụ 2:*

**Input:** `num1 = "1+-1i", num2 = "1+-1i"`
**Output:** `"0+-2i"`
**Explanation:** `(1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i`, and you need convert it to the form of 0+-2i.

## Constraints:
## *Ràng buộc:*

*   `num1` and `num2` are valid complex numbers.
