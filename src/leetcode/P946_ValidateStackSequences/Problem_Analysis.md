# 946. Validate Stack Sequences / Xác thực Chuỗi Ngăn xếp

## Problem Description / Mô tả bài toán
Given two integer arrays `pushed` and `popped` each with distinct values, return `true` if this could have been the result of a sequence of push and pop operations on an initially empty stack.
Cho hai mảng số nguyên `pushed` và `popped`, mỗi mảng chứa các giá trị riêng biệt, hãy trả về `true` nếu mảng này có thể là kết quả của một chuỗi các thao tác push (đẩy vào) và pop (lấy ra) trên một ngăn xếp ban đầu trống.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Simulation with Stack / Mô phỏng Tham lam với Ngăn xếp
Algorithm:
1. Maintain a `Stack` and an index `i = 0` for the `popped` array.
2. For each element `x` in `pushed`:
   - Push `x` onto the stack.
   - While the stack is not empty, and the top of the stack matches `popped[i]`:
     - Pop from the stack.
     - Increment `i`.
3. Return `true` if the stack is finaly empty.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Immediate Ejection
Simulate the stack operations greedily. Every time a value is pushed, check if it matches the current target in 'popped'. If it does, eject it immediately and continue checking subsequent values in 'popped' to see if they can also be cleared.
Mô phỏng các thao tác ngăn xếp một cách tham lam. Mỗi khi một giá trị được đẩy vào, hãy kiểm tra xem nó có khớp với mục tiêu hiện tại trong 'popped' hay không. Nếu có, hãy đẩy nó ra ngay lập tức và tiếp tục kiểm tra các giá trị tiếp theo trong 'popped' để xem liệu chúng có thể được giải phóng hay không.

---
