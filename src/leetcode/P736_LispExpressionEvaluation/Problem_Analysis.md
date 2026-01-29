# 736. Lisp Expression Evaluation / Đánh giá Biểu thức Lisp

## Problem Description / Mô tả bài toán
You are given an expression `expression` in Lisp-like format. Return the integer value of the expression.
Bạn được cho một biểu thức `expression` định dạng giống Lisp. Hãy trả về giá trị số nguyên của biểu thức đó.

Rules:
1. `let v1 e1 v2 e2 ... vn en expr`: Evaluate `expr` within a context where `v1` is assigned value of `e1`, etc.
2. `add e1 e2`: Return sum of `e1` and `e2`.
3. `mult e1 e2`: Return product of `e1` and `e2`.
4. Values can be integers or variables.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Recursive Descent Mapping / Ánh xạ Đệ quy Xuống
Parsing Lisp requires handling scopes and recursion.
Việc phân tích cú pháp Lisp yêu cầu xử lý các phạm vi và đệ quy.

We can use a recursive function `evaluate` that takes the current `expression` and a `scope` (Map of variables to values).
Chúng ta có thể sử dụng một hàm đệ quy `evaluate` nhận biểu thức hiện tại và một `scope` (Bản đồ biến thành giá trị).

Algorithm:
1. If the expression starts with `(`, identify the operator (`let`, `add`, `mult`).
2. Implement specific logic for each:
   - For `let`: Sub-evaluate pairs and update a *copy* of the scope.
   - For `add`/`mult`: Sub-evaluate the two operands and return result.
3. If it's a number, return its value.
4. If it's a variable, look it up in the scope.

### Complexity / Độ phức tạp
- **Time**: O(N^2) due to scope copies and string splitting.
- **Space**: O(N^2) for recursion depth and scopes.

---

## Analysis / Phân tích

### Approach: Recursive Scoped Evaluation
Maintain a context for variables. Since `let` creates a local scope, we pass a new map copy to recursive calls. Use a helper to find balanced closing parentheses.
Duy trì một ngữ cảnh cho các biến. Vì `let` tạo ra một phạm vi cục bộ, chúng ta truyền một bản sao map mới cho các lệnh gọi đệ quy. Sử dụng một hàm hỗ trợ để tìm các dấu ngoặc đơn đóng khớp nhau.

---
