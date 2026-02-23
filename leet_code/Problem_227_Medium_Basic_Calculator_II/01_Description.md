# Result for Basic Calculator II
# *Kết quả cho bài toán Máy tính cơ bản II*

## Description
## *Mô tả*

Given a string `s` which represents an expression, evaluate this expression and return its value.
*Cho một chuỗi `s` đại diện cho một biểu thức, hãy đánh giá biểu thức này và trả về giá trị của nó.*

The integer division should truncate toward zero.
*Phép chia số nguyên nên cắt bỏ phần thập phân về phía số không.*

You may assume that the given expression is always valid. All intermediate results will be in the range of `[-2^31, 2^31 - 1]`.
*Bạn có thể giả định rằng biểu thức đã cho luôn hợp lệ. Tất cả các kết quả trung gian sẽ nằm trong phạm vi `[-2^31, 2^31 - 1]`.*

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as `eval()`.
*Lưu ý: Bạn không được phép sử dụng bất kỳ hàm có sẵn nào đánh giá chuỗi dưới dạng biểu thức toán học, chẳng hạn như `eval()`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `s = "3+2*2"`
**Output:** `7`

## Example 2:
## *Ví dụ 2:*

**Input:** `s = " 3/2 "`
**Output:** `1`

## Example 3:
## *Ví dụ 3:*

**Input:** `s = " 3+5 / 2 "`
**Output:** `5`

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 3 * 10^5`
*   `s` consists of integers and operators `('+', '-', '*', '/')` separated by some number of spaces.
*   `s` represents a valid expression.
*   All the integers in the expression are non-negative integers in the range `[0, 2^31 - 1]`.
*   The answer is **guaranteed** to fit in a **32-bit integer**.
