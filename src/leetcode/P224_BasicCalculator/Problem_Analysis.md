# 224. Basic Calculator / Máy Tính Cơ Bản

## Problem Description / Mô tả bài toán
Given a string `s` representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
Cho một chuỗi `s` biểu diễn một biểu thức hợp lệ, hãy triển khai một máy tính cơ bản để đánh giá nó và trả về kết quả của việc đánh giá.

Note: You are **not** allowed to use any built-in function which evaluates strings as mathematical expressions, such as `eval()`.
Lưu ý: Bạn **không** được phép sử dụng bất kỳ hàm tích hợp nào đánh giá chuỗi dưới dạng biểu thức toán học, chẳng hạn như `eval()`.

The expression string may contain open `(` and closing parentheses `)`, the plus `+` or minus sign `-`, non-negative integers and empty spaces ` `.
Chuỗi biểu thức có thể chứa dấu ngoặc đơn mở `(` và đóng `)`, dấu cộng `+` hoặc dấu trừ `-`, các số nguyên không âm và khoảng trắng ` `.

### Example 1:
```text
Input: s = "1 + 1"
Output: 2
```

### Example 2:
```text
Input: s = " 2-1 + 2 "
Output: 3
```

### Example 3:
```text
Input: s = "(1+(4+5+2)-3)+(6+8)"
Output: 23
```

## Constraints / Ràng buộc
- `1 <= s.length <= 3 * 10^5`
- `s` consists of digits, `+`, `-`, `(`, `)`, and ` `.
- `s` represents a valid expression.
- `+` is not used as a unary operation (i.e., "+1" and "+(2+3)" is invalid).
- `-` could be used as a unary operation (i.e., "-1" and "-(2+3)" is valid).
- The result and intermediate results fit in a **32-bit integer**.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Stack for Parentheses / Ngăn xếp cho Ngoặc
Since we only have `+` and `-`, the order of operations is simple (left to right), but parentheses change precedence.
Usually, subtraction corresponds to adding a negative number.
`(A - B)` is basically `A + (-1)*B`.
`-(A + B)` is `-A - B`.

We can maintain:
1.  `result`: Current calculated sum at this level.
2.  `sign`: Current sign (`1` for `+`, `-1` for `-`).
3.  `stack`: To store the `result` and `sign` of the *outer* level when we enter a parenthesis.

**Algorithm**:
- Iterate through the string.
- If digit: Parse the full number. Add `sign * number` to `result`.
- If `+`: Set `sign = 1`.
- If `-`: Set `sign = -1`.
- If `(`: Push `result` and `sign` to stack. Reset `result = 0`, `sign = 1`.
- If `)`: 
  - `result` is now the evaluation of the inner parenthesis.
  - Pop `prevSign` and multiply `result` by it.
  - Pop `prevResult` and add to `result`.

---

## Analysis / Phân tích

### Approach: Linear Scan with Stack

**Complexity / Độ phức tạp**:
- **Time**: O(N) - Single pass through the string.
- **Space**: O(N) - Stack depth depends on nested parentheses.

---

## Edge Cases / Các trường hợp biên
1.  **Unary Minus**: `-2 + 1`. The loop should handle this since we start with `result=0, sign=1`, `-` sets sign to -1, then `2` adds `-2`.
2.  **Spaces**: Skip them.
3.  **Multiple Parentheses**: `((1))`.
4.  **No Parentheses**: `1 + 2`.
