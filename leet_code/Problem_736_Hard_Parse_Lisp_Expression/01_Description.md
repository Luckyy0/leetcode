# Result for Parse Lisp Expression
# *Kết quả cho bài toán Phân tích Biểu thức Lisp*

## Description
## *Mô tả*

You are given an expression which may contain integers, variables, and Lisp-like expressions.
*Bạn được cho một biểu thức có thể chứa các số nguyên, biến và các biểu thức dạng Lisp.*

The expressions are of the following three types:
*Các biểu thức thuộc ba loại sau:*

1.  **`let v1 e1 v2 e2 ... expr`**: The `let` expression assigns new values to variables `v1`, `v2`, etc., and then evaluates the expression `expr`.
    * **`let v1 e1 v2 e2 ... expr`**: Biểu thức `let` gán các giá trị mới cho các biến `v1`, `v2`,... và sau đó tính toán giá trị của biểu thức `expr`.*
2.  **`add e1 e2`**: The `add` expression returns the sum of `e1` and `e2`.
    * **`add e1 e2`**: Biểu thức `add` trả về tổng của `e1` và `e2`.*
3.  **`mult e1 e2`**: The `mult` expression returns the product of `e1` and `e2`.
    * **`mult e1 e2`**: Biểu thức `mult` trả về tích của `e1` và `e2`.*

An integer represents itself. A variable is represented by a string of lowercase English letters. The values of variables are determined by the most recent `let` expression in the scope.
*Một số nguyên đại diện cho chính nó. Một biến được đại diện bởi một chuỗi các chữ cái tiếng Anh viết thường. Giá trị của các biến được xác định bởi biểu thức `let` gần nhất trong phạm vi đó.*

The input expression is always valid and balanced with parentheses.
*Biểu thức đầu vào luôn hợp lệ và cân bằng dấu ngoặc.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** (let x 2 (mult x (let x 3 y 4 (add x y))))
**Output:** 14
**Explanation:** 
- In the outer `let`, x is assigned 2.
- Then we evaluate (mult x (inner let)).
- In the inner `let`, x is assigned 3 and y is assigned 4.
- (add x y) evaluates to 3+4=7.
- (mult x 7) where x is 2 evaluates to 2*7=14.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= expression.length <= 2000`
*   No white space at the beginning or end of the expression.
*   All tokens are separated by a single space.
*   The output and all intermediate results are in the range `[-10^6, 10^6]`.
