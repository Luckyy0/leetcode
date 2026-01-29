# 770. Basic Calculator IV / Máy tính Cơ bản IV

## Problem Description / Mô tả bài toán
Given an expression such as `"e + 8 - a + 5"` and an evaluation map such as `{"e": 1}`, return a list of tokens representing the simplified expression.
Cho một biểu thức như `"e + 8 - a + 5"` và một bản đồ đánh giá như `{"e": 1}`, hãy trả về một danh sách các mã đại diện cho biểu thức được rút gọn.

A token is a coefficient followed by variables in sorted order. Terms are sorted by degree (descending) and then lexicographically.
Một mã là một hệ số theo sau bởi các biến theo thứ tự đã sắp xếp. Các số hạng được sắp xếp theo bậc (giảm dần) và sau đó theo thứ tự từ điển.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Polynomial Arithmetic / Số học Đa thức
This problem requires representing expressions as polynomials.
Bài toán này yêu cầu biểu diễn các biểu thức dưới dạng đa thức.

A polynomial can be represented as a `Map<List<String>, Integer>`:
- Key: A sorted list of variables (representing a term).
- Value: The coefficient.

Operations:
- **Add**: Combine coefficients for the same keys.
- **Multiply**: Distributive property. Multiply terms (sorted union of variables) and coefficients.

Algorithm:
1. Parse the string using a stack or recursive descent.
2. Convert identifiers (variables/numbers) into polynomials.
3. Perform polynomial math for `+`, `-`, `*`.
4. Format the result map into the required list format.

### Complexity / Độ phức tạp
- **Time**: Exponential in the worst case (due to multiplications), but bounded by expression length.
- **Space**: O(Total possible terms).

---

## Analysis / Phân tích

### Approach: Symbolic Mathematical Simplification
Represent every operand as a custom `Poly` class. Implement addition and multiplication logic for these polynomials. This allows handling variables just like constants.
Biểu diễn mọi toán hạng dưới dạng một lớp `Poly` tùy chỉnh. Triển khai logic cộng và nhân cho các đa thức này. Điều này cho phép xử lý các biến giống như các hằng số.

---
