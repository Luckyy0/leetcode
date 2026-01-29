# 371. Sum of Two Integers / Tổng Hai Số Nguyên

## Problem Description / Mô tả bài toán
Given two integers `a` and `b`, return the sum of the two integers without using the operators `+` and `-`.
Cho hai số nguyên `a` và `b`, trả về tổng của hai số nguyên mà không sử dụng các toán tử `+` và `-`.

### Example 1:
```text
Input: a = 1, b = 2
Output: 3
```

### Example 2:
```text
Input: a = 2, b = 3
Output: 5
```

## Constraints / Ràng buộc
- `-1000 <= a, b <= 1000`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Bit Manipulation / Thao Tác Bit
`Sum = XOR`.
`Carry = AND << 1`.
Repeat until `Carry == 0`.
Example: `a = 1 (01)`, `b = 2 (10)`.
`XOR`: `01 ^ 10 = 11 (3)`.
`AND`: `01 & 10 = 00`.
Carry is 0. Done. Result 3.
Example: `a = 2 (10)`, `b = 3 (11)`.
`XOR`: `01`.
`AND`: `10`. `Carry = 10 << 1 = 100`.
Loop:
`a = 001`. `b = 100`.
`XOR`: `101 (5)`.
`AND`: `000`. Done. Result 5.

### Complexity / Độ phức tạp
- **Time**: O(1) (Does at most 32 iterations).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Bitwise Loop

**Algorithm**:
1.  While `b != 0`:
    - `carry = (a & b) << 1`.
    - `a = a ^ b`.
    - `b = carry`.
2.  Return `a`.

---
