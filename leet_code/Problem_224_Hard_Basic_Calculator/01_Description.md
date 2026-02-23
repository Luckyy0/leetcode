# Result for Basic Calculator
# *Kết quả cho bài toán Máy tính cơ bản*

## Description
## *Mô tả*

Given a string `s` representing a valid expression, implement a basic calculator to evaluate it, and return *the result of the evaluation*.
*Cho một chuỗi `s` đại diện cho một biểu thức hợp lệ, hãy triển khai một máy tính cơ bản để đánh giá nó, và trả về *kết quả của phép đánh giá*.*

Note: You are **not** allowed to use any built-in function which evaluates strings as mathematical expressions, such as `eval()`.
*Lưu ý: Bạn **không** được phép sử dụng bất kỳ hàm có sẵn nào đánh giá chuỗi dưới dạng biểu thức toán học, chẳng hạn như `eval()`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `s = "1 + 1"`
**Output:** `2`

## Example 2:
## *Ví dụ 2:*

**Input:** `s = " 2-1 + 2 "`
**Output:** `3`

## Example 3:
## *Ví dụ 3:*

**Input:** `s = "(1+(4+5+2)-3)+(6+8)"`
**Output:** `23`

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 3 * 10^5`
*   `s` consists of digits, `'+'`, `'-'`, `'('`, `')'`, and `' '`.
*   `s` represents a valid expression.
*   `'+'` is not used as a unary operation (i.e., `"+1"` and `"+(2 + 3)"` is invalid).
*   `'-'` could be used as a unary operation (i.e., `"-1"` and `"-(2 + 3)"` is valid).
*   There will be no two consecutive operators in the input.
*   Every number and running calculation will fit in a signed 32-bit integer.
