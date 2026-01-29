# 640. Solve the Equation / Giải Phương Trình

## Problem Description / Mô tả bài toán
Solve a given equation and return the value of `x` in the form of a string `"x=#value"`. The equation contains only '+', '-' operation, the variable `x` and its coefficient.
Giải một phương trình đã cho và trả về giá trị của `x` ở dạng chuỗi `"x=#value"`. Phương trình chỉ chứa phép toán '+', '-', biến `x` và hệ số của nó.

If there is no solution, return `"No solution"`.
Nếu không có nghiệm, hãy trả về `"No solution"`.

If there are infinite solutions, return `"Infinite solutions"`.
Nếu có vô số nghiệm, hãy trả về `"Infinite solutions"`.

If there is exactly one solution for the equation, we ensure that the value of `x` is an integer.
Nếu có chính xác một nghiệm cho phương trình, chúng tôi đảm bảo rằng giá trị của `x` là một số nguyên.

### Example 1:
```text
Input: equation = "x+5-3+x=6+x-2"
Output: "x=2"
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Parsing / Linear Equation Solving / Phân Tích / Giải Phương Trình Tuyến Tính
Equation: `LHS = RHS`.
Normalize to `ax + b = 0`.
Move everything to LHS: `LHS - RHS = 0`.
Parse the string. Sum up coefficents of x (`coeff`) and constants (`const`).
Equation becomes `coeff * x + const = 0` => `coeff * x = -const`.
Cases:
1. `coeff == 0` and `const == 0`: Infinite solutions.
2. `coeff == 0` and `const != 0`: No solution.
3. `coeff != 0`: `x = -const / coeff`.

Parsing details:
Split by `=`.
Parse each side.
Format `[+-]?(\d*x|\d+)`.
If `x`, coeff is 1. If `-x`, coeff is -1. If `nx`, coeff is n.
If number, adds to const.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Coefficient Accumulation

**Algorithm**:
1.  Split string into left and right parts.
2.  Helper function to evaluate expression to `(coefficient of x, constant value)`.
3.  Combine results: `leftX - rightX`, `rightConst - leftConst`.
4.  Solve linear equation.

---
