# 537. Complex Number Multiplication / Phép Nhân Số Phức

## Problem Description / Mô tả bài toán
A complex number can be represented as a string on the form `"real+imaginaryi"` where:
Một số phức có thể được biểu diễn dưới dạng chuỗi `"thực+ảoi"` trong đó:

- `real` is the real part and is an integer in the range `[-100, 100]`. / `thực` là phần thực và là một số nguyên trong phạm vi `[-100, 100]`.
- `imaginary` is the imaginary part and is an integer in the range `[-100, 100]`. / `ảo` là phần ảo và là một số nguyên trong phạm vi `[-100, 100]`.
- `i^2 == -1`.

Given two complex numbers `num1` and `num2` as strings, return a string of the complex number that represents their multiplications.
Cho hai số phức `num1` và `num2` dưới dạng chuỗi, hãy trả về một chuỗi số phức đại diện cho tích của chúng.

### Example 1:
```text
Input: num1 = "1+1i", num2 = "1+1i"
Output: "0+2i"
Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Algebraic Expansion / Khai triển Đại số
(a + bi) * (c + di) = ac + adi + bci + bdi^2
= ac + (ad + bc)i - bd
= (ac - bd) + (ad + bc)i

Algorithm:
1. Parse `num1` into `a` and `b`.
2. Parse `num2` into `c` and `d`.
3. Compute `real = a*c - b*d`.
4. Compute `imag = a*d + b*c`.
5. Format result string.

### Complexity / Độ phức tạp
- **Time**: O(1) (fixed length limits).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: String Parsing and Math

**Algorithm**:
1.  Verify string splitting.
2.  Extract real and imaginary components.
3.  Apply complex multiplication formula.
4.  Reconstruct string format.

---
