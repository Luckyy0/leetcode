# Result for Evaluate Reverse Polish Notation
# *Kết quả cho bài toán Đánh giá biểu thức ký pháp Ba Lan ngược*

## Description
## *Mô tả*

You are given an array of strings `tokens` that represents an arithmetic expression in a **Reverse Polish Notation**.
*Bạn được cho một mảng các chuỗi `tokens` đại diện cho một biểu thức số học trong **Ký pháp Ba Lan ngược (Reverse Polish Notation)***.*

Evaluate the expression. Return *an integer that represents the value of the expression*.
*Hãy đánh giá biểu thức. Trả về *một số nguyên đại diện cho giá trị của biểu thức***.*

Note that:
*Lưu ý:*

*   The valid operators are `+`, `-`, `*`, and `/`.
    *Các toán tử hợp lệ là `+`, `-`, `*`, và `/`.*
*   Each operand may be an integer or another expression.
    *Mỗi toán hạng có thể là một số nguyên hoặc một biểu thức khác.*
*   The division between two integers always **truncates toward zero**.
    *Phép chia giữa hai số nguyên luôn **làm tròn về phía số 0**.*
*   There will not be any division by zero.
    *Sẽ không có bất kỳ phép chia nào cho số 0.*
*   The input represents a valid arithmetic expression in a reverse polish notation.
    *Đầu vào đại diện cho một biểu thức số học hợp lệ trong ký pháp Ba Lan ngược.*
*   The answer and all the intermediate calculations can be represented in a **32-bit** integer.
    *Kết quả và tất cả các tính toán trung gian có thể được biểu diễn bằng số nguyên **32-bit***.*

## Example 1:
## *Ví dụ 1:*

**Input:** `tokens = ["2","1","+","3","*"]`
**Output:** `9`
**Explanation:** `((2 + 1) * 3) = 9`

## Example 2:
## *Ví dụ 2:*

**Input:** `tokens = ["4","13","5","/","+"]`
**Output:** `6`
**Explanation:** `(4 + (13 / 5)) = 6`

## Example 3:
## *Ví dụ 3:*

**Input:** `tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]`
**Output:** `22`
**Explanation:** `((10 * (6 / ((9 + 3) * -11))) + 17) + 5`
`= ((10 * (6 / (12 * -11))) + 17) + 5`
`= ((10 * (6 / -132)) + 17) + 5`
`= ((10 * 0) + 17) + 5`
`= (0 + 17) + 5`
`= 17 + 5`
`= 22`

## Constraints:
## *Ràng buộc:*

*   `1 <= tokens.length <= 10^4`
*   `tokens[i]` is either an operator: `"+"`, `"-"`, `"*"` or `"/"`, or an integer in the range `[-200, 200]`.
