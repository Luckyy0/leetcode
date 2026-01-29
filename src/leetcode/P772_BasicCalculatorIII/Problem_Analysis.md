# 772. Basic Calculator III / Máy tính Cơ bản III

## Problem Description / Mô tả bài toán
Implement a basic calculator to evaluate a simple expression string. The expression string may contain open `(` and closing parentheses `)`, the plus `+` or minus sign `-`, non-negative integers and empty spaces.
Triển khai một máy tính cơ bản để đánh giá một chuỗi biểu thức đơn giản. Chuỗi biểu thức có thể chứa các dấu ngoặc đóng mở `()`, dấu cộng `+` hoặc dấu trừ `-`, các số nguyên không âm và các dấu cách.

The expression can also contain multiplication `*` and division `/`.
Biểu thức cũng có thể chứa phép nhân `*` và phép chia `/`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Reverse Polish Notation or Stack-Based Parser / Ký hiệu Ba Lan ngược hoặc Trình phân tích cú pháp dưa trên Ngăn xếp
Standard infix expression evaluation with operator precedence.
Đánh giá biểu thức trung tố tiêu chuẩn với mức độ ưu tiên của toán tử.

Algorithm:
1. Use two stacks: `ops` for operators and `nums` for operands.
2. Define precedence: `*`, `/` > `+`, `-`.
3. Handle `(` by pushing to `ops`.
4. Handle `)` by evaluating all operations until reaching `(`.
5. When adding an operator `op`:
   - While `ops.top` has higher or equal precedence, evaluate it.
   - Push `op`.
6. Use recursion or iterative processing to handle numbers.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the length of the string.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Weighted Operator Evaluation
Evaluate expressions by comparing the weight of the current operator with the top of the operator stack. This ensures multiplication/division occur before addition/subtraction.
Đánh giá các biểu thức bằng cách so sánh trọng số của toán tử hiện tại với đỉnh của ngăn xếp toán tử. Điều này đảm bảo phép nhân/chia xảy ra trước phép cộng/trừ.

---
