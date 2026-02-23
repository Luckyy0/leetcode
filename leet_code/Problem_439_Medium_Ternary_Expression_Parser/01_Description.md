# Result for Ternary Expression Parser
# *Kết quả cho bài toán Trình phân tích Biểu thức Tam phân*

## Description
## *Mô tả*

Given a string `expression` representing arbitrarily nested ternary expressions, evaluate the expression and return *the result of it*.
*Cho một chuỗi `expression` đại diện cho các biểu thức tam phân (ternary expressions) được lồng vào nhau tùy ý, hãy tính toán biểu thức và trả về *kết quả của nó*.*

The input expressions are always valid and consist of digits `0-9`, `?`, `:`, `T` (True) and `F` (False). `expression` can contain nested ternary expressions.
*Các biểu thức đầu vào luôn hợp lệ và bao gồm các chữ số `0-9`, `?`, `:`, `T` (True) và `F` (False). `expression` có thể chứa các biểu thức tam phân lồng nhau.*

A ternary expression is in the format `condition ? expression1 : expression2`.
*Một biểu thức tam phân có định dạng `condition ? expression1 : expression2`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `expression = "T?2:3"`
**Output:** `"2"`

## Example 2:
## *Ví dụ 2:*

**Input:** `expression = "F?1:T?4:5"`
**Output:** `"4"`
**Explanation:** The conditional expressions are evaluated from right to left.
- `T?4:5` evaluates to `4`.
- `F?1:4` evaluates to `4`.

## Constraints:
## *Ràng buộc:*

*   `5 <= expression.length <= 10^4`
*   `expression` consists of digits, `?`, `:`, `T`, and `F`.
*   The conditional expressions are always valid.
