# Result for Solve the Equation
# *Kết quả cho bài toán Giải Phương trình*

## Description
## *Mô tả*

Solve a given equation and return the value of `x` in the form of a string `"x=#value"`. The equation contains only `'+'`, `'-'`, the variable `'x'`, and its coefficient.
*Giải một phương trình đã cho và trả về giá trị của `x` dưới dạng chuỗi `"x=#giá_trị"`. Phương trình chỉ chứa các ký tự `'+'`, `'-'`, biến `'x'` và hệ số của nó.*

If the equation has no solution, return `"No solution"`. If the equation has infinite solutions, return `"Infinite solutions"`.
*Nếu phương trình vô nghiệm, trả về `"No solution"`. Nếu phương trình có vô số nghiệm, trả về `"Infinite solutions"`.*

If there is exactly one solution for the equation, we ensure that the value of `x` is an integer.
*Nếu phương trình có đúng một nghiệm, chúng tôi đảm bảo rằng giá trị của `x` là một số nguyên.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** equation = "x+5-3+x=6+x-2"
**Output:** "x=2"

## Example 2:
## *Ví dụ 2:*

**Input:** equation = "x=x"
**Output:** "Infinite solutions"

## Example 3:
## *Ví dụ 3:*

**Input:** equation = "2x=x"
**Output:** "x=0"

---

## Constraints:
## *Ràng buộc:*

*   `3 <= equation.length <= 1000`
*   `equation` has exactly one `'='`.
*   `equation` consists of integers with an absolute value in the range `[0, 100]` and variable `'x'`.
