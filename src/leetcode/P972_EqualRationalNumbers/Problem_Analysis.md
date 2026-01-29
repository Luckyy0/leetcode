# 972. Equal Rational Numbers / Số Hữu tỉ Bằng nhau

## Problem Description / Mô tả bài toán
Given two strings `s` and `t`, each of which represents a non-negative rational number, return `true` if and only if they represent the same number.
Cho hai chuỗi `s` và `t`, mỗi chuỗi đại diện cho một số hữu tỉ không âm, hãy trả về `true` nếu và chỉ nếu chúng đại diện cho cùng một số.

Notation: `<IntegerPart>.<NonRepeatingPart>(<RepeatingPart>)`
Ký hiệu: `<Phần Nguyên>.<Phần Không Lặp>(<Phần Lặp>)`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Conversion to Double or Fraction / Chuyển đổi sang Double hoặc Phân số
Algorithm:
1. Parse the string into parts: `Integer`, `Non-repeating`, `Repeating`.
2. Convert the rational expression into a double by expanding the repeating part many times (e.g., to 15-20 decimal places).
3. Compare the two doubles.

Better (Precise) way:
Convert to a Fraction object `a/b`.
For `0.(9)`, the fraction is `9/9 = 1`.

### Complexity / Độ phức tạp
- **Time**: O(1).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Canonical Fraction Evaluation
Deconstruct each string into its mathematical components. By treating the repeating segment as a geometric series, we can normalize every representation into a standard fraction ($P/Q$). This eliminates ambiguity caused by multiple notations for the same value (like $0.999... = 1$).
Phân tích mỗi chuỗi thành các thành phần toán học của nó. Bằng cách coi phân đoạn lặp lại là một cấp số nhân, chúng ta có thể chuẩn hóa mọi biểu diễn thành một phân số tiêu chuẩn ($P/Q$). Điều này loại bỏ sự mơ hồ gây ra bởi nhiều ký hiệu cho cùng một giá trị (như $0,999... = 1$).

---
