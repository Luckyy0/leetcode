# 504. Base 7 / Cơ Số 7

## Problem Description / Mô tả bài toán
Given an integer `num`, return a string of its **base 7** representation.
Cho một số nguyên `num`, hãy trả về một chuỗi biểu diễn của nó trong **cơ số 7**.

### Example 1:
```text
Input: num = 100
Output: "202"
```

### Example 2:
```text
Input: num = -7
Output: "-10"
```

## Constraints / Ràng buộc
- `-10^7 <= num <= 10^7`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Successive Division / Chia liên tiếp
To convert a number to any base $B$:
1. Handle negative sign.
2. Repeatedly divide the magnitude by $B$, taking the remainder as the digits from right to left.
3. Stop when the quotient is 0.

Algorithm:
1. Corner case: if `num == 0`, return "0".
2. Record sign and take absolute value.
3. Use a `StringBuilder` to collect remainders of `num % 7`.
4. `num = num / 7`.
5. Reverse the `StringBuilder`, add sign if negative.

### Complexity / Độ phức tạp
- **Time**: O(log_7 N).
- **Space**: O(log_7 N) for the result string.

---

## Analysis / Phân tích

### Approach: Standard Base Conversion

**Algorithm**:
1.  Sign detection.
2.  Modulo/Division loop.
3.  String reversal.

---
