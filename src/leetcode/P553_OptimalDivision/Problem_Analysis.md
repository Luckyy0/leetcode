# 553. Optimal Division / Phép Chia Tối Ưu

## Problem Description / Mô tả bài toán
You are given an integer array `nums`. The adjacent integers in `nums` will perform the float division. For example, for `nums = [2,3,4]`, we will calculate `2 / 3 / 4`.
Bạn được cho một mảng số nguyên `nums`. Các số nguyên liền kề trong `nums` sẽ thực hiện phép chia sô thực. Ví dụ, với `nums = [2,3,4]`, chúng ta sẽ tính `2 / 3 / 4`.

However, you can add any number of parenthesis at any position to change the priority of operations. You want to add these parentheses such that the value of the expression after the evaluation is **maximum**.
Tuy nhiên, bạn có thể thêm bất kỳ số lượng dấu ngoặc đơn nào ở bất kỳ vị trí nào để thay đổi độ ưu tiên của các phép toán. Bạn muốn thêm các dấu ngoặc đơn này sao cho giá trị của biểu thức sau khi đánh giá là **lớn nhất**.

Return the corresponding expression that has the maximum value in string format.
Hãy trả về biểu thức tương ứng có giá trị lớn nhất ở định dạng chuỗi.

### Example 1:
```text
Input: nums = [1000,100,10,2]
Output: "1000/(100/10/2)"
Explanation: 1000/(100/10/2) = 1000/((100/10)/2) = 200.
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Mathematical Trick / Thủ thuật Toán học
Expression: `X1 / X2 / X3 / ... / Xn`.
This is equivalent to `X1 / (X2 * X3^{-1} * X4^{-1} ... )`.
To maximize the result, we want the denominator to be as small as possible.
Since `a / b / c` is `a / (b * c)`? No.
`a / b / c` = `(a / b) / c` = `a / (b * c)`.
`a / (b / c)` = `a * c / b`.

Generally, `X1` is always in the numerator. `X2` is always in the denominator.
To maximize the value, we want to multiply `X1` by as many subsequent numbers as possible (flipping them to the numerator).
This means we want `X2` to be divided by everything else: `X1 / (X2 / X3 / X4 / ... / Xn)`.
This expands to `X1 * X3 * X4 * ... * Xn / X2`.
This maximizes the numerator and minimizes the denominator (only X2).

Algorithm:
1. If `n == 1`, return "X1".
2. If `n == 2`, return "X1/X2".
3. Else, return "X1/(X2/X3/.../Xn)".

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Mathematical Maximization

**Algorithm**:
1.  Identify observation: Maximize numerator, minimize denominator.
2.  Num1 is fixed numerator, Num2 is fixed denominator.
3.  Maximize result by multiplying all nums from 3 to N.
4.  Construct string `num1/(num2/num3/.../numN)`.

---
