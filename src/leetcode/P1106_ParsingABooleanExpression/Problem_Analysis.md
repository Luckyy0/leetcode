# 1106. Parsing A Boolean Expression / Phân tích Biểu thức Boolean

## Problem Description / Mô tả bài toán
Return the result of evaluating a given boolean expression, represented as a string.
Expression can be:
- 't', 'f'
- `!(expr)`
- `&(expr1,expr2,...)`
- `|(expr1,expr2,...)`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Parsing with Stack / Phân tích với Ngăn xếp
Recursion or Stack.
Stack approach:
1. Iterate chars.
2. If `t, f, !, &, |`, push to stack (maybe 2 stacks, one for ops, one for values). Or single stack.
   - Actually simpler: Push everything except `)` and `,`.
   - When `)`:
     - Pop values from stack until `(`.
     - Pop `(` and then the operator before it.
     - Evaluate op with values. Push result back.
3. Final result is in stack.
Wait, `(` is delimiter.
Algorithm:
- Iterate char `c`:
  - If `c` in `( ! & | t f )`: push `c`.
  - If `c == ')'`:
    - Pop until `(`, collecting `t/f`.
    - Pop `(`.
    - Pop `op`.
    - Apply `op` to collected values.
    - Push result `t/f`.
  - Combine `,` logic? Or just skip `,`.
  - `&, |` take multiple args.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Stack-Based Evaluation
Utilize a stack to process the expression. Push operators and operands. Upon encountering a closing parenthesis ')', pop operands until the matching open parenthesis '('. Then, identify the operator immediately preceding '('. Apply the operator (AND, OR, NOT) to the popped operands and push the result back onto the stack. This handles nested expressions correctly.
Sử dụng một ngăn xếp để xử lý biểu thức. Đẩy các toán tử và toán hạng. Khi gặp dấu đóng ngoặc đơn ')', hãy pop các toán hạng cho đến khi khớp với dấu mở ngoặc đơn '('. Sau đó, xác định toán tử ngay trước '('. Áp dụng toán tử (AND, OR, NOT) cho các toán hạng đã pop và đẩy kết quả trở lại ngăn xếp. Điều này xử lý các biểu thức lồng nhau một cách chính xác.

---
