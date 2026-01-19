# 227. Basic Calculator II / Máy Tính Cơ Bản II

## Problem Description / Mô tả bài toán
Given a string `s` which represents an expression, evaluate this expression and return its value. 
Cho một chuỗi `s` đại diện cho một biểu thức, hãy tính toán biểu thức này và trả về giá trị của nó.

The integer division should **truncate toward zero**.
Phép chia số nguyên nên **cắt bỏ phần thập phân về 0**.

You may assume that the given expression is always valid. All intermediate results will be in the range of `[-2^31, 2^31 - 1]`.
Bạn có thể giả định rằng biểu thức đã cho luôn hợp lệ. Tất cả các kết quả trung gian sẽ nằm trong khoảng `[-2^31, 2^31 - 1]`.

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as `eval()`.
Lưu ý: Bạn không được phép sử dụng bất kỳ hàm có sẵn nào để tính toán chuỗi như biểu thức toán học, ví dụ như `eval()`.

### Example 1:
```text
Input: s = "3+2*2"
Output: 7
```

### Example 2:
```text
Input: s = " 3/2 "
Output: 1
```

### Example 3:
```text
Input: s = " 3+5 / 2 "
Output: 5
```

## Constraints / Ràng buộc
- `1 <= s.length <= 3 * 10^5`
- `s` consists of integers and operators `('+', '-', '*', '/')` separated by some number of spaces.
- `s` represents a valid expression.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Stack for Precedence / Ngăn Xếp Cho Thứ Tự Ưu Tiên
Unlike `Basic Calculator I` (only `+`, `-`, `(`), here we have `*` and `/` which have higher precedence than `+` and `-`.

**Logic**:
- We traverse the string and parse numbers.
- We maintain a `lastOperator` (initially `+`).
- When we encounter a new operator (or end of string), we process the *previous* number based on `lastOperator`:
    - `+`: Push number to stack.
    - `-`: Push `-number` to stack.
    - `*`: Pop top, multiply with current number, push result.
    - `/`: Pop top, divide by current number, push result.
- Finally, sum up all values in the stack.

**Optimization**:
Instead of a full stack, we can sometimes use a variable `lastNumber` if we carefully manage the sum. But a stack is clearer.

---

## Analysis / Phân tích

### Approach: Stack

**Algorithm**:
1. Initialize `stack`, `currentNumber = 0`, `operator = '+'`.
2. Loop `i` from 0 to `length`:
    - If digit: `currentNumber = currentNumber * 10 + digit`.
    - If operator or end of string:
        - If `+`: `stack.push(currentNumber)`
        - If `-`: `stack.push(-currentNumber)`
        - If `*`: `stack.push(stack.pop() * currentNumber)`
        - If `/`: `stack.push(stack.pop() / currentNumber)`
        - Update `operator = currChar`, `currentNumber = 0`.
3. Sum stack.

### Complexity / Độ phức tạp
- **Time**: O(N) - Single pass.
- **Space**: O(N) - Stack stores intermediate numbers.

---

## Edge Cases / Các trường hợp biên
1.  **Spaces**: Skip or handle logic carefully.
2.  **Multiple digits**: Parsing logic standard.
3.  **End of string**: Process the last number.
4.  **Division by zero**: Not expected per valid expression, but logic handles truncation.
