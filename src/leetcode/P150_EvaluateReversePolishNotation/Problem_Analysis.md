# 150. Evaluate Reverse Polish Notation / Tính Giá Trị Biểu Thức Ba Lan Ngược

## Problem Description / Mô tả bài toán
You are given an array of strings `tokens` that represents an arithmetic expression in a **Reverse Polish Notation**.
Cho một mảng các chuỗi `tokens` đại diện cho một biểu thức số học ở dạng **Ký pháp Ba Lan Ngược**.

Evaluate the expression. Return an integer that represents the value of the expression.
Hãy tính giá trị của biểu thức. Trả về một số nguyên đại diện cho giá trị của biểu thức.

**Note** that:
- The valid operators are `+`, `-`, `*`, and `/`.
- Each operand may be an integer or another expression.
- The division between two integers always truncates toward zero.
- There will not be any division by zero.
- The input represents a valid arithmetic expression in reverse polish notation.
- The answer and all the intermediate calculations can be represented in a **32-bit** integer.

### Example 1:
```text
Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
```

### Example 2:
```text
Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
```

## Constraints / Ràng buộc
- `1 <= tokens.length <= 10^4`
- `tokens[i]` is either an operator or an integer in the range `[-200, 200]`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Reverse Polish Notation (RPN) / Ký pháp Ba Lan Ngược
In RPN, the operators follow their operands. It eliminates the need for parentheses used in infix notation (e.g., `3 + 4` becomes `3 4 +`).
Trong RPN, các toán tử đứng sau các toán hạng của chúng. Nó loại bỏ sự cần thiết của dấu ngoặc đơn được sử dụng trong ký pháp trung tố.

### Stack Data Structure / Cấu trúc Dữ liệu Ngăn xếp
The evaluation is naturally performed using a **Stack**:
1.  Read tokens one by one.
2.  If the token is an **operand** (number), push it onto the stack.
3.  If the token is an **operator**:
    - Pop the top two elements from the stack.
    - Let the first popped be `b` and second popped be `a`.
    - Apply the operator: `result = a (op) b`.
    - Push the `result` back onto the stack.
4.  At the end, the stack will contain exactly one element, which is the final result.

---

## Analysis / Phân tích

### Approach: Stack Implementation

**Complexity / Độ phức tạp**:
- **Time**: O(N) - single pass through tokens.
- **Space**: O(N) - to store operands in the stack.

---

## Edge Cases / Các trường hợp biên
1.  **Single token**: The array contains only one number.
2.  **Negative numbers**: Subtracting or multiplying negative numbers.
3.  **Truncated division**: `13 / 5 = 2`, not `2.6`.
