# 461. Hamming Distance / Khoảng Cách Hamming

## Problem Description / Mô tả bài toán
The **Hamming distance** between two integers is the number of positions at which the corresponding bits are different.
**Khoảng cách Hamming** giữa hai số nguyên là số lượng vị trí mà tại đó các bit tương ứng là khác nhau.

Given two integers `x` and `y`, return the **Hamming distance** between them.
Cho hai số nguyên `x` và `y`, hãy trả về **khoảng cách Hamming** giữa chúng.

### Example 1:
```text
Input: x = 1, y = 4
Output: 2
Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑
The above arrows point to positions where the corresponding bits are different.
```

### Example 2:
```text
Input: x = 3, y = 1
Output: 1
```

## Constraints / Ràng buộc
- `0 <= x, y <= 2^31 - 1`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### XOR and Bit Counting / XOR và Đếm Bit
The `XOR` operation between two numbers results in a binary number where the bits are `1` only at positions where the original bits were different.
Therefore, the Hamming distance is simply the number of set bits (count of `1`s) in the result of `x ^ y`.

Algorithm:
1. Calculate `z = x ^ y`.
2. Count the number of set bits in `z`.
   - Use `Integer.bitCount(z)`.
   - Or implement manually using `z & (z - 1)` trick (Brian Kernighan's algorithm).

### Complexity / Độ phức tạp
- **Time**: O(1) as integers have a fixed number of bits (32 or 64).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: XOR bitCount

**Algorithm**:
1.  Compute `xorResult = x ^ y`.
2.  Count bits of `xorResult`.

---
