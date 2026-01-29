# 592. Fraction Addition and Subtraction / Cộng và Trừ Phân Số

## Problem Description / Mô tả bài toán
Given a string `expression` representing an expression of fraction addition and subtraction, return the calculation result in string format.
Cho một chuỗi `expression` đại diện cho một biểu thức cộng và trừ phân số, hãy trả về kết quả tính toán ở định dạng chuỗi.

The final result should be an **irreducible fraction**. If your final result is an integer, say `2`, you need to change it to the format of a fraction that has a denominator `1`. So in this case, `2` should be converted to `2/1`.
Kết quả cuối cùng phải là một **phân số tối giản**. Nếu kết quả cuối cùng của bạn là một số nguyên, chẳng hạn `2`, bạn cần đổi nó thành định dạng phân số có mẫu số `1`. Vì vậy, trong trường hợp này, `2` nên được chuyển đổi thành `2/1`.

### Example 1:
```text
Input: expression = "-1/2+1/2"
Output: "0/1"
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Parsing + LCM/GCD / Phân Tích + LCM/GCD
1. Parse the string into terms. Each term has a sign, numerator, denominator.
   Regex or manual split. Note `-` can be a sign or operator.
   Pattern: `[+-]?\d+/\d+`.
2. Maintain a running `numerator` and `denominator` (initially `0/1`).
3. For each fraction `n/d`:
   - `NewNumerator = CurrentNum * d + n * CurrentDenom`.
   - `NewDenom = CurrentDenom * d`.
   - Simplify using GCD.
   
GCD (Euclidean Algorithm):
```java
int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }
```

### Complexity / Độ phức tạp
- **Time**: O(N) where N is string length.
- **Space**: O(N) or O(1) if parsing iteratively.

---

## Analysis / Phân tích

### Approach: Linear Parsing and Accumulation

**Algorithm**:
1.  Parse fractions (sign, numerator, denominator).
2.  Add current fraction to accumulated sum.
3.  Simplify result at each step or at end using GCD.

---
